package com.tianywluo.dao;

import org.springframework.stereotype.Repository;

import com.tianywluo.entity.User;

@Repository
public interface UserDao {

	public void addUser(User user);
	
	public Long getAmount();
	
	public User verifyUser(String username, String password);

	public boolean editUser(User user);

	public void removeUser(String username);

	public User queryUserByUsername(String username);
}
