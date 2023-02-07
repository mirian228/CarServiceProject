package mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ICarDao;
import model.Car;
import utility.MyBatisUtil;

public class CarServiceImpl implements ICarDao {

	private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
	private static final Logger LOGGER = LogManager.getLogger(CarServiceImpl.class);
	Car car;

	@Override
	public Car selectEntityById(Long id) throws SQLException {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			ICarDao carDao = sqlSession.getMapper(ICarDao.class);
			car = carDao.selectEntityById(id);
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
		}
		return car;
	}

	@Override
	public List<Car> selectAllEntity() {
		List<Car> carList = null;
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			try {
				ICarDao carDao = sqlSession.getMapper(ICarDao.class);
				carList = carDao.selectAllEntity();
			} catch (SQLException e) {
				LOGGER.error("SQLException", e);
			}
		}
		return carList;
	}

	@Override
	public void insertEntity(Car entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			ICarDao carDao = sqlSession.getMapper(ICarDao.class);
			try {
				carDao.insertEntity(entity);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);

			}
		}
	}

	@Override
	public void updateEntity(Car entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			ICarDao carDao = sqlSession.getMapper(ICarDao.class);
			try {
				carDao.updateEntity(entity);
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
			ICarDao carDao = sqlSession.getMapper(ICarDao.class);
			try {
				carDao.deleteEntinty(id);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);
			}
		}

	}

}
