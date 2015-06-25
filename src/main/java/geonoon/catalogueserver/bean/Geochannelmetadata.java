package geonoon.catalogueserver.bean;

import java.sql.Date;

public class Geochannelmetadata implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String geowwUri = null;// Strnig for varchar of MYSQL DB
	String title = null;
	String alternativeTitle = null;
	String serviceLanguage = null;
	String abstract_ = null;
	String topicCategory = null;
	String geoChannelIdentifier = null;
	String resourceIdentifiers = null;// geochannel db set
	String keyword = null;
	String resourceType = null;
	String spatialFeature = null;
	java.math.BigDecimal spatialMetrics = null;// java.math.BigDecimal
												// for decial
	String boundingBox = null;
	String spatialExtent = null;

	Double verticalExtentLow = null;
	Double verticalExtentHigh = null;

	String spatialReferenceSystem = null;
	java.math.BigDecimal spatialResolution = null;// decimal shuzixing
	java.sql.Timestamp temporalExtentStart = null;
	java.sql.Timestamp temporalExtentEnd = null;
	Date publicationDate = null;
	String dataFormat = null;
	String responsibleOrganisation = null;
	String frequencyOfUpdata = null;
	String limitationOnPublicAccess = null;
	String useConstraints = null;
	String coupledGeoChannels = null;
	String additionalInformation = null;
	java.sql.Timestamp metadataDateTime = null;
	// String metadataDateTime =null;
	// mysql DB allow to assign values
	// to datetime & date columns using either strings or numbers.
	String metadataLanguage = null;
	String metadataContact = null;

	String searchTerms = null;

	/**
	 * @return the geowwUri
	 */
	public String getGeowwUri() {
		return geowwUri;
	}

	/**
	 * @param geowwUri
	 *            the geowwUri to set
	 */
	public void setGeowwUri(String geowwUri) {
		this.geowwUri = geowwUri;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the alternativeTitle
	 */
	public String getAlternativeTitle() {
		return alternativeTitle;
	}

	/**
	 * @param alternativeTitle
	 *            the alternativeTitle to set
	 */
	public void setAlternativeTitle(String alternativeTitle) {
		this.alternativeTitle = alternativeTitle;
	}

	/**
	 * @return the serviceLanguage
	 */
	public String getServiceLanguage() {
		return serviceLanguage;
	}

	/**
	 * @param serviceLanguage
	 *            the serviceLanguage to set
	 */
	public void setServiceLanguage(String serviceLanguage) {
		this.serviceLanguage = serviceLanguage;
	}

	/**
	 * @return the abstract_
	 */
	public String getAbstract_() {
		return abstract_;
	}

	/**
	 * @param abstract_
	 *            the abstract_ to set
	 */
	public void setAbstract_(String abstract_) {
		this.abstract_ = abstract_;
	}

	/**
	 * @return the topicCategory
	 */
	public String getTopicCategory() {
		return topicCategory;
	}

	/**
	 * @param topicCategory
	 *            the topicCategory to set
	 */
	public void setTopicCategory(String topicCategory) {
		this.topicCategory = topicCategory;
	}

	/**
	 * @return the geoChannelIdentifier
	 */
	public String getGeoChannelIdentifier() {
		return geoChannelIdentifier;
	}

	/**
	 * @param geoChannelIdentifier
	 *            the geoChannelIdentifier to set
	 */
	public void setGeoChannelIdentifier(String geoChannelIdentifier) {
		this.geoChannelIdentifier = geoChannelIdentifier;
	}

	/**
	 * @return the resourceIdentifiers
	 */
	public String getResourceIdentifiers() {
		return resourceIdentifiers;
	}

	/**
	 * @param resourceIdentifiers
	 *            the resourceIdentifiers to set
	 */
	public void setResourceIdentifiers(String resourceIdentifiers) {
		this.resourceIdentifiers = resourceIdentifiers;
	}

	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword
	 *            the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * @return the resourceType
	 */
	public String getResourceType() {
		return resourceType;
	}

	/**
	 * @param resourceType
	 *            the resourceType to set
	 */
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	/**
	 * @return the spatialFeature
	 */
	public String getSpatialFeature() {
		return spatialFeature;
	}

	/**
	 * @param spatialFeature
	 *            the spatialFeature to set
	 */
	public void setSpatialFeature(String spatialFeature) {
		this.spatialFeature = spatialFeature;
	}

	/**
	 * @return the spatialMetrics
	 */
	public java.math.BigDecimal getSpatialMetrics() {
		return spatialMetrics;
	}

	/**
	 * @param spatialMetrics
	 *            the spatialMetrics to set
	 */
	public void setSpatialMetrics(java.math.BigDecimal spatialMetrics) {
		this.spatialMetrics = spatialMetrics;
	}

	/**
	 * @return the boundingBox
	 */
	public String getBoundingBox() {
		return boundingBox;
	}

	/**
	 * @param boundingBox
	 *            the boundingBox to set
	 */
	public void setBoundingBox(String boundingBox) {
		this.boundingBox = boundingBox;
	}

	/**
	 * @return the spatialExtent
	 */
	public String getSpatialExtent() {
		return spatialExtent;
	}

	/**
	 * @param spatialExtent
	 *            the spatialExtent to set
	 */
	public void setSpatialExtent(String spatialExtent) {
		this.spatialExtent = spatialExtent;
	}

	/**
	 * @return the verticalExtentLow
	 */
	public Double getVerticalExtentLow() {
		return verticalExtentLow;
	}

	/**
	 * @param verticalExtentLow
	 *            the verticalExtentLow to set
	 */
	public void setVerticalExtentLow(Double verticalExtentLow) {
		this.verticalExtentLow = verticalExtentLow;
	}

	/**
	 * @return the verticalExtentHigh
	 */
	public Double getVerticalExtentHigh() {
		return verticalExtentHigh;
	}

	/**
	 * @param verticalExtentHigh
	 *            the verticalExtentHigh to set
	 */
	public void setVerticalExtentHigh(Double verticalExtentHigh) {
		this.verticalExtentHigh = verticalExtentHigh;
	}

	/**
	 * @return the spatialReferenceSystem
	 */
	public String getSpatialReferenceSystem() {
		return spatialReferenceSystem;
	}

	/**
	 * @param spatialReferenceSystem
	 *            the spatialReferenceSystem to set
	 */
	public void setSpatialReferenceSystem(String spatialReferenceSystem) {
		this.spatialReferenceSystem = spatialReferenceSystem;
	}

	/**
	 * @return the spatialResolution
	 */
	public java.math.BigDecimal getSpatialResolution() {
		return spatialResolution;
	}

	/**
	 * @param spatialResolution
	 *            the spatialResolution to set
	 */
	public void setSpatialResolution(java.math.BigDecimal spatialResolution) {
		this.spatialResolution = spatialResolution;
	}

	/**
	 * @return the temporalExtentStart
	 */
	public java.sql.Timestamp getTemporalExtentStart() {
		return temporalExtentStart;
	}

	/**
	 * @param temporalExtentStart
	 *            the temporalExtentStart to set
	 */
	public void setTemporalExtentStart(java.sql.Timestamp temporalExtentStart) {
		this.temporalExtentStart = temporalExtentStart;
	}

	/**
	 * @return the temporalExtentEnd
	 */
	public java.sql.Timestamp getTemporalExtentEnd() {
		return temporalExtentEnd;
	}

	/**
	 * @param temporalExtentEnd
	 *            the temporalExtentEnd to set
	 */
	public void setTemporalExtentEnd(java.sql.Timestamp temporalExtentEnd) {
		this.temporalExtentEnd = temporalExtentEnd;
	}

	/**
	 * @return the publicationDate
	 */
	public Date getPublicationDate() {
		return publicationDate;
	}

	/**
	 * @param publicationDate
	 *            the publicationDate to set
	 */
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	/**
	 * @return the dataFormat
	 */
	public String getDataFormat() {
		return dataFormat;
	}

	/**
	 * @param dataFormat
	 *            the dataFormat to set
	 */
	public void setDataFormat(String dataFormat) {
		this.dataFormat = dataFormat;
	}

	/**
	 * @return the responsibleOrganisation
	 */
	public String getResponsibleOrganisation() {
		return responsibleOrganisation;
	}

	/**
	 * @param responsibleOrganisation
	 *            the responsibleOrganisation to set
	 */
	public void setResponsibleOrganisation(String responsibleOrganisation) {
		this.responsibleOrganisation = responsibleOrganisation;
	}

	/**
	 * @return the frequencyOfUpdata
	 */
	public String getFrequencyOfUpdata() {
		return frequencyOfUpdata;
	}

	/**
	 * @param frequencyOfUpdata
	 *            the frequencyOfUpdata to set
	 */
	public void setFrequencyOfUpdata(String frequencyOfUpdata) {
		this.frequencyOfUpdata = frequencyOfUpdata;
	}

	/**
	 * @return the limitationOnPublicAccess
	 */
	public String getLimitationOnPublicAccess() {
		return limitationOnPublicAccess;
	}

	/**
	 * @param limitationOnPublicAccess
	 *            the limitationOnPublicAccess to set
	 */
	public void setLimitationOnPublicAccess(String limitationOnPublicAccess) {
		this.limitationOnPublicAccess = limitationOnPublicAccess;
	}

	/**
	 * @return the useConstraints
	 */
	public String getUseConstraints() {
		return useConstraints;
	}

	/**
	 * @param useConstraints
	 *            the useConstraints to set
	 */
	public void setUseConstraints(String useConstraints) {
		this.useConstraints = useConstraints;
	}

	/**
	 * @return the coupledGeoChannels
	 */
	public String getCoupledGeoChannels() {
		return coupledGeoChannels;
	}

	/**
	 * @param coupledGeoChannels
	 *            the coupledGeoChannels to set
	 */
	public void setCoupledGeoChannels(String coupledGeoChannels) {
		this.coupledGeoChannels = coupledGeoChannels;
	}

	/**
	 * @return the additionalInformation
	 */
	public String getAdditionalInformation() {
		return additionalInformation;
	}

	/**
	 * @param additionalInformation
	 *            the additionalInformation to set
	 */
	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	/**
	 * @return the metadataDateTime
	 */
	public java.sql.Timestamp getMetadataDateTime() {
		return metadataDateTime;
	}

	/**
	 * @param metadataDateTime
	 *            the metadataDateTime to set
	 */
	public void setMetadataDateTime(java.sql.Timestamp metadataDateTime) {
		this.metadataDateTime = metadataDateTime;
	}

	/**
	 * @return the metadataLanguage
	 */
	public String getMetadataLanguage() {
		return metadataLanguage;
	}

	/**
	 * @param metadataLanguage
	 *            the metadataLanguage to set
	 */
	public void setMetadataLanguage(String metadataLanguage) {
		this.metadataLanguage = metadataLanguage;
	}

	/**
	 * @return the metadataContact
	 */
	public String getMetadataContact() {
		return metadataContact;
	}

	/**
	 * @param metadataContact
	 *            the metadataContact to set
	 */
	public void setMetadataContact(String metadataContact) {
		this.metadataContact = metadataContact;
	}

	/**
	 * @return the searchTerms
	 */
	public String getSearchTerms() {
		return searchTerms;
	}

	/**
	 * @param searchTerms
	 *            the searchTerms to set
	 */
	public void setSearchTerms(String searchTerms) {
		this.searchTerms = searchTerms;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((abstract_ == null) ? 0 : abstract_.hashCode());
		result = prime
				* result
				+ ((additionalInformation == null) ? 0 : additionalInformation
						.hashCode());
		result = prime
				* result
				+ ((alternativeTitle == null) ? 0 : alternativeTitle.hashCode());
		result = prime * result
				+ ((boundingBox == null) ? 0 : boundingBox.hashCode());
		result = prime
				* result
				+ ((coupledGeoChannels == null) ? 0 : coupledGeoChannels
						.hashCode());
		result = prime * result
				+ ((dataFormat == null) ? 0 : dataFormat.hashCode());
		result = prime
				* result
				+ ((frequencyOfUpdata == null) ? 0 : frequencyOfUpdata
						.hashCode());
		result = prime
				* result
				+ ((geoChannelIdentifier == null) ? 0 : geoChannelIdentifier
						.hashCode());
		result = prime * result
				+ ((geowwUri == null) ? 0 : geowwUri.hashCode());
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime
				* result
				+ ((limitationOnPublicAccess == null) ? 0
						: limitationOnPublicAccess.hashCode());
		result = prime * result
				+ ((metadataContact == null) ? 0 : metadataContact.hashCode());
		result = prime
				* result
				+ ((metadataDateTime == null) ? 0 : metadataDateTime.hashCode());
		result = prime
				* result
				+ ((metadataLanguage == null) ? 0 : metadataLanguage.hashCode());
		result = prime * result
				+ ((publicationDate == null) ? 0 : publicationDate.hashCode());
		result = prime
				* result
				+ ((resourceIdentifiers == null) ? 0 : resourceIdentifiers
						.hashCode());
		result = prime * result
				+ ((resourceType == null) ? 0 : resourceType.hashCode());
		result = prime
				* result
				+ ((responsibleOrganisation == null) ? 0
						: responsibleOrganisation.hashCode());
		result = prime * result
				+ ((searchTerms == null) ? 0 : searchTerms.hashCode());
		result = prime * result
				+ ((serviceLanguage == null) ? 0 : serviceLanguage.hashCode());
		result = prime * result
				+ ((spatialExtent == null) ? 0 : spatialExtent.hashCode());
		result = prime * result
				+ ((spatialFeature == null) ? 0 : spatialFeature.hashCode());
		result = prime * result
				+ ((spatialMetrics == null) ? 0 : spatialMetrics.hashCode());
		result = prime
				* result
				+ ((spatialReferenceSystem == null) ? 0
						: spatialReferenceSystem.hashCode());
		result = prime
				* result
				+ ((spatialResolution == null) ? 0 : spatialResolution
						.hashCode());
		result = prime
				* result
				+ ((temporalExtentEnd == null) ? 0 : temporalExtentEnd
						.hashCode());
		result = prime
				* result
				+ ((temporalExtentStart == null) ? 0 : temporalExtentStart
						.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result
				+ ((topicCategory == null) ? 0 : topicCategory.hashCode());
		result = prime * result
				+ ((useConstraints == null) ? 0 : useConstraints.hashCode());
		result = prime
				* result
				+ ((verticalExtentHigh == null) ? 0 : verticalExtentHigh
						.hashCode());
		result = prime
				* result
				+ ((verticalExtentLow == null) ? 0 : verticalExtentLow
						.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		if (!(obj instanceof Geochannelmetadata)) {
			return false;
		}
		Geochannelmetadata other = (Geochannelmetadata) obj;
		if (abstract_ == null) {
			if (other.abstract_ != null) {
				return false;
			}
		} else if (!abstract_.equals(other.abstract_)) {
			return false;
		}
		if (additionalInformation == null) {
			if (other.additionalInformation != null) {
				return false;
			}
		} else if (!additionalInformation.equals(other.additionalInformation)) {
			return false;
		}
		if (alternativeTitle == null) {
			if (other.alternativeTitle != null) {
				return false;
			}
		} else if (!alternativeTitle.equals(other.alternativeTitle)) {
			return false;
		}
		if (boundingBox == null) {
			if (other.boundingBox != null) {
				return false;
			}
		} else if (!boundingBox.equals(other.boundingBox)) {
			return false;
		}
		if (coupledGeoChannels == null) {
			if (other.coupledGeoChannels != null) {
				return false;
			}
		} else if (!coupledGeoChannels.equals(other.coupledGeoChannels)) {
			return false;
		}
		if (dataFormat == null) {
			if (other.dataFormat != null) {
				return false;
			}
		} else if (!dataFormat.equals(other.dataFormat)) {
			return false;
		}
		if (frequencyOfUpdata == null) {
			if (other.frequencyOfUpdata != null) {
				return false;
			}
		} else if (!frequencyOfUpdata.equals(other.frequencyOfUpdata)) {
			return false;
		}
		if (geoChannelIdentifier == null) {
			if (other.geoChannelIdentifier != null) {
				return false;
			}
		} else if (!geoChannelIdentifier.equals(other.geoChannelIdentifier)) {
			return false;
		}
		if (geowwUri == null) {
			if (other.geowwUri != null) {
				return false;
			}
		} else if (!geowwUri.equals(other.geowwUri)) {
			return false;
		}
		if (keyword == null) {
			if (other.keyword != null) {
				return false;
			}
		} else if (!keyword.equals(other.keyword)) {
			return false;
		}
		if (limitationOnPublicAccess == null) {
			if (other.limitationOnPublicAccess != null) {
				return false;
			}
		} else if (!limitationOnPublicAccess
				.equals(other.limitationOnPublicAccess)) {
			return false;
		}
		if (metadataContact == null) {
			if (other.metadataContact != null) {
				return false;
			}
		} else if (!metadataContact.equals(other.metadataContact)) {
			return false;
		}
		if (metadataDateTime == null) {
			if (other.metadataDateTime != null) {
				return false;
			}
		} else if (!metadataDateTime.equals(other.metadataDateTime)) {
			return false;
		}
		if (metadataLanguage == null) {
			if (other.metadataLanguage != null) {
				return false;
			}
		} else if (!metadataLanguage.equals(other.metadataLanguage)) {
			return false;
		}
		if (publicationDate == null) {
			if (other.publicationDate != null) {
				return false;
			}
		} else if (!publicationDate.equals(other.publicationDate)) {
			return false;
		}
		if (resourceIdentifiers == null) {
			if (other.resourceIdentifiers != null) {
				return false;
			}
		} else if (!resourceIdentifiers.equals(other.resourceIdentifiers)) {
			return false;
		}
		if (resourceType == null) {
			if (other.resourceType != null) {
				return false;
			}
		} else if (!resourceType.equals(other.resourceType)) {
			return false;
		}
		if (responsibleOrganisation == null) {
			if (other.responsibleOrganisation != null) {
				return false;
			}
		} else if (!responsibleOrganisation
				.equals(other.responsibleOrganisation)) {
			return false;
		}
		if (searchTerms == null) {
			if (other.searchTerms != null) {
				return false;
			}
		} else if (!searchTerms.equals(other.searchTerms)) {
			return false;
		}
		if (serviceLanguage == null) {
			if (other.serviceLanguage != null) {
				return false;
			}
		} else if (!serviceLanguage.equals(other.serviceLanguage)) {
			return false;
		}
		if (spatialExtent == null) {
			if (other.spatialExtent != null) {
				return false;
			}
		} else if (!spatialExtent.equals(other.spatialExtent)) {
			return false;
		}
		if (spatialFeature == null) {
			if (other.spatialFeature != null) {
				return false;
			}
		} else if (!spatialFeature.equals(other.spatialFeature)) {
			return false;
		}
		if (spatialMetrics == null) {
			if (other.spatialMetrics != null) {
				return false;
			}
		} else if (!spatialMetrics.equals(other.spatialMetrics)) {
			return false;
		}
		if (spatialReferenceSystem == null) {
			if (other.spatialReferenceSystem != null) {
				return false;
			}
		} else if (!spatialReferenceSystem.equals(other.spatialReferenceSystem)) {
			return false;
		}
		if (spatialResolution == null) {
			if (other.spatialResolution != null) {
				return false;
			}
		} else if (!spatialResolution.equals(other.spatialResolution)) {
			return false;
		}
		if (temporalExtentEnd == null) {
			if (other.temporalExtentEnd != null) {
				return false;
			}
		} else if (!temporalExtentEnd.equals(other.temporalExtentEnd)) {
			return false;
		}
		if (temporalExtentStart == null) {
			if (other.temporalExtentStart != null) {
				return false;
			}
		} else if (!temporalExtentStart.equals(other.temporalExtentStart)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		if (topicCategory == null) {
			if (other.topicCategory != null) {
				return false;
			}
		} else if (!topicCategory.equals(other.topicCategory)) {
			return false;
		}
		if (useConstraints == null) {
			if (other.useConstraints != null) {
				return false;
			}
		} else if (!useConstraints.equals(other.useConstraints)) {
			return false;
		}
		if (verticalExtentHigh == null) {
			if (other.verticalExtentHigh != null) {
				return false;
			}
		} else if (!verticalExtentHigh.equals(other.verticalExtentHigh)) {
			return false;
		}
		if (verticalExtentLow == null) {
			if (other.verticalExtentLow != null) {
				return false;
			}
		} else if (!verticalExtentLow.equals(other.verticalExtentLow)) {
			return false;
		}
		return true;
	}

	// 验证所用属性是否为空，以及验证所用string类型的属性是否为“”字符串
	public boolean hasPropertyNotEqualNullAndEmptystring() {
		// string 类型的判定
		if (geowwUri != null && !geowwUri.equals("")) {
			return true;
		}
		if (title != null && !title.equals("")) {
			return true;
		}
		if (alternativeTitle != null && !alternativeTitle.equals("")) {
			return true;
		}
		if (serviceLanguage != null && !serviceLanguage.equals("")) {
			return true;
		}
		if (abstract_ != null && !abstract_.equals("")) {
			return true;
		}
		if (topicCategory != null && !topicCategory.equals("")) {
			return true;
		}
		if (geoChannelIdentifier != null && !geoChannelIdentifier.equals("")) {
			return true;
		}
		if (resourceIdentifiers != null && !resourceIdentifiers.equals("")) {
			return true;
		}
		if (keyword != null && !keyword.equals("")) {
			return true;
		}
		if (resourceType != null && !resourceType.equals("")) {
			return true;
		}
		if (spatialFeature != null && !spatialFeature.equals("")) {
			return true;
		}
		if (boundingBox != null && !boundingBox.equals("")) {
			return true;
		}
		if (spatialExtent != null && !spatialExtent.equals("")) {
			return true;
		}
		if (spatialReferenceSystem != null
				&& !spatialReferenceSystem.equals("")) {
			return true;
		}
		if (dataFormat != null && !dataFormat.equals("")) {
			return true;
		}
		if (responsibleOrganisation != null
				&& !responsibleOrganisation.equals("")) {
			return true;
		}
		if (frequencyOfUpdata != null && !frequencyOfUpdata.equals("")) {
			return true;
		}
		if (limitationOnPublicAccess != null
				&& !limitationOnPublicAccess.equals("")) {
			return true;
		}
		if (useConstraints != null && !useConstraints.equals("")) {
			return true;
		}
		if (coupledGeoChannels != null && !coupledGeoChannels.equals("")) {
			return true;
		}
		if (additionalInformation != null && !additionalInformation.equals("")) {
			return true;
		}
		if (metadataLanguage != null && !metadataLanguage.equals("")) {
			return true;
		}
		if (metadataContact != null && !metadataContact.equals("")) {
			return true;
		}
		if (searchTerms != null && !searchTerms.equals("")) {
			return true;
		}
		// 非string类型的判定
		if (spatialMetrics != null) {
			return true;
		}
		// 必须有高度范围的两个变量
		if (verticalExtentLow != null && verticalExtentHigh != null) {
			return true;
		}
		if (spatialResolution != null) {
			return true;
		}
		// 必须有表示时间范围的开始和结束时间
		if (temporalExtentStart != null && temporalExtentEnd != null) {
			return true;
		}
		if (publicationDate != null) {
			return true;
		}
		if (metadataDateTime != null) {
			return true;
		}
		return false;

	}

}