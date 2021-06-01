package com.waveaccess.waveaccesstesttask.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public class Schedule extends AbstractBaseEntity {

    @Column(name = "date_time", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "schedule")
    @JsonManagedReference
    private List<Room> rooms;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "schedule")
    @JsonManagedReference
    private List<Talk> talks;

    public Schedule() {
    }

    public Schedule(Integer id, LocalDateTime dateTime) {
        super(id);
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Talk> getTalks() {
        return talks;
    }

    public void setTalks(List<Talk> talks) {
        this.talks = talks;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                '}';
    }
}
