package com.asiantech.haivu.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asiantech.haivu.spring.entity.User;
import com.asiantech.haivu.spring.service.UserService;

@Controller
@RequestMapping(value = "/")
public class UserController {

	@Autowired
	@Qualifier(UserService.USER_SERVICE)
	private UserService userSv;

	@RequestMapping(value = "json/users-list")
	public @ResponseBody List<User> getAccountList(ModelMap model) {
		List<User> user = userSv.getListUser();
		model.put("listUser", user);
		// for (User u : user) {
		// System.out.print(u.getUserId() + ", ");
		// System.out.print(u.getUserName() + ", ");
		// System.out.print(u.getPwd() + ", ");
		// System.out.print(u.getFirstName() + ", ");
		// System.out.print(u.getLastName() + ", ");
		// System.out.println(u.getEmail() + ", ");
		// }
		return user;
	}

	@RequestMapping(value = "users-list")
	public ModelAndView listUser(ModelAndView model) {
		List<User> user = userSv.getListUser();
		model.addObject("listUser", user);
		model.setViewName("users-list");
		return model;
	}

	@RequestMapping(value = "users-table", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		List<User> user = userSv.getListUser();
		model.put("listUser", user);
		model.addAttribute("jsonArr", user);
		return "users-table";
	}

	@RequestMapping(value = "add-user", method = RequestMethod.GET)
	public ModelAndView addUser(ModelAndView model) {
		User user = new User();
		model.addObject("user", user);
		model.setViewName("add-edit-user");
		return model;
	}

	@RequestMapping(value = "edit-user", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("userId"));
		User user = userSv.getUser(userId);
		ModelAndView model = new ModelAndView("add-edit-user");
		model.addObject("user", user);
		return model;
	}

	@RequestMapping(value = "save-user", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute User user) {
		if (user.getUserId() != 0) {
			userSv.updateUser(user);
		} else {
			userSv.addUser(user);
		}
		return new ModelAndView("redirect:users-list");
	}

	@RequestMapping(value = "delete-user", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("userId"));
		userSv.delUser(userId);
		return new ModelAndView("redirect:users-list");
	}

}
