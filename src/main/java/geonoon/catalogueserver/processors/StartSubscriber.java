package geonoon.catalogueserver.processors;

//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

//import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
//import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartSubscriber {

	private final static Logger LOG = LoggerFactory
			.getLogger(StartSubscriber.class);

	private final ExecutorService executor;
	private LinkedBlockingQueue<Subscription> hubFeedtopicQueue;

	// private HttpClient httpclient = new DefaultHttpClient();
	private HttpClient httpclient = null;

	public StartSubscriber(LinkedBlockingQueue<Subscription> hubFeedtopicQueue) {
		this.hubFeedtopicQueue = hubFeedtopicQueue;

		executor = Executors.newFixedThreadPool(2);
	}

	public void start() {
		LOG.info("Starting StartSubscriber");
		executor.execute(new Runnable() {
			// @Override
			public void run() {
				while (true) {
					try {
						Subscription subscription = hubFeedtopicQueue.take();
						// subscribe to hub
						// Subscription subscription;
						// if (!hubFeedtopicQueue.isEmpty()) {
						//
						// subscription = hubFeedtopicQueue.poll();
						// }
						httpclient = new DefaultHttpClient();// ?why
						HttpPost post = new HttpPost(subscription.getHubUrl());
						post.addHeader("Content-Type","application/x-www-form-urlencoded");
						List<NameValuePair> params = new ArrayList<NameValuePair>();
						params.add(new BasicNameValuePair("hub.callback","http://localhost:9090/CatalogueServer/sub"));// sub服务器地址
						params.add(new BasicNameValuePair("hub.mode",subscription.getSubscribeMode()));
						params.add(new BasicNameValuePair("hub.topic",subscription.getFeedTopicUri()));
						try {
							post.setEntity(new UrlEncodedFormEntity(params));
							HttpResponse response1 = httpclient.execute(post);
							if (response1.getStatusLine().getStatusCode() != 202) {
								throw new RuntimeException();
							}
							// jin xing yan zheng
						} catch (Exception e) {
							e.printStackTrace();
							post.abort();
							throw new RuntimeException(e);
						} finally {
							httpclient.getConnectionManager().shutdown();
						}

					} catch (Exception e) {
						// e.printStackTrace();//会抛出异常，不能关闭一个线程，不知道为啥
						break;
					}

				}
				LOG.info("Stopped StartSubscriber");

			}

		});

	}

	public void stop() {
		LOG.info("Stopping StartSubscriber");
		executor.shutdownNow();
	}

}
