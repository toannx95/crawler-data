package com.crawler.service;

import com.crawler.entity.Post;

public interface PostService {

	Iterable<Post> getAllPosts();

	Post getPost(String id);

	Post create(Post post);

	Post update(Post post);

	void delete(String id);
}
