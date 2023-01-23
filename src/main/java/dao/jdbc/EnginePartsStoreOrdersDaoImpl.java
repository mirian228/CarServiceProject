package dao.jdbc;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IEnginePartsStoreOrdersDao;
import model.EnginePartsStoreOrders;
import utility.ConnectionPool;

public class EnginePartsStoreOrdersDaoImpl implements IEnginePartsStoreOrdersDao {
    private static final Logger LOGGER = LogManager.getLogger(EnginePartsStoreOrdersDaoImpl.class);
    ConnectionPool conPool = ConnectionPool.getInstance();
	@Override
	public void insertEntity(EnginePartsStoreOrders enity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EnginePartsStoreOrders selectEntityById(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnginePartsStoreOrders> selectAllEntity() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEntity(EnginePartsStoreOrders entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntinty(EnginePartsStoreOrders entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
