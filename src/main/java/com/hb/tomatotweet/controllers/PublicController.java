package com.hb.tomatotweet.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hb.tomatotweet.dtos.PostDTO;
import com.hb.tomatotweet.services.PostService;


@Controller
public class PublicController {

	private PostService postService;

	public PublicController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping("/")
	public ModelAndView homePage() {

		List<PostDTO> posts = postService.getPosts();
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("posts", posts);
		return mav;
	}

}
