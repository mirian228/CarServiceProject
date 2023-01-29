package service.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ICarServiceADao;
import model.CarServiceA;
import service.ICarServiceAService;
import utility.MyBatisUtil;

public class CarServiceAServiceImpl implements ICarServiceAService {
	private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
	private static final Logger LOGGER = LogManager.getLogger(CarServiceAServiceImpl.class);
	CarServiceA carServiceA;

	@Override
	public CarServiceA selectEntityById(Long id) throws SQLException {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			ICarServiceADao CarServiceADao = sqlSession.getMapper(ICarServiceADao.class);
			carServiceA = CarServiceADao.selectEntityById(id);
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
		}
		return carServiceA;
	}

	@Override
	public List<CarServiceA> selectAllEntity() {
		List<CarServiceA> carServiceAList = null;
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			try {
				ICarServiceADao CarServiceADao = sqlSession.getMapper(ICarServiceADao.class);
				carServiceAList = CarServiceADao.selectAllEntity();
			} catch (SQLException e) {
				LOGGER.error("SQLException", e);
			}
		}
		return carServiceAList;
	}

	@Override
	public void insertEntity(CarServiceA entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			ICarServiceADao CarServiceADao = sqlSession.getMapper(ICarServiceADao.class);
			try {
				CarServiceADao.insertEntity(entity);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);

			}
		}

	}

	@Override
	public void updateEntity(CarServiceA entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			ICarServiceADao CarServiceADao = sqlSession.getMapper(ICarServiceADao.class);
			try {
				CarServiceADao.updateEntity(entity);
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
			ICarServiceADao CarServiceADao = sqlSession.getMapper(ICarServiceADao.class);
			try {
				CarServiceADao.deleteEntinty(id);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);
			}
		}

	}

}
