package com.tianywluo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianywluo.dao.UserDao;
import com.tianywluo.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	public Long getAmount() {
		return userDao.getAmount();
	}

	public User verifyUser(String username, String password) {
		return userDao.verifyUser(username, password);
	}
	
	public boolean editUser(User user) {
		return userDao.editUser(user);
	}

	public void removeUser(String username) {
		userDao.removeUser(username);
	}

	public User queryUserByUsername(String username) {
		return userDao.queryUserByUsername(username);
	}
	
	
}
