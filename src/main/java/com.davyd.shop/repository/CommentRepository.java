package com.davyd.shop.repository;


import com.davyd.shop.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
List<Comment> findAllByUserId(Long commentId);
}
