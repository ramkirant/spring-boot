package com.ramlearning.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class MyUser {
    @Id
    private Integer id;
    private String username;
    private String password;
}
