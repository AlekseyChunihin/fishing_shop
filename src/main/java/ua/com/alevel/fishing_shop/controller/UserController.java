package ua.com.alevel.fishing_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.fishing_shop.Routes;
import ua.com.alevel.fishing_shop.dto.user.request.SaveUserRequest;
import ua.com.alevel.fishing_shop.dto.user.response.UserResponse;
import ua.com.alevel.fishing_shop.service.UserService;

import java.util.List;

@RestController
@RequestMapping(Routes.USERS)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody final SaveUserRequest userRequest) {
        return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserResponse> findUsersById(@PathVariable final Integer id) {
        return new ResponseEntity<>(userService.findUserByIdForResponse(id), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<UserResponse> updateUsers(@PathVariable final Integer id, @RequestBody final SaveUserRequest saveUserRequest) {
        return new ResponseEntity<>(userService.updateUser(id, saveUserRequest), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<UserResponse> deleteProduct(@PathVariable final Integer id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }
}
