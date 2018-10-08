package com.crawler.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crawler.entity.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, String> {

}
