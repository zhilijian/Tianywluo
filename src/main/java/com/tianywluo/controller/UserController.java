package com.tianywluo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tianywluo.dao.UserDao;
import com.tianywluo.entity.User;
import com.tianywluo.util.CommonVO;

import java.util.UUID;

import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/adduser")
	public CommonVO register(@RequestParam(name="username", required=true) String username, 
							 @RequestParam(name="password", required=true) String password, 
							 @RequestParam(name="realname", required=true) String realname, 
							 @RequestParam(name="idCard", required=true) String idCard, 
							 @RequestParam(name="email", required=true) String email, 
							 @RequestParam(name="telephone", required=true) String telephone) {
		CommonVO cvo = new CommonVO();
		if (userDao.queryUserByUsername(username) == null) {
			String userId = UUID.randomUUID().toString();
			User user = new User(userId, username, password, realname, idCard, email, telephone);
			userDao.addUser(user);
			cvo.setSuccess(true);
			cvo.setMsg("新用户注册成功！");
			cvo.setData(user);
		} else {
			cvo.setSuccess(false);
			cvo.setMsg("该用户已被注册！");
			cvo.setData(null);
		}
		return cvo;
	}
	
	@RequestMapping("/login")
	public CommonVO login(@RequestParam(name="username", required=true) String username, 
						  @RequestParam(name="password", required=true) String password, 
						  HttpSession session) {
		CommonVO cvo = new CommonVO();
		User user = userDao.verifyUser(username, password);
		if (user != null) {
			session.setAttribute("user", user);
			cvo.setSuccess(true);
			cvo.setMsg("用户登录成功！");
			cvo.setData(user);
		} else {
			cvo.setSuccess(false);
			cvo.setMsg("用户登录失败。");
			cvo.setData(null);
		}
		return cvo;
	}
	
	@RequestMapping("/logout")
	public CommonVO logout(HttpSession session) {
		CommonVO cvo = new CommonVO();
		session.removeAttribute("user");
		if (session.getAttribute("user") == null) {
			cvo.setSuccess(true);
			cvo.setMsg("用户退出成功！");
			cvo.setData(null);
		} else {
			cvo.setSuccess(false);
			cvo.setMsg("用户退出失败。");
			cvo.setData(null);
		}
		return cvo;
	}
	
	@RequestMapping("/edituser")
	public CommonVO editUser(@RequestParam(name="username") String username, 
							 @RequestParam(name="password") String password, 
							 @RequestParam(name="realname") String realname, 
							 @RequestParam(name="idCard") String idCard, 
							 @RequestParam(name="email") String email, 
							 @RequestParam(name="telephone") String telephone,
							 HttpSession session) {
		CommonVO cvo = new CommonVO();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			user.setUsername(username);
			user.setUsername(password);
			user.setUsername(realname);
			user.setUsername(idCard);
			user.setUsername(email);
			user.setUsername(telephone);
			if (userDao.editUser(user)) {
				cvo.setSuccess(true);
				cvo.setMsg("用户信息修改成功！");
				cvo.setData(user);
			} 
		} else {
			cvo.setSuccess(false);
			cvo.setMsg("用户信息修改失败。");
			cvo.setData(null);
		}
		return cvo;
	}
	
	@RequestMapping("/removeuser")
	public CommonVO removeUser(HttpSession session) {
		CommonVO cvo = new CommonVO();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			userDao.removeUser(user.getUsername());
			session.removeAttribute("user");
			cvo.setSuccess(true);
			cvo.setMsg("用户注销成功！");
			cvo.setData(null);
		} else {
			cvo.setSuccess(false);
			cvo.setMsg("用户注销失败。");
			cvo.setData(null);
		}
		return cvo;
	}
	
	@RequestMapping("isusername")
	public CommonVO ishasuser(@RequestParam(name="username") String username) {
		CommonVO cvo = new CommonVO();
		User user = userDao.queryUserByUsername(username);
		if (user == null) {
			cvo.setSuccess(true);
			cvo.setMsg("该用户名可用！");
			cvo.setData(null);
		} else {
			cvo.setMsg("该用户名已被注册。");
			cvo.setSuccess(false);
			cvo.setData(null);
		}
		return cvo;
	}
}
