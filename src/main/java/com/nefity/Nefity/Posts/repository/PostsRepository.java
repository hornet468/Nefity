package com.nefity.Nefity.Posts.repository;

import com.nefity.Nefity.Posts.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
