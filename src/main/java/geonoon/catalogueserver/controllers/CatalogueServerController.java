package geonoon.catalogueserver.controllers;

import geonoon.catalogueserver.bean.Geochannelmetadata;
import geonoon.catalogueserver.processors.Subscription;
import geonoon.catalogueserver.service.GeochannelservicedataService;
import geonoon.catalogueserver.util.BuilderOpensearchRespone;
import geonoon.catalogueserver.util.ParseMetaFeedEntryLabel;
import geonoon.catalogueserver.util.ParseOpensearchRequestToGeochannelmetadata;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Enumeration;
//import java.io.Reader;
//import java.math.BigDecimal;
//import java.net.URI;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.sql.Timestamp;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
//import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.InputSource;

//import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndLink;
import com.rometools.rome.io.SyndFeedInput;

/**
 * 
 * @author Kehuai controller of catalogueServer 主要功能:接受请求，分步处理
 *
 */
@Controller
public class CatalogueServerController {

	private final static Logger LOG = LoggerFactory.getLogger(CatalogueServerController.class);
	@Resource(name = "hubFeedtopicQueue")
	private LinkedBlockingQueue<Subscription> hubFeedtopicQueue;

	@Autowired
	private GeochannelservicedataService geoService;

	@RequestMapping(value = "/getmetafeed")
	// prase metafeed
	public ModelAndView getmetafeed(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String hubUri = null;
		String feedTopicUri = null;
		String subscribeMode=null;
		try {
			// get feed,// prase hub and feedtopic
			String feedUrl = request.getParameter("feedUrl");
			String subscribeModeTmp =request.getParameter("subscribeMode");
			// InputSource source = new InputSource(request.getInputStream());
			InputSource source = new InputSource(feedUrl);
			SyndFeedInput feedInput = new SyndFeedInput();
			feedInput.setPreserveWireFeed(true);
			final SyndFeed feed;
			feed = feedInput.build(source);

			@SuppressWarnings("rawtypes")
			List list = feed.getLinks();
			if (!list.isEmpty()) {
				for (Object s : list) {
					if (null == s) {
						continue;
					}
					if (s instanceof SyndLink) {
						SyndLink link = (SyndLink) s;
						if (link.getRel().equals("hub")) {
							hubUri = link.getHref();
							continue;
						} else if (link.getRel().equals("self")) {
							feedTopicUri = link.getHref();
							continue;
						}
					}

				}
			}
			// store hub and feedtopic to hubFeedtopicQueue
			if (feedTopicUri != null && hubUri != null) {
				//对subscribeMode字段赋值
				if (subscribeModeTmp.equals("unsubscribe")) {
					subscribeMode="unsubscribe";
				}
				else {
					subscribeMode="subscribe";
				}
				Subscription subscription = new Subscription(hubUri,feedTopicUri,subscribeMode);
				hubFeedtopicQueue.add(subscription);// 不同元素处理
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			response.setStatus(200);
		}

		return null;
	}

	@RequestMapping(value = "/sub")
	// Verify for get, update feed for post
	public ModelAndView subvalidateAndGetFeedUpdate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (request.getMethod().equals("GET")) {
			handleVerify(request, response);
		} else if (request.getMethod().equals("POST")) {
			handleNotify(request, response);
		} else {
			response.setStatus(405);
		}
		return null;
	}

	private void handleNotify(HttpServletRequest request,
			HttpServletResponse response) {
		// parser for xml with DOM4j,store date to DB with myBatis
		BufferedInputStream in2 = null;
		InputSource source = null;
		SAXReader reader = null;
		Document doc = null;

		try {
			in2 = new BufferedInputStream(request.getInputStream());
			source = new InputSource(in2);
			reader = new SAXReader();// 创建saxreader解析器
			doc = reader.read(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setStatus(200);

		// praser xml of metafeed for geochannelsmetafeed
		Element root = doc.getRootElement();// 获得xml根元素
		List<?> nodes = root.elements("entry");
		for (Iterator<?> it = nodes.iterator(); it.hasNext();) {
			Element aelm = (Element) it.next();
			// praser ENTRY label
			Geochannelmetadata geochannelmetadata = new Geochannelmetadata();
			geochannelmetadata = ParseMetaFeedEntryLabel.parseMetaFeedEntryLabel(geochannelmetadata, aelm);
			// 在springMVC集成mybatis来存取数据库
			LOG.info("Check DB for update!");
			if (null != geoService.findGeochannelmetadataByGeouri(geochannelmetadata)) {
				LOG.info("update  datebase!");
				geoService.updateGeoChannelMeta(geochannelmetadata);
			} else {
				LOG.info("insert  datebase!");
				geoService.insertGeoChannelMeta(geochannelmetadata);
			}
		}
	}

	// ////////////////////////////////////////////////////
	// ////////////////////利用mybatis配置文件手动创建session完成数据库访问
	// //////////////////////////////////////
	// // get session for connenctiong DB
	// String resource = "MyBatisConfig.xml";
	// Reader readermybatis = null;
	// SqlSession session;
	// try {
	// readermybatis = Resources.getResourceAsReader(resource);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
	// .build(readermybatis);
	// session = sqlMapper.openSession(false);//不使用自动提交
	//
	// LOG.info("Check DB for update!");
	// try {
	// GeochannelservicedataDao geochannelservicedataDao =
	// session.getMapper(GeochannelservicedataDao.class);
	// if(null!=geochannelservicedataDao.findByGeoUrlFromGeochannelmetadata(geochannelmetadata))
	// // if (null !=
	// session.selectOne("findByGeoUrlFromGeochannelmetadata",geochannelmetadata))
	// {
	// LOG.info("update  datebase!");
	// session.getMapper(GeochannelservicedataDao.class).updateGeoChannelMeta(geochannelmetadata);
	// // session.update("updateGeoChannelMeta", geochannelmetadata);
	// session.commit();
	// } else {
	// LOG.info("insert  datebase!");
	// session.insert("insertGeoChannelMeta", geochannelmetadata);
	// //
	// session.getMapper(GeochannelservicedataDao.class).insertGeoChannelMeta(geochannelmetadata);
	// session.commit();
	// }
	// } catch (Exception e) {
	// // TODO: handle exception
	// }finally{
	// session.close();
	// }

	// ///////////////////////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////store date to DB with
	// JDBC/////////////////////////////////
	/*
	 * // try { // InputSource source = new
	 * InputSource(request.getInputStream()); // SyndFeedInput feedInput = new
	 * SyndFeedInput(); // feedInput.setPreserveWireFeed(true); // final
	 * SyndFeed feed; // feed = feedInput.build(source); // // do something //
	 * for (SyndEntry sFeed : feed.getEntries()) { //
	 * System.out.println(sFeed.toString()); // } //
	 * System.out.println(feed.getEntries()); // BufferedInputStream in2 = new
	 * BufferedInputStream( // request.getInputStream()); // InputSource source
	 * = new InputSource(in2); // SAXReader reader = new SAXReader();//
	 * 创建saxreader解析器 // final Document doc = reader.read(source); //
	 * System.out.println("hello world!"); // String Driver =
	 * "com.mysql.jdbc.Driver"; // 驱动程序 // String URL =
	 * "jdbc:mysql://localhost:3306/geochannelservicedata"; // //
	 * 连接的URL,db_name为数据库名 // String Username = "root"; // 用户名 // String
	 * Password = "root"; // 密码 // // Statement statement = null; // Connection
	 * connection = null; // // String geowwUri = null;// Strnig for varchar of
	 * MYSQL DB // String title = null; // String alternativeTitle = null; //
	 * String serviceLanguage = null; // String abstract_ = null; // String
	 * topicCategory = null; // String geoChannelIdentifier = null; // String
	 * resourceIdentifiers = null;// geochannel db set // String keyword = null;
	 * // String resourceType = null; // String spatialFeature = null; //
	 * java.math.BigDecimal spatialMetrics = null;// java.math.BigDecimal // //
	 * for decial // String boundingBox = null; // String spatialExtent = null;
	 * // Double verticalExtent = null; // String spatialReferenceSystem = null;
	 * // java.math.BigDecimal spatialResolution = null;// decimal shuzixing //
	 * java.sql.Timestamp temporalExtent = null; // Date publicationDate = null;
	 * // String dataFormat = null; // String responsibleOrganisation = null; //
	 * String frequencyOfUpdata = null; // String limitationOnPublicAccess =
	 * null; // String useConstraints = null; // String coupledGeoChannels =
	 * null; // String additionalInformation = null; // java.sql.Timestamp
	 * metadataDateTime = null; // // String metadataDateTime =null; // // mysql
	 * DB allow to assign values // // to datetime & date columns using either
	 * strings or numbers. // String metadataLanguage = null; // String
	 * metadataContact = null; // // try { // // connect DB //
	 * Class.forName(Driver).newInstance(); // connection =
	 * DriverManager.getConnection(URL, Username, // Password); // statement =
	 * connection.createStatement(); // // // SAXReader reader = new
	 * SAXReader();// 创建saxreader解析器 // // FileInputStream fStream = new
	 * FileInputStream(new // // File("./a.txt")); // // Document doc =
	 * reader.read(fStream);// 开始解析 // // Document doc = reader.read(source);//
	 * 开始解析 // // Document doc = // //
	 * reader.read("http://192.168.1.234:8080/metafeed.xml"); // // Element root
	 * = doc.getRootElement();// 获得xml根元素 // List nodes =
	 * root.elements("entry"); // for (Iterator it = nodes.iterator();
	 * it.hasNext();) { // Element aelm = (Element) it.next(); // Element elm =
	 * aelm.element("CatalogMetadata"); // // title = elm.elementText("title");
	 * // alternativeTitle = elm.elementText("alternativeTitle"); // //
	 * System.out.println(title); // // serviceLanguage =
	 * elm.elementText("serviceLanguage"); // abstract_ =
	 * elm.elementText("abstract"); // topicCategory =
	 * elm.elementText("topicCategory"); // geoChannelIdentifier = elm //
	 * .elementText("geoChannelIdentifier"); // // resourceIdentifiers schema 没有
	 * // // resourceIdentifiers=elm.elementText(""); // keyword =
	 * elm.elementText("keyword"); // resourceType =
	 * elm.elementText("resourceType"); // spatialFeature =
	 * elm.elementText("spatialFeature"); // if (null !=
	 * elm.elementText("spatialMetrics")) { // spatialMetrics = new BigDecimal(
	 * // elm.elementText("spatialMetrics")); // } else { // spatialMetrics =
	 * BigDecimal.valueOf(0.0); // } // boundingBox =
	 * elm.elementText("boundingBox"); // spatialExtent =
	 * elm.elementText("spatialExtent"); // if (null !=
	 * elm.elementText("verticalExtent")) { // verticalExtent =
	 * Double.valueOf(elm // .elementText("verticalExtent")); // } else { //
	 * verticalExtent = 0.0; // } // // spatialReferenceSystem = elm //
	 * .elementText("spatialReferenceSystem"); // if (null !=
	 * elm.elementText("spatialResolution")) { // spatialResolution = new
	 * BigDecimal( // elm.elementText("spatialResolution")); // } else { //
	 * spatialResolution = BigDecimal.valueOf(0.0); // } // // a little problem
	 * // if (null != elm.elementText("temporalExtent")) { // temporalExtent =
	 * Timestamp.valueOf(elm // .elementText("temporalExtent")); // }else { //
	 * temporalExtent = new Timestamp(Calendar //
	 * .getInstance().getTimeInMillis()); // } // if (null !=
	 * elm.elementText("publicationDate")) { // publicationDate =
	 * Date.valueOf(elm // .elementText("publicationDate")); // }else { //
	 * publicationDate = new Date(new java.util.Date().getTime()); // } //
	 * geowwUri = elm.elementText("geowwURI"); // //
	 * System.out.println(geowwUri); // // dataFormat =
	 * elm.elementText("dataFormat"); // responsibleOrganisation = elm //
	 * .elementText("responsibleOrganisation"); // frequencyOfUpdata =
	 * elm.elementText("frequencyOfUpdate"); // limitationOnPublicAccess = elm
	 * // .elementText("limitationOnPublicAccess"); // useConstraints =
	 * elm.elementText("useConstraints"); // coupledGeoChannels =
	 * elm.elementText("coupledGeoChannels"); // additionalInformation = elm //
	 * .elementText("additionalInformation"); // if (null !=
	 * elm.elementText("metadataDateTime")) { // // SimpleDateFormat df = new //
	 * // SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // // java.util.Date time =
	 * // // df.parse(elm.elementText("metadataDateTime")); // //
	 * metadataDateTime = new Timestamp(time.getTime()); // // metadataDateTime
	 * = Timestamp.valueOf(elm // .elementText("metadataDateTime")); // //
	 * metadataDateTime = // // elm.elementText("metadataDateTime"); // // }else
	 * { // metadataDateTime = new Timestamp(Calendar //
	 * .getInstance().getTimeInMillis()); // } // //
	 * System.out.println(metadataDateTime.toGMTString()); // metadataLanguage =
	 * elm.elementText("metadataLanguage"); // metadataContact =
	 * elm.elementText("metadataContact"); // int len; //
	 * LOG.info("Check DB for update!"); // ResultSet rSet = statement //
	 * .executeQuery
	 * ("select count(*) from geochannelmetadata where geowwUri = '" // +
	 * geowwUri + "'"); // int cnt = 0; // if (rSet.next()) { // cnt =
	 * rSet.getInt(1); // } // if (cnt > 0) { // // update DB // String
	 * sqlupdate = "update  geochannelmetadata set title='" // + title // +
	 * "', alternativeTitle='" // + alternativeTitle // + "', serviceLanguage='"
	 * // + serviceLanguage // + "',abstract='" // + abstract_ // +
	 * "',topicCategory='" // + topicCategory // + "',geoChannelIdentifier='" //
	 * + geoChannelIdentifier // + "',resourceIdentifiers='" // +
	 * resourceIdentifiers // + "',keyword='" // + keyword // +
	 * "',resourceType='" // + resourceType // +
	 * "',spatialFeature=geomfromtext('" // + spatialFeature // +
	 * "'),spatialMetrics='" // + spatialMetrics // +
	 * "',boundingBox=geomfromtext('" // + boundingBox // +
	 * "'),spatialExtent=geomfromtext('" // + spatialExtent // +
	 * "'),verticalExtent='" // + verticalExtent // +
	 * "',spatialReferenceSystem='" // + spatialReferenceSystem // +
	 * "',spatialResolution='" // + spatialResolution // + "',temporalExtent='"
	 * // + temporalExtent // + "',publicationDate='" // + publicationDate // +
	 * "',dataFormat='" // + dataFormat // + "',responsibleOrganisation='" // +
	 * responsibleOrganisation // + "',frequencyOfUpdata='" // +
	 * frequencyOfUpdata // + "',limitationOnPublicAccess='" // +
	 * limitationOnPublicAccess // + "',useConstraints='" // + useConstraints //
	 * + "',coupledGeoChannels='" // + coupledGeoChannels // +
	 * "',additionalInformation='" // + additionalInformation // +
	 * "',metadataDateTime='" // + metadataDateTime // + "',metadataLanguage='"
	 * // + metadataLanguage // + "',metadataContact='" + metadataContact +
	 * "'where geowwURI='" // + geowwUri // + "'"; // //
	 * System.out.println(sqlupdate); // len =
	 * statement.executeUpdate(sqlupdate); // LOG.info("update new metafeed");
	 * // } else { // // insert DB // len = statement //
	 * .executeUpdate("INSERT INTO geochannelmetadata VALUES ('" // + title // +
	 * "','" // + alternativeTitle // + "','" // + serviceLanguage // + "','" //
	 * + abstract_ // + "','" // + topicCategory // + "','" // +
	 * geoChannelIdentifier // + "','" // + resourceIdentifiers // + "','" // +
	 * keyword // + "','" // + resourceType // + "',geomfromtext('" // +
	 * spatialFeature // + "'),'" // + spatialMetrics // + "',geomfromtext('" //
	 * + boundingBox // + "'),geomfromtext('" // + spatialExtent // + "'),'" //
	 * + verticalExtent // + "','" // + spatialReferenceSystem // + "','" // +
	 * spatialResolution // + "','" // + temporalExtent // + "','" // +
	 * publicationDate // + "','" // + geowwUri // + "','" // + dataFormat // +
	 * "','" // + responsibleOrganisation // + "','" // + frequencyOfUpdata // +
	 * "','" // + limitationOnPublicAccess // + "','" // + useConstraints // +
	 * "','" // + coupledGeoChannels // + "','" // + additionalInformation // +
	 * "','" // + metadataDateTime // + "','" // + metadataLanguage // + "','"
	 * // + metadataContact + "')"); // LOG.info("insert new metafeed"); // } //
	 * // statement.close(); // } // // } catch (Exception e) { //
	 * e.printStackTrace(); // } finally { // try { // if (statement != null) {
	 * // statement.close(); // } // if (connection != null) { //
	 * connection.close(); // } // } catch (Exception e2) { //
	 * e2.printStackTrace(); // } // // } // } catch (Exception e) { //
	 * e.printStackTrace(); // } finally { // response.setStatus(200); // } //
	 */
	// /////////////////////////////////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////////////////////////

	private void handleVerify(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		if (request.getParameter("hub.mode") != null
				&& request.getParameter("hub.topic") != null
				&& request.getParameter("hub.challenge") != null) {
			// URI feedTopicUri = URI.create(request.getParameter("hub.topic"));
			if (request.getParameter("hub.mode").equals("subscribe")) {
				response.setStatus(200);
				response.setContentType("text/plain");
				try {
					response.getWriter().write(request.getParameter("hub.challenge"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (request.getParameter("hub.mode").equals("unsubscribe")) {
				response.setStatus(200);
				response.setContentType("text/plain");
				try {
					response.getWriter().write(request.getParameter("hub.challenge"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} else {
			response.setStatus(400);
		}
	}

	@RequestMapping(value = "/opensearch")
	// , method = RequestMethod.GET)
	public ModelAndView opensearch(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// implement later --wkh
		Geochannelmetadata eGeochannelmetadata = new Geochannelmetadata();// 传搜索参数
		PrintWriter pwriter = response.getWriter();
		
		// 对request解析，构造eGeochannelmetadata
		Map<String, String[]> keyValue = request.getParameterMap();
		eGeochannelmetadata = ParseOpensearchRequestToGeochannelmetadata.saveParaToGeochannelmetadata(keyValue, eGeochannelmetadata);
		
		if (eGeochannelmetadata.hasPropertyNotEqualNullAndEmptystring()) {
			List<Geochannelmetadata> geochannelmetadataList = new ArrayList<Geochannelmetadata>();
			geochannelmetadataList = geoService.findGeochannelmetadataByOpensearchPara(eGeochannelmetadata);
			Document document = BuilderOpensearchRespone.builderOpensearchResponeDocument(geochannelmetadataList);
			pwriter.write(document.asXML());
		} else {
			pwriter.write("\nGET Method require search paremeters,not give your search paremeters or paremeters given is invalid");
		}
		return null;
	}
}
