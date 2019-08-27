package com.davyd.shop.repository;

import com.davyd.shop.entity.Comment;
import com.davyd.shop.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("from Comment s join s.user c where c.id=:commentuuId")
    List<Comment> findAllByCommentId(@Param("commentuuId") Long commentId);
}

