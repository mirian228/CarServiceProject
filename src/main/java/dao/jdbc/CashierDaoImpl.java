package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ICashierDao;
import model.Cashier;
import utility.ConnectionPool;

public class CashierDaoImpl implements ICashierDao {
	private static final Logger LOGGER = LogManager.getLogger(CarDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public Cashier selectEntityById(Long id){
		return null;
	}

	public List<Cashier> selectAllEntity() {
		return null;
	}

	public void insertEntity(Cashier entity) {
		
	}


	public List<Cashier> selectAllEntity(Cashier entity) {
		return null;
	}

	public boolean updateEntity(Cashier entity) {
		return false;
	}



	public boolean deleteEntinty(Cashier entity) throws SQLException {
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
		
		return true;
	}
	
	
	
	

}

