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

import dao.ICustomerDao;
import model.Customer;
import utility.ConnectionPool;

public class CustomerDaoImpl implements ICustomerDao {
	private static final Logger LOGGER = LogManager.getLogger(CustomerDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public Customer selectEntityById(Long id) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "SELECT * FROM Customer WHERE idCustomer=?";
		Customer customer = new Customer();
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			customer.setIdCustomer(resultSet.getLong("idCustomer"));
			customer.setFname(resultSet.getString("fname"));
			customer.setLname(resultSet.getString("lname"));
			customer.setPhoneNumber(resultSet.getString("phoneNumber"));
			customer.setAdress(resultSet.getString("adress"));
			customer.setDiscount(resultSet.getString("discount"));
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
		return customer;
	}

	public List<Customer> selectAllEntity() {
		Connection connection = conPool.retrieve();
		List<Customer> customerList = new ArrayList<Customer>();
		String sql = "SELECT * FROM Customer";
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setIdCustomer(resultSet.getLong("idCustomer"));
				customer.setFname(resultSet.getString("fname"));
				customer.setLname(resultSet.getString("lname"));
				customer.setPhoneNumber(resultSet.getString("phoneNumber"));
				customer.setAdress(resultSet.getString("adress"));
				customer.setDiscount(resultSet.getString("discount"));

				customerList.add(customer);
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

		return customerList;
	}

	public void insertEntity(Customer entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "INSERT INTO Customer () VALUES(?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdCustomer());
			statement.setString(2, entity.getFname());
			statement.setString(3, entity.getLname());
			statement.setString(4, entity.getPhoneNumber());
			statement.setString(5, entity.getAdress());
			statement.setString(6, entity.getDiscount());
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

	public void updateEntity(Customer entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "UPDATE Customer SET idCustomer=?, fname=?, lname=?, phoneNumber=?, adress=?, discount=?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setLong(1, entity.getIdCustomer());
			statement.setString(2, entity.getFname());
			statement.setString(3, entity.getLname());
			statement.setString(4, entity.getPhoneNumber());
			statement.setString(5, entity.getAdress());
			statement.setString(6, entity.getDiscount());
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

	public void deleteEntinty(Customer entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "DELETE FROM Customer WHERE idCustomer=?";

		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdCustomer());

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
