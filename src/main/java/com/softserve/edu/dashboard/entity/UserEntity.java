package com.softserve.edu.dashboard.entity;

public class UserEntity extends AEntity {
	
	public static final String USER_ENTITY_LOGIN = "login";
	public static final String USER_ENTITY_INEDTIFIER = "user";
	
	private String name;
	private String login;
	private String password;
	private String email;
	
	
	public UserEntity(Long id, String name, String login, String password, String email) {
		super(id);
		this.name = name;
		this.login = login;
		this.password = password;
		this.email = email;
	}
	
	public UserEntity(String name, String login, String password, String email) {
		this.name = name;
		this.login = login;
		this.password = password;
		this.email = email;
	}
	
	// setters
	
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

	@Override
	public String toString() {
		return "UserEntity [id=" + super.id +", name=" + name + ", login=" + login + ", password=" + password + ", email=" + email + "]";
	}
	
}
