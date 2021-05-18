package com.switchfully.codecoach.domain.models.users;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="topics")
public class Topic {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "topic")
    private String topic;

    public Topic(){
    }

    public Topic(UUID id, String topic) {
        this.id = id;
        this.topic = topic;
    }

    public UUID getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public Topic setId(UUID id) {
        this.id = id;
        return this;
    }

    public Topic setTopic(String topic) {
        this.topic = topic;
        return this;
    }
}
