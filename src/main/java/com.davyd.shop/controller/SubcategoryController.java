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

@RestController
@RequestMapping("subcategory")
public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;

    @PostMapping
    public void save(@Valid @RequestBody SubcategoryRequest request) {
        subcategoryService.save(request);
    }

    @DeleteMapping
    public void delete(Long id) {
        subcategoryService.delete(id);
    }

    @GetMapping
    public PageResponse<SubcategoryResponse> findPage(
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam(defaultValue = "name") String fieldName,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction
    ) {
        return subcategoryService.findPage(page, size, fieldName, direction);
    }
    @PutMapping
    public void update(@Valid @RequestBody SubcategoryRequest request, Long id) throws IOException {
        subcategoryService.update(request, id);
    }
}
