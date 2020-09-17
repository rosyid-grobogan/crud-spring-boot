package com.training.crud.service;

import com.training.crud.model.entity.User;
import com.training.crud.model.payload.UserRequest;
import com.training.crud.model.payload.UserResponse;
import com.training.crud.model.payload.UsersResponse;
import com.training.crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImplement implements UserService {
    @Autowired
    UserRepository repository;


@Override
    public UsersResponse getUsers(Integer pageNo, Integer pageSize){

        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<User> pagedResult = repository.findAll(paging);

        List<User> list = new ArrayList<User>();
        if(pagedResult.hasContent()) {
            list = pagedResult.getContent();
        } else {
           list = new ArrayList<User>();
        }

        UsersResponse users = new UsersResponse("200", "Sukses", list);
        return users;
    }

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        repository.save(user);
        UserResponse data = new UserResponse("201", "Sukses", user);

        return data;
    }


}
