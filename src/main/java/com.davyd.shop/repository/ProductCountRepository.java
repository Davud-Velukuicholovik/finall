//package com.davyd.shop.repository;
//
//import com.davyd.shop.entity.Product;
//import com.davyd.shop.entity.ProductCount;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface ProductCountRepository extends JpaRepository<ProductCount, Long> {
//    @Query("from Product p join p.subcategory s join s.category c where c.id=:categoryId")
//    List<ProductCount> findAllByProductId(@Param("categoryId") Long userId);
//}
