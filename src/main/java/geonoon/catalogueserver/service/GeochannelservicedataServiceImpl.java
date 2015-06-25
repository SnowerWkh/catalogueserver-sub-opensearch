package geonoon.catalogueserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import geonoon.catalogueserver.bean.Geochannelmetadata;
import geonoon.catalogueserver.dao.GeochannelservicedataDao;

//import org.springframework.stereotype.Service;

@Service
public class GeochannelservicedataServiceImpl implements
		GeochannelservicedataService {
	@Autowired
	private GeochannelservicedataDao gDao;

	// @Transactional(rollbackFor = Exception.class)
	public Geochannelmetadata findGeochannelmetadataByGeouri(
			Geochannelmetadata eGeochannelmetadata) {
		Geochannelmetadata result = null;
		try {
			result = gDao
					.findByGeoUrlFromGeochannelmetadata(eGeochannelmetadata);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updateGeoChannelMeta(Geochannelmetadata eGeochannelmetadata) {
		int i = 0;
		try {
			i = gDao.updateGeoChannelMeta(eGeochannelmetadata);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return i;
	}

	public int insertGeoChannelMeta(Geochannelmetadata eGeochannelmetadata) {
		int i = 0;
		try {
			i = gDao.insertGeoChannelMeta(eGeochannelmetadata);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public List<Geochannelmetadata> findGeochannelmetadataByOpensearchPara(
			Geochannelmetadata eGeochannelmetadata) {
		List<Geochannelmetadata> result = null;
		try {
			result = gDao.findByOpensearchParameter(eGeochannelmetadata);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
