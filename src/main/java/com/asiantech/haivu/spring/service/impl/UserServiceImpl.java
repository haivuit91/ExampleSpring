package com.asiantech.haivu.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiantech.haivu.spring.dao.UserDao;
import com.asiantech.haivu.spring.entity.User;
import com.asiantech.haivu.spring.service.UserService;

@Service(UserService.USER_SERVICE)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getListUser() {
		return userDao.getListUser();
	}

	@Override
	public User getUser(int userId) {
		return userDao.getUser(userId);
	}

	@Override
	public boolean addUser(User user) {
		boolean isCheck = false;
		if (userDao.addUser(user)) {
			isCheck = true;
		}
		return isCheck;
	}

	@Override
	public boolean updateUser(User user) {
		boolean isCheck = false;
		if (userDao.updateUser(user)) {
			isCheck = true;
		}
		return isCheck;
	}

	@Override
	public boolean delUser(int userId) {
		boolean isCheck = false;
		if (userDao.delUser(userId)) {
			isCheck = true;
		}
		return isCheck;
	}

	@Override
	public List<User> getUserPage(int pageSize, int pageNumber) {
		return userDao.getUserPage(pageSize, pageNumber);
	}

	@Override
	public int getPageNumber() {
		return userDao.getPageNumber();
	}

}
