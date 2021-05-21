package com.switchfully.codecoach.api.dtos.coachtopics;

import com.switchfully.codecoach.api.dtos.topics.TopicDTO;

import java.util.UUID;

public class CreateCoachTopicDTO {
    private UUID coachProfileId;
    private TopicDTO topic;

    public UUID getCoachProfileId() {
        return coachProfileId;
    }

    public CreateCoachTopicDTO setCoachProfileId(UUID coachProfileId) {
        this.coachProfileId = coachProfileId;
        return this;
    }

    public TopicDTO getTopic() {
        return topic;
    }

    public CreateCoachTopicDTO setTopic(TopicDTO topic) {
        this.topic = topic;
        return this;
    }
}
