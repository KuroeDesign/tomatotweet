package com.hb.tomatotweet.repositories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hb.tomatotweet.models.Categorie;

@Repository
public class CategoryRepository {
	
	public List<Categorie> getCategories() {
		List<Categorie> categories = new ArrayList<>();
		
		ObjectMapper mapper = new ObjectMapper();		
		try {
			File resourceJson = new ClassPathResource("categories.json").getFile();
			categories = mapper.readValue(
					resourceJson, 
					new TypeReference<List<Categorie>>() {} );			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return categories;
	}

}
