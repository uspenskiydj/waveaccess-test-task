package com.waveaccess.waveaccesstesttask.controller;

import com.waveaccess.waveaccesstesttask.model.Talk;
import com.waveaccess.waveaccesstesttask.service.TalkService;
import com.waveaccess.waveaccesstesttask.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static com.waveaccess.waveaccesstesttask.TestUtil.readFromJson;
import static com.waveaccess.waveaccesstesttask.TestUtil.writeValue;
import static com.waveaccess.waveaccesstesttask.testdata.TalkTestData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TalkRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = TalkRestController.REST_URL + '/';

    @Autowired
    private TalkService service;

    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + TALK1_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(TALK_MATCHER.contentJson(TALK1));
    }

    @Test
    void delete() throws Exception {
        perform(MockMvcRequestBuilders.delete(REST_URL + TALK2_ID))
                .andDo(print())
                .andExpect(status().isNoContent());
        assertThrows(NotFoundException.class, () -> service.get(TALK2_ID));
    }

    @Test
    void update() throws Exception {
        Talk updated = getUpdated();
        perform(MockMvcRequestBuilders.put(REST_URL + TALK2_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(writeValue(updated)))
                .andDo(print())
                .andExpect(status().isNoContent());
        TALK_MATCHER.assertMatch(service.get(TALK2_ID), updated);
    }

    @Test
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(TALK_MATCHER.contentJson(TALK1, TALK2, TALK3));
    }

    @Test
    void createWithLocation() throws Exception {
        Talk newTalk = getNew();
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        Talk created = readFromJson(action, Talk.class);
        int newId = created.getId();
        newTalk.setId(newId);
        TALK_MATCHER.assertMatch(created, newTalk);
        TALK_MATCHER.assertMatch(service.get(newId), newTalk);
    }
}