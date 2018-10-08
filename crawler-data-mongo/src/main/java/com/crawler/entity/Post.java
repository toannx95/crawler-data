package com.crawler.entity;

import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class Post {

	@Id
	public String id;
	private String title;
	private String url;
	private String category;
	private String sortContent;
	private String fullContent;
	private String imageUrl;
	private Set<String> imageUrls;
	private Set<String> tags;
	private Date datePost;

	public Post() {
		super();
	}

	public Post(String id, String title, String url, String category, String sortContent, String fullContent,
			String imageUrl, Set<String> imageUrls, Set<String> tags, Date datePost) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.category = category;
		this.sortContent = sortContent;
		this.fullContent = fullContent;
		this.imageUrl = imageUrl;
		this.imageUrls = imageUrls;
		this.tags = tags;
		this.datePost = datePost;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSortContent() {
		return sortContent;
	}

	public void setSortContent(String sortContent) {
		this.sortContent = sortContent;
	}

	public String getFullContent() {
		return fullContent;
	}

	public void setFullContent(String fullContent) {
		this.fullContent = fullContent;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Set<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(Set<String> imageUrls) {
		this.imageUrls = imageUrls;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public Date getDatePost() {
		return datePost;
	}

	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}

}
