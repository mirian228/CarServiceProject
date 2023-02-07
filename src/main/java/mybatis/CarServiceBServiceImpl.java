package mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ICarServiceBDao;
import model.CarServiceB;
import utility.MyBatisUtil;

public class CarServiceBServiceImpl implements ICarServiceBDao {
	private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
	private static final Logger LOGGER = LogManager.getLogger(CarServiceBServiceImpl.class);
	CarServiceB carServiceB;

	@Override
	public CarServiceB selectEntityById(Long id) throws SQLException {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			ICarServiceBDao carServiceBDao = sqlSession.getMapper(ICarServiceBDao.class);
			carServiceB = carServiceBDao.selectEntityById(id);
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
		}
		return carServiceB;
	}

	@Override
	public List<CarServiceB> selectAllEntity() {
		List<CarServiceB> carServiceBList = null;
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			try {
				ICarServiceBDao carServiceBDao = sqlSession.getMapper(ICarServiceBDao.class);
				carServiceBList = carServiceBDao.selectAllEntity();
			} catch (SQLException e) {
				LOGGER.error("SQLException", e);
			}
		}
		return carServiceBList;
	}

	@Override
	public void insertEntity(CarServiceB entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			ICarServiceBDao carServiceBDao = sqlSession.getMapper(ICarServiceBDao.class);
			try {
				carServiceBDao.insertEntity(entity);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);

			}
		}
	}

	@Override
	public void updateEntity(CarServiceB entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			ICarServiceBDao carServiceBDao = sqlSession.getMapper(ICarServiceBDao.class);
			try {
				carServiceBDao.updateEntity(entity);
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
			ICarServiceBDao carServiceBDao = sqlSession.getMapper(ICarServiceBDao.class);
			try {
				carServiceBDao.deleteEntinty(id);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);
			}
		}

	}

}
