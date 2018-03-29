package com.softserve.edu.dashboard.dto;

public class ItemDTO {

	private long idItem;
	private String title;
	private String description;
	private long idUser;
	private String status;

	public ItemDTO(long idItem, String title, String description, long idUser, String status) {
		this.idItem = idItem;
		this.title = title;
		this.description = description;
		this.idUser = idUser;
		this.status = status;
	}

	// setters

	public void setIdItem(long idItem) {
		this.idItem = idItem;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// getters

	public long getIdItem() {
		return idItem;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public long getIdUser() {
		return idUser;
	}

	public String getStatus() {
		return status;
	}

}
