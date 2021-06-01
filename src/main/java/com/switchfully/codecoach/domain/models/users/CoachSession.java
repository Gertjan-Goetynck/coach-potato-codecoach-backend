package com.switchfully.codecoach.domain.models.users;

import com.switchfully.codecoach.infrastructure.utils.ValidationUtil;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
@Entity
@Table(name = "coach_sessions")
public class CoachSession {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="coachee_id")
    private User coachee;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="coach_id")
    private User coach;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="topic_id")
    private Topic topic;

    @Column(name="date")
    private LocalDate date;

    @Column(name="time")
    private LocalTime time;

    @Column(name="location")
    private String location;

    @Column(name="remarks")
    private String remarks;

    public CoachSession() {
    }

    public CoachSession(User coachee, User coach, Topic topic, LocalDate date, LocalTime time, String location, String remarks) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(coachee,"coachee");
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(coach,"coach");
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(topic,"topic");
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(date,"date");
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(time,"time");
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(location,"location");


        this.coachee = coachee;
        this.coach = coach;
        this.topic = topic;
        this.date = date;
        this.time = time;
        this.location = location;
        this.remarks = remarks;
    }

    public UUID getId() {
        return id;
    }

    public User getCoachee() {
        return coachee;
    }

    public User getCoach() {
        return coach;
    }

    public Topic getTopic() {
        return topic;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getRemarks() {
        return remarks;
    }

    @Override
    public String toString() {
        return "CoachSession{" +
                "id=" + id +
                ", coachee=" + coachee +
                ", coach=" + coach +
                ", topic=" + topic +
                ", date=" + date +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
