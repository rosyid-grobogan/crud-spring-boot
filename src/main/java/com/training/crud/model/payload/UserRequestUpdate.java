package com.training.crud.model.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestUpdate {
    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
