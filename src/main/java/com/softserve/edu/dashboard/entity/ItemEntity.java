package com.softserve.edu.dashboard.entity;

public class ItemEntity extends AEntity{
	
	public static final String ITEM_ENTITY_INEDTIFIER = "item";

	private String title;
	private String description;
	private Long userId;
	private String status;
	
	public ItemEntity(String title, String description, Long userId, String status) {
		this.title = title;
		this.description = description;
		this.userId = userId;
		this.status = status;
	}
	
	public ItemEntity(Long id, String title, String description, Long userId, String status) {
		super(id);
		this.title = title;
		this.description = description;
		this.userId = userId;
		this.status = status;
	}

	// setters
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	// getters
	
	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Long getUserId() {
		return userId;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "ItemEntity [id=" + super.id +", title=" + title + ", description=" + description + ", userId=" + userId + ", status="
				+ status + "]";
	}

}
