
package com.switchfully.codecoach.domain.models.users;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="topics")
@DynamicUpdate
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "topic")
    private String topic;

    public Topic(){
    }

    public Topic(UUID id, String topic) {
        this.id = id;
        this.topic = topic;
    }

    public UUID getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public Topic setId(UUID id) {
        this.id = id;
        return this;
    }

    public Topic setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Topic{");
        sb.append("id=").append(id);
        sb.append(", topic='").append(topic).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Topic topic1 = (Topic) o;
        return Objects.equals(topic.toLowerCase(), topic1.topic.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic);
    }
}
