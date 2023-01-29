package service;

import java.sql.SQLException;
import java.util.List;

public interface IBaseDaoService<T> {
	void insertEntity(T enity) throws SQLException;

	T selectEntityById(Long id) throws SQLException;

	List<T> selectAllEntity() throws SQLException;

	void updateEntity(T entity) throws SQLException;


	void deleteEntinty(Long id) throws SQLException;
}
