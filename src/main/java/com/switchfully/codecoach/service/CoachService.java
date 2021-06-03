package com.switchfully.codecoach.service;

import com.switchfully.codecoach.api.dtos.coachprofiles.UpdateCoachProfileDTO;
import com.switchfully.codecoach.api.dtos.coachtopics.CreateCoachTopicDTO;
import com.switchfully.codecoach.api.mappers.CoachTopicMapper;
import com.switchfully.codecoach.domain.models.users.Topic;
import com.switchfully.codecoach.domain.models.users.User;
import com.switchfully.codecoach.domain.repositories.CoachJPARepository;
import com.switchfully.codecoach.domain.repositories.RoleJPARepository;
import com.switchfully.codecoach.infrastructure.exceptions.UserNotFoundException;
import com.switchfully.codecoach.infrastructure.utils.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CoachService {
    private final CoachJPARepository coachJPARepository;
    private final CoachTopicMapper coachTopicMapper;
    private final TopicService topicService;
    private final RoleJPARepository roleJPARepository;

    private static final Logger logger = LoggerFactory.getLogger(CoachService.class);

    @Autowired
    public CoachService(CoachJPARepository coachJPARepository, CoachTopicMapper coachTopicMapper, TopicService topicService, RoleJPARepository roleJPARepository) {
        this.coachJPARepository = coachJPARepository;
        this.coachTopicMapper = coachTopicMapper;
        this.topicService = topicService;
        this.roleJPARepository = roleJPARepository;
    }

    public User getCoachById(String id) {
        logger.info("Getting a coach with id: " + id);
        return coachJPARepository.findById(ValidationUtil.convertStringToUUID(id)).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User setCoachTopic(String coachId, CreateCoachTopicDTO coachTopic) {
        logger.info("Setting a coach topic " + coachTopic + "for coach with id " + coachId);
        User coach = getCoachById(coachId);
        Topic topic = topicService.getTopicById(coachTopic.getTopic().getId().toString());
        coach.getCoachProfile().addCoachTopic(coachTopicMapper.mapCreateCoachTopicDTOToCoachTopic(coachTopic, topic));
        return coach;
    }

    public List<User> getCoaches() {
        logger.info("Getting all coaches");
        return coachJPARepository.findCoachesWithTopics();
    }

    public User editCoachById(String coachId, UpdateCoachProfileDTO updateCoachProfileDto){
        logger.info("Editing information for coach with id " +coachId);
        User coach = getCoachById(coachId);
        coach.getCoachProfile().setIntroduction(updateCoachProfileDto.getIntroduction()).setAvailable(updateCoachProfileDto.getAvailability());
        return coach;

    }
}
