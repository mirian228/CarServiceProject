package mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IEngineMechanicDao;
import model.EngineMechanic;
import utility.MyBatisUtil;

public class EngineMechanicServiceImpl implements IEngineMechanicDao {
	private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
	private static final Logger LOGGER = LogManager.getLogger(EngineMechanicServiceImpl.class);
	EngineMechanic engineMechanic;

	@Override
	public EngineMechanic selectEntityById(Long id) throws SQLException {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IEngineMechanicDao engineMechanicDao = sqlSession.getMapper(IEngineMechanicDao.class);
			engineMechanic = engineMechanicDao.selectEntityById(id);
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);

		}
		return engineMechanic;
	}

	@Override
	public List<EngineMechanic> selectAllEntity() {
		List<EngineMechanic> engineMechanicList = null;
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IEngineMechanicDao engineMechanicDao = sqlSession.getMapper(IEngineMechanicDao.class);
			try {
				engineMechanicList = engineMechanicDao.selectAllEntity();
			} catch (SQLException e) {
				LOGGER.error("SQLException", e);
			}

		}
		return engineMechanicList;
	}

	@Override
	public void insertEntity(EngineMechanic entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {

			IEngineMechanicDao engineMechanicDao = sqlSession.getMapper(IEngineMechanicDao.class);

			try {
				engineMechanicDao.insertEntity(entity);
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
	public void updateEntity(EngineMechanic entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IEngineMechanicDao engineMechanicDao = sqlSession.getMapper(IEngineMechanicDao.class);
			try {
				engineMechanicDao.updateEntity(entity);
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
			IEngineMechanicDao engineMechanicDao = sqlSession.getMapper(IEngineMechanicDao.class);

			try {
				engineMechanicDao.deleteEntinty(id);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);
			}

		}

	}

}
