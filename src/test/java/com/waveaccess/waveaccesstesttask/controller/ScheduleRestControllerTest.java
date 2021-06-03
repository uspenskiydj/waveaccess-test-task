package com.waveaccess.waveaccesstesttask.controller;

import com.waveaccess.waveaccesstesttask.model.Schedule;
import com.waveaccess.waveaccesstesttask.service.ScheduleService;
import com.waveaccess.waveaccesstesttask.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static com.waveaccess.waveaccesstesttask.TestUtil.readFromJson;
import static com.waveaccess.waveaccesstesttask.TestUtil.writeValue;
import static com.waveaccess.waveaccesstesttask.testdata.ScheduleTestData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ScheduleRestControllerTest extends AbstractControllerTest{

    private static final String REST_URL = ScheduleRestController.REST_URL + '/';

    @Autowired
    private ScheduleService service;

    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + SCHEDULE1_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(SCHEDULE_MATCHER.contentJson(SCHEDULE1));
    }

    @Test
    void delete() throws Exception {
        perform(MockMvcRequestBuilders.delete(REST_URL + SCHEDULE2_ID))
                .andDo(print())
                .andExpect(status().isNoContent());
        assertThrows(NotFoundException.class, () -> service.get(SCHEDULE2_ID));
    }

    @Test
    void update() throws Exception {
        Schedule updated = getUpdated();
        perform(MockMvcRequestBuilders.put(REST_URL + SCHEDULE2_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(writeValue(updated)))
                .andDo(print())
                .andExpect(status().isNoContent());
        SCHEDULE_MATCHER.assertMatch(service.get(SCHEDULE2_ID), updated);
    }

    @Test
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(SCHEDULE_MATCHER.contentJson(SCHEDULE1, SCHEDULE2, SCHEDULE3));
    }

    @Test
    void createWithLocation() throws Exception {
        Schedule newSchedule = getNew();
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        Schedule created = readFromJson(action, Schedule.class);
        int newId = created.getId();
        newSchedule.setId(newId);
        SCHEDULE_MATCHER.assertMatch(created, newSchedule);
        SCHEDULE_MATCHER.assertMatch(service.get(newId), newSchedule);
    }
}