package com.hb.tomatotweet.services;

import java.util.ArrayList;
import java.util.List;

import com.hb.tomatotweet.dtos.CategoryDTO;
import com.hb.tomatotweet.models.Categorie;
import com.hb.tomatotweet.repositories.CategoryRepository;


public class CategoryService {
	
	private CategoryRepository categoryRepository;
	

	public List<CategoryDTO> getCategories() {
		
		List<Categorie> categories = categoryRepository.getCategories();
		List<CategoryDTO> categoriesDtos = new ArrayList<>();
		
		categories.forEach((category) -> { 
					categoriesDtos.add(new CategoryDTO(category.getLabel())); 
				});
		
		return categoriesDtos;
	}

}
