package com.switchfully.codecoach.api.dtos.users;

import java.util.UUID;

public class CoachTopicDTO {

    private UUID userId;
    private int experience;
    private TopicDTO topicDTO;

    public UUID getUserId() {
        return userId;
    }

    public CoachTopicDTO setUserId(UUID userId) {
        this.userId = userId;
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
