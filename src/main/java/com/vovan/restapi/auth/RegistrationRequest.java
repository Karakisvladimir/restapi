package com.vovan.restapi.auth;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String email;
    private String password;
    private String name;
    private int age;
}