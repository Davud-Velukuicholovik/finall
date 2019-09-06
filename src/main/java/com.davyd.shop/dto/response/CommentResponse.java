package com.davyd.shop.dto.response;

import com.davyd.shop.entity.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponse {
    private long id;
    private String comments;
    private ProductResponse productResponse;
    private UserResponse userResponse;

    public CommentResponse(Comment comment) {
        id = comment.getId();
        comments = comment.getComment();
        productResponse = new ProductResponse(comment.getProducts());
        userResponse = new UserResponse(comment.getUser());

    }
}
