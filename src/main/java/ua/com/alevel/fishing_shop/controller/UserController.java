package ua.com.alevel.fishing_shop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users")
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok("ITS OK");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
