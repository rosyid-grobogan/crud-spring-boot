package com.training.crud.controllers;

import com.training.crud.model.payload.UserRequest;
import com.training.crud.model.payload.UserRequestUpdate;
import com.training.crud.model.payload.UserResponse;
import com.training.crud.model.payload.UsersResponse;
import com.training.crud.repositories.UserRepository;

import com.training.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



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
            @RequestParam(defaultValue = "3") Integer paging)
    {
        UsersResponse data = service.getUsers(page, paging);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id)
    {
        UserResponse data= service.getUser(id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request)
    {
        UserResponse data = service.createUser(request);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserRequestUpdate request, @PathVariable Long id)
    {
        UserResponse data = service.updateUser(request, id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> destroyUser(@PathVariable Long id)
    {
        UserResponse data = service.destroyUser(id);
        return new ResponseEntity<>(data, HttpStatus.ACCEPTED);

    }
}
