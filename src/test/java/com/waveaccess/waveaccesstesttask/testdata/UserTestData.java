package com.waveaccess.waveaccesstesttask.testdata;

import com.waveaccess.waveaccesstesttask.TestMatcher;
import com.waveaccess.waveaccesstesttask.model.Role;
import com.waveaccess.waveaccesstesttask.model.User;
import static com.waveaccess.waveaccesstesttask.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {
    public static final TestMatcher<User> USER_MATCHER = TestMatcher.usingIgnoringFieldsComparator(User.class, "password", "talks", "schedules");

    public static final int ADMIN_ID = START_SEQ;
    public static final int LISTENER_ID = START_SEQ + 1;
    public static final int SPEAKER_ID = START_SEQ + 2;
    public static final int NOT_FOUND = 10;

    public static final User ADMIN = new User(ADMIN_ID, "Name 1", "admin@gmail.com", "admin", Role.ADMIN);
    public static final User LISTENER = new User(LISTENER_ID, "Name 2", "listener@gmail.com", "listener",  Role.LISTENER);
    public static final User SPEAKER = new User(SPEAKER_ID, "Name 3", "speaker@gmail.com", "speaker", Role.SPEAKER);

    public static User getNew() {
        return new User(null, "newName", "new@gmail.com", "newPass", Role.LISTENER);
    }

    public static User getUpdated() {
        User updated = new User(LISTENER);
        updated.setEmail("update@gmail.com");
        updated.setName("updatedName");
        updated.setPassword("updatedPass");
        updated.setRole(Role.SPEAKER);
        return updated;
    }
}
