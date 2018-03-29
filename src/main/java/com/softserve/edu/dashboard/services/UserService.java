package com.softserve.edu.dashboard.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.dashboard.constants.FieldName;
import com.softserve.edu.dashboard.dao.UserDAO;
import com.softserve.edu.dashboard.dto.UserDTO;
import com.softserve.edu.dashboard.entity.UserEntity;

public class UserService {

	private UserDAO userDAO;

	public UserService() {
		this.userDAO = new UserDAO();
	}

	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserDTO getUserDTO(String login) {
		UserEntity userEntity;
		if (isExistLogin(login)) {
				userEntity = userDAO.findByField(UserEntity.USER_ENTITY_LOGIN, login).get(0);
				return new UserDTO(userEntity.getId(), userEntity.getName(), userEntity.getLogin(),
						userEntity.getPassword(), userEntity.getEmail());
		}
		return null;
	}

	public void setUserDTO(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity(userDTO.getId(), userDTO.getName(), userDTO.getLogin(),
				userDTO.getPassword(), userDTO.getEmail());
		if (userDTO.getId() < 0) {
			if (!isExistLogin(userEntity.getLogin())) {
				try {
					userDAO.create(userEntity);
				} catch (SQLException e) {
					e.printStackTrace();
					// TODO handle Exception
				}
			}
		} else {
			try {
				userEntity.setId(userDAO.findByField(FieldName.LOGIN, userDTO.getLogin()).get(0).getId());
				userDAO.update(userEntity);
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO handle Exception
			}
		}
	}

	public boolean isExistLogin(String login) {
		boolean result = true;
		List<UserEntity> list;
			list = userDAO.findByField(UserEntity.USER_ENTITY_LOGIN, login);
			if (list.isEmpty()) {
				return false;
			}
		return result;
	}

	public void deleteUserDTO(UserDTO userDTO) {
		deleteUserDTOById(userDTO.getId());
	}

	public void deleteUserDTOById(Long id) {
		try {
			userDAO.deleteById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO handle Exception
		}
	}

	public boolean isLogged(String login, String password) {
		List<UserEntity> users = new ArrayList<>();
			users = userDAO.findByField(UserEntity.USER_ENTITY_LOGIN, login);
		if (users.size() == 1) {
			if (users.get(0).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

}
