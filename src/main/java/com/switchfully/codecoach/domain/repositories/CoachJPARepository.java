package com.switchfully.codecoach.domain.repositories;

import com.switchfully.codecoach.domain.models.users.CoachProfile;
import com.switchfully.codecoach.domain.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoachJPARepository extends JpaRepository<User, UUID> {
}
