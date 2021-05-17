package com.switchfully.codecoach.domain.models.users;

import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private Role role;
}