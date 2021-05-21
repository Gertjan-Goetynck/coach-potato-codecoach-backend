package com.switchfully.codecoach.domain.models.users;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Table(name = "coach_topics")
public class CoachTopic {

    @Id
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
//        this.experience = 0;
        this.topic = topic;
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

}


