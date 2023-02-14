package com.hb.tomatotweet.controllers;

import com.hb.tomatotweet.dtos.PostDTO;
import com.hb.tomatotweet.repositories.CategoryRepository;
import com.hb.tomatotweet.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/private/post")
public class PostController {
	
	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("")
	public ModelAndView getPosts(CategoryRepository cs) {
		List<PostDTO> posts = postService.getPosts(cs);
		ModelAndView mav = new ModelAndView("posts");
		mav.addObject("posts", posts);
		return mav;
	}
	
	
	@GetMapping("/add")
	public ModelAndView addPost() {
		ModelAndView mav = new ModelAndView("addpost");
		
		mav.addObject("post", new PostDTO("", "", ""));
		return mav;
	}
	
	@PostMapping("/add")
	public ModelAndView addPost(@ModelAttribute PostDTO post, CategoryRepository cs) {
		
		postService.addPost(post, cs);
		List<PostDTO> posts = postService.getPosts(cs);
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("posts", posts);
		return mav;
	}
}