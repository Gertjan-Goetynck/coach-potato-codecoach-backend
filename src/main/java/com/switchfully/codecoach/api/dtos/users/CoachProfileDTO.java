package com.switchfully.codecoach.api.dtos.users;

import com.switchfully.codecoach.domain.models.users.Topic;

import java.util.List;
import java.util.UUID;

public class CoachProfileDTO {
    private UUID id;
    private String introduction;
    private boolean availability;
    private int experience;
    private List<Topic> topic;

}
