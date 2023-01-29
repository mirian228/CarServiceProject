package service.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IAutomotivePartsStoreDao;
import model.AutomotivePartsStore;
import service.IAutomotivePartsStoreService;
import utility.MyBatisUtil;

public class AutomotivePartsStoreServiceImpl implements IAutomotivePartsStoreService {
	private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
	private static final Logger LOGGER = LogManager.getLogger(AutomotivePartsStoreServiceImpl.class);
	AutomotivePartsStore automotivePartsStore;

	@Override
	public AutomotivePartsStore selectEntityById(Long id) throws SQLException {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IAutomotivePartsStoreDao automotivePartsStoreDao = sqlSession.getMapper(IAutomotivePartsStoreDao.class);
			automotivePartsStore = automotivePartsStoreDao.selectEntityById(id);
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
		}

		return automotivePartsStore;
	}

	@Override
	public List<AutomotivePartsStore> selectAllEntity() {
		List<AutomotivePartsStore> automotivePartsStoreList = null;
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			try {
				IAutomotivePartsStoreDao automotivePartsStoreDao = sqlSession.getMapper(IAutomotivePartsStoreDao.class);
				automotivePartsStoreList = automotivePartsStoreDao.selectAllEntity();
			} catch (SQLException e) {
				LOGGER.error("SQLException", e);
			}
		}
		return automotivePartsStoreList;
	}

	@Override
	public void insertEntity(AutomotivePartsStore entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IAutomotivePartsStoreDao automotivePartsStoreDao = sqlSession.getMapper(IAutomotivePartsStoreDao.class);
			try {
				automotivePartsStoreDao.insertEntity(entity);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);

			}
		}

	}

	@Override
	public void updateEntity(AutomotivePartsStore entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IAutomotivePartsStoreDao automotivePartsStoreDao = sqlSession.getMapper(IAutomotivePartsStoreDao.class);
			try {
				automotivePartsStoreDao.updateEntity(entity);
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
			IAutomotivePartsStoreDao automotivePartsStoreDao = sqlSession.getMapper(IAutomotivePartsStoreDao.class);
			try {
				automotivePartsStoreDao.deleteEntinty(id);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);
			}
		}

	}

}
