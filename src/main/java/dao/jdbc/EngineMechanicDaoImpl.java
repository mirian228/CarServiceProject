package dao.jdbc;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IEngineMechanicDao;
import model.EngineMechanic;
import utility.ConnectionPool;

public class EngineMechanicDaoImpl implements IEngineMechanicDao {
	private static final Logger LOGGER = LogManager.getLogger(EngineMechanicDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public EngineMechanic selectEntityById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EngineMechanic> selectAllEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertEntity(EngineMechanic entity) {
		// TODO Auto-generated method stub
		
	}

	public EngineMechanic selectEntintyById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EngineMechanic> selectAllEntity(EngineMechanic entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateEntity(EngineMechanic entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public EngineMechanic createEntity(EngineMechanic entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteEntinty(EngineMechanic entity) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	


}
