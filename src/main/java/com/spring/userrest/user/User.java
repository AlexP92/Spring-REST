package com.spring.userrest.user;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {

	private Integer id;

	@Size(min = 3, max = 20, message = "The username must be from 3 to 20 characters.")
	private String username;

	@NotNull
	@Past
	private Date birthdate;

	User() {

	}

	public User(Integer id, String username, Date birthdate) {
		super();
		this.id = id;
		this.username = username;
		this.birthdate = birthdate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthdate=" + birthdate + "]";
	}

}
