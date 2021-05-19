SET SCHEMA 'code_coach';

CREATE TABLE coach_profiles(
                               id uuid NOT NULL PRIMARY KEY ,
                               introduction varchar(255),
                               availability boolean

);
