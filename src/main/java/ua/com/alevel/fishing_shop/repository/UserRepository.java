package ua.com.alevel.fishing_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.alevel.fishing_shop.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    Optional<User> findUserByName(String userName);

    boolean existsByEmail(String email);

    void deleteByEmail(String email);
}
