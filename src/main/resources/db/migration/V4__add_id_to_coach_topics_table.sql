ALTER TABLE coach_topics

    drop constraint coach_topics_pkey,
    drop constraint coach_topics_coach_profile_fk,
add column id uuid not null primary key,
add constraint coach_topics_coach_profile_fk foreign key (coach_profile_id)
    references coach_profiles(id);
