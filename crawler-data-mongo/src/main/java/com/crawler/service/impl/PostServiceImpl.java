package com.crawler.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawler.entity.Post;
import com.crawler.exception.NotFoundException;
import com.crawler.repository.PostRepository;
import com.crawler.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public Iterable<Post> getAllPosts() {
		return postRepository.findAll();
	}

	@Override
	public Post getPost(String id) {
		Optional<Post> post = postRepository.findById(id);
		if (!post.isPresent()) {
			throw new NotFoundException("Post", "id", id);
		}

		return post.get();
	}

	@Override
	public Post create(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Post update(Post post) {
		String id = post.getId();
		Optional<Post> existPost = postRepository.findById(id);
		if (!existPost.isPresent()) {
			throw new NotFoundException("Post", "id", id);
		}

		return mergePost(existPost.get(), post);
	}

	public Post mergePost(Post existPost, Post newPost) {
		if (newPost.getTitle() != null) {
			existPost.setTitle(newPost.getTitle());
		}

		if (newPost.getUrl() != null) {
			existPost.setUrl(newPost.getUrl());
		}

		if (newPost.getCategory() != null) {
			existPost.setCategory(newPost.getCategory());
		}

		if (newPost.getSortContent() != null) {
			existPost.setSortContent(newPost.getSortContent());
		}

		if (newPost.getFullContent() != null) {
			existPost.setFullContent(newPost.getFullContent());
		}

		if (newPost.getImageUrl() != null) {
			existPost.setImageUrl(newPost.getImageUrl());
		}

		if (newPost.getImageUrls() != null) {
			existPost.setImageUrls(newPost.getImageUrls());
		}

		if (newPost.getTags() != null) {
			existPost.setTags(newPost.getTags());
		}

		if (newPost.getDatePost() != null) {
			existPost.setDatePost(newPost.getDatePost());
		}

		return newPost;
	}

	@Override
	public void delete(String id) {
		Optional<Post> post = postRepository.findById(id);
		if (!post.isPresent()) {
			throw new NotFoundException("Post", "id", id);
		}
		postRepository.delete(post.get());
	}

}
