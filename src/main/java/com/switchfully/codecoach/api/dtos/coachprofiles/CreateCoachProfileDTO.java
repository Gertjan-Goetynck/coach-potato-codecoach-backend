package com.switchfully.codecoach.api.dtos.coachprofiles;

import com.switchfully.codecoach.api.dtos.coachtopics.CoachTopicDTO;

import java.util.List;

public class CreateCoachProfileDTO {

    private String introduction;
    private String availability;
    private List<CoachTopicDTO> coachTopicsList;

    public String getIntroduction() {
        return introduction;
    }

    public CreateCoachProfileDTO setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public String getAvailability() {
        return availability;
    }

    public CreateCoachProfileDTO setAvailability(String availability) {
        this.availability = availability;
        return this;
    }

    public List<CoachTopicDTO> getCoachTopicsList() {
        return coachTopicsList;
    }

}
