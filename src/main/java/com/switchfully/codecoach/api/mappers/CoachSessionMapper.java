package com.switchfully.codecoach.api.mappers;

import com.switchfully.codecoach.api.dtos.coachsessions.CoachSessionDTO;
import com.switchfully.codecoach.api.dtos.coachsessions.CreateCoachSessionDTO;
import com.switchfully.codecoach.api.dtos.users.CreateUserDTO;
import com.switchfully.codecoach.api.dtos.users.UserDTO;
import com.switchfully.codecoach.domain.models.users.CoachSession;
import com.switchfully.codecoach.domain.models.users.Topic;
import com.switchfully.codecoach.domain.models.users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CoachSessionMapper {

    private final UserMapper userMapper;
    private final TopicMapper topicMapper;
    private static final Logger logger = LoggerFactory.getLogger(CoachSessionMapper.class);

    public CoachSessionMapper(UserMapper userMapper, TopicMapper topicMapper) {
        this.userMapper = userMapper;
        this.topicMapper = topicMapper;
    }

    public CoachSession mapCreateCoachSessionDTOToCoachSession(User coachee, User coach, Topic topic, CreateCoachSessionDTO createCoachSessionDTO) {
        logger.info("Mapping a CreateCoachSessionDTO to a CoachSession, returning a CoachSession");
        return new CoachSession(
                coachee,
                coach,
                topic,
                createCoachSessionDTO.getDate(),
                createCoachSessionDTO.getTime(),
                createCoachSessionDTO.getLocation(),
                createCoachSessionDTO.getRemarks());
    }

    public CoachSessionDTO mapCoachSessionToCoachSessionDTO(CoachSession coachSession) {
        logger.info("Mapping a CreateCoachSession to a CoachSessionDTO, returning a CoachSessionDTO");
        return new CoachSessionDTO().setId(coachSession.getId())
                .setCoachee(userMapper.mapUserToDto(coachSession.getCoachee()))
                .setCoach(userMapper.mapUserToDto(coachSession.getCoach()))
                .setTopic(topicMapper.mapTopicToTopicDTO(coachSession.getTopic()))
                .setDate(coachSession.getDate())
                .setTime(coachSession.getTime())
                .setLocation(coachSession.getLocation())
                .setRemarks(coachSession.getRemarks());
    }
}


