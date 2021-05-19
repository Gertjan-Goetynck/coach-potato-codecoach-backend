package com.switchfully.codecoach.api.mappers;

import com.switchfully.codecoach.api.dtos.users.CoachTopicDTO;
import com.switchfully.codecoach.domain.models.users.CoachTopic;
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

    public CoachTopic mapCoachTopicDTOToCoachTopic(CoachTopicDTO coachTopicDTO){
        logger.info("Mapping CoachTopicDTO to CoachTopic");
        return new CoachTopic(coachTopicDTO.getUserId(), coachTopicDTO.getExperience(),
                topicMapper.mapTopicDTOtoTopic(coachTopicDTO.getTopicDTO()));

    }

    public CoachTopicDTO mapCoachTopictoCoachTopicDto(CoachTopic coachTopic){
        logger.info("Mapping CoachTopic to CoachTopicDTO");
        return new CoachTopicDTO()
                .setUserId(coachTopic.getUserId())
                .setExperience(coachTopic.getExperience())
                .setTopicDTO(topicMapper.mapTopicToTopicDTO(coachTopic.getTopic()));
    }

    public List<CoachTopicDTO> mapCoachTopicListToCoachTopicDtoList(List<CoachTopic> coachTopicsList){
        logger.info("Mapping a list of CoachTopicDtos to list of CoachTopic");
        return coachTopicsList.stream().map(this::mapCoachTopictoCoachTopicDto).collect(Collectors.toList());
    }


}
