package com.softserve.edu.dashboard.dto;

import java.util.ArrayList;
import java.util.List;

public class UserItemsDTO {

	private String userLogin;
	private List<ItemDTO> items;

	public UserItemsDTO(String userLogin) {
		this.userLogin = userLogin;
		items = new ArrayList<>();
	}

	public UserItemsDTO(String userLogin, List<ItemDTO> items) {
		this.userLogin = userLogin;
		this.items = items;
	}

	// setters

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}

	public void addItemDTO(ItemDTO item) {
		getItems().add(item);
	}

	// getters

	public String getUserLogin() {
		return userLogin;
	}

	public List<ItemDTO> getItems() {
		return items;
	}

}
