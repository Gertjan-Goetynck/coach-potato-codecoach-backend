package com.switchfully.codecoach.domain.repositories;

import com.switchfully.codecoach.domain.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CoachJPARepository extends JpaRepository<User, UUID> {

    @Query(value = "SELECT DISTINCT ON (users.id) *" +
            "FROM users" +
            "         INNER JOIN coach_profiles cp ON users.coach_profile_id = cp.id" +
            "         INNER JOIN coach_topics ct ON cp.id = ct.coach_profile_id;",
            nativeQuery = true)
    List<User> findCoachesWithTopics();

}
