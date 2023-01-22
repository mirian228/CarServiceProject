package dao.jdbc;

import java.sql.Connection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IEmployeesDao;
import model.Employees;
import utility.ConnectionPool;

public class EmployeesDaoImpl implements IEmployeesDao {
	private static final Logger LOGGER = LogManager.getLogger(CarDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public Employees selectEntityById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employees> selectAllEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertEntity(Employees entity) {
		// TODO Auto-generated method stub
		
	}

	public Employees selectEntintyById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employees> selectAllEntity(Employees entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateEntity(Employees entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public Employees createEntity(Employees entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteEntinty(Employees entity) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
	


}
