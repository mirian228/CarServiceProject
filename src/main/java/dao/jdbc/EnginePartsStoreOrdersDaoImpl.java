package dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IEnginePartsStoreOrdersDao;
import model.EnginePartsStoreOrders;
import utility.ConnectionPool;

public class EnginePartsStoreOrdersDaoImpl implements IEnginePartsStoreOrdersDao {
	private static final Logger LOGGER = LogManager.getLogger(EnginePartsStoreOrdersDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	@Override
	public void insertEntity(EnginePartsStoreOrders entity) throws SQLException {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "INSERT INTO EnginePartsStoreOrders () VALUES(?, ?, ?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdCustomer());
			statement.setLong(2, entity.getIdEnginePartsStore());
			statement.setLong(3, entity.getIdOrder());
			statement.setDate(4, (Date) entity.getOrderDate());
			statement.setDouble(5, entity.getOrderAmount());
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

	@Override
	public EnginePartsStoreOrders selectEntityById(Long id) throws SQLException {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "SELECT * FROM EnginePartsStoreOrders WHERE idCustomer=?";
		EnginePartsStoreOrders enginePartsStoreOrders = new EnginePartsStoreOrders();
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			enginePartsStoreOrders.setIdCustomer(resultSet.getLong("idCustomer"));
			enginePartsStoreOrders.setIdEnginePartsStore(resultSet.getLong("idEnginePartsStore"));
			enginePartsStoreOrders.setIdOrder(resultSet.getLong("idOrder"));
			enginePartsStoreOrders.setOrderDate(resultSet.getDate("orderDate"));
			enginePartsStoreOrders.setOrderAmount(resultSet.getDouble("orderAmount"));
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
		return enginePartsStoreOrders;
	}

	@Override
	public List<EnginePartsStoreOrders> selectAllEntity() throws SQLException {
		Connection connection = conPool.retrieve();
		List<EnginePartsStoreOrders> enginePartsStoreOrdersList = new ArrayList<EnginePartsStoreOrders>();
		String sql = "SELECT * FROM EnginePartsStoreOrders";
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				EnginePartsStoreOrders enginePartsStoreOrders = new EnginePartsStoreOrders();
				enginePartsStoreOrders.setIdCustomer(resultSet.getLong("idCustomer"));
				enginePartsStoreOrders.setIdEnginePartsStore(resultSet.getLong("idEnginePartsStore"));
				enginePartsStoreOrders.setIdOrder(resultSet.getLong("idOrder"));
				enginePartsStoreOrders.setOrderDate(resultSet.getDate("orderDate"));
				enginePartsStoreOrders.setOrderAmount(resultSet.getDouble("orderAmount"));

				enginePartsStoreOrdersList.add(enginePartsStoreOrders);
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

		return enginePartsStoreOrdersList;
	}

	@Override
	public void updateEntity(EnginePartsStoreOrders entity) throws SQLException {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "UPDATE EnginePartsStoreOrders SET idCustomer=?, idEnginePartsStore=?, idOrder=?, orderDate=?, orderAmount=?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setLong(1, entity.getIdCustomer());
			statement.setLong(2, entity.getIdEnginePartsStore());
			statement.setLong(3, entity.getIdOrder());
			statement.setDate(4, (Date) entity.getOrderDate());
			statement.setDouble(5, entity.getOrderAmount());
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

	@Override
	public void deleteEntinty(EnginePartsStoreOrders entity) throws SQLException {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "DELETE FROM EnginePartsStoreOrders WHERE idCustomer=?";

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
