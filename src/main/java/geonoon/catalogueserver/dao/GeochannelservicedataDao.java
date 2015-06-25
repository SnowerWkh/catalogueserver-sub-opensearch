package geonoon.catalogueserver.dao;

import java.util.List;

import geonoon.catalogueserver.bean.Geochannelmetadata;

public interface GeochannelservicedataDao {
	// select item by geowwuri from table geochannelmetadata
	public Geochannelmetadata findByGeoUrlFromGeochannelmetadata(
			Geochannelmetadata eGeochannelmetadata);

	// select item by opensearch parameter
	public List<Geochannelmetadata> findByOpensearchParameter(
			Geochannelmetadata eGeochannelmetadata);

	// update table geochannelmetadata
	public int updateGeoChannelMeta(Geochannelmetadata eGeochannelmetadata);

	// insert table geochannelmetadata
	public int insertGeoChannelMeta(Geochannelmetadata eGeochannelmetadata);
}
