package com.davyd.shop.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    @Positive
    private Long price;

    private String photo;

    @Column(columnDefinition = "text")
    private String description;
    @NotNull
    @DecimalMin("0.1")
    @DecimalMax("5.0")
    private Double rating;

    @ManyToOne
    private Subcategory subcategory;

    @ManyToMany(mappedBy = "favoriteProducts")
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "products")
    private List<Comment> comments = new ArrayList<>();
}
