package com.davyd.shop.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class OrderRequest {
    @NotNull
    @Future
    private LocalDate date;
    @NotNull
    @NumberFormat
    private String phoneNumber;
    @NotNull
    private String address;

    @NotNull
    private Long userId;
    @NotEmpty
    @JsonProperty("products")
    private List<ProductCountRequest> productCountRequests;
}
