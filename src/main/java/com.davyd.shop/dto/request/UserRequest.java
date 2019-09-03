package com.davyd.shop.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class UserRequest {
//    @NotBlank
    private String username;
//    @NotBlank
    private String password;
    private List<Long> favoritesIds;


}
