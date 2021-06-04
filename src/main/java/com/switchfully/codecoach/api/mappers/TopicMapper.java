package com.switchfully.codecoach.api.mappers;

import com.switchfully.codecoach.api.dtos.topics.TopicDTO;
import com.switchfully.codecoach.domain.models.coaches.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TopicMapper {

    private static final Logger logger = LoggerFactory.getLogger(TopicMapper.class);

    public Topic mapTopicDTOtoTopic(TopicDTO topicDTO) {
        logger.info("Mapping TopicDto to Topic");
        return new Topic(topicDTO.getId(), topicDTO.getTopic());
    }

    public TopicDTO mapTopicToTopicDTO(Topic topic) {
        logger.info("Mapping Topic to TopicDTO");
        return new TopicDTO()
                .setId(topic.getId())
                .setTopic(topic.getTopic());
    }

    public List<TopicDTO> mapListTopicsToListTopicDtos(List<Topic> topicList) {
        logger.info("Mapping a list of Topics to a List of TopicDTO's");
        return topicList.stream().map(this::mapTopicToTopicDTO).collect(Collectors.toList());
    }
}
