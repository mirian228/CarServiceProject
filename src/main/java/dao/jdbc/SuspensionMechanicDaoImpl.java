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

import dao.ISuspensionMechanicDao;
import model.SuspensionMechanic;
import utility.ConnectionPool;

public class SuspensionMechanicDaoImpl implements ISuspensionMechanicDao {
	private static final Logger LOGGER = LogManager.getLogger(SuspensionMechanicDaoImpl.class);
	ConnectionPool conPool = ConnectionPool.getInstance();

	public SuspensionMechanic selectEntityById(Long id) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "SELECT * FROM SuspensionMechanic WHERE idSuspensionMechanic=?";
		SuspensionMechanic suspensionMechanic = new SuspensionMechanic();
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultset = statement.executeQuery();
			suspensionMechanic.setIdSuspensionMechanic(resultset.getLong("idSuspensionMechanic"));
			suspensionMechanic.setIdCarServiceB(resultset.getLong("idCarServiceB"));
			suspensionMechanic.setIdEmployees(resultset.getLong("idEmployees"));
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
		return suspensionMechanic;
	}

	public List<SuspensionMechanic> selectAllEntity() {
		Connection connection = conPool.retrieve();
		List<SuspensionMechanic> suspensionMechanicList = new ArrayList<SuspensionMechanic>();
		String sql = "SELECT * FROM SuspensionMechanic";
		Statement statement = null;
		
		try {
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) {
			SuspensionMechanic suspensionMechanic = new SuspensionMechanic();
			suspensionMechanic.setIdSuspensionMechanic(resultSet.getLong("idSuspensionMechanic"));
			suspensionMechanic.setIdCarServiceB(resultSet.getLong("idCarServiceB"));
			suspensionMechanic.setIdEmployees(resultSet.getLong("idEmployees"));
			
			suspensionMechanicList.add(suspensionMechanic);
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
		
		return suspensionMechanicList;
	}

	public void insertEntity(SuspensionMechanic entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "INSERT INTO SuspensionMechanic (idSuspensionMechanic, idCarServiceB, idEmployees) VALUES(?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdSuspensionMechanic());
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




	public boolean updateEntity(SuspensionMechanic entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "UPDATE SuspensionMechanic SET idSuspensionMechanic=?, idCarServiceB=?, idEmployees=?";
		
				
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setLong(1, entity.getIdSuspensionMechanic());
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

	

	public boolean deleteEntinty(SuspensionMechanic entity) {
		Connection connection = conPool.retrieve();
		PreparedStatement statement = null;
		String sql = "DELETE FROM SuspensionMechanic WHERE idSuspensionMechanic=?";
			
				
				
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, entity.getIdSuspensionMechanic());
			
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
