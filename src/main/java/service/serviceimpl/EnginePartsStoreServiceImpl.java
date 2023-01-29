package service.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IEnginePartsStoreDao;
import model.EnginePartsStore;
import service.IEnginePartsStoreService;
import utility.MyBatisUtil;

public class EnginePartsStoreServiceImpl implements IEnginePartsStoreService {
	private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
	private static final Logger LOGGER = LogManager.getLogger(EnginePartsStoreServiceImpl.class);
	EnginePartsStore enginePartsStore;

	@Override
	public EnginePartsStore selectEntityById(Long id) throws SQLException {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IEnginePartsStoreDao enginePartsStoreDao = sqlSession.getMapper(IEnginePartsStoreDao.class);
			enginePartsStore = enginePartsStoreDao.selectEntityById(id);
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);

		}
		return enginePartsStore;
	}

	@Override
	public List<EnginePartsStore> selectAllEntity() {
		List<EnginePartsStore> enginePartsStoreList = null;
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IEnginePartsStoreDao enginePartsStoreDao = sqlSession.getMapper(IEnginePartsStoreDao.class);
			try {
				enginePartsStoreList = enginePartsStoreDao.selectAllEntity();
			} catch (SQLException e) {
				LOGGER.error("SQLException", e);
			}

		}
		return enginePartsStoreList;
	}

	@Override
	public void insertEntity(EnginePartsStore entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {

			IEnginePartsStoreDao enginePartsStoreDao = sqlSession.getMapper(IEnginePartsStoreDao.class);

			try {
				enginePartsStoreDao.insertEntity(entity);
				sqlSession.commit();

			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);

			} catch (Exception e) {
				LOGGER.error("Exception", e);
			}

		}

	}

	@Override
	public void updateEntity(EnginePartsStore entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IEnginePartsStoreDao enginePartsStoreDao = sqlSession.getMapper(IEnginePartsStoreDao.class);
			try {
				enginePartsStoreDao.updateEntity(entity);
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
			IEnginePartsStoreDao enginePartsStoreDao = sqlSession.getMapper(IEnginePartsStoreDao.class);

			try {
				enginePartsStoreDao.deleteEntinty(id);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);
			}

		}

	}

}
