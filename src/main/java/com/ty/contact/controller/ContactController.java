package com.ty.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ty.contact.entity.User;
import com.ty.contact.service.ContactService;
import com.ty.contact.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ContactController {

	@Autowired
	private UserService userService;

	@Autowired
	private ContactService contactService;

	@GetMapping("/")
	public ModelAndView registerPage() {

		ModelAndView mv = new ModelAndView("index.jsp");
		mv.addObject("user", new User());

		return mv;
	}

	@PostMapping("/register")
	public ModelAndView registerUser(User user) {

		boolean saved = userService.registerUser(user);
		ModelAndView mv = new ModelAndView("login.jsp");
		if (saved) {
			mv.addObject("msg", "Registered Successfully");
		} else {
			mv.addObject("msg", "Already Registered");
		}

		return mv;
	}

}
