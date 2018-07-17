package com.tianywluo.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="youmei_user")
public class User {

	@Indexed
	private String userId;
	private String username;
	private String password;
	private String realname;
	private String idCard;
	private String Email;
	private String telephone;
	
	public User() {
	}
	public User(String userId, String username, String password, String realname, 
			String idCard, String email, String telephone) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.idCard = idCard;
		Email = email;
		this.telephone = telephone;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}
