package com.switchfully.codecoach.domain.models.users;

import com.switchfully.codecoach.domain.models.coaches.CoachProfile;
import com.switchfully.codecoach.infrastructure.utils.ValidationUtil;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")

public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "picture_url")
    private String pictureUrl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coach_profile_id")
    private CoachProfile coachProfile;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private final List<Role> roles = new ArrayList<>();

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, String pictureUrl) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(firstName, "Firstname");
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(lastName, "LastName");
        ValidationUtil.throwExceptionIfEmailNullEmptyBlankOrInvalid(email, "Email");
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(password, "password");

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email.toLowerCase();
        this.password = password;
        this.pictureUrl = pictureUrl;
        this.coachProfile = new CoachProfile();
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public CoachProfile getCoachProfile() {
        return coachProfile;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public User setCoachProfile(CoachProfile coachProfile) {
        this.coachProfile = coachProfile;
        return this;
    }

    public User addRole(Role role) {
        this.roles.add(role);
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
