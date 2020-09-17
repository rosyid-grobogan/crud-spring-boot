package com.training.crud.repositories;

import com.training.crud.model.entity.User;
import com.training.crud.model.payload.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
