//package com.davyd.shop.repository;
//
//
//import com.davyd.shop.entity.Comment;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface CommentRepository extends JpaRepository<Comment, Long> {
//
//
////    @Query("from Comment c join c.product p where p.id=:productId")
////    List<Comment> findAllByCommentId(@Param("productId") Long productId);
//}
