package ua.com.alevel.fishing_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.alevel.fishing_shop.entity.Brand;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

    Optional<Brand> findByName(String name);
}
