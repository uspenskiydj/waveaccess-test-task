package com.waveaccess.waveaccesstesttask.service;

import com.waveaccess.waveaccesstesttask.model.Schedule;
import com.waveaccess.waveaccesstesttask.util.exception.BusyDateTimeException;
import com.waveaccess.waveaccesstesttask.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import static com.waveaccess.waveaccesstesttask.testdata.RoomTestData.ROOM3;
import static com.waveaccess.waveaccesstesttask.testdata.ScheduleTestData.*;
import static com.waveaccess.waveaccesstesttask.testdata.TalkTestData.TALK2;
import static org.junit.jupiter.api.Assertions.*;

class ScheduleServiceTest extends AbstractServiceTest {

    @Autowired
    protected ScheduleService service;

    @Test
    void create() {
        Schedule created = service.create(getNew());
        int newId = created.getId();
        Schedule newSchedule = getNew();
        newSchedule.setId(newId);
        SCHEDULE_MATCHER.assertMatch(created, newSchedule);
        SCHEDULE_MATCHER.assertMatch(service.get(newId), newSchedule);
    }

    @Test
    void busyDateTimeCreate() {
        assertThrows(BusyDateTimeException.class, () ->
                service.create(new Schedule(null, LocalDateTime.of(2020, Month.JANUARY, 31, 11, 30), ROOM3, TALK2)));
    }

    @Test
    void delete() {
        service.delete(SCHEDULE1_ID);
        assertThrows(NotFoundException.class, () -> service.get(SCHEDULE1_ID));
    }

    @Test
    void get() {
        Schedule talk = service.get(SCHEDULE2_ID);
        SCHEDULE_MATCHER.assertMatch(talk, SCHEDULE2);
    }

    @Test
    void update() {
        Schedule updated = getUpdated();
        service.update(updated);
        SCHEDULE_MATCHER.assertMatch(service.get(SCHEDULE1_ID), getUpdated());
    }

    @Test
    void getAll() {
        List<Schedule> all = service.getAll();
        SCHEDULE_MATCHER.assertMatch(all, SCHEDULE1, SCHEDULE2, SCHEDULE3);
    }
}