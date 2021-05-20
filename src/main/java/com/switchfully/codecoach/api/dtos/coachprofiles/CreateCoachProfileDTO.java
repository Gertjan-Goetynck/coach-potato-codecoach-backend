package com.switchfully.codecoach.api.dtos.coachprofiles;

import com.switchfully.codecoach.api.dtos.CoachTopicDTO;

import java.util.List;

public class CreateCoachProfileDTO {

    private String introduction;
    private boolean availability;
    private List<CoachTopicDTO> coachTopicsList;

    public String getIntroduction() {
        return introduction;
    }

    public CreateCoachProfileDTO setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public boolean isAvailability() {
        return availability;
    }

    public CreateCoachProfileDTO setAvailability(boolean availability) {
        this.availability = availability;
        return this;
    }

    public List<CoachTopicDTO> getCoachTopicsList() {
        return coachTopicsList;
    }

}
