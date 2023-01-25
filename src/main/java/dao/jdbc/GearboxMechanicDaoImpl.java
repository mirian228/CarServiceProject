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

import dao.IGearboxMechanicDao;
import model.GearboxMechanic;
import utility.ConnectionPool;

public class GearboxMechanicDaoImpl implements IGearboxMechanicDao {
	private static final Logger LOGGER = LogManager.getLogger(GearboxMechanicDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public GearboxMechanic selectEntityById(Long id) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "SELECT idGearboxMechanic, idCarServiceB, idEmployees FROM AutomotiveElectrician WHERE idGearboxMechanic=?";
		GearboxMechanic gearboxMechanic = new GearboxMechanic();
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			gearboxMechanic.setIdGearboxMechanic(resultSet.getLong("idGearboxMechanic"));
			gearboxMechanic.setIdCarServiceB(resultSet.getLong("idCarServiceB"));
			gearboxMechanic.setIdEmployees(resultSet.getLong("idEmployees"));
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
					LOGGER.info("Statement closed");
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
		return gearboxMechanic;
	}

	public List<GearboxMechanic> selectAllEntity() {
		Connection connection = conPool.retrieve();
		List<GearboxMechanic> gearboxMechanicList = new ArrayList<GearboxMechanic>();
		String sql = "SELECT idGearboxMechanic, idCarServiceB, idEmployees FROM GearboxMechanic";
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				GearboxMechanic gearboxMechanic = new GearboxMechanic();
				gearboxMechanic.setIdGearboxMechanic(resultSet.getLong("idGearboxMechanic"));
				gearboxMechanic.setIdCarServiceB(resultSet.getLong("idCarServiceB"));
				gearboxMechanic.setIdEmployees(resultSet.getLong("idEmployees"));

				gearboxMechanicList.add(gearboxMechanic);
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

		return gearboxMechanicList;
	}

	public void insertEntity(GearboxMechanic entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "INSERT INTO GearboxMechanic (idGearboxMechanic, idCarServiceB, idEmployees) VALUES(?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdGearboxMechanic());
			statement.setLong(2, entity.getIdCarServiceB());
			statement.setLong(3, entity.getIdEmployees());
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

	public void updateEntity(GearboxMechanic entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "UPDATE GearboxMechanic SET idGearboxMechanic=?, idCarServiceB=?, idEmployees=?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setLong(1, entity.getIdGearboxMechanic());
			statement.setLong(2, entity.getIdCarServiceB());
			statement.setLong(3, entity.getIdEmployees());

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

	public void deleteEntinty(GearboxMechanic entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "DELETE FROM GearboxMechanic WHERE idGearboxMechanic=?";

		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdGearboxMechanic());

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
