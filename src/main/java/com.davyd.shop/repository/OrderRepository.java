package com.davyd.shop.repository;


import com.davyd.shop.entity.Order;
import com.davyd.shop.entity.Subcategory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
List<Order> findAllByUsersId(Long userId);
}
