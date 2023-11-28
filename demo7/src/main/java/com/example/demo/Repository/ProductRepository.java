package com.example.demo.Repository;

import com.example.demo.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Может потребоваться добавить дополнительные методы для запросов к базе данных
}
