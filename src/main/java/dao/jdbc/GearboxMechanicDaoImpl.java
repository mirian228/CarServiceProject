package dao.jdbc;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IGearboxMechanicDao;
import model.GearboxMechanic;
import utility.ConnectionPool;

public class GearboxMechanicDaoImpl implements IGearboxMechanicDao {
	private static final Logger LOGGER = LogManager.getLogger(GearboxMechanicDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public GearboxMechanic selectEntityById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GearboxMechanic> selectAllEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertEntity(GearboxMechanic entity) {
		// TODO Auto-generated method stub
		
	}

	public GearboxMechanic selectEntintyById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GearboxMechanic> selectAllEntity(GearboxMechanic entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateEntity(GearboxMechanic entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public GearboxMechanic createEntity(GearboxMechanic entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteEntinty(GearboxMechanic entity) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	


}
