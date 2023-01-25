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

import dao.IEmployeesDao;
import model.Employees;
import utility.ConnectionPool;

public class EmployeesDaoImpl implements IEmployeesDao {
	private static final Logger LOGGER = LogManager.getLogger(EmployeesDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public Employees selectEntityById(Long id) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "SELECT * FROM Employees WHERE idEmployees=?";
		Employees employees = new Employees();
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			employees.setIdEmployees(resultSet.getLong("idEmployees"));
			employees.setFname(resultSet.getString("fname"));
			employees.setLname(resultSet.getString("lname"));
			employees.setCity(resultSet.getString("city"));
			employees.setPhoneNumber(resultSet.getString("phoneNumber"));
			employees.setAdress(resultSet.getString("adress"));
			employees.setSalary(resultSet.getInt("salary"));
			employees.setIdManager(resultSet.getLong("idManager"));
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
					LOGGER.info("Resultset closed");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				LOGGER.error("Cannot close resultSet", e);
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
		return employees;
	}

	public List<Employees> selectAllEntity() {
		Connection connection = conPool.retrieve();
		List<Employees> employeesList = new ArrayList<Employees>();
		String sql = "SELECT * FROM Employees";
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Employees employees = new Employees();
				employees.setIdEmployees(resultSet.getLong("idEmployees"));
				employees.setFname(resultSet.getString("fname"));
				employees.setLname(resultSet.getString("lname"));
				employees.setCity(resultSet.getString("city"));
				employees.setPhoneNumber(resultSet.getString("phoneNumber"));
				employees.setAdress(resultSet.getString("adress"));
				employees.setSalary(resultSet.getInt("salary"));
				employees.setIdManager(resultSet.getLong("idManager"));

				employeesList.add(employees);
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

		return employeesList;
	}

	public void insertEntity(Employees entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "INSERT INTO Customer () VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdEmployees());
			statement.setString(2, entity.getFname());
			statement.setString(3, entity.getLname());
			statement.setString(4, entity.getCity());
			statement.setString(5, entity.getPhoneNumber());
			statement.setString(6, entity.getAdress());
			statement.setInt(7, entity.getSalary());
			statement.setLong(8, entity.getIdManager());
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

	public void updateEntity(Employees entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "UPDATE Employees SET idEmployees=?, fname=?, lname=?, city=?, phoneNumber=?, adress=?, salary=?, idManager=?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setLong(1, entity.getIdEmployees());
			statement.setString(2, entity.getFname());
			statement.setString(3, entity.getLname());
			statement.setString(4, entity.getCity());
			statement.setString(5, entity.getPhoneNumber());
			statement.setString(6, entity.getAdress());
			statement.setInt(7, entity.getSalary());
			statement.setLong(8, entity.getIdManager());
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

	public void deleteEntinty(Employees entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "DELETE FROM Employees WHERE idEmployees=?";

		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdEmployees());

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
