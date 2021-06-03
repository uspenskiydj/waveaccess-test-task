package com.waveaccess.waveaccesstesttask.testdata;

import com.waveaccess.waveaccesstesttask.TestMatcher;
import com.waveaccess.waveaccesstesttask.model.Schedule;
import java.time.LocalDateTime;
import java.time.Month;
import static com.waveaccess.waveaccesstesttask.model.AbstractBaseEntity.START_SEQ;

public class ScheduleTestData {
    public static final TestMatcher<Schedule> SCHEDULE_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Schedule.class, "room", "talk");

    public static final int SCHEDULE1_ID = START_SEQ + 9;
    public static final int SCHEDULE2_ID = START_SEQ + 10;
    public static final int SCHEDULE3_ID = START_SEQ + 11;

    public static final Schedule SCHEDULE1 = new Schedule(SCHEDULE1_ID, LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0));
    public static final Schedule SCHEDULE2 = new Schedule(SCHEDULE2_ID, LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0));
    public static final Schedule SCHEDULE3 = new Schedule(SCHEDULE3_ID, LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0));

    public static Schedule getNew() {
        return new Schedule(null, LocalDateTime.of(2020, Month.FEBRUARY, 1, 18, 0));
    }

    public static Schedule getUpdated() {
        Schedule updated = new Schedule(SCHEDULE1);
        updated.setDateTime(LocalDateTime.of(2020, Month.FEBRUARY, 2, 19, 0));
        return updated;
    }
}
