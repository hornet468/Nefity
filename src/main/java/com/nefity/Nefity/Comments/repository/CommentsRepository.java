package com.nefity.Nefity.Comments.repository;



import com.nefity.Nefity.Comments.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {
}

