package service.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IPartWarehouseDao;
import model.PartWarehouse;
import service.IPartWarehouseService;
import utility.MyBatisUtil;

public class PartWarehouseServiceImpl implements IPartWarehouseService {
	private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
	private static final Logger LOGGER = LogManager.getLogger(PartWarehouseServiceImpl.class);
	PartWarehouse partWarehouse;

	@Override
	public PartWarehouse selectEntityById(Long id) throws SQLException {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IPartWarehouseDao partWarehouseDao = sqlSession.getMapper(IPartWarehouseDao.class);
			partWarehouse = partWarehouseDao.selectEntityById(id);
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);

		}
		return partWarehouse;
	}

	@Override
	public List<PartWarehouse> selectAllEntity() {
		List<PartWarehouse> partWarehouseList = null;
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IPartWarehouseDao partWarehouseDao = sqlSession.getMapper(IPartWarehouseDao.class);
			try {
				partWarehouseList = partWarehouseDao.selectAllEntity();
			} catch (SQLException e) {
				LOGGER.error("SQLException", e);
			}

		}
		return partWarehouseList;
	}

	@Override
	public void insertEntity(PartWarehouse entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {

			IPartWarehouseDao partWarehouseDao = sqlSession.getMapper(IPartWarehouseDao.class);

			try {
				partWarehouseDao.insertEntity(entity);
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
	public void updateEntity(PartWarehouse entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IPartWarehouseDao partWarehouseDao = sqlSession.getMapper(IPartWarehouseDao.class);
			try {
				partWarehouseDao.updateEntity(entity);
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
			IPartWarehouseDao partWarehouseDao = sqlSession.getMapper(IPartWarehouseDao.class);

			try {
				partWarehouseDao.deleteEntinty(id);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);
			}

		}

	}

}
