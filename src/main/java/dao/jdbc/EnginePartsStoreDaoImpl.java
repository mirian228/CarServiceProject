package dao.jdbc;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IEnginePartsStoreDao;
import model.EnginePartsStore;
import utility.ConnectionPool;

public class EnginePartsStoreDaoImpl implements IEnginePartsStoreDao {
	private static final Logger LOGGER = LogManager.getLogger(EnginePartsStoreDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public EnginePartsStore selectEntityById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EnginePartsStore> selectAllEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertEntity(EnginePartsStore entity) {
		// TODO Auto-generated method stub
		
	}

	public EnginePartsStore selectEntintyById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EnginePartsStore> selectAllEntity(EnginePartsStore entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateEntity(EnginePartsStore entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public EnginePartsStore createEntity(EnginePartsStore entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteEntinty(EnginePartsStore entity) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	


}
