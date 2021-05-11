package com.switchfully.codecoach.domain.models.users;

import com.switchfully.codecoach.infrastructure.utils.ValidationUtil;

import javax.persistence.*;
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

    public User() {
    }

    public User(String firstName, String lastName, String email, String password) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(firstName, "Firstname");
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(lastName, "LastName");
        ValidationUtil.throwExceptionIfEmailNullEmptyBlankOrInvalid(email, "email");
        //TODO will need to be something else for the password:
        //TODO check length and character had to be uppercase
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(password, "password");

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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
