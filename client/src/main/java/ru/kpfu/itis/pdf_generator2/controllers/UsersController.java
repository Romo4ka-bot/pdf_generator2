package ru.kpfu.itis.pdf_generator2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.pdf_generator2.services.UsersService;

@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/user_info/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(usersService.getUser(userId));
    }

    @PostMapping("/users/{user-id}/block")
    public ResponseEntity<?> blockUser(@PathVariable("user-id") Long userId) {
        usersService.blockUser(userId);
        return ResponseEntity.ok().build();
    }
}
