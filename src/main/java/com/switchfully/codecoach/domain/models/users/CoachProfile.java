package com.switchfully.codecoach.domain.models.users;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "coach_profiles")
public class CoachProfile {
    @Id
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "availability")
    private boolean available;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<CoachTopic> coachTopics;


    public CoachProfile() {
    }

    public CoachProfile(UUID userId) {
        this.userId = userId;
    }

    public CoachProfile(UUID userId, String introduction, boolean available) {
        this.userId = userId;
        this.introduction = introduction;
        this.available = available;
        this.coachTopics = new ArrayList<>();
    }

    public UUID getUserId() {
        return userId;
    }

    public CoachProfile setUserId(UUID userId) {
        this.userId = userId;
        return this;
    }

    public String getIntroduction() {
        return introduction;
    }

    public CoachProfile setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public boolean isAvailable() {
        return available;
    }

    public CoachProfile setAvailable(boolean available) {
        this.available = available;
        return this;
    }

    public List<CoachTopic> getCoachTopics() {
        return coachTopics;
    }

}
