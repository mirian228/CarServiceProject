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

import dao.IEngineMechanicDao;
import model.EngineMechanic;
import utility.ConnectionPool;

public class EngineMechanicDaoImpl implements IEngineMechanicDao {
	private static final Logger LOGGER = LogManager.getLogger(EngineMechanicDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public EngineMechanic selectEntityById(Long id) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "SELECT idEngineMechanic, idCarServiceA, idEmployees FROM DiagnosticsMechanic WHERE idEngineMechanic=?";
		EngineMechanic engineMechanic = new EngineMechanic();
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			engineMechanic.setIdEngineMechanic(resultSet.getLong("idEngineMechanic"));
			engineMechanic.setIdCarServiceA(resultSet.getLong("idCarServiceA"));
			engineMechanic.setIdEmployees(resultSet.getLong("idEmployees"));
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
		return engineMechanic;
	}

	public List<EngineMechanic> selectAllEntity() {
		Connection connection = conPool.retrieve();
		List<EngineMechanic> engineMechanicList = new ArrayList<EngineMechanic>();
		String sql = "SELECT idEngineMechanic, idCarServiceA, idEmployees FROM EngineMechanic";
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				EngineMechanic engineMechanic = new EngineMechanic();
				engineMechanic.setIdEngineMechanic(resultSet.getLong("idEngineMechanic"));
				engineMechanic.setIdCarServiceA(resultSet.getLong("idCarServiceA"));
				engineMechanic.setIdEmployees(resultSet.getLong("idEmployees"));

				engineMechanicList.add(engineMechanic);
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

		return engineMechanicList;
	}

	public void insertEntity(EngineMechanic entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "INSERT INTO EngineMechanic (idEngineMechanic, idCarServiceA, idEmployees) VALUES(?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdEngineMechanic());
			statement.setLong(2, entity.getIdCarServiceA());
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

	public void updateEntity(EngineMechanic entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "UPDATE EngineMechanic SET idEngineMechanic=?, idCarServiceA=?, idEmployees=?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setLong(1, entity.getIdEngineMechanic());
			statement.setLong(2, entity.getIdCarServiceA());
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

	public void deleteEntinty(EngineMechanic entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "DELETE FROM EngineMechanic WHERE idEngineMechanic=?";

		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdEngineMechanic());

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
	public void deleteEntinty(Long id) throws SQLException {
		// TODO Auto-generated method stub

	}

}
