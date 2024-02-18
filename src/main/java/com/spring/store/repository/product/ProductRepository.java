package com.spring.store.repository.product;

import com.spring.store.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Modifying
    @Transactional
    @Query("update Product p set p.amount = :amount where p.id = :id")
    int updateProductAmount(Long id, int amount);
    @Query("select p.amount from Product p where p.id = :productId")
    Integer findAmountByProductId(Long productId);
}
