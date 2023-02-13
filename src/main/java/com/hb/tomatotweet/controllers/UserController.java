package com.hb.tomatotweet.controllers;

import com.hb.tomatotweet.dtos.UserDTO;
import com.hb.tomatotweet.dtos.UserFormDTO;
import com.hb.tomatotweet.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;		
	}
	
	@GetMapping("private/user")
	public ModelAndView adminPage() {		
		List<UserDTO> users = userService.getUsers();
		ModelAndView mav = new ModelAndView("home-user");
		mav.addObject("users", users);		
		return mav;
	}
	
	@GetMapping("public/user/new")
	public ModelAndView getRegistrationForm() {		
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new UserFormDTO("", "" ));
		return mav;
	}
	
	@PostMapping("public/user/new")
	public ModelAndView registerUser(@ModelAttribute UserFormDTO user) {		
		userService.saveUser(user);		
		ModelAndView mav = new ModelAndView("redirect:/login");
		return mav;		
	}
	
	
	
}