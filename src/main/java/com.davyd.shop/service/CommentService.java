package com.davyd.shop.service;

import com.davyd.shop.dto.request.CommentRequest;
import com.davyd.shop.dto.response.CommentResponse;
import com.davyd.shop.dto.response.PageResponse;
import com.davyd.shop.entity.Comment;
import com.davyd.shop.entity.Product;
import com.davyd.shop.entity.User;
import com.davyd.shop.exception.NoMatchesException;
import com.davyd.shop.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    public void save(CommentRequest request) {
Comment comment = new Comment();
comment.setComment(request.getComments());
        Product product = productService.findOne(request.getProductId());
        comment.setProducts(product);
        User user = userService.findOne(request.getProductId());
        comment.setUser(user);
        commentRepository.save(comment);
    }
    public List<CommentResponse> findAll(String fieldName) {
        return commentRepository.findAll(Sort.by(fieldName)).stream()
                .map(CommentResponse::new)
                .collect(Collectors.toList());
    }
    public Comment findOne(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new NoMatchesException("Comment with id " + id + " not exists"));
    }
    public void delete(Long id) {
        Comment comment = findOne(id);
            commentRepository.delete(comment);
    }
    public void update(CommentRequest request, Long id) {
        commentRepository.save(CommentRequestToComment(findOne(id), request));
    }

    private Comment CommentRequestToComment(Comment comment, CommentRequest request) {
        if (comment == null) {
            comment = new Comment();
        }
        comment.setComment(request.getComments());
        return comment;
    }
//    public PageResponse<CommentResponse> find_Page(Integer page, Integer size, String fieldName, Sort.Direction direction) {
//        Page<Comment> data = commentRepository.findAll(PageRequest.of(page, size, direction, fieldName));
//        List<CommentResponse> collect = data.get().map(CommentResponse::new).collect(Collectors.toList());
//        return new PageResponse<>(data.getTotalElements(),
//                data.getTotalPages(),
//                collect);
//
//    }
}
