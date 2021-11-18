package ua.com.alevel.fishing_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.alevel.fishing_shop.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
