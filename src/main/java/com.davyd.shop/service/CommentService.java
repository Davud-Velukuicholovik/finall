package com.davyd.shop.service;

import com.davyd.shop.dto.request.CommentRequest;
import com.davyd.shop.dto.response.CommentResponse;
import com.davyd.shop.entity.Comment;
import com.davyd.shop.exception.HasDependenciesException;
import com.davyd.shop.exception.NoMatchesException;
import com.davyd.shop.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void save(CommentRequest request) {
        commentRepository.save(
                commentRequestToComment(null, request));
    }

    public List<CommentResponse> findAll(String fieldName) {
        return commentRepository.findAll(Sort.by(fieldName)).stream()
                .map(CommentResponse::new)
                .collect(Collectors.toList());
    }

    public Comment findOne(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new NoMatchesException("Comment with id " + id + " not exists"));
    }

    public void update(CommentRequest request, Long id) {
        commentRepository.save(commentRequestToComment(findOne(id), request));
    }

    public void delete(Long id) {
        Comment comment = findOne(id);
        if (comment.getComments().isEmpty()) {
            commentRepository.delete(comment);
        } else {
            throw new HasDependenciesException("Cannot delete comment with id " + id + " because it has dependencies");
        }
    }

    private Comment commentRequestToComment(Comment comment,
                                               CommentRequest request) {
        if (comment == null) {
            comment = new Comment();
        }
        comment.setComments(request.getComments());
        return comment;
    }
}
