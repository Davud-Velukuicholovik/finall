package com.davyd.shop.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

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
}
