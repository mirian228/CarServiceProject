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

import dao.IManagerDao;
import model.Manager;
import utility.ConnectionPool;

public class ManagerDaoImpl implements IManagerDao {
	private static final Logger LOGGER = LogManager.getLogger(ManagerDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public Manager selectEntityById(Long id) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "SELECT * FROM Manager WHERE idManager=?";
		Manager manager = new Manager();
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			manager.setIdManager(resultSet.getLong("idManager"));
			manager.setFname(resultSet.getString("fname"));
			manager.setLname(resultSet.getString("lname"));
			manager.setAdress(resultSet.getString("adress"));
			manager.setPhoneNumber(resultSet.getString("phoneNumber"));
			manager.setsalary(resultSet.getInt("salary"));
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
		return manager;
	}

	public List<Manager> selectAllEntity() {
		Connection connection = conPool.retrieve();
		List<Manager> managerList = new ArrayList<Manager>();
		String sql = "SELECT * FROM Manager";
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Manager manager = new Manager();
				manager.setIdManager(resultSet.getLong("idManager"));
				manager.setFname(resultSet.getString("fname"));
				manager.setLname(resultSet.getString("lname"));
				manager.setAdress(resultSet.getString("adress"));
				manager.setPhoneNumber(resultSet.getString("phoneNumber"));
				manager.setsalary(resultSet.getInt("salary"));

				managerList.add(manager);
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

		return managerList;
	}

	public void insertEntity(Manager entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "INSERT INTO Customer () VALUES(?, ?, ?, ?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdManager());
			statement.setString(2, entity.getFname());
			statement.setString(3, entity.getLname());
			statement.setString(4, entity.getPhoneNumber());
			statement.setString(5, entity.getAdress());
			statement.setInt(6, entity.getsalary());
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

	public void updateEntity(Manager entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "UPDATE Manager SET idManager=?, fname=?, lname=?, phoneNumber=?, adress=?, salary=?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setLong(1, entity.getIdManager());
			statement.setString(2, entity.getFname());
			statement.setString(3, entity.getLname());
			statement.setString(4, entity.getPhoneNumber());
			statement.setString(5, entity.getAdress());
			statement.setInt(6, entity.getsalary());
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

	public void deleteEntinty(Manager entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "DELETE FROM Manager WHERE idManager=?";

		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdManager());

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
