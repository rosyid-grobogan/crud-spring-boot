package com.training.crud.service;

import com.training.crud.model.payload.UserRequest;
import com.training.crud.model.payload.UserResponse;
import com.training.crud.model.payload.UsersResponse;


public interface UserService {

    UsersResponse getUsers(Integer pageNo, Integer pageSize);
    UserResponse createUser(UserRequest request);
}
