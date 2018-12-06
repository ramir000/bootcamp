package com.api.shoppingcart.dao;

import java.util.List;

import com.api.shoppingcart.model.Cart;
import com.api.shoppingcart.model.CartId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao extends JpaRepository<Cart, CartId> {

    @Query(value = "SELECT * FROM Cart c where userid = ?1", nativeQuery = true)
    List<Cart> findAllByUserId(Long UserId);

    @Query(value = "SELECT EXISTS(SELECT * FROM Cart c where userid = ?1)", nativeQuery = true)
    boolean existsByUserId(Long UserId);

    @Query(value = "DELETE * FROM Cart c where userid = ?1", nativeQuery = true)
    void deleteByUserId(Long UserId);
}