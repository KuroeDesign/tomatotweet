package com.hb.tomatotweet.services;


import com.hb.tomatotweet.dtos.PostDTO;
import com.hb.tomatotweet.models.Categorie;
import com.hb.tomatotweet.models.Post;
import com.hb.tomatotweet.repositories.CategoryRepository;
import com.hb.tomatotweet.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
	
	private PostRepository postRepository;
	private String catPost;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public List<PostDTO> getPosts(CategoryRepository cs) {
		List<Post> posts = postRepository.getPosts();
		List<Categorie> categories = cs.getCategories();
 		List<PostDTO> postsDtos = new ArrayList<>();

		posts.forEach((post) -> {
					categories.forEach((cat -> {
						if(cat.getId() == post.getId()) {
							catPost = cat.getLabel();
						}
					}));
					postsDtos.add(new PostDTO(post.getId().toString(), catPost, post.getContent())); 
				});
		
		return postsDtos;
	}
	
	public void addPost(PostDTO postDTO, CategoryRepository cs) {
		Post post = new Post();
		List<Categorie> categories = cs.getCategories();
		post.setContent(postDTO.content());
		categories.forEach((cat -> {
			if(cat.getLabel() == postDTO.category()) {
				post.setCategory(cat.getId());
			}
		}));
		postRepository.save(post);
	}
	
}
