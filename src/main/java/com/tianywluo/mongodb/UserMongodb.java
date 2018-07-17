package com.tianywluo.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.tianywluo.dao.UserDao;
import com.tianywluo.entity.User;
import com.tianywluo.util.MD5Util;

@Component
public class UserMongodb implements UserDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void addUser(User user) {
		user.setPassword(MD5Util.getMD5(user.getPassword(), "utf-8"));
		mongoTemplate.insert(user);
	}

	@Override
	public Long getAmount() {
		Query query = new Query();
		return mongoTemplate.count(query, User.class);
	}
	
	@Override
	public User verifyUser(String username, String password) {
		Query query = new Query();
		Criteria criteria = new Criteria();
		criteria.and("username").is(username);
		criteria.and("password").is(MD5Util.getMD5(password, "utf-8"));
		query.addCriteria(criteria);
		return mongoTemplate.findOne(query, User.class);
	}
	
	@Override
	public boolean editUser(User user) {
		Query query = new Query(Criteria.where("userId").is(user.getUserId()));
		Update update = new Update();
		update.set("username", user.getUsername());
		update.set("password", MD5Util.getMD5(user.getPassword(), "utf-8"));
		mongoTemplate.updateFirst(query, update, User.class);
		return true;
	}

	@Override
	public void removeUser(String username) {
		Query query = new Query(Criteria.where("username").is(username));
		mongoTemplate.remove(query, User.class);
	}

	@Override
	public User queryUserByUsername(String username) {
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username));
		return mongoTemplate.findOne(query, User.class);
	}

	

}
