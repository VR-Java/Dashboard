package com.softserve.edu.dashboard.dto;

public class UserDTO {

	private long id;
	private String name;
	private String login;
	private String password;
	private String email;

	public UserDTO(long id, String name, String login, String password, String email) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.email = email;
	}

	// setters

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// getters

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

}
