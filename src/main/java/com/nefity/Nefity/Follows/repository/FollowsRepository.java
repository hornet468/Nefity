package com.nefity.Nefity.Follows.repository;

import com.nefity.Nefity.Follows.model.Follows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowsRepository extends JpaRepository<Follows , Long>{

}
