SET SCHEMA 'code_coach';

CREATE TABLE topics(
                      id uuid NOT NULL PRIMARY KEY,
                      topic varchar(255) NOT NULL
);



CREATE TABLE coach_topics
(
    user_id uuid NOT NULL PRIMARY KEY ,
    experience int,
    topic_id uuid NOT NULL,

CONSTRAINT coach_topics_coach_profile_fk FOREIGN KEY (user_id) REFERENCES coach_profiles(user_id),

CONSTRAINT topics_coach_topic_fk FOREIGN KEY (topic_id) REFERENCES topics(id)


);

