package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ICarServiceADao;
import model.CarServiceA;
import utility.ConnectionPool;

public class CarServiceADaoImpl implements ICarServiceADao {
	private static final Logger LOGGER = LogManager.getLogger(CarServiceADaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public CarServiceA selectEntityById(Long id) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "SELECT * FROM CarServiceA WHERE idCarServiceA=?";
		CarServiceA carServiceA = new CarServiceA();
		ResultSet resultset = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			resultset = statement.executeQuery();
			carServiceA.setIdCarServiceA(resultset.getLong("idCarServiceA"));
			carServiceA.setIdCar(resultset.getLong("idCar"));
			carServiceA.setServiceType(resultset.getString("ServiceType"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null) {
					resultset.close();
					LOGGER.info("Resultset closed");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				LOGGER.error("Cannot close resultset", e);
			}
			try {
				if (statement != null) {
					statement.close();
					LOGGER.info("Statement closed successfully");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				LOGGER.error("Cannot close statement", e);
			}
			if (connection != null) {
				conPool.putBack(connection);
				LOGGER.info("Connection has returned back to connection pool");
			}
		}
		return carServiceA;

	}

	public List<CarServiceA> selectAllEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertEntity(CarServiceA entity) {
		// TODO Auto-generated method stub

	}

	public CarServiceA selectEntintyById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CarServiceA> selectAllEntity(CarServiceA entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateEntity(CarServiceA entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public CarServiceA createEntity(CarServiceA entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteEntinty(CarServiceA entity) {
		// TODO Auto-generated method stub
		return false;
	}

}
