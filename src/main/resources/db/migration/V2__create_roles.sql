SET SCHEMA 'code_coach';

CREATE TABLE roles(
                      id uuid NOT NULL PRIMARY KEY,
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

INSERT INTO roles (id, role_type) values ('40e6215d-b5c6-4896-987c-f30f3678f608', 'Coachee');

INSERT INTO roles (id, role_type) values ('6ecd8c99-4036-403d-bf84-cf8400f67836', 'Coach');

INSERT INTO roles (id, role_type) values ('3f333df6-90a4-4fda-8dd3-9485d27cee36', 'Admin');

