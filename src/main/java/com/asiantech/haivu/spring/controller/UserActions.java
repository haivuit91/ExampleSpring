package com.asiantech.haivu.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.asiantech.haivu.spring.entity.User;
import com.asiantech.haivu.spring.service.UserService;

@Controller
@RequestMapping(value = "/action/")
public class UserActions {

	@Autowired
	@Qualifier(UserService.USER_SERVICE)
	private UserService userSv;

	@RequestMapping(value = "users-management", method = RequestMethod.GET)
	public ModelAndView getPage(@RequestParam(required = false) Integer page,
			ModelAndView model) {
		int currentPage = 1;
		int maxRow = 3;
		if (page != null)
			currentPage = page;

		int rowCount = userSv.getListUser().size();

		int pageSize = (int) Math.ceil(rowCount * 1.0 / maxRow);

		List<User> listUser = userSv.getUserPage((currentPage - 1) * maxRow,
				maxRow);

		System.out.println(currentPage);
		System.out.println(maxRow);
		System.out.println(rowCount);
		System.out.println(pageSize);

		model.addObject("listUser", listUser);
		model.addObject("pageSize", pageSize);
		model.addObject("currentPage", currentPage);

		User user = new User();
		model.addObject("user", user);

		model.setViewName("user-list");
		return model;
	}

	@RequestMapping(value = "edit-user", method = RequestMethod.GET)
	public ModelAndView editContact(
			@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer userId, ModelAndView model,
			HttpServletRequest request) {
		int pageNumber = 1;
		int pageSize = 3;
		if (page != null)
			pageNumber = page;

		int noOfRecords = userSv.getPageNumber();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / pageSize);

		List<User> listUser = userSv.getUserPage((pageNumber - 1) * pageSize,
				pageSize);
		model.addObject("listUser", listUser);
		model.addObject("noOfPages", noOfPages);
		model.addObject("currentPage", pageNumber);

		User user = userSv.getUser(userId);
		model.addObject("user", user);
		model.setViewName("user-list");
		return model;
	}

	@RequestMapping(value = "save-user", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute User user) {
		if (user.getUserId() != 0) {
			userSv.updateUser(user);
		} else {
			userSv.addUser(user);
		}
		return new ModelAndView("redirect:users-management");
	}

	@RequestMapping(value = "delete-user", method = RequestMethod.GET)
	public ModelAndView deleteContact(
			@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer userId) {
		userSv.delUser(userId);
		return new ModelAndView("redirect:users-management?page=" + page);
	}

}
