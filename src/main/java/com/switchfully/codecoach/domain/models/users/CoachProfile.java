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

    @Column(name = "experience")
    private int experience;

    @OneToMany(mappedBy = "coach_profiles")
    private List<CoachTopic> coachTopics = new ArrayList<>();


    public CoachProfile() {
    }

    public CoachProfile(UUID userId) {
        this.userId = userId;
    }

    public CoachProfile(UUID userId, String introduction, boolean available, int experience,
                        List<CoachTopic> coachTopics) {
        this.userId = userId;
        this.introduction = introduction;
        this.available = available;
        this.experience = experience;
        this.coachTopics = coachTopics;
    }
}
