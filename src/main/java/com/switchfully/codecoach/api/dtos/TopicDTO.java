package com.switchfully.codecoach.api.dtos;

import java.util.UUID;

public class TopicDTO {

    private UUID id;
    private String topic;

    public UUID getId() {
        return id;
    }

    public TopicDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getTopic() {
        return topic;
    }

    public TopicDTO setTopic(String topic) {
        this.topic = topic;
        return this;
    }
}
