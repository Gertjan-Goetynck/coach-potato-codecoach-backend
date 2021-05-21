package com.switchfully.codecoach.api.dtos.users;

import com.switchfully.codecoach.api.dtos.coachprofiles.CoachProfileDTO;
import com.switchfully.codecoach.api.dtos.roles.RoleDTO;

import java.util.List;
import java.util.UUID;

public class UserDTO {

    private UUID id;
    private String firstname;
    private String lastname;
    private String email;
    private String pictureUrl;
    private CoachProfileDTO coachProfile;
    private List<RoleDTO> roles;

    public CoachProfileDTO getCoachProfile() {
        return coachProfile;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public UserDTO setRoles(List<RoleDTO> roles) {
        this.roles = roles;
        return this;
    }

    public UserDTO setCoachProfile(CoachProfileDTO coachProfile) {
        this.coachProfile = coachProfile;
        return this;
    }

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
