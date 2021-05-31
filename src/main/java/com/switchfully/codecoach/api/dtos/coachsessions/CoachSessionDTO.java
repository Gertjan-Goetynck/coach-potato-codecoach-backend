package com.switchfully.codecoach.api.dtos.coachsessions;

import com.switchfully.codecoach.api.dtos.topics.TopicDTO;
import com.switchfully.codecoach.api.dtos.users.UserDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class CoachSessionDTO {
    private UUID id;
    private UserDTO coachee;
    private UserDTO coach;
    private TopicDTO topic;
    private LocalDate date;
    private LocalTime time;
    private String location;
    private String remarks;

    public UUID getId() {
        return id;
    }

    public CoachSessionDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public UserDTO getCoachee() {
        return coachee;
    }

    public CoachSessionDTO setCoachee(UserDTO coachee) {
        this.coachee = coachee;
        return this;
    }

    public UserDTO getCoach() {
        return coach;
    }

    public CoachSessionDTO setCoach(UserDTO coach) {
        this.coach = coach;
        return this;
    }

    public TopicDTO getTopic() {
        return topic;
    }

    public CoachSessionDTO setTopic(TopicDTO topic) {
        this.topic = topic;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public CoachSessionDTO setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public LocalTime getTime() {
        return time;
    }

    public CoachSessionDTO setTime(LocalTime time) {
        this.time = time;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public CoachSessionDTO setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public CoachSessionDTO setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }
}