package com.switchfully.codecoach.api.dtos.users;

public class RoleDTO {

    private String roleType;

    public String getRoleType() {
        return roleType;
    }

    public RoleDTO setRoleType(String roleType) {
        this.roleType = roleType;
        return this;
    }
}
