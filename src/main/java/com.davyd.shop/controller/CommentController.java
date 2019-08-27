package com.davyd.shop.controller;


import com.davyd.shop.dto.request.CommentRequest;
import com.davyd.shop.dto.response.CommentResponse;
import com.davyd.shop.entity.Comment;
import com.davyd.shop.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public void save(@Valid @RequestBody CommentRequest request) {
        commentService.save(request);
    }

    @GetMapping
    public List<CommentResponse> findAll(@RequestParam(defaultValue = "id") String fieldName) {
        return commentService.findAll(fieldName);
    }

    @PutMapping
    public void update(@Valid @RequestBody CommentRequest request, Long id) {
        commentService.update(request, id);
    }

    @DeleteMapping
    public void delete(Long id) {
        commentService.delete(id);
    }

}
