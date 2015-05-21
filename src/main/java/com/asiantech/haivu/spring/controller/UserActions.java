package com.asiantech.haivu.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public ModelAndView listUser(ModelAndView model) {
		// Show list user
		List<User> listUser = userSv.getListUser();
		model.addObject("listUser", listUser);

		// Get object user
		User user = new User();
		model.addObject("user", user);

		model.setViewName("user-list");
		return model;
	}

	@RequestMapping(value = "user-page", method = RequestMethod.GET)
	public ModelAndView getPage(@RequestParam(value = "page") int page,
			ModelAndView model) {
		
		return null;
	}

	@RequestMapping(value = "edit-user", method = RequestMethod.GET)
	public ModelAndView editContact(ModelAndView model,
			HttpServletRequest request) {
		List<User> listUser = userSv.getListUser();
		model.addObject("listUser", listUser);

		int userId = Integer.parseInt(request.getParameter("userId"));
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
	public ModelAndView deleteContact(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("userId"));
		userSv.delUser(userId);
		return new ModelAndView("redirect:users-management");
	}

}
