package ua.com.alevel.fishing_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.alevel.fishing_shop.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    boolean existsByEmail(String email);

    void deleteByEmail(String email);
}
