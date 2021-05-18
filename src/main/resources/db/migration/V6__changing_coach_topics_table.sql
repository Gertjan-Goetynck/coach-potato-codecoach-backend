SET SCHEMA 'code_coach';

ALTER TABLE coach_profiles
    drop column experience;

ALTER TABLE coach_topics
    add column experience int;
