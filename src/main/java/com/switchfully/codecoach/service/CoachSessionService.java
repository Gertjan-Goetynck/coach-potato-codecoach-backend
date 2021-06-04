package com.switchfully.codecoach.service;

import com.switchfully.codecoach.domain.models.coaches.CoachSession;
import com.switchfully.codecoach.domain.models.sessions.SessionStatus;
import com.switchfully.codecoach.domain.repositories.CoachSessionJpaRepository;
import com.switchfully.codecoach.infrastructure.exceptions.CoachSessionNotFoundException;
import org.apache.tomcat.jni.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class CoachSessionService {
    private final CoachSessionJpaRepository coachSessionJpaRepository;
    private static final Logger logger = LoggerFactory.getLogger(CoachSessionService.class);

    @Autowired
    public CoachSessionService(CoachSessionJpaRepository coachSessionJpaRepository) {
        this.coachSessionJpaRepository = coachSessionJpaRepository;
    }

    public CoachSession addCoachSession(CoachSession coachSession) {
        logger.info("Coachsession created: " + coachSession);
        return coachSessionJpaRepository.save(coachSession);
    }

    public List<CoachSession> getCoachSessionByCoachId(UUID coachId) {
        return updateCoachSessionListStatus(coachSessionJpaRepository.findCoachSessionByCoachId(coachId));
    }

    public List<CoachSession> getCoachSessionsByCoacheeId(UUID coacheeId) {
        return updateCoachSessionListStatus(coachSessionJpaRepository.findCoachSessionByCoacheeId((coacheeId)));
    }

    public List<CoachSession> updateCoachSessionListStatus(List<CoachSession> coachSessions) {

        return coachSessions.stream()
                .map(this::updateCoachSession)
                .collect(Collectors.toList());
    }

    public CoachSession updateCoachSession(CoachSession coachSession) {
        LocalDateTime coachSessionDateTime = LocalDateTime.of(coachSession.getDate(), coachSession.getTime());
        if (coachSession.getStatus().equals(SessionStatus.REQUESTED) && coachSessionDateTime.isBefore(LocalDateTime.now())) {
            coachSession.setStatus(SessionStatus.AUTOMATICALLY_CLOSED);
        } else if (coachSession.getStatus().equals(SessionStatus.ACCEPTED) && coachSessionDateTime.isBefore(LocalDateTime.now())) {
            coachSession.setStatus(SessionStatus.DONE_WAITING_FEEDBACK);
        }

        return coachSession;
    }

    public CoachSession acceptCoachSession(CoachSession coachSession){
        return coachSession.setStatus(SessionStatus.ACCEPTED);
    }

    public CoachSession declineCoachSession(CoachSession coachSession){
        return coachSession.setStatus(SessionStatus.DECLINED);
    }

    public CoachSession getCoachSessionBySessionId(UUID sessionId){
        return coachSessionJpaRepository.findById(sessionId).orElseThrow(() -> new CoachSessionNotFoundException(sessionId.toString()));

    }

}
