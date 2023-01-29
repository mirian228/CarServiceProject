package service.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IGearboxMechanicDao;
import model.GearboxMechanic;
import service.IGearboxMechanicService;
import utility.MyBatisUtil;

public class GearboxMechanicServiceImpl implements IGearboxMechanicService {
	private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
	private static final Logger LOGGER = LogManager.getLogger(GearboxMechanicServiceImpl.class);
	GearboxMechanic gearboxMechanic;

	@Override
	public GearboxMechanic selectEntityById(Long id) throws SQLException {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IGearboxMechanicDao gearboxMechanicDao = sqlSession.getMapper(IGearboxMechanicDao.class);
			gearboxMechanic = gearboxMechanicDao.selectEntityById(id);
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);

		}
		return gearboxMechanic;
	}

	@Override
	public List<GearboxMechanic> selectAllEntity() {
		List<GearboxMechanic> gearboxMechanicList = null;
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IGearboxMechanicDao gearboxMechanicDao = sqlSession.getMapper(IGearboxMechanicDao.class);
			try {
				gearboxMechanicList = gearboxMechanicDao.selectAllEntity();
			} catch (SQLException e) {
				LOGGER.error("SQLException", e);
			}

		}
		return gearboxMechanicList;
	}

	@Override
	public void insertEntity(GearboxMechanic entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {

			IGearboxMechanicDao gearboxMechanicDao = sqlSession.getMapper(IGearboxMechanicDao.class);

			try {
				gearboxMechanicDao.insertEntity(entity);
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
	public void updateEntity(GearboxMechanic entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IGearboxMechanicDao gearboxMechanicDao = sqlSession.getMapper(IGearboxMechanicDao.class);

			try {
				gearboxMechanicDao.updateEntity(entity);
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
			IGearboxMechanicDao gearboxMechanicDao = sqlSession.getMapper(IGearboxMechanicDao.class);

			try {
				gearboxMechanicDao.deleteEntinty(id);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);
			}

		}

	}

}
