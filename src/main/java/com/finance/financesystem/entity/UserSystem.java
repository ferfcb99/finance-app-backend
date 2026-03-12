package com.finance.financesystem.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "user_system")
public class UserSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "currency")
    private String currency;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "status")
    private String status;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    /*
    create table user_system (
            id int auto_increment,
            name varchar(100),
    email varchar(120),
    password varchar(255),
    currency varchar(10),
    created_at datetime,
    updated_at datetime,
    status varchar(20),
    last_login datetime,
    constraint user_system_pk primary key(id)
);*/

}
