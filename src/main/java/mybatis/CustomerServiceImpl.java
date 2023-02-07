package mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ICustomerDao;
import model.Customer;
import utility.MyBatisUtil;

public class CustomerServiceImpl implements ICustomerDao {
	private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
	private static final Logger LOGGER = LogManager.getLogger(CustomerServiceImpl.class);
	Customer customer;

	@Override
	public Customer selectEntityById(Long id) throws SQLException {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			ICustomerDao customerDao = sqlSession.getMapper(ICustomerDao.class);
			customer = customerDao.selectEntityById(id);
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);

		}
		return customer;
	}

	@Override
	public List<Customer> selectAllEntity() {
		List<Customer> customerList = null;
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			ICustomerDao customerDao = sqlSession.getMapper(ICustomerDao.class);
			try {
				customerList = customerDao.selectAllEntity();
			} catch (SQLException e) {
				LOGGER.error("SQLException", e);
			}

		}
		return customerList;
	}

	@Override
	public void insertEntity(Customer entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {

			ICustomerDao customerDao = sqlSession.getMapper(ICustomerDao.class);

			try {
				customerDao.insertEntity(entity);
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
	public void updateEntity(Customer entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			ICustomerDao customerDao = sqlSession.getMapper(ICustomerDao.class);
			try {
				customerDao.updateEntity(entity);
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
			ICustomerDao customerDao = sqlSession.getMapper(ICustomerDao.class);

			try {
				customerDao.deleteEntinty(id);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);
			}

		}

	}

}
