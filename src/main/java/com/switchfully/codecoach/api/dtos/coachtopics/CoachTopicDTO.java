package com.switchfully.codecoach.api.dtos.coachtopics;

import com.switchfully.codecoach.api.dtos.topics.TopicDTO;

import java.util.UUID;

public class CoachTopicDTO {

    private UUID coachProfileId;
    private int experience;
    private TopicDTO topicDTO;

    public UUID getCoachProfileId() {
        return coachProfileId;
    }

    public CoachTopicDTO setCoachProfileId(UUID coachProfileId) {
        this.coachProfileId = coachProfileId;
        return this;
    }

    public int getExperience() {
        return experience;
    }

    public CoachTopicDTO setExperience(int experience) {
        this.experience = experience;
        return this;
    }

    public TopicDTO getTopicDTO() {
        return topicDTO;
    }

    public CoachTopicDTO setTopicDTO(TopicDTO topicDTO) {
        this.topicDTO = topicDTO;
        return this;
    }
}
