package com.switchfully.codecoach.domain.repositories;

import com.switchfully.codecoach.domain.models.users.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleJPARepository extends JpaRepository<Role, UUID> {
   Role getRoleByRoleType(String roleType);
}
