package com.waveaccess.waveaccesstesttask.service;

import com.waveaccess.waveaccesstesttask.model.Schedule;
import com.waveaccess.waveaccesstesttask.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import static com.waveaccess.waveaccesstesttask.testdata.ScheduleTestData.*;
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