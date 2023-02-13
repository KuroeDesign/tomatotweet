package com.hb.tomatotweet.controllers;

import com.hb.tomatotweet.dtos.CategoryDTO;
import com.hb.tomatotweet.dtos.UserDTO;
import com.hb.tomatotweet.dtos.UserFormDTO;
import com.hb.tomatotweet.services.CategoryService;
import com.hb.tomatotweet.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

	private UserService userService;
	private CategoryService categoryService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("private/user")
	public ModelAndView adminPage() {		
		List<UserDTO> users = userService.getUsers();
		ModelAndView mav = new ModelAndView("home");
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
	
	@GetMapping("private/user/addcategories")
	public ModelAndView getAddCategoriesForm( CategoryService categoryService) {
		List<CategoryDTO> categories = categoryService.getCategories();
		ModelAndView mav = new ModelAndView("addcategories");
		mav.addObject("categorie", categories);
		return mav;
	}
	
	@PostMapping("private/user/addcategories")
	public ModelAndView selectCategories(@RequestParam  Object cat,  CategoryService categoryService) {		
		System.out.println(cat);
		ModelAndView mav = new ModelAndView("redirect:/");
		return mav;		
	}
	
	
	
}