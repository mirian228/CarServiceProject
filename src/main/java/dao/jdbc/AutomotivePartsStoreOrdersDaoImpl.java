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
import dao.IAutomotivePartsStoreOrdersDao;
import model.AutomotivePartsStoreOrders;
import utility.ConnectionPool;

public class AutomotivePartsStoreOrdersDaoImpl implements IAutomotivePartsStoreOrdersDao {
	private static final Logger LOGGER = LogManager.getLogger(AutomotivePartsStoreOrdersDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	@Override
	public void insertEntity(AutomotivePartsStoreOrders entity) throws SQLException {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "INSERT INTO AutomotivePartsStoreOrders () VALUES(?, ?, ?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdCustomer());
			statement.setLong(2, entity.getIdAutomotivePartsStore());
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
	public AutomotivePartsStoreOrders selectEntityById(Long id) throws SQLException {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "SELECT * FROM AutomotivePartsStoreOrders WHERE idCustomer=?";
		AutomotivePartsStoreOrders automotivePartsStoreOrders = new AutomotivePartsStoreOrders();
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			automotivePartsStoreOrders.setIdCustomer(resultSet.getLong("idCustomer"));
			automotivePartsStoreOrders.setIdAutomotivePartsStore(resultSet.getLong("idAutomotivePartsStore"));
			automotivePartsStoreOrders.setIdOrder(resultSet.getLong("idOrder"));
			automotivePartsStoreOrders.setOrderDate(resultSet.getDate("orderDate"));
			automotivePartsStoreOrders.setOrderAmount(resultSet.getDouble("orderAmount"));
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
		return automotivePartsStoreOrders;
	}

	@Override
	public List<AutomotivePartsStoreOrders> selectAllEntity() throws SQLException {
		Connection connection = conPool.retrieve();
		List<AutomotivePartsStoreOrders> automotivePartsStoreOrdersList = new ArrayList<AutomotivePartsStoreOrders>();
		String sql = "SELECT * FROM AutomotivePartsStoreOrders";
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				AutomotivePartsStoreOrders automotivePartsStoreOrders = new AutomotivePartsStoreOrders();
				automotivePartsStoreOrders.setIdCustomer(resultSet.getLong("idCustomer"));
				automotivePartsStoreOrders.setIdAutomotivePartsStore(resultSet.getLong("idAutomotivePartsStore"));
				automotivePartsStoreOrders.setIdOrder(resultSet.getLong("idOrder"));
				automotivePartsStoreOrders.setOrderDate(resultSet.getDate("orderDate"));
				automotivePartsStoreOrders.setOrderAmount(resultSet.getDouble("orderAmount"));

				automotivePartsStoreOrdersList.add(automotivePartsStoreOrders);
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

		return automotivePartsStoreOrdersList;
	}

	public void updateEntity(AutomotivePartsStoreOrders entity) throws SQLException {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "UPDATE AutomotivePartsStoreOrders SET idCustomer=?, idAutomotivePartsStore=?, idOrder=?, orderDate=?, orderAmount=?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setLong(1, entity.getIdCustomer());
			statement.setLong(2, entity.getIdAutomotivePartsStore());
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

	public void deleteEntinty(AutomotivePartsStoreOrders entity) throws SQLException {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "DELETE FROM AutomotivePartsStoreOrders WHERE idCustomer=?";

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

	@Override
	public void deleteEntinty(Long id) throws SQLException {
		// TODO Auto-generated method stub

	}

}
