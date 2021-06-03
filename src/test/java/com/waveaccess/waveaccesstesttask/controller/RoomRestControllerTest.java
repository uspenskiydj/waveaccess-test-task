package com.waveaccess.waveaccesstesttask.controller;

import com.waveaccess.waveaccesstesttask.model.Room;
import com.waveaccess.waveaccesstesttask.service.RoomService;
import com.waveaccess.waveaccesstesttask.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static com.waveaccess.waveaccesstesttask.TestUtil.*;
import static com.waveaccess.waveaccesstesttask.testdata.RoomTestData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RoomRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = RoomRestController.REST_URL + '/';

    @Autowired
    private RoomService service;

    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + ROOM1_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(ROOM_MATCHER.contentJson(ROOM1));
    }

    @Test
    void delete() throws Exception {
        perform(MockMvcRequestBuilders.delete(REST_URL + ROOM2_ID))
                .andDo(print())
                .andExpect(status().isNoContent());
        assertThrows(NotFoundException.class, () -> service.get(ROOM2_ID));
    }

    @Test
    void update() throws Exception {
        Room updated = getUpdated();
        perform(MockMvcRequestBuilders.put(REST_URL + ROOM2_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(writeValue(updated)))
                .andDo(print())
                .andExpect(status().isNoContent());
        ROOM_MATCHER.assertMatch(service.get(ROOM2_ID), updated);
    }

    @Test
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(ROOM_MATCHER.contentJson(ROOM1, ROOM2, ROOM3));
    }

    @Test
    void createWithLocation() throws Exception {
        Room newRoom = getNew();
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        Room created = readFromJson(action, Room.class);
        int newId = created.getId();
        newRoom.setId(newId);
        ROOM_MATCHER.assertMatch(created, newRoom);
        ROOM_MATCHER.assertMatch(service.get(newId), newRoom);
    }
}