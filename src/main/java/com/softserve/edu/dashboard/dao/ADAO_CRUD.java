package com.softserve.edu.dashboard.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.dashboard.constants.FieldName;
import com.softserve.edu.dashboard.db.ConnectionManager;
import com.softserve.edu.dashboard.entity.AEntity;
import com.softserve.edu.dashboard.tools.SQLProperty;

public abstract class ADAO_CRUD<TEntity extends AEntity> implements IDAO_CRUD<TEntity> {

	private String queryPrefix;

	public ADAO_CRUD() {
		this.queryPrefix = getQueryPrefix();
		createTable();
	}

	public abstract String getQueryPrefix();

	public abstract TEntity createEntity(ResultSet resultSet) throws SQLException;

	public abstract List<Object> getEntityParams(String operation, TEntity entity);

	public static final String CREATE = "create";
	public static final String UPDATE = "update";

	@Override
	public void create(TEntity entity) throws SQLException {
		String query = SQLProperty.get(queryPrefix + ".insert");
		try (PreparedStatement preparedStatement = ConnectionManager.getInstance().getConnection()
				.prepareStatement(query)) {
			List<Object> entityParams = getEntityParams(ADAO_CRUD.CREATE, entity);
			for (int i = 1; i < entityParams.size(); i++) {
				preparedStatement.setObject(i, entityParams.get(i));
			}
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TEntity> findAll() throws SQLException {
		List<TEntity> entities = new ArrayList<>();
		String query = SQLProperty.get(queryPrefix + ".findAll");
		try (Statement st = ConnectionManager.getInstance().getConnection().createStatement()) {
			ResultSet resultSet = st.executeQuery(query);
			while (resultSet.next()) {
				entities.add(createEntity(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entities;
	}

	@Override
	public List<TEntity> findByField(String field, Object o){
		List<TEntity> entities = new ArrayList<>();
		String query = SQLProperty.get(queryPrefix + ".findByField").replace("$field$", field);
		try (PreparedStatement preparedStatement = ConnectionManager.getInstance().getConnection()
				.prepareStatement(query)) {
			preparedStatement.setObject(1, o);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				entities.add(createEntity(resultSet));
			}
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entities;
	}

	@Override
	public TEntity findById(Long id) throws SQLException {
		return findByField(FieldName.ID, id).get(0);
	}

	@Override
	public void update(TEntity entity) throws SQLException {
		String query = SQLProperty.get(queryPrefix + ".updateById");
		try (PreparedStatement preparedStatement = ConnectionManager.getInstance().getConnection()
				.prepareStatement(query)) {
			List<Object> entityParams = getEntityParams(ADAO_CRUD.UPDATE, entity);
			for (int i = 1; i <= entityParams.size(); i++) {
				preparedStatement.setObject(i, entityParams.get(i - 1));
			}
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(TEntity entity) throws SQLException {
		deleteById(entity.getId());
	}

	@Override
	public void deleteById(Long id) throws SQLException {
		String query = SQLProperty.get(queryPrefix + ".deleteById");
		try (PreparedStatement preparedStatement = ConnectionManager.getInstance().getConnection()
				.prepareStatement(query)) {
			preparedStatement.setObject(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void createTable() {
		String query = SQLProperty.get(queryPrefix + ".createTable");
		try (Statement statement = ConnectionManager.getInstance().getConnection().createStatement()) {
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
