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
import dao.IAutomotivePartsStoreDao;
import model.AutomotivePartsStore;
import utility.ConnectionPool;

public class AutomotivePartsStoreDaoImpl implements IAutomotivePartsStoreDao {
    private static final Logger LOGGER = LogManager.getLogger(AutomotivePartsStoreDaoImpl.class);
    ConnectionPool conPool = ConnectionPool.getInstance();
	
    public AutomotivePartsStore selectEntityById(Long id) throws SQLException {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		AutomotivePartsStore automotivePartsStore = new AutomotivePartsStore();
		String sql = "SELECT idAutomotivePartsStore, idСashier, idOrders, idPartWarehouse, Partid FROM AutomotivePartsStore WHERE idAutomotivePartsStore=?";
		try {
			statement = connection.prepareStatement(sql);

			statement.setLong(1, id);

			ResultSet resultSet = statement.executeQuery();

			automotivePartsStore.setIdAutomotivePartsStore(resultSet.getLong("idAutomotivePartsStore"));
			automotivePartsStore.setIdСashier(resultSet.getLong("idСashier"));
			automotivePartsStore.setIdOrders(resultSet.getLong("idOrders"));
			automotivePartsStore.setIdPartWarehouse(resultSet.getLong("idPartWarehouse"));
			automotivePartsStore.setPartid(resultSet.getString("Partid"));

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

		return automotivePartsStore;
	}

	public List<AutomotivePartsStore> selectAllEntity() throws SQLException {
		Connection connection = conPool.retrieve();
		List<AutomotivePartsStore> automotivePartsStoreList = new ArrayList<AutomotivePartsStore>();
		Statement statement = null;
		String sql = "SELECT idAutomotivePartsStore, idСashier, idOrders, idPartWarehouse, Partid FROM AutomotivePartsStore";

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				AutomotivePartsStore automotivePartsStore = new AutomotivePartsStore();
				automotivePartsStore.setIdAutomotivePartsStore(resultSet.getLong("idAutomotivePartsStore"));
				automotivePartsStore.setIdСashier(resultSet.getLong("idСashier"));
				automotivePartsStore.setIdOrders(resultSet.getLong("idOrders"));
				automotivePartsStore.setIdPartWarehouse(resultSet.getLong("idPartWarehouse"));
				automotivePartsStore.setPartid(resultSet.getString("Partid"));

				automotivePartsStoreList.add(automotivePartsStore);

			}

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

		return automotivePartsStoreList;
	}

	public void insertEntity(AutomotivePartsStore entity) throws SQLException {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "INSERT INTO AutomotivePartsStore (idAutomotivePartsStore, idСashier, idOrders, idPartWarehouse, partid) VALUES(?, ?, ?, ?, ?)";

		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdAutomotivePartsStore());
			statement.setLong(2, entity.getIdСashier());
			statement.setLong(3, entity.getIdOrders());
			statement.setLong(4, entity.getIdPartWarehouse());
			statement.setString(5, entity.getPartid());

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

	}

	public boolean updateEntity(AutomotivePartsStore entity) throws SQLException {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "UPDATE AutomotivePartsStore SET idAutomotivePartsStore=?, idСashier=?, idOrders=?, idPartWarehouse=?, partid=?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setLong(1, entity.getIdAutomotivePartsStore());
			statement.setLong(2, entity.getIdСashier());
			statement.setLong(3, entity.getIdOrders());
			statement.setLong(4, entity.getIdPartWarehouse());
			statement.setString(5, entity.getPartid());

			statement.executeQuery();
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

		return false;
	}

	public boolean deleteEntinty(AutomotivePartsStore entity) throws SQLException {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "DELETE FROM AutomotivePartsStore WHERE idAutomotivePartsStore=?";

		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdAutomotivePartsStore());

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

		return false;
	}

}
