SET SCHEMA 'code_coach';

CREATE TABLE coach_profiles(
                               user_id uuid NOT NULL PRIMARY KEY ,
                               introduction varchar(255),
                               availability boolean

);
