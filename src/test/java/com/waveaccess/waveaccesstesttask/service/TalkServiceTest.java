package com.waveaccess.waveaccesstesttask.service;

import com.waveaccess.waveaccesstesttask.model.Talk;
import com.waveaccess.waveaccesstesttask.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import static com.waveaccess.waveaccesstesttask.testdata.TalkTestData.*;
import static com.waveaccess.waveaccesstesttask.testdata.UserTestData.SPEAKER_ID;
import static org.junit.jupiter.api.Assertions.*;

class TalkServiceTest extends AbstractServiceTest {

    @Autowired
    protected TalkService service;

    @Test
    void create() {
        Talk created = service.create(getNew(), SPEAKER_ID);
        int newId = created.getId();
        Talk newTalk = getNew();
        newTalk.setId(newId);
        TALK_MATCHER.assertMatch(created, newTalk);
        TALK_MATCHER.assertMatch(service.get(newId, SPEAKER_ID), newTalk);
    }

    @Test
    void delete() {
        service.delete(TALK2_ID, SPEAKER_ID);
        assertThrows(NotFoundException.class, () -> service.get(TALK2_ID, SPEAKER_ID));
    }

    @Test
    void get() {
        Talk talk = service.get(TALK2_ID, SPEAKER_ID);
        TALK_MATCHER.assertMatch(talk, TALK2);
    }

    @Test
    void update() {
        Talk updated = getUpdated();
        service.update(updated, updated.getId(), SPEAKER_ID);
        TALK_MATCHER.assertMatch(service.get(TALK2_ID, SPEAKER_ID), getUpdated());
    }

    @Test
    void getAll() {
        List<Talk> all = service.getAll(SPEAKER_ID);
        TALK_MATCHER.assertMatch(all, TALK2, TALK3);
    }
}