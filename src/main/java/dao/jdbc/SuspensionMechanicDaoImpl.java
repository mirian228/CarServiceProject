package dao.jdbc;

import java.sql.Connection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ISuspensionMechanicDao;
import model.SuspensionMechanic;
import utility.ConnectionPool;

public class SuspensionMechanicDaoImpl implements ISuspensionMechanicDao {
	private static final Logger LOGGER = LogManager.getLogger(CarDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public SuspensionMechanic selectEntityById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SuspensionMechanic> selectAllEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertEntity(SuspensionMechanic entity) {
		// TODO Auto-generated method stub
		
	}

	public SuspensionMechanic selectEntintyById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SuspensionMechanic> selectAllEntity(SuspensionMechanic entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateEntity(SuspensionMechanic entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public SuspensionMechanic createEntity(SuspensionMechanic entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteEntinty(SuspensionMechanic entity) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	


}
