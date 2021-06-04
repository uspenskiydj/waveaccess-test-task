package com.waveaccess.waveaccesstesttask.testdata;

import com.waveaccess.waveaccesstesttask.TestMatcher;
import com.waveaccess.waveaccesstesttask.model.Room;
import static com.waveaccess.waveaccesstesttask.model.AbstractBaseEntity.START_SEQ;

public class RoomTestData {
    public static final TestMatcher<Room> ROOM_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Room.class, "schedules");

    public static final int ROOM1_ID = START_SEQ + 3;
    public static final int ROOM2_ID = START_SEQ + 4;
    public static final int ROOM3_ID = START_SEQ + 5;

    public static final Room ROOM1 = new Room(ROOM1_ID, "Комната 1");
    public static final Room ROOM2 = new Room(ROOM2_ID, "Комната 2");
    public static final Room ROOM3 = new Room(ROOM3_ID, "Комната 3");

    public static Room getNew() {
        return new Room(null, "newName");
    }

    public static Room getUpdated() {
        Room updated = new Room(ROOM1);
        updated.setName("updatedName");
        return updated;
    }
}
