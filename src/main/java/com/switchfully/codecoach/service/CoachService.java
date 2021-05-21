package com.switchfully.codecoach.service;

import com.switchfully.codecoach.api.dtos.coachtopics.CreateCoachTopicDTO;
import com.switchfully.codecoach.api.mappers.CoachTopicMapper;
import com.switchfully.codecoach.domain.models.users.Topic;
import com.switchfully.codecoach.domain.models.users.User;
import com.switchfully.codecoach.domain.repositories.CoachJPARepository;
import com.switchfully.codecoach.infrastructure.exceptions.UserNotFoundException;
import com.switchfully.codecoach.infrastructure.utils.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CoachService {
    private final CoachJPARepository coachJPARepository;
    private final CoachTopicMapper coachTopicMapper;
    private final TopicService topicService;

    private static final Logger logger = LoggerFactory.getLogger(CoachService.class);

    @Autowired
    public CoachService(CoachJPARepository coachJPARepository, CoachTopicMapper coachTopicMapper, TopicService topicService) {
        this.coachJPARepository = coachJPARepository;
        this.coachTopicMapper = coachTopicMapper;
        this.topicService = topicService;
    }

    public User getCoachById(String id){
        logger.info("Getting a coach with id: " + id);
        return coachJPARepository.findById(ValidationUtil.convertStringToUUID(id)).orElseThrow(() -> new UserNotFoundException(id));
    }

//    public User setCoachTopics(String coachId, List<CreateCoachTopicDTO> coachTopics){
//        logger.info("Setting coachtopics: " + coachTopics + "of coach with id: " + coachId);
//        User coach = getCoachById(coachId);
//        coachTopics.forEach(coachTopic -> coach.getCoachProfile().addCoachTopic(coachTopicMapper.mapCreateCoachTopicDTOToCoachTopic(coachTopic)));
//
//
//        return coach;
//    }

    public User setCoachTopic(String coachId, CreateCoachTopicDTO coachTopic) {
        User coach = getCoachById(coachId);
       Topic topic = topicService.getTopicById(coachTopic.getTopic().getId().toString());
        coach.getCoachProfile().addCoachTopic(coachTopicMapper.mapCreateCoachTopicDTOToCoachTopic(coachTopic,topic));
        return coach;
    }
}
