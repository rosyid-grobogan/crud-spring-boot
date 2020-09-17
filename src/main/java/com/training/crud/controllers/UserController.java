package com.training.crud.controllers;

import com.training.crud.model.entity.User;
import com.training.crud.model.payload.UserRequest;
import com.training.crud.model.payload.UserResponse;
import com.training.crud.model.payload.UsersResponse;
import com.training.crud.repositories.UserRepository;

import com.training.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService service;


    @GetMapping
    public ResponseEntity<UsersResponse> pagingUsers(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "3") Integer paging
    ){
        UsersResponse data = service.getUsers(page, paging);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        UserResponse data = service.createUser(request);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long id) {
        user.setId(id);
        userRepo.save(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroyUser(@PathVariable Long id) {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }
}
