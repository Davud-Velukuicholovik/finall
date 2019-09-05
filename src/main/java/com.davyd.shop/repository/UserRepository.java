package com.davyd.shop.repository;

import com.davyd.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
//    List<User> findAllByCategoryId(Long categoryId);
}
