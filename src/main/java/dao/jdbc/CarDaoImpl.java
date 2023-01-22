package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ICarDao;
import model.Car;
import utility.ConnectionPool;

public class CarDaoImpl implements ICarDao {
    private static final Logger LOGGER = LogManager.getLogger(CarDaoImpl.class);
    ConnectionPool conPool = ConnectionPool.getInstance();
    

	public Car selectEntityById(Long id) throws SQLException {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "SELECT * FROM Car WHERE idCar=?";
		Car car = new Car();
		ResultSet resultset = null;
		try {
		statement = connection.prepareStatement(sql);
		statement.setLong(1, id);
		resultset = statement.executeQuery();
		car.setIdCar(resultset.getLong("idCar"));
		car.setIdCustomer(resultset.getLong("idCustomer"));
		car.setVin(resultset.getString("vin"));
		car.setMake(resultset.getString("make"));
		car.setModel(resultset.getString("model"));
		car.setBodytype(resultset.getString("bodytype"));
		car.setProductionYear(resultset.getInt("productionYear"));
		car.setEngineCapacity(resultset.getString("engineCapacity"));
		car.setFuelType(resultset.getString("fuelType"));
		car.setExteriorColor(resultset.getString("exteriorColor"));
		
			
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if(resultset !=  null) {
					resultset.close();
					LOGGER.info("Resultset closed");
									    } 
				} catch(SQLException e) {
					e.printStackTrace();
					LOGGER.error("Cannot close resultset", e);
				}
			try {
				if(statement != null) {
					statement.close();
					LOGGER.info("Statement closed successfully");
				}	
				}catch(SQLException e) {
					e.printStackTrace();
					LOGGER.error("Cannot close statement", e);
				}
			if (connection != null) {
				conPool.putBack(connection);
				LOGGER.info("Connection has returned back to connection pool");
			}
				}
		return car;
	}

	public List<Car> selectAllEntity() throws SQLException {
		Connection connection = conPool.retrieve();
		String sql = "SELECT * FROM Car";
		List<Car> carList = new ArrayList<Car>();
		Statement statement = null;
		ResultSet resultset = null; 
		try {
			statement = connection.createStatement();
			resultset = statement.executeQuery(sql);
			
			while(resultset.next()) 
			{
			Car car = new Car();
			car.setIdCar(resultset.getLong("idCar"));
			car.setIdCustomer(resultset.getLong("idCustomer"));
			car.setVin(resultset.getString("vin"));
			car.setMake(resultset.getString("make"));
			car.setModel(resultset.getString("model"));
			car.setBodytype(resultset.getString("bodytype"));
			car.setProductionYear(resultset.getInt("productionYear"));
			car.setEngineCapacity(resultset.getString("engineCapacity"));
			car.setFuelType(resultset.getString("fuelType"));
			car.setExteriorColor(resultset.getString("exteriorColor"));
			carList.add(car);
			}
			} 
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
		try {
			if(resultset != null) {
				resultset.close();
				LOGGER.info("Resultset closed successfully");
			}
		} 
		catch(SQLException e) {
			e.printStackTrace();
			LOGGER.error("Cannot close resultset", e);
			
		}
		try {
			if(statement != null) {
				statement.close();
				LOGGER.info("Statement closed successfully");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			LOGGER.error("Cannot close statement");
		}
		
		if (connection != null) {
			conPool.putBack(connection);
			LOGGER.info("Connection has returned back to connection pool");
		}
		
			   }
		
		return carList;
	}

	public void insertEntity(Car entity) {
	Connection connection = conPool.retrieve();
	PreparedStatement statement = null;
	String sql = "INSERT INTO Car VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	try {
		statement = connection.prepareStatement(sql);
		statement.setLong(1, entity.getIdCar());
		statement.setLong(2, entity.getIdCustomer());
		statement.setString(3, entity.getVin());
		statement.setString(4, entity.getMake());
		statement.setString(5, entity.getModel());
		statement.setString(6, entity.getBodytype());
		statement.setInt(7, entity.getProductionYear());
		statement.setString(8, entity.getEngineCapacity());
		statement.setString(9, entity.getFuelType());
		statement.setString(10, entity.getExteriorColor());
		statement.executeUpdate();
		
	} catch(SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			if (statement != null) {
				statement.close();
				LOGGER.info("Statement closed successfully");
										   } 
			} catch (SQLException e) {
				e.printStackTrace();
				LOGGER.error("Cannot close Statement", e);
									 } 
		if (connection != null) {
			conPool.putBack(connection);
			LOGGER.info("Connection has returned back to connection pool");
		}
	          }
	
	}

	public boolean updateEntity(Car entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteEntinty(Car entity) {
		// TODO Auto-generated method stub
		return false;
	}

	

	
	
	


	



}
