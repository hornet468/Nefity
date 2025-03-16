package com.nefity.Nefity.Likes.repository;


import com.nefity.Nefity.Likes.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    List<Likes> findByPostId(Long id);
}

