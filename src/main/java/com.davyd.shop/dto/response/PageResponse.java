package com.davyd.shop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PageResponse<T> {
    private Long totalElements;
    private Integer totalPages;
    private List<T> data;

//    public PageResponse(Page page) {
//        totalElements = page.getTotalElements();
//        totalPages = page.getTotalPages();
//    }
}
