package com.davyd.shop.service;

import com.davyd.shop.dto.request.UserRequest;
import com.davyd.shop.dto.response.UserResponse;
import com.davyd.shop.entity.Cart;
import com.davyd.shop.entity.Product;
import com.davyd.shop.entity.User;
import com.davyd.shop.exception.HasDependenciesException;
import com.davyd.shop.exception.NoMatchesException;
import com.davyd.shop.repository.CartRepository;
import com.davyd.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    public void save(UserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        Cart cart = new Cart();
        cart = cartRepository.save(cart);
        user.setCart(cart);

        if (request.getFavoritesIds() != null) {
            List<Product> collect = request.getFavoritesIds().stream()
                    .map(productService::findOne)
                    .collect(Collectors.toList());
            user.setFavoriteProducts(collect);
        }
        userRepository.save(user);
    }
//    public void save(UserRequest request) {
//        User user = new User();
//        user.setUsername(request.getUsername());
//        user.setPassword(request.getPassword());
//        userRepository.save(user);
//    }
    public List<UserResponse> findAll(String fieldName) {
        return userRepository.findAll(Sort.by(fieldName)).stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    public User findOne(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoMatchesException("User with id " + id + " not exists"));
    }
    public void update(UserRequest request, Long id) {
        userRepository.save(userRequestToUser(findOne(id), request));
    }
    public void delete(Long id) {
        User user = findOne(id);
        if (user.getComments().isEmpty()) {
            userRepository.delete(user);
        } else {
            throw new HasDependenciesException("Cannot delete User with id " + id + " because it has comment");
        }
    }


    private User userRequestToUser(User user,UserRequest request) {
        if (user == null) {
            user = new User();
        }
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        return user;
    }

    public void create(UserRequest request) {
        User user = new User();
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());

        Cart cart = new Cart();
        cart = cartRepository.save(cart);
        user.setCart(cart);

        if (request.getFavoritesIds() != null) {
            List<Product> collect = request.getFavoritesIds().stream()
                    .map(productService::findOne)
                    .collect(Collectors.toList());
            user.setFavoriteProducts(collect);
        }

        userRepository.save(user);
    }
}
