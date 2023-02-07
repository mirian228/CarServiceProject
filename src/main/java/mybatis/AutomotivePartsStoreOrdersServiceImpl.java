package mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IAutomotivePartsStoreOrdersDao;
import model.AutomotivePartsStoreOrders;
import utility.MyBatisUtil;

public class AutomotivePartsStoreOrdersServiceImpl implements IAutomotivePartsStoreOrdersDao {
	private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
	private static final Logger LOGGER = LogManager.getLogger(AutomotivePartsStoreOrdersServiceImpl.class);
	AutomotivePartsStoreOrders automotivePartsStoreOrders;

	@Override
	public AutomotivePartsStoreOrders selectEntityById(Long id) throws SQLException {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IAutomotivePartsStoreOrdersDao automotivePartsStoreOrdersDao = sqlSession
					.getMapper(IAutomotivePartsStoreOrdersDao.class);
			automotivePartsStoreOrders = automotivePartsStoreOrdersDao.selectEntityById(id);
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
		}
		return automotivePartsStoreOrders;
	}

	@Override
	public List<AutomotivePartsStoreOrders> selectAllEntity() {
		List<AutomotivePartsStoreOrders> automotivePartsStoreOrdersList = null;
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			try {
				IAutomotivePartsStoreOrdersDao automotivePartsStoreOrdersDao = sqlSession
						.getMapper(IAutomotivePartsStoreOrdersDao.class);
				automotivePartsStoreOrdersList = automotivePartsStoreOrdersDao.selectAllEntity();
			} catch (SQLException e) {
				LOGGER.error("SQLException", e);
			}
		}
		return automotivePartsStoreOrdersList;
	}

	@Override
	public void insertEntity(AutomotivePartsStoreOrders entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IAutomotivePartsStoreOrdersDao automotivePartsStoreOrdersDao = sqlSession
					.getMapper(IAutomotivePartsStoreOrdersDao.class);
			try {
				automotivePartsStoreOrdersDao.insertEntity(entity);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);

			}
		}
	}

	@Override
	public void updateEntity(AutomotivePartsStoreOrders entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IAutomotivePartsStoreOrdersDao automotivePartsStoreOrdersDao = sqlSession
					.getMapper(IAutomotivePartsStoreOrdersDao.class);
			try {
				automotivePartsStoreOrdersDao.updateEntity(entity);
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
			IAutomotivePartsStoreOrdersDao automotivePartsStoreOrdersDao = sqlSession
					.getMapper(IAutomotivePartsStoreOrdersDao.class);
			try {
				automotivePartsStoreOrdersDao.deleteEntinty(id);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);
			}
		}

	}

}
