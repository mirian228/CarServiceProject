package mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IManagerDao;
import model.Manager;
import utility.MyBatisUtil;

public class ManagerServiceImpl implements IManagerDao {
	private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
	private static final Logger LOGGER = LogManager.getLogger(ManagerServiceImpl.class);
	Manager manager;
	@Override
	public Manager selectEntityById(Long id) throws SQLException {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IManagerDao managerDao = sqlSession.getMapper(IManagerDao.class);
			manager = managerDao.selectEntityById(id);
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);

		}
		return manager;
	}

	@Override
	public List<Manager> selectAllEntity() {
		List<Manager> managerList = null;
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IManagerDao managerDao = sqlSession.getMapper(IManagerDao.class);
			try {
				managerList = managerDao.selectAllEntity();
			} catch (SQLException e) {
				LOGGER.error("SQLException", e);
			}

		}
		return managerList;
	}

	@Override
	public void insertEntity(Manager entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {

			IManagerDao managerDao = sqlSession.getMapper(IManagerDao.class);

			try {
				managerDao.insertEntity(entity);
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
	public void updateEntity(Manager entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IManagerDao managerDao = sqlSession.getMapper(IManagerDao.class);
			try {
				managerDao.updateEntity(entity);
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
			IManagerDao managerDao = sqlSession.getMapper(IManagerDao.class);

			try {
				managerDao.deleteEntinty(id);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);
			}

		}
		
	}

}
