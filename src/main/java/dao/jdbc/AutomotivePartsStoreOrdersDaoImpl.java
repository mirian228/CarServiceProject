package dao.jdbc;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IAutomotivePartsStoreOrdersDao;
import model.AutomotivePartsStoreOrders;
import utility.ConnectionPool;

public class AutomotivePartsStoreOrdersDaoImpl implements IAutomotivePartsStoreOrdersDao {
    private static final Logger LOGGER = LogManager.getLogger(AutomotivePartsStoreOrdersDaoImpl.class);
    ConnectionPool conPool = ConnectionPool.getInstance();
	@Override
	public void insertEntity(AutomotivePartsStoreOrders enity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AutomotivePartsStoreOrders selectEntityById(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AutomotivePartsStoreOrders> selectAllEntity() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEntity(AutomotivePartsStoreOrders entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntinty(AutomotivePartsStoreOrders entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
