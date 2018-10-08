package com.crawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crawler.dto.ActionDto;
import com.crawler.dto.ActionDto.Status;
import com.crawler.entity.Post;
import com.crawler.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping
	public Iterable<Post> getAllPosts() {
		return postService.getAllPosts();
	}

	@GetMapping("/{id}")
	public Post getPost(@RequestParam String id) {
		return postService.getPost(id);
	}

	@PostMapping
	public ActionDto create(@RequestBody Post post) {
		Post createdPost = postService.create(post);
		if (createdPost == null) {
			return new ActionDto(Status.FAIL, "update fail");
		}
		return new ActionDto(Status.SUCCESS, createdPost.getId());
	}

	@PutMapping
	public Post update(@RequestBody Post post) {
		return postService.update(post);
	}

	@DeleteMapping("/{id}")
	public ActionDto delete(@RequestParam String id) {
		postService.delete(id);
		return new ActionDto(Status.SUCCESS, "delete success");
	}

}
