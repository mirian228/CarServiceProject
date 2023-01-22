package dao.jdbc;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ICustomerDao;
import model.Customer;
import utility.ConnectionPool;

public class CustomerDaoImpl implements ICustomerDao {
	private static final Logger LOGGER = LogManager.getLogger(CarDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public Customer selectEntityById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Customer> selectAllEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertEntity(Customer entity) {
		// TODO Auto-generated method stub
		
	}

	public Customer selectEntintyById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Customer> selectAllEntity(Customer entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateEntity(Customer entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public Customer createEntity(Customer entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteEntinty(Customer entity) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
	
}
