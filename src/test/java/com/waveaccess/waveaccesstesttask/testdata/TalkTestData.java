package com.waveaccess.waveaccesstesttask.testdata;

import com.waveaccess.waveaccesstesttask.TestMatcher;
import com.waveaccess.waveaccesstesttask.model.Talk;
import static com.waveaccess.waveaccesstesttask.model.AbstractBaseEntity.START_SEQ;

public class TalkTestData {
    public static final TestMatcher<Talk> TALK_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Talk.class, "users", "schedules");

    public static final int TALK1_ID = START_SEQ + 6;
    public static final int TALK2_ID = START_SEQ + 7;
    public static final int TALK3_ID = START_SEQ + 8;

    public static final Talk TALK1 = new Talk(TALK1_ID, "Доклад 1", 30);
    public static final Talk TALK2 = new Talk(TALK2_ID, "Доклад 2", 60);
    public static final Talk TALK3 = new Talk(TALK3_ID, "Доклад 3", 90);

    public static Talk getNew() {
        return new Talk(null, "newName", 45);
    }

    public static Talk getUpdated() {
        Talk updated = new Talk(TALK1);
        updated.setName("updatedName");
        updated.setDurationMinutes(55);
        return updated;
    }
}
