package com.waveaccess.waveaccesstesttask.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "talks")
public class Talk extends AbstractNamedEntity {

    @Column(name = "duration_minutes", nullable = false)
    private Integer durationMinutes;

    @ManyToMany(mappedBy = "talks")
    @JsonIgnore
    private Set<User> users;

    @OneToMany(mappedBy = "talk")
    @JsonIgnore
    private Set<Schedule> schedules;

    public Talk() {
    }

    public Talk(Integer id, String name, Integer durationMinutes) {
        super(id, name);
        this.durationMinutes = durationMinutes;
    }

    public Talk(Talk talk) {
        this(talk.getId(), talk.getName(), talk.getDurationMinutes());
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "Talk{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
