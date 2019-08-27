package com.davyd.shop.dto.response;

import com.davyd.shop.entity.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponse {

    private Long id;
    private String comments;

    public CommentResponse(Comment comment) {
        id = comment.getId();
        comments = comment.getComments();
    }

}
