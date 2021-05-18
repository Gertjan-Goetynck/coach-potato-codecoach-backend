SET SCHEMA 'code_coach';

ALTER TABLE coach_topics DROP CONSTRAINT coach_profiles_topic_fk;
ALTER TABLE coach_topics DROP CONSTRAINT coach_profiles_coach_fk;
ALTER TABLE coach_profiles DROP CONSTRAINT coach_profile_user_FK;

DROP TABLE topics;
DROP TABLE coach_topics;
DROP TABLE coach_profiles;

CREATE TABLE coach_profiles(
                               user_id uuid NOT NULL PRIMARY KEY ,
                               introduction varchar(255),
                               availability boolean,
                               experience int,
                               CONSTRAINT coach_profile_user_FK
                                   FOREIGN KEY (user_id) REFERENCES users(id)

);

CREATE TABLE topics(
                       id uuid NOT NULL PRIMARY KEY,
                       topic varchar(255) NOT NULL
);


CREATE TABLE coach_topics
(
    profile_id uuid NOT NULL,
    topic_id uuid NOT NULL,

    PRIMARY KEY (profile_id, topic_id),
    CONSTRAINT coach_profiles_topic_fk
        FOREIGN KEY (topic_id) REFERENCES topics (id),
    CONSTRAINT coach_profiles_coach_fk
        FOREIGN KEY (profile_id) REFERENCES coach_profiles (user_id)
);
