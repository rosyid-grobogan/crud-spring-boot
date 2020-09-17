package com.training.crud.model.payload;

import com.training.crud.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String statusCode;
    private String statusMessage;
    private User user;
}
