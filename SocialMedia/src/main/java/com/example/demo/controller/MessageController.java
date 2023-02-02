package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.http.*;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.mapper.*;
import com.example.demo.dto.*;

import java.util.*;

@RequestMapping("/users")
@Controller
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        List<User>  = messageService.getAllUsers();
        List<UserDTO> usersDtos = UserMapper.toUserDTOList(users);

        return ResponseEntity.ok(usersDtos);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId) {

        User user = messageService.getUserById(userId);

        if (user == null) {
            return ResponseEntity.notFound().build();
        } 
        UserDTO dto = UserMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto) {
        User fromDto = UserMapper.toUser(dto);
        User createdUser = messageService.createUser(fromDto);
        if (createdUser == null) {
            return ResponseEntity.badRequest().build();
        }
        UserDTO createdUserDto = UserMapper.toUserDTO(createdUser);
        return ResponseEntity.ok(createdUserDto);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUserById(@PathVariable Integer userId) {

        User user = messageService.getUserById(userId);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } 
        messageService.deleteUser(user); 
        return ResponseEntity.ok(user);
    
    }


}



