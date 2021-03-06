package com.switchfully.codecoach.api.dtos.coachprofiles;

import com.switchfully.codecoach.api.dtos.coachtopics.CoachTopicDTO;

import java.util.List;
import java.util.UUID;

public class CoachProfileDTO {

    private UUID id;
    private String introduction;
    private String availability;
    private List<CoachTopicDTO> coachTopics;

    public UUID getId() {
        return id;
    }

    public CoachProfileDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getIntroduction() {
        return introduction;
    }

    public CoachProfileDTO setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public String getAvailability() {
        return availability;
    }

    public CoachProfileDTO setAvailability(String availability) {
        this.availability = availability;
        return this;
    }

    public List<CoachTopicDTO> getCoachTopics() {
        return coachTopics;
    }

    public CoachProfileDTO setCoachTopics(List<CoachTopicDTO> coachTopics) {
        this.coachTopics = coachTopics;
        return this;
    }
}

