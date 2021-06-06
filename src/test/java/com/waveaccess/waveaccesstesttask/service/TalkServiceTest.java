package com.waveaccess.waveaccesstesttask.service;

import com.waveaccess.waveaccesstesttask.model.Talk;
import com.waveaccess.waveaccesstesttask.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import static com.waveaccess.waveaccesstesttask.testdata.TalkTestData.*;
import static org.junit.jupiter.api.Assertions.*;

class TalkServiceTest extends AbstractServiceTest {

    @Autowired
    protected TalkService service;

    @Test
    void create() {
        Talk created = service.create(getNew());
        int newId = created.getId();
        Talk newTalk = getNew();
        newTalk.setId(newId);
        TALK_MATCHER.assertMatch(created, newTalk);
        TALK_MATCHER.assertMatch(service.get(newId), newTalk);
    }

    @Test
    void delete() {
        service.delete(TALK1_ID);
        assertThrows(NotFoundException.class, () -> service.get(TALK1_ID));
    }

    @Test
    void get() {
        Talk talk = service.get(TALK2_ID);
        TALK_MATCHER.assertMatch(talk, TALK2);
    }

    @Test
    void update() {
        Talk updated = getUpdated();
        service.update(updated, updated.getId());
        TALK_MATCHER.assertMatch(service.get(TALK1_ID), getUpdated());
    }

    @Test
    void getAll() {
        List<Talk> all = service.getAll();
        TALK_MATCHER.assertMatch(all, TALK1, TALK2, TALK3);
    }
}