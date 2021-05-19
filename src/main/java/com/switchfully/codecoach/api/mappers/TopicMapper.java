package com.switchfully.codecoach.api.mappers;

import com.switchfully.codecoach.api.dtos.users.TopicDTO;
import com.switchfully.codecoach.domain.models.users.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TopicMapper {

    private static final Logger logger = LoggerFactory.getLogger(TopicMapper.class);

    public Topic mapTopicDTOtoTopic(TopicDTO topicDTO){
        logger.info("Mapping TopicDto to Topic");
        return new Topic(topicDTO.getId(), topicDTO.getTopic());
    }

    public TopicDTO mapTopicToTopicDTO(Topic topic){
        logger.info("Mapping Topic to TopicDTO");
        return new TopicDTO()
                .setId(topic.getId())
                .setTopic(topic.getTopic());
    }
}
