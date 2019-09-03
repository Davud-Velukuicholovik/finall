package com.davyd.shop.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
public class ProductCount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Positive
    private Integer count;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Cart cart;
}
