package com.switchfully.codecoach.domain.repositories;

import com.switchfully.codecoach.domain.models.users.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
public interface TopicJPARepository extends JpaRepository<Topic, UUID> {
}
