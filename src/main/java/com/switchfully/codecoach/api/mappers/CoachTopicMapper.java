package com.switchfully.codecoach.api.mappers;

import com.switchfully.codecoach.api.dtos.coachtopics.CoachTopicDTO;
import com.switchfully.codecoach.api.dtos.coachtopics.CreateCoachTopicDTO;
import com.switchfully.codecoach.domain.models.users.CoachTopic;
import com.switchfully.codecoach.domain.models.users.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CoachTopicMapper {

    private final TopicMapper topicMapper;

    private static final Logger logger = LoggerFactory.getLogger(CoachTopicMapper.class);

    public CoachTopicMapper(TopicMapper topicMapper) {
        this.topicMapper = topicMapper;
    }

    public CoachTopic mapCreateCoachTopicDTOToCoachTopic(CreateCoachTopicDTO createCoachTopicDTO, Topic topic){
        logger.info("Mapping CoachTopicDTO to CoachTopic");
        logger.info(topic.toString());
        return new CoachTopic(createCoachTopicDTO.getCoachProfileId(),topic);
    }

    public CoachTopicDTO mapCoachTopictoCoachTopicDto(CoachTopic coachTopic){
        logger.info("Mapping CoachTopic to CoachTopicDTO");
        return new CoachTopicDTO()
                .setCoachProfileId(coachTopic.getCoachProfileId())
                .setExperience(coachTopic.getExperience())
                .setTopic(topicMapper.mapTopicToTopicDTO(coachTopic.getTopic()));
    }

    public List<CoachTopicDTO> mapCoachTopicListToCoachTopicDtoList(List<CoachTopic> coachTopicsList){
        logger.info("Mapping a list of CoachTopicDtos to list of CoachTopic");
        if (coachTopicsList == null) {
            return null;
        }
        else return coachTopicsList.stream().map(this::mapCoachTopictoCoachTopicDto).collect(Collectors.toList());
    }
}
