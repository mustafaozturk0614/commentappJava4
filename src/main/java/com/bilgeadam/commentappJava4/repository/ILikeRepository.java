package com.bilgeadam.commentappJava4.repository;

import com.bilgeadam.commentappJava4.repository.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikeRepository extends JpaRepository<Like, Long> {
}
