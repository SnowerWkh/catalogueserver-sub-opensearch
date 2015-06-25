package geonoon.catalogueserver.service;

import java.util.List;

import geonoon.catalogueserver.bean.Geochannelmetadata;

public interface GeochannelservicedataService {
	// find geochannelmetadata by ID(Geouri)
	public Geochannelmetadata findGeochannelmetadataByGeouri(
			Geochannelmetadata eGeochannelmetadata);

	// find geochannelmetadata by opensearch parameters given
	public List<Geochannelmetadata> findGeochannelmetadataByOpensearchPara(
			Geochannelmetadata eGeochannelmetadata);

	// update
	public int updateGeoChannelMeta(Geochannelmetadata eGeochannelmetadata);

	// insert
	public int insertGeoChannelMeta(Geochannelmetadata eGeochannelmetadata);
}
