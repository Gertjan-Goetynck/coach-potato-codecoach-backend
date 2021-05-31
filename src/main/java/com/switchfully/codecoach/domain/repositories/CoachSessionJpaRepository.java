package com.switchfully.codecoach.domain.repositories;

import com.switchfully.codecoach.domain.models.users.CoachSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoachSessionJpaRepository extends JpaRepository<CoachSession, UUID> {
}
