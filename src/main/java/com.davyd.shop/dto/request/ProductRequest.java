package com.davyd.shop.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class ProductRequest {
    @NotBlank
    private String name;
    @Positive
    @NotNull
    private Long price;
    @DecimalMin("0.1")
    @DecimalMax("5.0")
    private Double rating;
    private String description;
    private String photo;
    @NotNull
    private Long subcategoryId;


}
