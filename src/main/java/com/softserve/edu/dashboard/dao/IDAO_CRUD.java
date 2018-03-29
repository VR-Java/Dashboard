package com.softserve.edu.dashboard.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDAO_CRUD<TEntity> {

	// create
	void create(TEntity entity) throws SQLException;

	// read
	List<TEntity> findAll() throws SQLException;

	List<TEntity> findByField(String field, Object o) throws SQLException;

	TEntity findById(Long id) throws SQLException;

	// update
	void update(TEntity entity) throws SQLException;

	// delete
	void delete(TEntity entity) throws SQLException;

	void deleteById(Long id) throws SQLException;

}
