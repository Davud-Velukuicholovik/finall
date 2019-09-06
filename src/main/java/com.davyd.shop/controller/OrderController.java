package com.davyd.shop.controller;

import com.davyd.shop.dto.request.OrderRequest;
import com.davyd.shop.dto.response.OrderResponse;
import com.davyd.shop.dto.response.PageResponse;
import com.davyd.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public void save(@Valid @RequestBody OrderRequest request) {
        orderService.save(request);
    }
    @GetMapping
    public List<OrderResponse> findAll() {
        return orderService.findAll();
    }

    @DeleteMapping
    public void delete(Long id) {
        orderService.deleteOrder(id);
    }

//    @GetMapping
//    public PageResponse<OrderResponse> findPage(
//            @RequestParam Integer page,
//            @RequestParam Integer size,
//            @RequestParam(defaultValue = "name") String fieldName,
//            @RequestParam(defaultValue = "ASC") Sort.Direction direction
//    ) {
//        return orderService.findPage(page, size, fieldName, direction);
//    }
    @PutMapping
    public void update(@Valid @RequestBody OrderRequest request, Long id) throws IOException {
        orderService.update(request, id);
    }

@GetMapping("/byUserId/{userId}")
public List<OrderResponse> findAllByUsersId(@PathVariable Long userId) {
    return orderService.findAllByUsersId(userId);
}
}
