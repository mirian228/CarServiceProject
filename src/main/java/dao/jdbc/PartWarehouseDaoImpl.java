package dao.jdbc;

import java.sql.Connection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IPartWarehouseDao;
import model.PartWarehouse;
import utility.ConnectionPool;

public class PartWarehouseDaoImpl implements IPartWarehouseDao {
	private static final Logger LOGGER = LogManager.getLogger(CarDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public PartWarehouse selectEntityById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PartWarehouse> selectAllEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertEntity(PartWarehouse entity) {
		// TODO Auto-generated method stub
		
	}

	public PartWarehouse selectEntintyById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PartWarehouse> selectAllEntity(PartWarehouse entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateEntity(PartWarehouse entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public PartWarehouse createEntity(PartWarehouse entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteEntinty(PartWarehouse entity) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
}
