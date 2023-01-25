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

import dao.ICarServiceBDao;
import model.CarServiceB;
import utility.ConnectionPool;

public class CarServiceBDaoImpl implements ICarServiceBDao {
	private static final Logger LOGGER = LogManager.getLogger(CarServiceBDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public CarServiceB selectEntityById(Long id) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "SELECT * FROM CarServiceB WHERE idCarServiceB=?";
		CarServiceB carServiceB = new CarServiceB();
		ResultSet resultset = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			resultset = statement.executeQuery();
			carServiceB.setIdCarServiceB(resultset.getLong("idCarServiceB"));
			carServiceB.setIdCar(resultset.getLong("idCar"));
			carServiceB.setServiceType(resultset.getString("ServiceType"));
			statement.executeUpdate();
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
		return carServiceB;
	}

	public List<CarServiceB> selectAllEntity() {
		Connection connection = conPool.retrieve();
		List<CarServiceB> carServiceBList = new ArrayList<CarServiceB>();
		String sql = "SELECT * FROM CarServiceA";
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				CarServiceB carServiceB = new CarServiceB();
				carServiceB.setIdCarServiceB(resultSet.getLong("idAutomotiveElectrician"));
				carServiceB.setIdCar(resultSet.getLong("idCar"));
				carServiceB.setServiceType(resultSet.getString("ServiceType"));

				carServiceBList.add(carServiceB);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

		return carServiceBList;
	}

	public void insertEntity(CarServiceB entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "INSERT INTO CarServiceB () VALUES(?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdCarServiceB());
			statement.setLong(2, entity.getIdCar());
			statement.setString(3, entity.getServiceType());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
					LOGGER.info("Statement closed successfully");
				}
			} catch (SQLException e) {
				LOGGER.error("Cannot close Statement", e);
			}
			if (connection != null) {
				conPool.putBack(connection);
				LOGGER.info("Connection has returned back to connection pool");
			}
		}

	}

	

	public void updateEntity(CarServiceB entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "UPDATE CarServiceB SET idCarServiceB=?, idCar=?, ServiceType=?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setLong(1, entity.getIdCarServiceB());
			statement.setLong(2, entity.getIdCar());
			statement.setString(3, entity.getServiceType());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
	}

	

	public void deleteEntinty(CarServiceB entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "DELETE FROM CarServiceB WHERE idCarServiceB=?";

		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdCarServiceB());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
					LOGGER.info("Statement closed successfully");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				LOGGER.error("Cannot close statement", e);

			}
			try {
				if (connection != null) {
					connection.close();
					LOGGER.info("Connection closed successfully");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				LOGGER.error("Cannot close connection", e);
			}
		}
	}

}
