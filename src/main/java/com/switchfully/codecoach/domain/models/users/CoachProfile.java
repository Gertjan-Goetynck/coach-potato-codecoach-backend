package com.switchfully.codecoach.domain.models.users;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "coach_profiles")
public class CoachProfile {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "availability")
    private String available;

    @Column(name = "user_id")
    private UUID userId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "coach_profile_id")
    private List<CoachTopic> coachTopics;

    public CoachProfile() {
    }

    public CoachProfile(String introduction, String available, UUID userId) {
        this.introduction = introduction;
        this.available = available;
        this.userId = userId;
        this.coachTopics = new ArrayList<>();
    }

    public String getIntroduction() {
        return introduction;
    }

    public CoachProfile setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public String getAvailability() {
        return available;
    }

    public CoachProfile setAvailable(String available) {
        this.available = available;
        return this;
    }

    public List<CoachTopic> getCoachTopics() {
        return coachTopics;
    }

    public UUID getId() {
        return id;
    }

    public CoachProfile addCoachTopic(CoachTopic coachTopic) {
        this.coachTopics.add(coachTopic);
        return this;
    }

    @Override
    public String toString() {
        return "CoachProfile{" +
                "id=" + id +
                ", introduction='" + introduction + '\'' +
                ", available=" + available +
                ", userId=" + userId +
                ", coachTopics=" + coachTopics +
                '}';
    }
}
