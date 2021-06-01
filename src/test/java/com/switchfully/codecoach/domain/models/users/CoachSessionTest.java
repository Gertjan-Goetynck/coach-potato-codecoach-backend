package com.switchfully.codecoach.domain.models.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

class CoachSessionTest {

    @Test
    void givenNullCoachee_whenCreatingCoachSession_thenThrowIllegalArgumentException(){
        User coachExample = new User("jeannie", "nitro", "jeannie@nitro.io", "BE123", "https://placedog.net/500");
        Topic topicExample = new Topic(UUID.randomUUID(), "test topic");

        Assertions.assertThrows(IllegalArgumentException.class, () -> new CoachSession(null, coachExample, topicExample, LocalDate.now(), LocalTime.now(), "online", "none"));
    }

    @Test
    void givenNullCoach_whenCreatingCoachSession_thenThrowIllegalArgumentException(){
        User coacheeExample = new User("jeannie", "nitro", "jeannie@nitro.io", "BE123", "https://placedog.net/500");
        Topic topicExample = new Topic(UUID.randomUUID(), "test topic");

        Assertions.assertThrows(IllegalArgumentException.class, () -> new CoachSession(coacheeExample, null, topicExample, LocalDate.now(), LocalTime.now(), "online", "none"));
    }

    @Test
    void givenNullTopic_whenCreatingCoachSession_thenThrowIllegalArgumentException(){
        User coacheeExample = new User("coachee", "nitro", "coachee@nitro.io", "BE123", "https://placedog.net/500");
        User coachExample = new User("jeannie", "nitro", "jeannie@nitro.io", "BE123", "https://placedog.net/500");

        Assertions.assertThrows(IllegalArgumentException.class, () -> new CoachSession(coacheeExample, coachExample, null, LocalDate.now(), LocalTime.now(), "online", "none"));
    }

    @Test
    void givenNullDate_whenCreatingCoachSession_thenThrowIllegalArgumentException(){
        User coacheeExample = new User("coachee", "nitro", "coachee@nitro.io", "BE123", "https://placedog.net/500");
        User coachExample = new User("jeannie", "nitro", "jeannie@nitro.io", "BE123", "https://placedog.net/500");
        Topic topicExample = new Topic(UUID.randomUUID(), "test topic");

        Assertions.assertThrows(IllegalArgumentException.class, () -> new CoachSession(coacheeExample, coachExample, topicExample, null, LocalTime.now(), "online", "none"));
    }

    @Test
    void givenNullTime_whenCreatingCoachSession_thenThrowIllegalArgumentException(){
        User coacheeExample = new User("coachee", "nitro", "coachee@nitro.io", "BE123", "https://placedog.net/500");
        User coachExample = new User("jeannie", "nitro", "jeannie@nitro.io", "BE123", "https://placedog.net/500");
        Topic topicExample = new Topic(UUID.randomUUID(), "test topic");

        Assertions.assertThrows(IllegalArgumentException.class, () -> new CoachSession(coacheeExample, coachExample, topicExample, LocalDate.now(), null, "online", "none"));
    }

    @Test
    void givenNullLocation_whenCreatingCoachSession_thenThrowIllegalArgumentException(){
        User coacheeExample = new User("coachee", "nitro", "coachee@nitro.io", "BE123", "https://placedog.net/500");
        User coachExample = new User("jeannie", "nitro", "jeannie@nitro.io", "BE123", "https://placedog.net/500");
        Topic topicExample = new Topic(UUID.randomUUID(), "test topic");

        Assertions.assertThrows(IllegalArgumentException.class, () -> new CoachSession(coacheeExample, coachExample, topicExample, LocalDate.now(), LocalTime.now(), null, "none"));
    }

    @Test
    void givenEmptyLocation_whenCreatingCoachSession_thenThrowIllegalArgumentException(){
        User coacheeExample = new User("coachee", "nitro", "coachee@nitro.io", "BE123", "https://placedog.net/500");
        User coachExample = new User("jeannie", "nitro", "jeannie@nitro.io", "BE123", "https://placedog.net/500");
        Topic topicExample = new Topic(UUID.randomUUID(), "test topic");

        Assertions.assertThrows(IllegalArgumentException.class, () -> new CoachSession(coacheeExample, coachExample, topicExample, LocalDate.now(), LocalTime.now(), " ", "none"));
    }

    @Test
    void givenBlankLocation_whenCreatingCoachSession_thenThrowIllegalArgumentException(){
        User coacheeExample = new User("coachee", "nitro", "coachee@nitro.io", "BE123", "https://placedog.net/500");
        User coachExample = new User("jeannie", "nitro", "jeannie@nitro.io", "BE123", "https://placedog.net/500");
        Topic topicExample = new Topic(UUID.randomUUID(), "test topic");

        Assertions.assertThrows(IllegalArgumentException.class, () -> new CoachSession(coacheeExample, coachExample, topicExample, LocalDate.now(), LocalTime.now(), "", "none"));
    }

    @Test
    void givenNullRemarks_whenCreatingCoachSession_thenThrowIllegalArgumentException(){
        User coacheeExample = new User("coachee", "nitro", "coachee@nitro.io", "BE123", "https://placedog.net/500");
        User coachExample = new User("jeannie", "nitro", "jeannie@nitro.io", "BE123", "https://placedog.net/500");
        Topic topicExample = new Topic(UUID.randomUUID(), "test topic");

        Assertions.assertThrows(IllegalArgumentException.class, () -> new CoachSession(coacheeExample, coachExample, topicExample, LocalDate.now(), LocalTime.now(), "online", null));
    }
}
