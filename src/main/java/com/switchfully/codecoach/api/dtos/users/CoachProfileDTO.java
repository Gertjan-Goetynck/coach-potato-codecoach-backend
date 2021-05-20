package com.switchfully.codecoach.api.dtos.users;

import java.util.List;
import java.util.UUID;

public class CoachProfileDTO {

    private UUID id;
    private String introduction;
    private boolean availability;
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

    public boolean isAvailability() {
        return availability;
    }

    public CoachProfileDTO setAvailability(boolean availability) {
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

