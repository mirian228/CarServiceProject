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

import dao.IDiagnosticsMechanicDao;
import model.DiagnosticsMechanic;
import utility.ConnectionPool;

public class DiagnosticsMechanicDaoImpl implements IDiagnosticsMechanicDao {
	private static final Logger LOGGER = LogManager.getLogger(DiagnosticsMechanicDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public DiagnosticsMechanic selectEntityById(Long id) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "SELECT idDiagnosticsMechanic, idCarServiceA, idEmployees FROM DiagnosticsMechanic WHERE idDiagnosticsMechanic=?";
		DiagnosticsMechanic diagnosticsMechanic = new DiagnosticsMechanic();
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			diagnosticsMechanic.setIdDiagnosticsMechanic(resultSet.getLong("idDiagnosticsMechanic"));
			diagnosticsMechanic.setIdCarServiceA(resultSet.getLong("idCarServiceA"));
			diagnosticsMechanic.setIdEmployees(resultSet.getLong("idEmployees"));
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
		return diagnosticsMechanic;
	}

	public List<DiagnosticsMechanic> selectAllEntity() {
		Connection connection = conPool.retrieve();
		List<DiagnosticsMechanic> diagnosticsMechanicList = new ArrayList<DiagnosticsMechanic>();
		String sql = "SELECT idDiagnosticsMechanic, idCarServiceA, idEmployees FROM DiagnosticsMechanic";
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				DiagnosticsMechanic diagnosticsMechanic = new DiagnosticsMechanic();
				diagnosticsMechanic.setIdDiagnosticsMechanic(resultSet.getLong("idDiagnosticsMechanic"));
				diagnosticsMechanic.setIdCarServiceA(resultSet.getLong("idCarServiceA"));
				diagnosticsMechanic.setIdEmployees(resultSet.getLong("idEmployees"));

				diagnosticsMechanicList.add(diagnosticsMechanic);
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

		return diagnosticsMechanicList;
	}

	public void insertEntity(DiagnosticsMechanic entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "INSERT INTO DiagnosticsMechanic (idDiagnosticsMechanic, idCarServiceA, idEmployees) VALUES(?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdDiagnosticsMechanic());
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

	public void updateEntity(DiagnosticsMechanic entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "UPDATE DiagnosticsMechanic SET idDiagnosticsMechanic=?, idCarServiceA=?, idEmployees=?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setLong(1, entity.getIdDiagnosticsMechanic());
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

	public void deleteEntinty(DiagnosticsMechanic entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "DELETE FROM DiagnosticsMechanic WHERE idDiagnosticsMechanic=?";

		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdDiagnosticsMechanic());

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
