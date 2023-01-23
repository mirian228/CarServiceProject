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

import dao.IAutomotiveElectricianDao;
import model.AutomotiveElectrician;
import utility.ConnectionPool;

public class AutomotiveElectricianDaoImpl implements IAutomotiveElectricianDao {
    private static final Logger LOGGER = LogManager.getLogger(AutomotiveElectricianDaoImpl.class);
    ConnectionPool conPool = ConnectionPool.getInstance();
	
	
	public void insertEntity(AutomotiveElectrician entity) throws SQLException {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "INSERT INTO AutomotiveElectrician (idAutomotiveElectrician, idCarServiceB, idEmployees) VALUES(?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdAutomotiveElectrician());
			statement.setLong(2, entity.getIdCarServiceB());
			statement.setLong(3, entity.getIdEmployees());
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

	public AutomotiveElectrician selectEntityById(Long id) throws SQLException { 
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "SELECT idAutomotiveElectrician, idCarServiceB, idEmployees FROM AutomotiveElectrician WHERE idAutomotiveElectrician=?";
		AutomotiveElectrician automotiveElectrician = new AutomotiveElectrician();
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultset = statement.executeQuery();
			automotiveElectrician.setIdAutomotiveElectrician(resultset.getLong("idAutomotiveElectrician"));
			automotiveElectrician.setIdCarServiceB(resultset.getLong("idCarServiceB"));
			automotiveElectrician.setIdEmployees(resultset.getLong("idEmployees"));
			statement.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
			if(statement != null) {
				statement.close();
				LOGGER.info("Statement closed");
			}
			} catch(SQLException e) {
				e.printStackTrace();
				LOGGER.error("Cannot close Statement" ,e);
			}
			if (connection != null) {
				conPool.putBack(connection);
				LOGGER.info("Connection has returned back to connection pool");
			}
		}
		return automotiveElectrician;
	}

	public List<AutomotiveElectrician> selectAllEntity() throws SQLException {
		Connection connection = conPool.retrieve();
		List<AutomotiveElectrician> automotiveElectricianList = new ArrayList<AutomotiveElectrician>();
		String sql = "SELECT idAutomotiveElectrician, idCarServiceB, idEmployees FROM AutomotiveElectrician";
		Statement statement = null;
		
		try {
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) {
			AutomotiveElectrician automotiveElectrician = new AutomotiveElectrician();
			automotiveElectrician.setIdAutomotiveElectrician(resultSet.getLong("idAutomotiveElectrician"));
			automotiveElectrician.setIdCarServiceB(resultSet.getLong("idCarServiceB"));
			automotiveElectrician.setIdEmployees(resultSet.getLong("idEmployees"));
			
			automotiveElectricianList.add(automotiveElectrician);
		}
		}
		catch(SQLException e) { 
			e.printStackTrace();
		}
		finally {
			try {
			if(statement != null) {
				statement.close();
				LOGGER.info("Statement closed successfully");
			}
			} catch(SQLException e) {
				e.printStackTrace();
				LOGGER.error("Cannot close statement", e);
				
			}
			if (connection != null) {
				conPool.putBack(connection);
				LOGGER.info("Connection has returned back to connection pool");
			}
		}
		
		return automotiveElectricianList;
	}

	public boolean updateEntity(AutomotiveElectrician entity) throws SQLException {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "UPDATE AutomotiveElectrician SET idAutomotiveElectrician=?, idCarServiceB=?, idEmployees=?";
		
				
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setLong(1, entity.getIdAutomotiveElectrician());
			statement.setLong(2, entity.getIdCarServiceB());
			statement.setLong(3, entity.getIdEmployees());
			
			statement.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
			}		finally {
				try {
					if(statement != null) {
						statement.close();
						LOGGER.info("Statement closed successfully");
					}
					} catch(SQLException e) {
						e.printStackTrace();
						LOGGER.error("Cannot close statement", e);
						
					}
				if (connection != null) {
					conPool.putBack(connection);
					LOGGER.info("Connection has returned back to connection pool");
				}
				}
		
		return false;
	}



	public boolean deleteEntinty(AutomotiveElectrician entity) throws SQLException {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "DELETE FROM AutomotiveElectrician WHERE idAutomotiveElectrician=?";
			
				
				
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdAutomotiveElectrician());
			
			statement.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
			if(statement != null) {
				statement.close();
				LOGGER.info("Statement closed successfully");
			}
			} catch(SQLException e) {
				e.printStackTrace();
				LOGGER.error("Cannot close statement", e);
				
			}
			try {
			if(connection != null) {
				connection.close();
				LOGGER.info("Connection closed successfully");
									}
				}catch(SQLException e) {
					e.printStackTrace();
					LOGGER.error("Cannot close connection" ,e);
				}
		}
		
		return false;
	}

	 
	



}
