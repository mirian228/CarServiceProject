package service;

import java.sql.SQLException;
import java.util.List;

import model.Cashier;

public interface ICashierService {
	
	Cashier selectEntityById(Long id) throws SQLException;
	List<Cashier> selectAllEntity();
	void insertEntity(Cashier entity);
	void updateEntity(Cashier entity);
	void deleteEntinty(Cashier entity);
}
