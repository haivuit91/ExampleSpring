package com.asiantech.haivu.spring.dao;

import java.util.List;

import com.asiantech.haivu.spring.entity.User;

public interface UserDao {

	List<User> getListUser();

	User getUser(int userId);

	boolean addUser(User user);

	boolean updateUser(User user);

	boolean delUser(int userId);

	List<User> getUserPage(int pageSize, int pageNumber);

	int getPageNumber();

}
