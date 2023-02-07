package mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IEnginePartsStoreOrdersDao;
import model.EnginePartsStoreOrders;
import utility.MyBatisUtil;

public class EnginePartsStoreOrdersServiceImpl implements IEnginePartsStoreOrdersDao {
	private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
	private static final Logger LOGGER = LogManager.getLogger(EnginePartsStoreOrdersServiceImpl.class);
	EnginePartsStoreOrders enginePartsStoreOrders;

	@Override
	public EnginePartsStoreOrders selectEntityById(Long id) throws SQLException {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IEnginePartsStoreOrdersDao enginePartsStoreOrdersDao = sqlSession
					.getMapper(IEnginePartsStoreOrdersDao.class);
			enginePartsStoreOrders = enginePartsStoreOrdersDao.selectEntityById(id);
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);

		}
		return enginePartsStoreOrders;
	}

	@Override
	public List<EnginePartsStoreOrders> selectAllEntity() {
		List<EnginePartsStoreOrders> enginePartsStoreOrdersList = null;
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IEnginePartsStoreOrdersDao enginePartsStoreOrdersDao = sqlSession
					.getMapper(IEnginePartsStoreOrdersDao.class);
			try {
				enginePartsStoreOrdersList = enginePartsStoreOrdersDao.selectAllEntity();
			} catch (SQLException e) {
				LOGGER.error("SQLException", e);
			}

		}
		return enginePartsStoreOrdersList;
	}

	@Override
	public void insertEntity(EnginePartsStoreOrders entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {

			IEnginePartsStoreOrdersDao enginePartsStoreOrdersDao = sqlSession
					.getMapper(IEnginePartsStoreOrdersDao.class);

			try {
				enginePartsStoreOrdersDao.insertEntity(entity);
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
	public void updateEntity(EnginePartsStoreOrders entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IEnginePartsStoreOrdersDao enginePartsStoreOrdersDao = sqlSession
					.getMapper(IEnginePartsStoreOrdersDao.class);
			try {
				enginePartsStoreOrdersDao.updateEntity(entity);
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
			IEnginePartsStoreOrdersDao enginePartsStoreOrdersDao = sqlSession
					.getMapper(IEnginePartsStoreOrdersDao.class);

			try {
				enginePartsStoreOrdersDao.deleteEntinty(id);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);
			}

		}

	}

}
