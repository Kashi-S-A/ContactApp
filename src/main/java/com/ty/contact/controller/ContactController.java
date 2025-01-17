package com.ty.contact.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.contact.entity.Contact;
import com.ty.contact.entity.User;
import com.ty.contact.service.ContactService;
import com.ty.contact.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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

	@GetMapping("/login")
	public String loginPage() {
		return "login.jsp";
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

	@PostMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Optional<User> opt = userService.findByEmail(email);

		ModelAndView mv = new ModelAndView();

		if (opt.isPresent() && password.equals(opt.get().getPassword())) {
			User user = opt.get();
			HttpSession session = request.getSession(true);
			session.setAttribute("uid", user.getUid());

			mv.setViewName("home.jsp");
			mv.addObject("contacts", user.getContacts());

		} else {
			mv.setViewName("login.jsp");
			mv.addObject("msg", "Invalid credentials");
		}

		return mv;
	}

	@GetMapping("/add")
	public ModelAndView addPage() {

		ModelAndView mv = new ModelAndView("contact.jsp");
		mv.addObject("contact", new Contact());
		return mv;
	}

	@PostMapping("/add")
	public ModelAndView addContact(Contact contact, HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		Integer uid = (Integer) session.getAttribute("uid");

		User user = userService.findById(uid);

		contact.setUser(user);

		contactService.saveContact(contact);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");
		mv.addObject("contacts", user.getContacts());

		return mv;
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {

		HttpSession session = request.getSession(true);

		session.invalidate();

		return "login.jsp";
	}

	@GetMapping("/update")
	public ModelAndView updatePage(@RequestParam Integer cid) {

		Contact contact = contactService.findById(cid);

		ModelAndView mv = new ModelAndView("update.jsp");
		mv.addObject("cont", contact);

		return mv;
	}

	@PostMapping("/update")
	public ModelAndView updateContact(Contact contact, HttpServletRequest request) {

		Contact dbContact = contactService.findById(contact.getCid());
		dbContact.setName(contact.getName());
		dbContact.setAdharNo(contact.getAdharNo());
		dbContact.setPhone(contact.getPhone());

		contactService.saveContact(dbContact);

		ModelAndView mv = new ModelAndView("home.jsp");
		mv.addObject("contacts", dbContact.getUser().getContacts());

		return mv;
	}

	@GetMapping("/delete")
	public ModelAndView getMethodName(@RequestParam Integer cid, HttpServletRequest request) {

		contactService.deleteById(cid);

		HttpSession session = request.getSession(false);

		Integer uid = (Integer) session.getAttribute("uid");

		User user = userService.findById(uid);

		ModelAndView mv = new ModelAndView("home.jsp");
		mv.addObject("contacts", user.getContacts());

		return mv;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView catchException() {
		ModelAndView mv = new ModelAndView("error.jsp");
		return mv;
	}

}
