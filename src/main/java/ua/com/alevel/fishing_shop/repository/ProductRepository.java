package ua.com.alevel.fishing_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.alevel.fishing_shop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
