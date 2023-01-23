package dao.jdbc;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IDiagnosticsMechanicDao;
import model.DiagnosticsMechanic;
import utility.ConnectionPool;

public class DiagnosticsMechanicDaoImpl implements IDiagnosticsMechanicDao {
	private static final Logger LOGGER = LogManager.getLogger(DiagnosticsMechanicDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public DiagnosticsMechanic selectEntityById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DiagnosticsMechanic> selectAllEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertEntity(DiagnosticsMechanic entity) {
		// TODO Auto-generated method stub
		
	}

	public DiagnosticsMechanic selectEntintyById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DiagnosticsMechanic> selectAllEntity(DiagnosticsMechanic entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateEntity(DiagnosticsMechanic entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public DiagnosticsMechanic createEntity(DiagnosticsMechanic entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteEntinty(DiagnosticsMechanic entity) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	


}
