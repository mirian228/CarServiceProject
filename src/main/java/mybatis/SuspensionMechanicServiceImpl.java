package mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ISuspensionMechanicDao;
import model.SuspensionMechanic;
import utility.MyBatisUtil;

public class SuspensionMechanicServiceImpl implements ISuspensionMechanicDao {
	private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
	private static final Logger LOGGER = LogManager.getLogger(SuspensionMechanicServiceImpl.class);
	SuspensionMechanic suspensionMechanic;

	@Override
	public SuspensionMechanic selectEntityById(Long id) throws SQLException {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			ISuspensionMechanicDao suspensionMechanicDao = sqlSession.getMapper(ISuspensionMechanicDao.class);
			suspensionMechanic = suspensionMechanicDao.selectEntityById(id);
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);

		}
		return suspensionMechanic;
	}

	@Override
	public List<SuspensionMechanic> selectAllEntity() {
		List<SuspensionMechanic> suspensionMechanicList = null;
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			ISuspensionMechanicDao suspensionMechanicDao = sqlSession.getMapper(ISuspensionMechanicDao.class);
			try {
				suspensionMechanicList = suspensionMechanicDao.selectAllEntity();
			} catch (SQLException e) {
				LOGGER.error("SQLException", e);
			}

		}
		return suspensionMechanicList;
	}

	@Override
	public void insertEntity(SuspensionMechanic entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {

			ISuspensionMechanicDao suspensionMechanicDao = sqlSession.getMapper(ISuspensionMechanicDao.class);

			try {
				suspensionMechanicDao.insertEntity(entity);
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
	public void updateEntity(SuspensionMechanic entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			ISuspensionMechanicDao suspensionMechanicDao = sqlSession.getMapper(ISuspensionMechanicDao.class);
			try {
				suspensionMechanicDao.updateEntity(entity);
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
			ISuspensionMechanicDao suspensionMechanicDao = sqlSession.getMapper(ISuspensionMechanicDao.class);

			try {
				suspensionMechanicDao.deleteEntinty(id);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);
			}

		}

	}

}
