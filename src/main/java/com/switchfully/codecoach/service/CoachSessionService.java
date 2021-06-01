package com.switchfully.codecoach.service;

import com.switchfully.codecoach.api.dtos.coachsessions.CreateCoachSessionDTO;
import com.switchfully.codecoach.domain.models.users.CoachSession;
import com.switchfully.codecoach.domain.repositories.CoachSessionJpaRepository;
import com.switchfully.codecoach.domain.repositories.UserJPARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CoachSessionService {
    private final CoachSessionJpaRepository coachSessionJpaRepository;
    private final UserJPARepository userJPARepository;
    private static final Logger logger = LoggerFactory.getLogger(CoachSessionService.class);

    @Autowired
    public CoachSessionService(CoachSessionJpaRepository coachSessionJpaRepository, UserJPARepository userJPARepository) {
        this.coachSessionJpaRepository = coachSessionJpaRepository;
        this.userJPARepository = userJPARepository;
    }

    public CoachSession addCoachSession(CoachSession coachSession) {
        logger.info("Coachsession created: " + coachSession);
        return coachSessionJpaRepository.save(coachSession);
    }

    public List<CoachSession> getCoachSessionByCoachId(UUID coachId){
        return coachSessionJpaRepository.findCoachSessionByCoachId(coachId);
    }

    public List<CoachSession> getCoachSessionsByCoacheeId(UUID coacheeId){
        return coachSessionJpaRepository.findCoachSessionByCoacheeId((coacheeId));
    }
}
