package ua.com.alevel.fishing_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.alevel.fishing_shop.entity.CartProducts;
import ua.com.alevel.fishing_shop.entity.User;

import java.util.List;

@Repository
public interface CartProductsRepository extends JpaRepository<CartProducts, Integer> {

    List<CartProducts> findByUser(User user);
}
