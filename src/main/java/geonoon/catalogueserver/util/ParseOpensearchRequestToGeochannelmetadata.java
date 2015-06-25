package geonoon.catalogueserver.util;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Map;

import geonoon.catalogueserver.bean.Geochannelmetadata;

/**
 * 
 * @author Kehuai 解析opensearch请求参数 ,构造eGeochannelmetadata
 */
public class ParseOpensearchRequestToGeochannelmetadata {

	public static Geochannelmetadata saveParaToGeochannelmetadata(
			Map<String, String[]> keyValue,
			Geochannelmetadata eGeochannelmetadata) {
		for (Iterator<String> iterator = keyValue.keySet().iterator(); iterator
				.hasNext();) {
			String key = iterator.next();
			selectCaseforRequest(keyValue, key, eGeochannelmetadata);
		}
		return eGeochannelmetadata;
	}

	//每个循环设置eGeochannelmetadata的属性值
	public static void selectCaseforRequest(Map<String, String[]> keyValue,
			String key, Geochannelmetadata eGeochannelmetadata) {
		switch (key) {
		case "title":
		case "Title":
			String[] title = keyValue.get(key);
			eGeochannelmetadata.setTitle(title[0]);
			break;
		case "alternativeTitle":
		case "AlternativeTitle":
			String[] alternativeTitle = keyValue.get(key);
			eGeochannelmetadata.setAlternativeTitle(alternativeTitle[0]);
			break;
		case "serviceLanguage":
		case "ServiceLanguage":
			String[] serviceLanguage = keyValue.get(key);
			eGeochannelmetadata.setServiceLanguage(serviceLanguage[0]);
			break;
		case "abstract":
		case "Abstract":
			String[] abstract_ = keyValue.get(key);
			eGeochannelmetadata.setAbstract_(abstract_[0]);
			break;
		case "topicCategory":
		case "TopicCategory":
			String[] topicCategory = keyValue.get(key);
			eGeochannelmetadata.setTopicCategory(topicCategory[0]);
			break;
		case "geoChannelIdentifier":
		case "GeoChannelIdentifier":
			String[] geoChannelIdentifier = keyValue.get(key);
			eGeochannelmetadata
					.setGeoChannelIdentifier(geoChannelIdentifier[0]);
			break;
		case "resourceIdentifiers":
		case "ResourceIdentifiers":
			String[] resourceIdentifiers = keyValue.get(key);
			eGeochannelmetadata.setResourceIdentifiers(resourceIdentifiers[0]);
			break;
		case "keyword":
		case "Keyword":
			String[] keyword = keyValue.get(key);
			eGeochannelmetadata.setKeyword(keyword[0]);
			break;
		case "resourceType":
		case "ResourceType":
			String[] resourceType = keyValue.get(key);
			eGeochannelmetadata.setResourceType(resourceType[0]);
			break;
		case "spatialFeature":
		case "SpatialFeature":
			String[] spatialFeature = keyValue.get(key);
			eGeochannelmetadata.setSpatialFeature(spatialFeature[0]);
			break;
//		case "spatialMetrics":
//		case "SpatialMetrics":
//			String[] spatialMetrics = keyValue.get(key);
//			if (null != spatialMetrics[0]) {
//				eGeochannelmetadata.setSpatialMetrics(new BigDecimal(
//						spatialMetrics[0]));
//			}
//			break;
		case "boundingBox":
		case "BoundingBox":
			String[] boundingBox = keyValue.get(key);
			eGeochannelmetadata.setBoundingBox(boundingBox[0]);
			break;
		case "spatialExtent":
		case "SpatialExtent":
			String[] spatialExtent = keyValue.get(key);
			eGeochannelmetadata.setSpatialExtent(spatialExtent[0]);
			break;
		case "verticalExtentLow":
		case "VerticalExtentLow":
			String[] verticalExtentLow = keyValue.get(key);
			if (null != verticalExtentLow[0]) {
				eGeochannelmetadata.setVerticalExtentLow(Double.valueOf(verticalExtentLow[0]));
			}
			break;
		case "verticalExtentHigh":
		case "VerticalExtentHigh":
			String[] verticalExtentHigh = keyValue.get(key);
			if (null != verticalExtentHigh[0]) {
				eGeochannelmetadata.setVerticalExtentLow(Double.valueOf(verticalExtentHigh[0]));
			}
			break;
		case "spatialReferenceSystem":
		case "SpatialReferenceSystem":
			String[] spatialReferenceSystem = keyValue.get(key);
			eGeochannelmetadata.setSpatialReferenceSystem(spatialReferenceSystem[0]);
			break;
//		case "spatialResolution":
//		case "SpatialResolution":
//			String[] spatialResolution = keyValue.get(key);
//			if (spatialResolution[0] != null) {
//				eGeochannelmetadata.setSpatialResolution(new BigDecimal(
//						spatialResolution[0]));
//			}
//
//			break;
		case "temporalExtentStart":
		case "TemporalExtentStart":
			String[] temporalExtentStart = keyValue.get(key);
			if (null != temporalExtentStart[0]) {
				eGeochannelmetadata.setTemporalExtentStart(Timestamp.valueOf(temporalExtentStart[0]));
			}

			break;
		case "temporalExtentEnd":
		case "TemporalExtentEnd":
			String[] temporalExtentEnd = keyValue.get(key);
			if (null != temporalExtentEnd[0]) {
				eGeochannelmetadata.setTemporalExtentEnd(Timestamp.valueOf(temporalExtentEnd[0]));
			}

			break;
//		case "publicationDate":
//		case "PublicationDate":
//			String[] publicationDate = keyValue.get(key);
//			if (null != publicationDate[0]) {
//				eGeochannelmetadata.setPublicationDate(Date
//						.valueOf(publicationDate[0]));
//			}
//
//			break;
		case "dataFormat":
		case "DataFormat":
			String[] dataFormat = keyValue.get(key);
			eGeochannelmetadata.setDataFormat(dataFormat[0]);
			break;
		case "responsibleOrganisation":
		case "ResponsibleOrganisation":
			String[] responsibleOrganisation = keyValue.get(key);
			eGeochannelmetadata
					.setResponsibleOrganisation(responsibleOrganisation[0]);
			break;
		case "frequencyOfUpdata":
		case "FrequencyOfUpdata":
			String[] frequencyOfUpdata = keyValue.get(key);
			eGeochannelmetadata.setFrequencyOfUpdata(frequencyOfUpdata[0]);
			break;
		case "limitationOnPublicAccess":
		case "LimitationOnPublicAccess":
			String[] limitationOnPublicAccess = keyValue.get(key);
			eGeochannelmetadata.setLimitationOnPublicAccess(limitationOnPublicAccess[0]);
			break;
//		case "useConstraints":
//		case "UseConstraints":
//			String[] useConstraints = keyValue.get(key);
//			eGeochannelmetadata.setUseConstraints(useConstraints[0]);
//			break;
		case "coupledGeoChannels":
		case "CoupledGeoChannels":
			String[] coupledGeoChannels = keyValue.get(key);
			eGeochannelmetadata.setCoupledGeoChannels(coupledGeoChannels[0]);
			break;
		case "additionalInformation":
		case "AdditionalInformation":
			String[] additionalInformation = keyValue.get(key);
			eGeochannelmetadata.setAdditionalInformation(additionalInformation[0]);
			break;
//		case "metadataDateTime":
//		case "MetadataDateTime":
//			String[] metadataDateTime = keyValue.get(key);
//			if (null != metadataDateTime[0]) {
//				eGeochannelmetadata.setMetadataDateTime(Timestamp
//						.valueOf(metadataDateTime[0]));
//			}
//			break;
		case "metadataLanguage":
		case "MetadataLanguage":
			String[] metadataLanguage = keyValue.get(key);
			eGeochannelmetadata.setMetadataLanguage(metadataLanguage[0]);
			break;
		case "metadataContact":
		case "MetadataContact":
			String[] metadataContact = keyValue.get(key);
			eGeochannelmetadata.setMetadataContact(metadataContact[0]);
			break;
		// add by wkh
		case "searchTerms":
		case "SearchTerms":
			String[] searchTerms = keyValue.get(key);
			eGeochannelmetadata.setSearchTerms(searchTerms[0]);

		default:
			break;
		}

	}

}
