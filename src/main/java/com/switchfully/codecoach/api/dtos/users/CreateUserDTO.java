package com.switchfully.codecoach.api.dtos.users;

public class CreateUserDTO {

    private String firstname;
    private String lastname;
    private String email;
    private String password;

    public String getFirstname() {
        return firstname;
    }

    public CreateUserDTO setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public CreateUserDTO setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateUserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CreateUserDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
