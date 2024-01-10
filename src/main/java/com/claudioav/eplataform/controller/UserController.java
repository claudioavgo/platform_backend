package com.claudioav.eplataform.controller;

import com.claudioav.eplataform.domain.user.User;
import com.claudioav.eplataform.dtos.UserDTO;
import com.claudioav.eplataform.services.MailService;
import com.claudioav.eplataform.services.UserService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @PostMapping
    public ResponseEntity createUser(@RequestBody @Valid UserDTO data) {
        return ResponseEntity.ok(userService.createUser(data));
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable String id) throws MessagingException, UnsupportedEncodingException {
        User user = userService.getUserById(id);
        mailService.sendHelloTestEmail(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable String id, @RequestBody UserDTO data) {
        return ResponseEntity.ok(userService.updateUserById(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable String id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}
