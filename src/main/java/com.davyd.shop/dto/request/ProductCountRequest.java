package com.davyd.shop.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class ProductCountRequest {
    private Long productId;
    private Integer count;


}
