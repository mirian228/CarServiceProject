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

import dao.IEnginePartsStoreDao;
import model.EnginePartsStore;
import utility.ConnectionPool;

public class EnginePartsStoreDaoImpl implements IEnginePartsStoreDao {
	private static final Logger LOGGER = LogManager.getLogger(EnginePartsStoreDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public EnginePartsStore selectEntityById(Long id) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		EnginePartsStore enginePartsStore = new EnginePartsStore();
		String sql = "SELECT idEnginePartsStore, idСashier, idPartWarehouse, Partid FROM EnginePartsStore WHERE idEnginePartsStore=?";
		try {
			statement = connection.prepareStatement(sql);

			statement.setLong(1, id);

			ResultSet resultSet = statement.executeQuery();

			enginePartsStore.setIdEnginePartsStore(resultSet.getLong("idEnginePartsStore"));
			enginePartsStore.setIdСashier(resultSet.getLong("idСashier"));
			enginePartsStore.setIdPartWarehouse(resultSet.getLong("idPartWarehouse"));
			enginePartsStore.setPartid(resultSet.getString("Partid"));
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

		return enginePartsStore;
	}

	public List<EnginePartsStore> selectAllEntity() {
		Connection connection = conPool.retrieve();
		List<EnginePartsStore> enginePartsStoreList = new ArrayList<EnginePartsStore>();
		Statement statement = null;
		String sql = "SELECT idEnginePartsStore, idСashier, idPartWarehouse, Partid FROM EnginePartsStore";

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				EnginePartsStore enginePartsStore = new EnginePartsStore();
				enginePartsStore.setIdEnginePartsStore(resultSet.getLong("idEnginePartsStore"));
				enginePartsStore.setIdСashier(resultSet.getLong("idСashier"));
				enginePartsStore.setIdPartWarehouse(resultSet.getLong("idPartWarehouse"));
				enginePartsStore.setPartid(resultSet.getString("Partid"));

				enginePartsStoreList.add(enginePartsStore);

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

		return enginePartsStoreList;
	}

	public void insertEntity(EnginePartsStore entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "INSERT INTO EnginePartsStore (idEnginePartsStore, idСashier, idPartWarehouse, partid) VALUES(?, ?, ?, ?)";

		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdEnginePartsStore());
			statement.setLong(2, entity.getIdСashier());
			statement.setLong(3, entity.getIdPartWarehouse());
			statement.setString(4, entity.getPartid());

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

	public void updateEntity(EnginePartsStore entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "UPDATE EnginePartsStore SET idEnginePartsStore=?, idСashier=?,  idPartWarehouse=?, partid=?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setLong(1, entity.getIdEnginePartsStore());
			statement.setLong(2, entity.getIdСashier());
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

	}

	public void deleteEntinty(EnginePartsStore entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "DELETE FROM EnginePartsStore WHERE idEnginePartsStore=?";

		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdEnginePartsStore());

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

	@Override
	public void deleteEntinty(Long id) throws SQLException {
		// TODO Auto-generated method stub

	}

}
