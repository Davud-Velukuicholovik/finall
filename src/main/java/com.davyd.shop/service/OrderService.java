package com.davyd.shop.service;

import com.davyd.shop.dto.request.OrderRequest;
import com.davyd.shop.dto.response.OrderResponse;
import com.davyd.shop.dto.response.PageResponse;
import com.davyd.shop.entity.*;
import com.davyd.shop.exception.NoMatchesException;
import com.davyd.shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;
//
//    @Autowired
//    private FileService fileService;


//        public void save(OrderRequest request) throws IOException {
//        orderRepository.save(orderRequestToOrder(null, request));
//    }
    public void save(OrderRequest request) {
        Order order = new Order();
        order.setPhoneNumber(request.getPhoneNumber());
        order.setAddress(request.getAddress());
        order.setDate(request.getDate());
        User user = userService.findOne(request.getUserId());
        order.setUsers(user);
        orderRepository.save(order);
    }
    public void update(OrderRequest request, Long id) throws IOException {
        orderRepository.save(orderRequestToOrder(findOne(id), request));
    }
public List<OrderResponse> findAll() {
        return orderRepository.findAll().stream()
                .map(OrderResponse::new).collect(Collectors.toList());
}
    public List<OrderResponse> findAllByName(String value) {
        return orderRepository.findAllByUsersContaining('%' + value + '%', Sort.by("name")).stream()
                .map(OrderResponse::new).collect(Collectors.toList());
    }

//    public PageResponse<OrderResponse> findPage(Integer page, Integer size, String fieldName, Sort.Direction direction) {
//        Page<Order> daata = orderRepository.findAll(PageRequest.of(page, size, direction, fieldName));
//        List<OrderResponse> collect = daata.get().map(OrderResponse::new).collect(Collectors.toList());
//        return new PageResponse<>(daata.getTotalElements(),
//                daata.getTotalPages(),
//                collect);
//    }



    public Order findOne(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NoMatchesException("Order with id " + id + " not exists"));
    }

    private Order orderRequestToOrder(Order order, OrderRequest request) throws IOException {
        if (order == null) {
            order = new Order();
        }
        order.setDate(request.getDate());
        order.setPhoneNumber(request.getPhoneNumber());
        order.setAddress(request.getAddress());
        order.setUsers(userService.findOne(request.getUserId()));
    return order;
    }
    public void deleteOrder(Long id) {
        Order order = findOne(id);
            orderRepository.delete(order);
    }


////    public List<OrderResponse> findAllByUserId(Long userId) {
////        return orderRepository.findAllByUserId(userId).stream().
////                map(OrderResponse::new).collect(Collectors.toList());
////    }
}
