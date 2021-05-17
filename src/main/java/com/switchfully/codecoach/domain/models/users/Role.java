package com.switchfully.codecoach.domain.models.users;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue
    @Column(name ="id")
    private UUID id;

    @Column(name = "role_type")
    private String roleType;

    public Role() {
    }

    public Role(UUID id, String roleType) {
        this.id = id;
        this.roleType = roleType;
    }

    public UUID getId() {
        return id;
    }

    public String getRoleType() {
        return roleType;
    }

    public Role setId(UUID id) {
        this.id = id;
        return this;
    }

    public Role setRoleType(String roleType) {
        this.roleType = roleType;
        return this;
    }
}
