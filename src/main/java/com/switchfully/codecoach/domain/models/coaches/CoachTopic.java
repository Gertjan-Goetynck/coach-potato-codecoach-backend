package com.switchfully.codecoach.domain.models.coaches;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Table(name = "coach_topics")
public class CoachTopic {

    @Id
    @GeneratedValue
    @Column(name="id")
    private UUID id;

    @Column(name = "coach_profile_id")
    private UUID coachProfileId;

    @Column(name = "experience")
    private int experience;

    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="topic_id")
    private Topic topic;

    public CoachTopic() {
    }

    public CoachTopic(UUID coachProfileId, Topic topic) {
        this.coachProfileId = coachProfileId;
        this.topic = topic;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCoachProfileId() {
        return coachProfileId;
    }

    public CoachTopic setCoachProfileId(UUID coachProfileId) {
        this.coachProfileId = coachProfileId;
        return this;
    }

    public int getExperience() {
        return experience;
    }

    public Topic getTopic() {
        return topic;
    }

    public CoachTopic setExperience(int experience) {
        this.experience = experience;
        return this;
    }

    public CoachTopic setTopic(Topic topic) {
        this.topic = topic;
        return this;
    }

    @Override
    public String toString() {
        return "CoachTopic{" +
                "topic=" + topic +
                '}';
    }
}


