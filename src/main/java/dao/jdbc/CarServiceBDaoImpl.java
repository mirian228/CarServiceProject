package dao.jdbc;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ICarServiceBDao;
import model.CarServiceB;
import utility.ConnectionPool;

public class CarServiceBDaoImpl implements ICarServiceBDao {
	private static final Logger LOGGER = LogManager.getLogger(CarServiceBDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public CarServiceB selectEntityById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CarServiceB> selectAllEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertEntity(CarServiceB entity) {
		// TODO Auto-generated method stub

	}

	public CarServiceB selectEntintyById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CarServiceB> selectAllEntity(CarServiceB entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateEntity(CarServiceB entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public CarServiceB createEntity(CarServiceB entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteEntinty(CarServiceB entity) {
		// TODO Auto-generated method stub
		return false;
	}

}
