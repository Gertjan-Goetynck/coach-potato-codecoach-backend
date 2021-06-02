package com.switchfully.codecoach.service;

import com.switchfully.codecoach.domain.models.users.Topic;
import com.switchfully.codecoach.domain.repositories.TopicJPARepository;
import com.switchfully.codecoach.infrastructure.utils.ValidationUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TopicService {
    private final TopicJPARepository topicJPARepository;

    public TopicService(TopicJPARepository topicJPARepository) {
        this.topicJPARepository = topicJPARepository;
    }

    public Topic getTopicById(String id){
        return topicJPARepository.findById(ValidationUtil.convertStringToUUID(id)).orElseThrow();
    }

    public List<Topic> getTopics() {
        return topicJPARepository.findAll();
    }
}
