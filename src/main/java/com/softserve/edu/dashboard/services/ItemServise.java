package com.softserve.edu.dashboard.services;

import java.sql.SQLException;

import com.softserve.edu.dashboard.dao.ItemDAO;
import com.softserve.edu.dashboard.dto.ItemDTO;
import com.softserve.edu.dashboard.entity.ItemEntity;

public class ItemServise {

	private ItemDAO itemDAO;

	public ItemServise() {
		this.itemDAO = new ItemDAO(); // bad practice
	}

	public ItemServise(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public ItemDTO getItemDTO(long id) {
		ItemEntity itemEntity;
		try {
			itemEntity = itemDAO.findById(id);
			return new ItemDTO(itemEntity.getId(), itemEntity.getTitle(), itemEntity.getDescription(),
					itemEntity.getUserId(), itemEntity.getStatus());
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO handle Exception
			return null;
		}
	}

	public void setItemDTO(ItemDTO itemDTO) {
		ItemEntity itemEntity = new ItemEntity(itemDTO.getIdItem(), itemDTO.getTitle(), itemDTO.getDescription(),
				itemDTO.getIdUser(), itemDTO.getStatus());
		if (itemDTO.getIdItem() < 0) { // if itemDTO.getIdItem == -1, we are going to create new Item
			try {
				itemDAO.create(itemEntity);
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO handle Exception
			}
		} else {
			try {
				itemDAO.update(itemEntity);
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO handle Exception
			}
		}
	}

	public boolean isExistItem(long id) {
		boolean result = true;
		try {
			itemDAO.findById(id);
		} catch (SQLException e) {
			// TODO handle Exception
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public void deleteItemDTO(ItemDTO itemDTO) {
		deleteItemDTOById(itemDTO.getIdItem());
	}

	public void deleteItemDTOById(Long id) {
		try {
			if (isExistItem(id)) {
				itemDAO.deleteById(id);
			} else {
				// TODO myException
				throw new RuntimeException("Id doesn't exists!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO handle Exception
		}
	}

}
