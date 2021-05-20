package com.switchfully.codecoach.api.mappers;

import com.switchfully.codecoach.api.dtos.coachprofiles.CoachProfileDTO;
import com.switchfully.codecoach.domain.models.users.CoachProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CoachProfileMapper {

    private final CoachTopicMapper coachTopicMapper;

    private static final Logger logger = LoggerFactory.getLogger(CoachProfileMapper.class);

    public CoachProfileMapper(CoachTopicMapper coachTopicMapper) {
        this.coachTopicMapper = coachTopicMapper;
    }

//    public CoachProfile mapDtoToCoachProfile(CoachProfileDTO coachProfileDTO){
//        logger.info("Mapping a CoachProfileDto to CoachProfile");
//        return new CoachProfile(coachProfileDTO.getIntroduction(), coachProfileDTO.isAvailability());
//    }


    public CoachProfileDTO mapCoachProfileToCoachProfileDTO(CoachProfile coachProfile) {
        logger.info("Mapping a CoachProfile to a CoachProfileDTO");
        if(coachProfile == null) return null;
        else return new CoachProfileDTO()
                .setIntroduction(coachProfile.getIntroduction())
                .setAvailability(coachProfile.isAvailable())
                .setCoachTopics(coachTopicMapper.mapCoachTopicListToCoachTopicDtoList(coachProfile.getCoachTopics()));
    }
}
