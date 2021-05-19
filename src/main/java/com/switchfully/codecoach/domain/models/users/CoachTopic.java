package com.switchfully.codecoach.domain.models.users;

import javax.persistence.*;
import java.util.UUID;
/*@Entity
@Table(name = "coach_topics")
public class CoachTopic {

    @Id
    @Column(name = "user_id")
    UUID userId;

    @Column(name = "experience")
    int experience;

   *//* @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="topic_id", referencedColumnName = "topic_id")
    private Topic topic;*//*

    public CoachTopic() {
    }

    public CoachTopic(UUID userId, int experience) {
        this.userId = userId;
        this.experience = experience;

    }

    public UUID getUserId() {
        return userId;
    }

    public int getExperience() {
        return experience;
    }

    public Topic getTopic() {
        return topic;
    }

    public CoachTopic setUserId(UUID userId) {
        this.userId = userId;
        return this;
    }

    public CoachTopic setExperience(int experience) {
        this.experience = experience;
        return this;
    }

    public CoachTopic setTopic(Topic topic) {
        this.topic = topic;
        return this;
    }
}*/


