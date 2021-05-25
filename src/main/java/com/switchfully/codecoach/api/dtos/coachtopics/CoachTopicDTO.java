package com.switchfully.codecoach.api.dtos.coachtopics;

import com.switchfully.codecoach.api.dtos.topics.TopicDTO;

import java.util.UUID;

public class CoachTopicDTO {

    private UUID coachProfileId;
    private int experience;
    private TopicDTO topic;

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

    public TopicDTO getTopic() {
        return topic;
    }

    public CoachTopicDTO setTopic(TopicDTO topic) {
        this.topic = topic;
        return this;
    }
}
