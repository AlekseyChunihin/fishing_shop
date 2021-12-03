package ua.com.alevel.fishing_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.alevel.fishing_shop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
