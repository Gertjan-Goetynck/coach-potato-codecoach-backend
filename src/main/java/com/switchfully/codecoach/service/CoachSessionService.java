package com.switchfully.codecoach.service;

import com.switchfully.codecoach.api.dtos.coachsessions.CreateCoachSessionDTO;
import com.switchfully.codecoach.domain.models.users.CoachSession;
import com.switchfully.codecoach.domain.models.users.SessionStatus;
import com.switchfully.codecoach.domain.repositories.CoachSessionJpaRepository;
import com.switchfully.codecoach.domain.repositories.UserJPARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        return updateCoachSessionListStatus(coachSessionJpaRepository.findCoachSessionByCoachId(coachId));
    }

    public List<CoachSession> getCoachSessionsByCoacheeId(UUID coacheeId){
        return updateCoachSessionListStatus(coachSessionJpaRepository.findCoachSessionByCoacheeId((coacheeId)));
    }

    public List<CoachSession> updateCoachSessionListStatus(List<CoachSession> coachSessions){

        return coachSessions.stream()
                .map(this::updateCoachSession)
                .collect(Collectors.toList());
    }

    public CoachSession updateCoachSession(CoachSession coachSession){
        if(coachSession.getStatus().equals(SessionStatus.REQUESTED) && coachSession.getDate().isBefore(LocalDate.now())){
            coachSession.setStatus(SessionStatus.AUTOMATICALLY_CLOSED);
        }

        return coachSession;
    }
}
