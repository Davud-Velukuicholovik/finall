package com.davyd.shop.service;

import com.davyd.shop.dto.request.OrderRequest;
import com.davyd.shop.dto.request.ProductCountRequest;
import com.davyd.shop.dto.response.OrderResponse;
import com.davyd.shop.dto.response.PageResponse;
import com.davyd.shop.entity.*;
import com.davyd.shop.exception.NoMatchesException;
import com.davyd.shop.repository.OrderRepository;
import com.davyd.shop.repository.ProductCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private ProductCountRepository productCountRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

//    @Autowired
//    private UserService userService;

//    @Autowired
//    private FileService fileService;
public void save(OrderRequest request) {
    Order order = orderRequestToOrder(null, request);
    order = orderRepository.saveAndFlush(order);
    List<ProductCount> productCounts = orderRequestToProductCounts(request, order);
    productCountRepository.saveAll(productCounts);
}
    private List<ProductCount> orderRequestToProductCounts(OrderRequest request, Order order) {
        return request.getProductCountRequests().stream().map(p -> productCountRequestToProductCount(p, order)).collect(Collectors.toList());
    }
    private ProductCount productCountRequestToProductCount(ProductCountRequest request, Order order) {
        return ProductCount.builder()
                .count(request.getCount())
                .product(productService.findOne(request.getProductId()))
                .order(order)
                .build();
    }
    private Order orderRequestToOrder(Order order, OrderRequest request) {
        if (order == null) {
            order = new Order();
            order.setDate(LocalDate.now());
            order.setTime(LocalTime.now());
            order.setFinished(false);
        }
        return order;
    }
//    public void save(OrderRequest request) {
//        Order order = new Order();
//        order.setPhoneNumber(request.getPhoneNumber());
//        order.setAddress(request.getAddress());
//        order.setDate(request.getDate());
//        User user = userService.findOne(request.getUserId());
//        order.setUsers(user);
//        orderRepository.save(order);
//    }
    public void update(OrderRequest request, Long id) throws IOException {
        orderRepository.save(orderRequestToOrder(findOne(id), request));
    }
public List<OrderResponse> findAll() {
        return orderRepository.findAll().stream()
                .map(OrderResponse::new).collect(Collectors.toList());
}
//    public PageResponse<OrderResponse> findPage(Integer page, Integer size, String fieldName, Sort.Direction direction) {
//        Page<Order> data = orderRepository.findAll(PageRequest.of(page, size, direction, fieldName));
//        List<OrderResponse> collect = data.get().map(OrderResponse::new).collect(Collectors.toList());
//        return new PageResponse<>(data.getTotalElements(),data.getTotalPages(),collect);
//    }
    public Order findOne(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NoMatchesException("Order with id " + id + " not exists"));
    }

//    private Order orderRequestToOrder(Order order, OrderRequest request) throws IOException {
//        if (order == null) {
//            order = new Order();
//        }
//        order.setDate(request.getDate());
//        order.setPhoneNumber(request.getPhoneNumber());
//        order.setAddress(request.getAddress());
//        order.setUsers(userService.findOne(request.getUserId()));
//    return order;
//    }
    public void deleteOrder(Long id) {
        Order order = findOne(id);
            orderRepository.delete(order);
    }


    public List<OrderResponse> findAllByUsersId(Long userId) {
        return orderRepository.findAllByUsersId(userId).stream().
                map(OrderResponse::new).collect(Collectors.toList());
    }
}
