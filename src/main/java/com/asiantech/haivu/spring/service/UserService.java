package com.asiantech.haivu.spring.service;

import java.util.List;

import com.asiantech.haivu.spring.entity.User;

public interface UserService {

	public static String USER_SERVICE = "userService";

	List<User> getListUser();

	User getUser(int userId);

	boolean addUser(User user);

	boolean updateUser(User user);

	boolean delUser(int userId);

	List<User> getUserLimit(int pageLimit, int pageNum);

}
