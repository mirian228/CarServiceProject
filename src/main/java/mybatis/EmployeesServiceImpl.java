package mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IEmployeesDao;
import model.Employees;
import utility.MyBatisUtil;

public class EmployeesServiceImpl implements IEmployeesDao {
	private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
	private static final Logger LOGGER = LogManager.getLogger(EmployeesServiceImpl.class);
	Employees employees;

	@Override
	public Employees selectEntityById(Long id) throws SQLException {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IEmployeesDao employeesDao = sqlSession.getMapper(IEmployeesDao.class);
			employees = employeesDao.selectEntityById(id);
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);

		}
		return employees;
	}

	@Override
	public List<Employees> selectAllEntity() {
		List<Employees> employeesList = null;
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IEmployeesDao employeesDao = sqlSession.getMapper(IEmployeesDao.class);
			try {
				employeesList = employeesDao.selectAllEntity();
			} catch (SQLException e) {
				LOGGER.error("SQLException", e);
			}

		}
		return employeesList;
	}

	@Override
	public void insertEntity(Employees entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {

			IEmployeesDao employeesDao = sqlSession.getMapper(IEmployeesDao.class);

			try {
				employeesDao.insertEntity(entity);
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
	public void updateEntity(Employees entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IEmployeesDao employeesDao = sqlSession.getMapper(IEmployeesDao.class);
			try {
				employeesDao.updateEntity(entity);
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
			IEmployeesDao employeesDao = sqlSession.getMapper(IEmployeesDao.class);

			try {
				employeesDao.deleteEntinty(id);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);
			}

		}

	}

}
