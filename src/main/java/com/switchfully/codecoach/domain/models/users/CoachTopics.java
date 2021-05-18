package com.switchfully.codecoach.domain.models.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "coach_topics")
public class CoachTopics {
    @Id
    @Column(name = "userId")
    UUID userId;

    @Column(name = "experience")
    int experience;

    @Column(name= "topicId")
    UUID topicId;

}
