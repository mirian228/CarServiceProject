package service.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ICashierDao;
import model.Cashier;
import service.ICashierService;
import utility.MyBatisUtil;

public class CashierServiceImpl implements ICashierService {
	private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
	private static final Logger LOGGER = LogManager.getLogger(CashierServiceImpl.class);

	Cashier cashier;

	@Override
	public Cashier selectEntityById(Long id) {

		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			ICashierDao cashierDao = sqlSession.getMapper(ICashierDao.class);
			cashier = cashierDao.selectEntityById(id);
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);

		}
		return cashier;
	}

	@Override
	public List<Cashier> selectAllEntity() {
		List<Cashier> cashierList = null;
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			ICashierDao cashierDao = sqlSession.getMapper(ICashierDao.class);
			try {
				cashierList = cashierDao.selectAllEntity();
			} catch (SQLException e) {
				LOGGER.error("SQLException", e);
			}

		}
		return cashierList;
	}

	@Override
	public void insertEntity(Cashier entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {

			ICashierDao cashierDao = sqlSession.getMapper(ICashierDao.class);

			try {
				cashierDao.insertEntity(entity);
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
	public void updateEntity(Cashier entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			ICashierDao cashierDao = sqlSession.getMapper(ICashierDao.class);
			try {
				cashierDao.updateEntity(entity);
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
			ICashierDao cashierDao = sqlSession.getMapper(ICashierDao.class);

			try {
				cashierDao.deleteEntinty(id);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);
			}

		}

	}

}
