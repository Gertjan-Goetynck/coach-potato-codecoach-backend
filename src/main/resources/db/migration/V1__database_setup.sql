CREATE TABLE coach_profiles
(
    id           uuid    NOT NULL PRIMARY KEY,
    introduction varchar(255),
    availability boolean NOT NULL

);
CREATE TABLE users
(
    id               uuid         NOT NULL PRIMARY KEY,
    first_name       varchar(255) NOT NULL,
    last_name        varchar(255) NOT NULL,
    email            varchar(255) NOT NULL,
    password         varchar(255) NOT NULL,
    picture_url      VARCHAR(255),
    coach_profile_id uuid,
    FOREIGN KEY (coach_profile_id) REFERENCES coach_profiles(id)

);

CREATE TABLE roles
(
    id        uuid         NOT NULL PRIMARY KEY,
    role_type varchar(255) NOT NULL
);


CREATE TABLE user_roles
(
    user_id uuid NOT NULL,
    role_id uuid NOT NULL,

    PRIMARY KEY (user_id, role_id),
    CONSTRAINT user_roles_role_fk
        FOREIGN KEY (role_id) REFERENCES roles (id),
    CONSTRAINT user_roles_users_fk
        FOREIGN KEY (user_id) REFERENCES users (id)
);

INSERT INTO roles (id, role_type)
values ('40e6215d-b5c6-4896-987c-f30f3678f608', 'Coachee');
INSERT INTO roles (id, role_type)
values ('6ecd8c99-4036-403d-bf84-cf8400f67836', 'Coach');
INSERT INTO roles (id, role_type)
values ('3f333df6-90a4-4fda-8dd3-9485d27cee36', 'Admin');

CREATE TABLE topics
(
    id    uuid         NOT NULL PRIMARY KEY,
    topic varchar(255) NOT NULL
);

CREATE TABLE coach_topics
(
    coach_profile_id uuid NOT NULL PRIMARY KEY,
    experience       int DEFAULT 0,
    topic_id         uuid NOT NULL,

    CONSTRAINT coach_topics_coach_profile_fk FOREIGN KEY (coach_profile_id) REFERENCES coach_profiles (id),
    CONSTRAINT topics_coach_topic_fk FOREIGN KEY (topic_id) REFERENCES topics (id)
);

INSERT INTO topics(id, topic) values ('76881eab-c189-480c-a316-ec398ec613cc', 'AI');
INSERT INTO topics(id, topic) values ('4d1d08c6-d070-4923-b994-c5f6b0642c7a', 'Bioinformatics');
INSERT INTO topics(id, topic) values ('55c70aed-42a6-417b-b153-a33fab816988', 'Databases');
INSERT INTO topics(id, topic) values ('b0a6285a-237a-49c9-89aa-c6fb1759bc89', 'Software engineering');
