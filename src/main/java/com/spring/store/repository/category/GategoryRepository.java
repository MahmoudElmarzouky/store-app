package com.spring.store.repository.category;

import com.spring.store.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GategoryRepository extends JpaRepository<Category,Long> {
}
