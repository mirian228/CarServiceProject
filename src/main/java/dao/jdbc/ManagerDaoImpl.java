package dao.jdbc;

import java.sql.Connection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IManagerDao;
import model.Manager;
import utility.ConnectionPool;

public class ManagerDaoImpl implements IManagerDao {
	private static final Logger LOGGER = LogManager.getLogger(CarDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public Manager selectEntityById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Manager> selectAllEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertEntity(Manager entity) {
		// TODO Auto-generated method stub
		
	}

	public Manager selectEntintyById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Manager> selectAllEntity(Manager entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateEntity(Manager entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public Manager createEntity(Manager entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteEntinty(Manager entity) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	

}
