package com.switchfully.codecoach.api.dtos.coachsessions;

import com.switchfully.codecoach.api.dtos.topics.TopicDTO;
import com.switchfully.codecoach.api.dtos.users.UserDTO;
import com.switchfully.codecoach.domain.models.users.Topic;
import com.switchfully.codecoach.domain.models.users.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class CreateCoachSessionDTO {


    private String coacheeId;
    private String coachId;
    private String topicId;
    private LocalDate date;
    private LocalTime time;
    private String location;
    private String remarks;

    public String getCoacheeId() {
        return coacheeId;
    }

    public CreateCoachSessionDTO setCoacheeId(String coacheeId) {
        this.coacheeId = coacheeId;
        return this;
    }

    public String getCoachId() {
        return coachId;
    }

    public CreateCoachSessionDTO setCoachId(String coachId) {
        this.coachId = coachId;
        return this;
    }

    public String getTopicId() {
        return topicId;
    }

    public CreateCoachSessionDTO setTopicId(String topicId) {
        this.topicId = topicId;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public CreateCoachSessionDTO setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public LocalTime getTime() {
        return time;
    }

    public CreateCoachSessionDTO setTime(LocalTime time) {
        this.time = time;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public CreateCoachSessionDTO setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public CreateCoachSessionDTO setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }
}
