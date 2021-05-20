package com.switchfully.codecoach.api.mappers;

import com.switchfully.codecoach.api.dtos.users.RoleDTO;
import com.switchfully.codecoach.domain.models.users.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RolesMapper {

    private static final Logger logger = LoggerFactory.getLogger(RolesMapper.class);

    public RoleDTO mapRoleToRoleDTO(Role role){
        logger.info("Mapping a Role to RoleDTO");
        return new RoleDTO().setRoleType(role.getRoleType());
    }

    public List<RoleDTO> mapRoleListToRoleDTOList(List<Role> roles){
        logger.info("Mapping a List of Roles to a List of Roles DTOs");
        return roles.stream().map(this::mapRoleToRoleDTO).collect(Collectors.toList());
    }
}
