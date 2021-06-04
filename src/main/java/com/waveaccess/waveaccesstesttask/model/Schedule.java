package com.waveaccess.waveaccesstesttask.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedules", uniqueConstraints = {@UniqueConstraint(columnNames = {"date_time", "room_id"}, name = "date_time_rooms_idx")})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Schedule extends AbstractBaseEntity {

    @Column(name = "date_time", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;

    @ManyToOne()
    @JoinColumn(name = "room_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Room room;

    @ManyToOne()
    @JoinColumn(name = "talk_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Talk talk;

    public Schedule() {
    }

    public Schedule(Integer id, LocalDateTime dateTime) {
        super(id);
        this.dateTime = dateTime;
    }

    public Schedule(Integer id, LocalDateTime dateTime, Room room, Talk talk) {
        super(id);
        this.dateTime = dateTime;
        this.room = room;
        this.talk = talk;
    }

    public Schedule(Schedule schedule) {
        this(schedule.getId(), schedule.getDateTime());
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Talk getTalk() {
        return talk;
    }

    public void setTalk(Talk talk) {
        this.talk = talk;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                '}';
    }
}
