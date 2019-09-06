package com.davyd.shop.dto.response;

import com.davyd.shop.entity.Order;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class OrderResponse {
    private Long id;
    private LocalDate date;
    private String phoneNumber;
    private String address;
    private UserResponse userResponse;

    public OrderResponse(Order order) {
        id = order.getId();
        date = order.getDate();
        phoneNumber = order.getPhoneNumber();
        address = order.getAddress();
        userResponse = new UserResponse(order.getUsers());
    }
}
