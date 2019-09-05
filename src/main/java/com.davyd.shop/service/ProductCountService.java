//package com.davyd.shop.service;
//
//import com.davyd.shop.dto.request.ProductCountRequest;
//import com.davyd.shop.dto.request.ProductRequest;
//import com.davyd.shop.dto.response.PageResponse;
//import com.davyd.shop.dto.response.ProductCountResponse;
//import com.davyd.shop.dto.response.ProductResponse;
//import com.davyd.shop.entity.Product;
//import com.davyd.shop.entity.ProductCount;
//import com.davyd.shop.exception.NoMatchesException;
//import com.davyd.shop.repository.ProductCountRepository;
//import com.davyd.shop.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class ProductCountService {
//
//    @Autowired
//    private ProductCountRepository productCountRepository;
//
//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private FileService fileService;
//
//    public void save(ProductCountRequest request) throws IOException {
//        productCountRepository.save(productCountRequestToProductCount(null, request));
//    }
//
//    public PageResponse<ProductCountResponse> findPage(Integer page, Integer size, String fieldName, Sort.Direction direction) {
//        Page<ProductCount> data = productCountRepository.findAll(PageRequest.of(page, size, direction, fieldName));
//        List<ProductCountResponse> collect = data.get().map(ProductCountResponse::new).collect(Collectors.toList());
//        return new PageResponse<>(data.getTotalElements(),
//                data.getTotalPages(),
//                collect);
//
//    }
//
//    public void update(ProductCountRequest request, Long id) throws IOException {
//        productCountRepository.save(productCountRequestToProductCount(findOne(id), request));
//    }
//
//    public ProductCount findOne(Long id) {
//        return productCountRepository.findById(id).orElseThrow(()
//                -> new NoMatchesException("ProductCount with id " + id + " not exists"));
//    }
//
//    private ProductCount productCountRequestToProductCount(ProductCount productCount, ProductCountRequest request) throws IOException {
//        if (productCount == null) {
//            productCount = new ProductCount();
//        }
//        productCount.setCount(request.getCount());
//        productCount.setOrder(orderService.findOne(request.getOrderId()));
//        return productCount;
//    }
//}
