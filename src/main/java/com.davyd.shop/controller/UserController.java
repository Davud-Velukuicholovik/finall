package com.davyd.shop.controller;

import com.davyd.shop.dto.request.UserRequest;
import com.davyd.shop.dto.response.UserResponse;
import com.davyd.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void save(@Valid @RequestBody UserRequest request) {
        userService.save(request);
    }

    @GetMapping
    public List<UserResponse> findAll(@RequestParam(defaultValue = "id") String fieldName) {
        return userService.findAll(fieldName);
    }

    @PutMapping
    public void update(@Valid @RequestBody UserRequest request, Long id) {
        userService.update(request, id);
    }

    @DeleteMapping
    public void delete(Long id) {
        userService.delete(id);
    }
}
