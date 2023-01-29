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

import dao.IPartWarehouseDao;
import model.PartWarehouse;
import utility.ConnectionPool;

public class PartWarehouseDaoImpl implements IPartWarehouseDao {
	private static final Logger LOGGER = LogManager.getLogger(PartWarehouseDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public PartWarehouse selectEntityById(Long id) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "SELECT * FROM PartWarehouse WHERE idPartWarehouse=?";
		PartWarehouse partWarehouse = new PartWarehouse();
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			partWarehouse.setIdPartWarehouse(resultSet.getLong("idPartWarehouse"));
			partWarehouse.setPartId(resultSet.getString("PartId"));
			partWarehouse.setPartName(resultSet.getString("partName"));
			partWarehouse.setPartNumber(resultSet.getString("partNumber"));
			partWarehouse.setPartquantity(resultSet.getInt("partquantity"));
			partWarehouse.setProducer(resultSet.getString("producer"));
			partWarehouse.setReleaseyear(resultSet.getInt("releaseyear"));
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
		return partWarehouse;
	}

	public List<PartWarehouse> selectAllEntity() {
		Connection connection = conPool.retrieve();
		List<PartWarehouse> partWarehouseList = new ArrayList<PartWarehouse>();
		String sql = "SELECT * FROM PartWarehouse";
		Statement statement = null;

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				PartWarehouse partWarehouse = new PartWarehouse();
				partWarehouse.setIdPartWarehouse(resultSet.getLong("idPartWarehouse"));
				partWarehouse.setPartId(resultSet.getString("PartId"));
				partWarehouse.setPartName(resultSet.getString("partName"));
				partWarehouse.setPartNumber(resultSet.getString("partNumber"));
				partWarehouse.setPartquantity(resultSet.getInt("partquantity"));
				partWarehouse.setProducer(resultSet.getString("producer"));
				partWarehouse.setReleaseyear(resultSet.getInt("releaseyear"));

				partWarehouseList.add(partWarehouse);
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

		return partWarehouseList;
	}

	public void insertEntity(PartWarehouse entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "INSERT INTO PartWarehouse (idPartWarehouse, PartId, partName, partNumber, partquantity, producer, releaseyear) VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdPartWarehouse());
			statement.setString(2, entity.getPartId());
			statement.setString(3, entity.getPartName());
			statement.setString(4, entity.getPartNumber());
			statement.setInt(5, entity.getPartquantity());
			statement.setString(6, entity.getProducer());
			statement.setInt(7, entity.getReleaseyear());

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
				LOGGER.error("Cannot close Statement", e);
			}
			if (connection != null) {
				conPool.putBack(connection);
				LOGGER.info("Connection has returned back to connection pool");
			}
		}

	}

	public void updateEntity(PartWarehouse entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "UPDATE PartWarehouse SET idPartWarehouse=?, PartId=?, partName=?, partNumber=?, partquantity=?, producer=?, releaseyear=?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setLong(1, entity.getIdPartWarehouse());
			statement.setString(2, entity.getPartId());
			statement.setString(3, entity.getPartName());
			statement.setString(4, entity.getPartNumber());
			statement.setInt(5, entity.getPartquantity());
			statement.setString(6, entity.getProducer());
			statement.setInt(7, entity.getReleaseyear());

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

	public void deleteEntinty(PartWarehouse entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "DELETE FROM PartWarehouse WHERE idPartWarehouse=?";

		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdPartWarehouse());

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
