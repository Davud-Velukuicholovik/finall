package com.davyd.shop.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CommentRequest {
    @NotBlank
    private String comments;

    @NotNull
    private Long productId;
}
