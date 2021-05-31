CREATE TABLE coach_sessions
(
    id         uuid         NOT NULL PRIMARY KEY,
    coachee_id uuid         NOT NULL,
    coach_id   uuid         NOT NULL,
    topic_id   uuid         NOT NULL,
    date       date         NOT NULL,
    time       time         NOT NULL,
    location   varchar(255) NOT NULL,
    remarks    varchar(255),

    CONSTRAINT coachees_fk
    FOREIGN KEY (coachee_id) REFERENCES users(id),

    CONSTRAINT coaches_fk
    FOREIGN KEY (coach_id) REFERENCES users(id),

    CONSTRAINT topics_fk
    FOREIGN KEY (topic_id) REFERENCES topics(id)
)