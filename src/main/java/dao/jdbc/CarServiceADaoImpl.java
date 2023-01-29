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
		return carServiceA;

	}

	public void insertEntity(CarServiceA entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "INSERT INTO CarServiceA () VALUES(?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdCarServiceA());
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

	public void updateEntity(CarServiceA entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "UPDATE CarServiceA SET idCarServiceA=?, idCar=?, ServiceType=?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setLong(1, entity.getIdCarServiceA());
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

	public void deleteEntinty(CarServiceA entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "DELETE FROM CarServiceA WHERE idCarServiceA=?";

		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdCarServiceA());

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

	@Override
	public List<CarServiceA> selectAllEntity() throws SQLException {
		Connection connection = conPool.retrieve();
		List<CarServiceA> carServiceAList = new ArrayList<CarServiceA>();
		String sql = "SELECT * FROM CarServiceA";
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				CarServiceA carServiceA = new CarServiceA();
				carServiceA.setIdCarServiceA(resultSet.getLong("idAutomotiveElectrician"));
				carServiceA.setIdCar(resultSet.getLong("idCar"));
				carServiceA.setServiceType(resultSet.getString("ServiceType"));

				carServiceAList.add(carServiceA);
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

		return carServiceAList;
	}

	@Override
	public void deleteEntinty(Long id) throws SQLException {
		// TODO Auto-generated method stub

	}

}
