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

import dao.ICashierDao;
import model.Cashier;
import utility.ConnectionPool;

public class CashierDaoImpl implements ICashierDao {
	private static final Logger LOGGER = LogManager.getLogger(CashierDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public Cashier selectEntityById(Long id){
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "SELECT * FROM Cashier WHERE idCashier=?";
		Cashier cashier = new Cashier();
		ResultSet resultset = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			resultset = statement.executeQuery();
			cashier.setIdCashier(resultset.getLong("idCashier"));
			cashier.setIdEmployees(resultset.getLong("idEmployees"));
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
		return cashier;
	}

	public List<Cashier> selectAllEntity() {
		Connection connection = conPool.retrieve();
		List<Cashier> cashierList = new ArrayList<Cashier>();
		String sql = "SELECT * FROM Cashier";
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Cashier cashier = new Cashier();
				cashier.setIdCashier(resultSet.getLong("idCashier"));
				cashier.setIdEmployees(resultSet.getLong("idEmployees"));
				

				cashierList.add(cashier);
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

		return cashierList;
	}

	public void insertEntity(Cashier entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "INSERT INTO Cashier () VALUES(?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdCashier());
			statement.setLong(2, entity.getIdEmployees());
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



	public void updateEntity(Cashier entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "UPDATE CarServiceA SET idCashier=?, idEmployees=?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setLong(1, entity.getIdCashier());
			statement.setLong(2, entity.getIdEmployees());
			

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



	public void deleteEntinty(Cashier entity) throws SQLException {
		PreparedStatement statement = null;
		String sql = "DELETE FROM Cashier WHERE idCashier=?";
		Connection connection = conPool.retrieve();

		try {
			statement = connection.prepareStatement(sql);
			
			statement.setLong(1, entity.getIdCashier());
			
			statement.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
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
	
	
	
	

}

