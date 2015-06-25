package geonoon.catalogueserver.processors;

public class Subscription {
	private String hubUrl;
	private String feedTopicUri;
	private String subscribeMode;
	
	
	/**
	 * @return the subscribeMode
	 */
	public String getSubscribeMode() {
		return subscribeMode;
	}
	/**
	 * @param subscribeMode the subscribeMode to set
	 */
	public void setSubscribeMode(String subscribeMode) {
		this.subscribeMode = subscribeMode;
	}
	
	public String getHubUrl() {
		return hubUrl;
	}
	public void setHubUrl(String hubUrl) {
		this.hubUrl = hubUrl;
	}
	public String getFeedTopicUri() {
		return feedTopicUri;
	}
	public void setFeedTopicUri(String feedTopicUri) {
		this.feedTopicUri = feedTopicUri;
	}
	
	public Subscription(String hubUrl, String feedTopicUri) {
		super();
		this.hubUrl = hubUrl;
		this.feedTopicUri = feedTopicUri;
	}
	public Subscription(String hubUrl, String feedTopicUri, String subscribeMode) {
		super();
		this.hubUrl = hubUrl;
		this.feedTopicUri = feedTopicUri;
		this.subscribeMode = subscribeMode;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((feedTopicUri == null) ? 0 : feedTopicUri.hashCode());
		result = prime * result + ((hubUrl == null) ? 0 : hubUrl.hashCode());
		result = prime * result
				+ ((subscribeMode == null) ? 0 : subscribeMode.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Subscription)) {
			return false;
		}
		Subscription other = (Subscription) obj;
		if (feedTopicUri == null) {
			if (other.feedTopicUri != null) {
				return false;
			}
		} else if (!feedTopicUri.equals(other.feedTopicUri)) {
			return false;
		}
		if (hubUrl == null) {
			if (other.hubUrl != null) {
				return false;
			}
		} else if (!hubUrl.equals(other.hubUrl)) {
			return false;
		}
		if (subscribeMode == null) {
			if (other.subscribeMode != null) {
				return false;
			}
		} else if (!subscribeMode.equals(other.subscribeMode)) {
			return false;
		}
		return true;
	}

	

}
