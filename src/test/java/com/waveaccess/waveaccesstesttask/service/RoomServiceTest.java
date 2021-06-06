package com.waveaccess.waveaccesstesttask.service;

import com.waveaccess.waveaccesstesttask.model.Room;
import com.waveaccess.waveaccesstesttask.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import static com.waveaccess.waveaccesstesttask.testdata.RoomTestData.*;
import static org.junit.jupiter.api.Assertions.*;

class RoomServiceTest extends AbstractServiceTest {

    @Autowired
    protected RoomService service;

    @Test
    void create() {
        Room created = service.create(getNew());
        int newId = created.getId();
        Room newRoom = getNew();
        newRoom.setId(newId);
        ROOM_MATCHER.assertMatch(created, newRoom);
        ROOM_MATCHER.assertMatch(service.get(newId), newRoom);
    }

    @Test
    void delete() {
        service.delete(ROOM1_ID);
        assertThrows(NotFoundException.class, () -> service.get(ROOM1_ID));
    }

    @Test
    void get() {
        Room room = service.get(ROOM2_ID);
        ROOM_MATCHER.assertMatch(room, ROOM2);
    }

    @Test
    void update() {
        Room updated = getUpdated();
        service.update(updated, updated.getId());
        ROOM_MATCHER.assertMatch(service.get(ROOM1_ID), getUpdated());
    }

    @Test
    void getAll() {
        List<Room> all = service.getAll();
        ROOM_MATCHER.assertMatch(all, ROOM1, ROOM2, ROOM3);
    }
}