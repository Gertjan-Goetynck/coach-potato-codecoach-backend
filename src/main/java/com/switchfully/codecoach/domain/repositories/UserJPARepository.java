package com.switchfully.codecoach.domain.repositories;

import com.switchfully.codecoach.domain.models.users.CoachProfile;
import com.switchfully.codecoach.domain.models.users.Role;
import com.switchfully.codecoach.domain.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserJPARepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
}
