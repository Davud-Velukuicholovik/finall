package com.davyd.shop.controller;

import com.davyd.shop.dto.request.SubcategoryRequest;

import com.davyd.shop.dto.response.PageResponse;
import com.davyd.shop.dto.response.SubcategoryResponse;
import com.davyd.shop.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("subcategory")
public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;

    @PostMapping
    public void save(@Valid @RequestBody SubcategoryRequest request) {
        subcategoryService.save(request);
    }

    @GetMapping("/byCategoryId/{categoryId}")
    public List<SubcategoryResponse> findAllByCategoryId(@PathVariable Long categoryId) {
        return subcategoryService.findAllByCategoryId(categoryId);
    }
}
