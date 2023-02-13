package com.hb.tomatotweet.models;


public class Post {
	
	private Integer id;

	private Integer category;
	private String content;
	
	public Post() {	}

	public Post(Integer id, Integer category, String content) {
		this.id = id;
		this.category = category;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
