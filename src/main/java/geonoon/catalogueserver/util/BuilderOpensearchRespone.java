package geonoon.catalogueserver.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import geonoon.catalogueserver.bean.Geochannelmetadata;

import org.dom4j.*;
import org.dom4j.io.XMLWriter;

/**
 * 
 * @author Kehuai build opensearch respone for client
 */
public class BuilderOpensearchRespone {
	@SuppressWarnings({ "deprecation", "unused" })
	public static Document builderOpensearchResponeDocument(List<Geochannelmetadata> geochannelmetadataList) {
		
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("kml","http://www.opengis.net/kml/2.2");// 创建根节点
		root.addNamespace("geoww", "http://www.geoww.net/geochannel");
		root.addNamespace("geofeed", "http://www.geoww.net/geofeed");
		root.addNamespace("opensearch", "http://a9.com/-/spec/opensearch/1.1/");
		root.addNamespace("geo","http://a9.com/-/opensearch/extensions/geo/1.0/");
		root.addNamespace("time","http://a9.com/-/opensearch/extensions/time/1.0/");
		
		root.addComment("This is a test for opensearch respone!");

		Element geowwGeoChannelSearch = root.addElement("geoww:GeoChannelSearch");
		Element opensearchtotalResults = geowwGeoChannelSearch.addElement("opensearch:totalResults");
		Element opensearchstartIndex = geowwGeoChannelSearch.addElement("opensearch:startIndex");
		Element opensearchitemsPerPage = geowwGeoChannelSearch.addElement("opensearch:itemsPerPage");
		Element opensearchQuery = geowwGeoChannelSearch.addElement("opensearch:Query");
		Element geowwSearchLinks = geowwGeoChannelSearch.addElement("geoww:SearchLinks");

		for (Geochannelmetadata geochannelmetadata : geochannelmetadataList) {
			Element geowwGeoChannel = geowwGeoChannelSearch.addElement("geoww:GeoChannel");

			// geoww:GeoChannel
			Element name = geowwGeoChannel.addElement("name");
			Element description = geowwGeoChannel.addElement("description");
			Element geowwMetadata = geowwGeoChannel.addElement("geoww:Metadata");
			Element geofeedAccessFeed = geowwGeoChannel.addElement("geofeed:AccessFeed");
			
			// geoww:Metadata
			Element geowwtitle = geowwMetadata.addElement("geoww:title");
			Element Geometry = geowwMetadata.addElement("Geometry");
			Element geowwsMetadataList = geowwMetadata.addElement("geoww:MetadataList");
			
			// geoww:MetadataList//geoww:GeowwURI
			Element geowwGeowwURI = geowwsMetadataList.addElement("geoww:GeowwURI");
			Element geowwnote = geowwGeowwURI.addElement("geoww:note");
			Element geowwgeowwURI = geowwGeowwURI.addElement("geoww:geowwURI");
			if (null != geochannelmetadata.getGeowwUri()) {
				geowwgeowwURI.setText(geochannelmetadata.getGeowwUri());
			}

			//
			// geoww:MetadataList//Data
			// Title
			Element titleData = geowwsMetadataList.addElement("Data");
			titleData.addAttribute("name", "Title");
			Element titleValue = titleData.addElement("value");
			if (null != geochannelmetadata.getTitle()) {
				titleValue.setText(geochannelmetadata.getTitle());
			}

			// alternativeTitle
			Element alternativeTitleData = geowwsMetadataList.addElement("Data");
			alternativeTitleData.addAttribute("name", "AlternativeTitle");
			Element alternativeTitleValue = alternativeTitleData.addElement("value");
			if (null != geochannelmetadata.getAlternativeTitle()) {
				alternativeTitleValue.setText(geochannelmetadata.getAlternativeTitle());
			}

			// ServiceLanguage
			Element serviceLanguageData = geowwsMetadataList.addElement("Data");
			serviceLanguageData.addAttribute("name", "ServiceLanguage");
			Element serviceLanguageValue = serviceLanguageData.addElement("value");
			if (null != geochannelmetadata.getServiceLanguage()) {
				serviceLanguageValue.setText(geochannelmetadata.getServiceLanguage());
			}

			// Abstract
			Element abstractData = geowwsMetadataList.addElement("Data");
			abstractData.addAttribute("name", "Abstract");
			Element abstractValue = abstractData.addElement("value");
			if (null != geochannelmetadata.getAbstract_()) {abstractValue.setText(geochannelmetadata.getAbstract_());
			}

			// TopicCategory
			Element topicCategoryData = geowwsMetadataList.addElement("Data");
			topicCategoryData.addAttribute("name", "TopicCategory");
			Element topicCategoryValue = topicCategoryData.addElement("value");
			if (null != geochannelmetadata.getTopicCategory()) {
				topicCategoryValue.setText(geochannelmetadata.getTopicCategory());
			}

			// GeoChannelIdentifier
			Element geoChannelIdentifierData = geowwsMetadataList
					.addElement("Data");
			geoChannelIdentifierData.addAttribute("name",
					"GeoChannelIdentifier");
			Element geoChannelIdentifierValue = geoChannelIdentifierData
					.addElement("value");
			if (null != geochannelmetadata.getGeoChannelIdentifier()) {
				geoChannelIdentifierValue.setText(geochannelmetadata.getGeoChannelIdentifier());
			}

			// ResourceIdentifiers
			Element resourceIdentifiersData = geowwsMetadataList.addElement("Data");
			resourceIdentifiersData.addAttribute("name", "ResourceIdentifiers");
			Element resourceIdentifiersValue = resourceIdentifiersData.addElement("value");
			if (null != geochannelmetadata.getResourceIdentifiers()) {
				resourceIdentifiersValue.setText(geochannelmetadata.getResourceIdentifiers());
			}

			// Keyword
			Element keywordData = geowwsMetadataList.addElement("Data");
			keywordData.addAttribute("name", "Keyword");
			Element keywordValue = keywordData.addElement("value");
			if (null != geochannelmetadata.getKeyword()) {
				keywordValue.setText(geochannelmetadata.getKeyword());
			}

			// ResourceType
			Element resourceTypeData = geowwsMetadataList.addElement("Data");
			resourceTypeData.addAttribute("name", "ResourceType");
			Element resourceTypeValue = resourceTypeData.addElement("value");
			if (null != geochannelmetadata.getResourceType()) {
				resourceTypeValue.setText(geochannelmetadata.getResourceType());
			}

			// SpatialFeature
			Element SpatialFeatureData = geowwsMetadataList.addElement("Data");
			SpatialFeatureData.addAttribute("name", "SpatialFeature");
			Element SpatialFeatureValue = SpatialFeatureData.addElement("value");
			if (null != geochannelmetadata.getSpatialFeature()) {
				SpatialFeatureValue.setText(geochannelmetadata.getSpatialFeature());
			}

			// SpatialMetrics
			Element SpatialMetricsData = geowwsMetadataList.addElement("Data");
			SpatialMetricsData.addAttribute("name", "SpatialMetrics");
			Element SpatialMetricsValue = SpatialMetricsData.addElement("value");
			if (null != geochannelmetadata.getSpatialMetrics()) {
				SpatialMetricsValue.setText(geochannelmetadata.getSpatialMetrics().toString());
			}

			// BoundingBox
			Element BoundingBoxData = geowwsMetadataList.addElement("Data");
			BoundingBoxData.addAttribute("name", "BoundingBox");
			Element BoundingBoxValue = BoundingBoxData.addElement("value");
			if (null != geochannelmetadata.getBoundingBox()) {
				BoundingBoxValue.setText(geochannelmetadata.getBoundingBox());
			}

			// SpatialExtent
			Element SpatialExtentData = geowwsMetadataList.addElement("Data");
			SpatialExtentData.addAttribute("name", "SpatialExtent");
			Element SpatialExtentValue = SpatialExtentData.addElement("value");
			if (null != geochannelmetadata.getSpatialExtent()) {
				SpatialExtentValue.setText(geochannelmetadata.getSpatialExtent());
			}

			// VerticalExtentLow
			Element verticalExtentLowData = geowwsMetadataList.addElement("Data");
			verticalExtentLowData.addAttribute("name", "VerticalExtentLow");
			Element verticalExtentLowValue = verticalExtentLowData.addElement("value");
			if (null != geochannelmetadata.getVerticalExtentLow()) {
				verticalExtentLowValue.setText(geochannelmetadata.getVerticalExtentLow().toString());
			}

			// VerticalExtentHigh
			Element verticalExtentHighData = geowwsMetadataList.addElement("Data");
			verticalExtentHighData.addAttribute("name", "VerticalExtentHigh");
			Element verticalExtentHighValue = verticalExtentHighData.addElement("value");
			if (null != geochannelmetadata.getVerticalExtentHigh()) {
				verticalExtentHighValue.setText(geochannelmetadata.getVerticalExtentHigh().toString());
			}

			// SpatialReferenceSystem
			Element SpatialReferenceSystemData = geowwsMetadataList.addElement("Data");
			SpatialReferenceSystemData.addAttribute("name","SpatialReferenceSystem");
			Element SpatialReferenceSystemValue = SpatialReferenceSystemData.addElement("value");
			if (null != geochannelmetadata.getSpatialReferenceSystem()) {
				SpatialReferenceSystemValue.setText(geochannelmetadata.getSpatialReferenceSystem());
			}

			// SpatialResolution
			Element SpatialResolutionData = geowwsMetadataList.addElement("Data");
			SpatialResolutionData.addAttribute("name", "SpatialResolution");
			Element SpatialResolutionValue = SpatialResolutionData.addElement("value");
			if (null != geochannelmetadata.getSpatialResolution()) {
				SpatialResolutionValue.setText(geochannelmetadata.getSpatialResolution().toString());
			}

			// TemporalExtentStart
			Element TemporalExtentStartData = geowwsMetadataList.addElement("Data");
			TemporalExtentStartData.addAttribute("name", "TemporalExtentStart");
			Element TemporalExtentStartValue = TemporalExtentStartData.addElement("value");
			if (null != geochannelmetadata.getTemporalExtentStart()) {
				TemporalExtentStartValue.setText(geochannelmetadata.getTemporalExtentStart().toGMTString());
			}
			// TemporalExtentEnd
			Element TemporalExtentEndData = geowwsMetadataList.addElement("Data");
			TemporalExtentEndData.addAttribute("name", "TemporalExtentEnd");
			Element TemporalExtentEndValue = TemporalExtentEndData.addElement("value");
			if (null != geochannelmetadata.getTemporalExtentEnd()) {
				TemporalExtentEndValue.setText(geochannelmetadata.getTemporalExtentEnd().toGMTString());
			}

			// PublicationDate
			Element PublicationDateData = geowwsMetadataList.addElement("Data");
			PublicationDateData.addAttribute("name", "PublicationDate");
			Element PublicationDateValue = PublicationDateData.addElement("value");
			if (null != geochannelmetadata.getPublicationDate()) {
				PublicationDateValue.setText(geochannelmetadata.getPublicationDate().toGMTString());
			}

			// DataFormat
			Element DataFormatData = geowwsMetadataList.addElement("Data");
			DataFormatData.addAttribute("name", "DataFormat");
			Element DataFormatValue = DataFormatData.addElement("value");
			if (null != geochannelmetadata.getDataFormat()) {
				DataFormatValue.setText(geochannelmetadata.getDataFormat());
			}

			// ResponsibleOrganisation
			Element ResponsibleOrganisationData = geowwsMetadataList.addElement("Data");
			ResponsibleOrganisationData.addAttribute("name","ResponsibleOrganisation");
			Element ResponsibleOrganisationValue = ResponsibleOrganisationData.addElement("value");
			if (null != geochannelmetadata.getResponsibleOrganisation()) {
				ResponsibleOrganisationValue.setText(geochannelmetadata.getResponsibleOrganisation());
			}

			// FrequencyOfUpdata
			Element FrequencyOfUpdataData = geowwsMetadataList.addElement("Data");
			FrequencyOfUpdataData.addAttribute("name", "FrequencyOfUpdata");
			Element FrequencyOfUpdataValue = FrequencyOfUpdataData.addElement("value");
			if (null != geochannelmetadata.getFrequencyOfUpdata()) {
				FrequencyOfUpdataValue.setText(geochannelmetadata.getFrequencyOfUpdata());
			}

			// LimitationOnPublicAccess
			Element LimitationOnPublicAccessData = geowwsMetadataList.addElement("Data");
			LimitationOnPublicAccessData.addAttribute("name","LimitationOnPublicAccess");
			Element LimitationOnPublicAccessValue = LimitationOnPublicAccessData.addElement("value");
			if (null != geochannelmetadata.getLimitationOnPublicAccess()) {
				LimitationOnPublicAccessValue.setText(geochannelmetadata.getLimitationOnPublicAccess());
			}

			// UseConstraints
			Element UseConstraintsData = geowwsMetadataList.addElement("Data");
			UseConstraintsData.addAttribute("name", "UseConstraints");
			Element UseConstraintsValue = UseConstraintsData.addElement("value");
			if (null != geochannelmetadata.getUseConstraints()) {
				UseConstraintsValue.setText(geochannelmetadata.getUseConstraints());
			}

			// CoupledGeoChannels
			Element CoupledGeoChannelsData = geowwsMetadataList.addElement("Data");
			CoupledGeoChannelsData.addAttribute("name", "CoupledGeoChannels");
			Element CoupledGeoChannelsValue = CoupledGeoChannelsData.addElement("value");
			if (null != geochannelmetadata.getCoupledGeoChannels()) {
				CoupledGeoChannelsValue.setText(geochannelmetadata.getCoupledGeoChannels());
			}

			// AdditionalInformation
			Element AdditionalInformationData = geowwsMetadataList.addElement("Data");
			AdditionalInformationData.addAttribute("name","AdditionalInformation");
			Element AdditionalInformationValue = AdditionalInformationData.addElement("value");
			if (null != geochannelmetadata.getAdditionalInformation()) {
				AdditionalInformationValue.setText(geochannelmetadata.getAdditionalInformation());
			}

			// MetadataDateTime
			Element MetadataDateTimeData = geowwsMetadataList.addElement("Data");
			MetadataDateTimeData.addAttribute("name", "MetadataDateTime");
			Element MetadataDateTimeValue = MetadataDateTimeData.addElement("value");
			if (null != geochannelmetadata.getMetadataDateTime()) {
				MetadataDateTimeValue.setText(geochannelmetadata.getMetadataDateTime().toGMTString());
			}

			// MetadataLanguage
			Element MetadataLanguageData = geowwsMetadataList.addElement("Data");
			MetadataLanguageData.addAttribute("name", "MetadataLanguage");
			Element MetadataLanguageValue = MetadataLanguageData.addElement("value");
			if (null != geochannelmetadata.getMetadataLanguage()) {
				MetadataLanguageValue.setText(geochannelmetadata.getMetadataLanguage());
			}

			// MetadataContact
			Element MetadataContactData = geowwsMetadataList.addElement("Data");
			MetadataContactData.addAttribute("name", "MetadataContact");
			Element MetadataContactValue = MetadataContactData.addElement("value");
			if (geochannelmetadata.getMetadataContact() != null) {
				MetadataContactValue.setText(geochannelmetadata.getMetadataContact());
			}

		}
		return document;

	}

}
