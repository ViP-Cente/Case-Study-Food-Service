package com.project.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Moderator {
	
	@Id
	Integer modID;
	String username;
	String password;
	
	public Moderator() {
		
	}

	public Moderator(Integer modID, String username, String password) {
		super();
		this.modID = modID;
		this.username = username;
		this.password = password;
	}

	public Integer getModID() {
		return modID;
	}

	public void setModID(Integer modID) {
		this.modID = modID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Moderator [modID=" + modID + ", username=" + username + ", password=" + password + "]";
	}

}

