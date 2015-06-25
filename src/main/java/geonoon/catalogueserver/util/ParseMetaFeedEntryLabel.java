package geonoon.catalogueserver.util;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

//import org.dom4j.Document;
import org.dom4j.Element;

//import com.mysql.jdbc.log.Log;

import geonoon.catalogueserver.bean.Geochannelmetadata;

/**
 * 
 * @author Kehuai parser for parsing Entry label
 */
public class ParseMetaFeedEntryLabel {
	public static Geochannelmetadata parseMetaFeedEntryLabel(
			Geochannelmetadata geochannelmetadata, Element aelm) {
		System.out.println("Beginning parse metafeed...");
		Element elm = aelm.element("CatalogMetadata");

		geochannelmetadata.setTitle(elm.elementText("title"));
		// System.out.println(geochannelmetadata.getTitle());
		geochannelmetadata.setAlternativeTitle(elm.elementText("alternativeTitle"));
		geochannelmetadata.setServiceLanguage(elm.elementText("serviceLanguage"));		
		geochannelmetadata.setAbstract_(elm.elementText("abstract"));		
		geochannelmetadata.setTopicCategory(elm.elementText("topicCategory"));		
		geochannelmetadata.setGeoChannelIdentifier(elm.elementText("geoChannelIdentifier"));
		// resourceIdentifiers schema ц╩сп
		// resourceIdentifiers=elm.elementText("");
		geochannelmetadata.setResourceIdentifiers(null);	
		geochannelmetadata.setKeyword(elm.elementText("keyword"));
		geochannelmetadata.setResourceType(elm.elementText("resourceType"));
		geochannelmetadata.setSpatialFeature(elm.elementText("spatialFeature"));
		
		if (null != elm.elementText("spatialMetrics")) {
			geochannelmetadata.setSpatialMetrics(new BigDecimal(elm.elementText("spatialMetrics")));
		} else {
			geochannelmetadata.setSpatialMetrics(BigDecimal.valueOf(0.0));
		}
		
		geochannelmetadata.setBoundingBox(elm.elementText("boundingBox"));
		geochannelmetadata.setSpatialExtent(elm.elementText("spatialExtent"));
		
		if (null != elm.elementText("verticalExtentLow")) {
			geochannelmetadata.setVerticalExtentLow(Double.valueOf(elm.elementText("verticalExtentLow")));
		} else {
			geochannelmetadata.setVerticalExtentLow(0.0);
		}
		
		if (null != elm.elementText("verticalExtentHigh")) {
			geochannelmetadata.setVerticalExtentHigh(Double.valueOf(elm.elementText("verticalExtentHigh")));
		} else {
			geochannelmetadata.setVerticalExtentHigh(0.0);
		}
		
		geochannelmetadata.setSpatialReferenceSystem(elm.elementText("spatialReferenceSystem"));
		
		if (null != elm.elementText("spatialResolution")) {
			geochannelmetadata.setSpatialResolution(new BigDecimal(elm.elementText("spatialResolution")));
		} else {
			geochannelmetadata.setSpatialResolution(BigDecimal.valueOf(0.0));
		}

		if (null != elm.element("temporalExtent")) {
			if (null != elm.element("temporalExtent").elementText("start")) {
				geochannelmetadata.setTemporalExtentStart(Timestamp.valueOf(elm
						.element("temporalExtent").elementText("start")));
			} else {
				geochannelmetadata.setTemporalExtentStart(new Timestamp(
						Calendar.getInstance().getTimeInMillis()));
			}
		} else {
			geochannelmetadata.setTemporalExtentStart(new Timestamp(Calendar
					.getInstance().getTimeInMillis()));
		}

		if (null != elm.element("temporalExtent")) {
			if (null != elm.element("temporalExtent").elementText("end")) {
				geochannelmetadata.setTemporalExtentEnd(Timestamp.valueOf(elm
						.element("temporalExtent").elementText("end")));
			} else {
				geochannelmetadata.setTemporalExtentEnd(new Timestamp(Calendar
						.getInstance().getTimeInMillis()));
			}
		} else {
			geochannelmetadata.setTemporalExtentEnd(new Timestamp(Calendar
					.getInstance().getTimeInMillis()));
		}

		
		if (null != elm.elementText("publicationDate")) {
			geochannelmetadata.setPublicationDate(Date.valueOf(elm.elementText("publicationDate")));
		} else {
			geochannelmetadata.setPublicationDate(new Date(new java.util.Date().getTime()));
		}
		geochannelmetadata.setGeowwUri(elm.elementText("geowwURI"));
		// System.out.println(geochannelmetadata.getGeowwUri());

		geochannelmetadata.setDataFormat(elm.elementText("dataFormat"));
		geochannelmetadata.setResponsibleOrganisation(elm.elementText("responsibleOrganisation"));
		geochannelmetadata.setFrequencyOfUpdata(elm.elementText("frequencyOfUpdate"));
		geochannelmetadata.setLimitationOnPublicAccess(elm.elementText("limitationOnPublicAccess"));
		geochannelmetadata.setUseConstraints(elm.elementText("useConstraints"));
		geochannelmetadata.setCoupledGeoChannels(elm.elementText("coupledGeoChannels"));
		geochannelmetadata.setAdditionalInformation(elm.elementText("additionalInformation"));
		
		if (null != elm.elementText("metadataDateTime")) {
			// SimpleDateFormat df = new
			// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// java.util.Date time =
			// df.parse(elm.elementText("metadataDateTime"));
			// metadataDateTime = new Timestamp(time.getTime());
			geochannelmetadata.setMetadataDateTime(Timestamp.valueOf(elm.elementText("metadataDateTime")));
			// metadataDateTime =elm.elementText("metadataDateTime");
		} else {
			geochannelmetadata.setMetadataDateTime(new Timestamp(Calendar
					.getInstance().getTimeInMillis()));
		}
		// System.out.println(metadataDateTime.toGMTString());
		geochannelmetadata.setMetadataLanguage(elm
				.elementText("metadataLanguage"));
		geochannelmetadata.setMetadataContact(elm
				.elementText("metadataContact"));
		System.out.println("Endding parse metafeed...");
		;
		return geochannelmetadata;
	}

}
