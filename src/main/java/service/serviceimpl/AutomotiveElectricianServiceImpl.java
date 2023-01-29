package service.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IAutomotiveElectricianDao;
import model.AutomotiveElectrician;
import service.IAutomotiveElectricianService;
import utility.MyBatisUtil;

public class AutomotiveElectricianServiceImpl implements IAutomotiveElectricianService {
	private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
	private static final Logger LOGGER = LogManager.getLogger(AutomotiveElectricianServiceImpl.class);
	AutomotiveElectrician automotiveElectrician;

	@Override
	public AutomotiveElectrician selectEntityById(Long id) throws SQLException {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IAutomotiveElectricianDao automotiveElectricianDao = sqlSession.getMapper(IAutomotiveElectricianDao.class);
			automotiveElectrician = automotiveElectricianDao.selectEntityById(id);
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
		}
		return automotiveElectrician;
	}

	@Override
	public List<AutomotiveElectrician> selectAllEntity() {
		List<AutomotiveElectrician> automotiveElectricianList = null;
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			try {
				IAutomotiveElectricianDao automotiveElectricianDao = sqlSession
						.getMapper(IAutomotiveElectricianDao.class);
				automotiveElectricianList = automotiveElectricianDao.selectAllEntity();
			} catch (SQLException e) {
				LOGGER.error("SQLException", e);
			}
		}
		return automotiveElectricianList;
	}

	@Override
	public void insertEntity(AutomotiveElectrician entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IAutomotiveElectricianDao automotiveElectricianDao = sqlSession.getMapper(IAutomotiveElectricianDao.class);
			try {
				automotiveElectricianDao.insertEntity(entity);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);

			}
		}

	}

	@Override
	public void updateEntity(AutomotiveElectrician entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IAutomotiveElectricianDao automotiveElectricianDao = sqlSession.getMapper(IAutomotiveElectricianDao.class);
			try {
				automotiveElectricianDao.updateEntity(entity);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);
			}
		}

	}

	@Override
	public void deleteEntinty(Long id) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IAutomotiveElectricianDao automotiveElectricianDao = sqlSession.getMapper(IAutomotiveElectricianDao.class);
			try {
				automotiveElectricianDao.deleteEntinty(id);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);
			}
		}

	}

}
