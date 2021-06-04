package com.switchfully.codecoach.domain.repositories;

import com.switchfully.codecoach.domain.models.coaches.CoachSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CoachSessionJpaRepository extends JpaRepository<CoachSession, UUID> {
    List<CoachSession> findCoachSessionByCoachId(UUID coachId);

    List<CoachSession> findCoachSessionByCoacheeId(UUID coacheeId);
}
