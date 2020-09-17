package com.training.crud.model.payload;

import com.training.crud.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersResponse {
    private String statusCode;
    private String statusMessage;
    private List<User> users;

}
