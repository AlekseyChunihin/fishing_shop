package ua.com.alevel.fishing_shop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.fishing_shop.dto.product.response.ProductResponse;
import ua.com.alevel.fishing_shop.dto.user.request.SaveUserRequest;
import ua.com.alevel.fishing_shop.dto.user.response.UserResponse;
import ua.com.alevel.fishing_shop.entity.Brand;
import ua.com.alevel.fishing_shop.entity.Product;
import ua.com.alevel.fishing_shop.entity.User;
import ua.com.alevel.fishing_shop.exception.BrandNotFoundException;
import ua.com.alevel.fishing_shop.exception.ProductNotFoundException;
import ua.com.alevel.fishing_shop.exception.UserNotFoundException;
import ua.com.alevel.fishing_shop.exception.UserWithSuchIdNotFoundException;
import ua.com.alevel.fishing_shop.repository.UserRepository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponse createUser(SaveUserRequest userRequest) {
        User user = convertSaveUserRequestToUser(userRequest);
        return UserResponse.from((userRepository.save(user)));
    }

    @Transactional
    public User findUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(()
                -> new UserWithSuchIdNotFoundException(id));
    }

    public User findUserByName(String name) {
        return userRepository.findUserByName(name).orElseThrow(()
                -> new UserNotFoundException(name));
    }

    @Transactional
    public UserResponse findUserByIdForResponse(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()
                -> new UserWithSuchIdNotFoundException(id));
        return UserResponse.from(user);
    }

    @Transactional
    public List<UserResponse> findAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            userResponses.add(UserResponse.from(user));
        }
        return userResponses;
    }

    @Transactional
    public UserResponse deleteUser(Integer id) {
        User user = findUserById(id);
        userRepository.delete(user);
        return UserResponse.from(user);
    }

    @Transactional
    public UserResponse updateUser(Integer id, SaveUserRequest saveUserRequest) {
        User user = new User();
        user.setName(saveUserRequest.getName());
        user.setPassword(saveUserRequest.getPassword());
        user.setPassword(saveUserRequest.getPassword());
        return UserResponse.from(user);
    }

    public static User convertSaveUserRequestToUser(SaveUserRequest saveUserRequest) {
        User user = new User();
        user.setName(saveUserRequest.getName());
        user.setEmail(saveUserRequest.getEmail());
        user.setPassword(saveUserRequest.getPassword());
        user.setCreatedAt(OffsetDateTime.now());
        return user;
    }

    private boolean isEmailUnique(String email) {
        return userRepository.existsByEmail(email);
    }

}
