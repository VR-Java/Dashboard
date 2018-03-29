package com.softserve.edu.dashboard.services;

import java.sql.SQLException;

import com.softserve.edu.dashboard.dao.ItemDAO;
import com.softserve.edu.dashboard.dao.UserDAO;
import com.softserve.edu.dashboard.dto.ItemDTO;
import com.softserve.edu.dashboard.dto.UserDTO;
import com.softserve.edu.dashboard.dto.UserItemsDTO;
import com.softserve.edu.dashboard.entity.ItemEntity;
import com.softserve.edu.dashboard.entity.UserEntity;

public class UserItemsServise {

	private UserDAO userDAO;
	private ItemDAO itemDAO;

	public UserItemsServise() { // bad practice
		userDAO = new UserDAO();
		itemDAO = new ItemDAO();
	}

	public UserItemsServise(UserDAO userDAO, ItemDAO itemDAO) {
		this.userDAO = userDAO;
		this.itemDAO = itemDAO;
	}

	public UserItemsDTO getUserItems(UserDTO userDTO) {
		UserEntity userEntity;
		try {
			userEntity = userDAO.findByField(UserEntity.USER_ENTITY_LOGIN, userDTO.getLogin()).get(0);
			UserItemsDTO userItemsDTO = new UserItemsDTO(userEntity.getLogin());

			for (ItemEntity itemEntity : itemDAO.findAll()) {
				if (itemEntity.getUserId() == userEntity.getId()) {
					ItemDTO itemDTO = new ItemDTO(itemEntity.getId(), itemEntity.getTitle(),
							itemEntity.getDescription(), itemEntity.getUserId(), itemEntity.getStatus());

					userItemsDTO.addItemDTO(itemDTO);
				}
			}
			return userItemsDTO;
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO handle Exception
			return null;
		}
	}

}
