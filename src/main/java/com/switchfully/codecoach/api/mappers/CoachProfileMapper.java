package com.switchfully.codecoach.api.mappers;

import com.switchfully.codecoach.api.dtos.coachprofiles.CoachProfileDTO;
import com.switchfully.codecoach.domain.models.users.CoachProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CoachProfileMapper {

    private final CoachTopicMapper coachTopicMapper;

    private static final Logger logger = LoggerFactory.getLogger(CoachProfileMapper.class);

    public CoachProfileMapper(CoachTopicMapper coachTopicMapper) {
        this.coachTopicMapper = coachTopicMapper;
    }

    public CoachProfileDTO mapCoachProfileToCoachProfileDTO(CoachProfile coachProfile) {
        logger.info("Mapping a CoachProfile to a CoachProfileDTO: " + coachProfile);
        if(coachProfile==null){
            return new CoachProfileDTO()
                    .setId(null)
                    .setIntroduction("")
                    .setAvailability("")
                    .setCoachTopics(new ArrayList<>());
        }

        else return new CoachProfileDTO()
                .setId(coachProfile.getId())
                .setIntroduction(coachProfile.getIntroduction())
                .setAvailability(coachProfile.getAvailability())
                .setCoachTopics(coachTopicMapper.mapCoachTopicListToCoachTopicDtoList(coachProfile.getCoachTopics()));
    }
}
