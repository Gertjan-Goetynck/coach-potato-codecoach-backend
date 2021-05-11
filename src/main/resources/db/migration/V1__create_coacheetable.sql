SET SCHEMA 'code_coach';

CREATE TABLE users(
                          id uuid NOT NULL PRIMARY KEY,
                          first_name varchar(255) NOT NULL,
                          last_name varchar(255) NOT NULL,
                          email varchar(255) NOT NULL,
                          password varchar(255) NOT NULL
);
