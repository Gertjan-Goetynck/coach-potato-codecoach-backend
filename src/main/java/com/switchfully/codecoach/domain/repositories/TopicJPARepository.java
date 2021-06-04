package com.switchfully.codecoach.domain.repositories;

import com.switchfully.codecoach.domain.models.coaches.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
public interface TopicJPARepository extends JpaRepository<Topic, UUID> {
}
