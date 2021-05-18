package com.switchfully.codecoach.api.dtos.users;

import java.util.UUID;

public class UserDTO {

    private UUID id;
    private String firstname;
    private String lastname;
    private String email;
    private String pictureUrl;




    public UUID getId() {
        return id;
    }

    public UserDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public UserDTO setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public UserDTO setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public UserDTO setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }
}
