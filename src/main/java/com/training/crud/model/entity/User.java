package com.training.crud.model.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = true)
    private String lastName;
}
