package com.waveaccess.waveaccesstesttask.util;

import com.waveaccess.waveaccesstesttask.model.AbstractBaseEntity;
import com.waveaccess.waveaccesstesttask.model.Schedule;
import com.waveaccess.waveaccesstesttask.util.exception.BusyDateTimeException;
import com.waveaccess.waveaccesstesttask.util.exception.IllegalRequestDataException;
import com.waveaccess.waveaccesstesttask.util.exception.NotFoundException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import static com.waveaccess.waveaccesstesttask.util.DateTimeUtil.isNotOverlapping;
import static com.waveaccess.waveaccesstesttask.util.DateTimeUtil.toSimpleString;

public class ValidationUtil {

    public static <T> T checkNotFoundWithId(T object, Integer id) {
        checkNotFoundWithId(object != null, id);
        return object;
    }

    public static void checkNotFoundWithId(boolean found, Integer id) {
        checkNotFound(found, "id=" + id);
    }

    public static <T> T checkNotFound(T object, String msg) {
        checkNotFound(object != null, msg);
        return object;
    }

    public static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new NotFoundException("Not found entity with " + msg);
        }
    }

    public static void assureIdConsistent(AbstractBaseEntity bean, int id) {
        if (bean.getId() == null) {
            bean.setId(id);
        }
        else if (bean.getId() != id) {
            throw new IllegalRequestDataException(bean + " must be with id=" + id);
        }
    }

    public static void checkNew(AbstractBaseEntity bean) {
        if (bean.getId() != null) {
            throw new IllegalRequestDataException(bean + " must be new (id=null)");
        }
    }

    public static void checkIfBusyDateTime(Schedule schedule, List<Schedule> all) {
        LocalDateTime startTalk = schedule.getDateTime();
        Integer duration = schedule.getTalk().getDurationMinutes();
        LocalDateTime endTalk = startTalk.plus(duration, ChronoUnit.MINUTES);
        for (Schedule next: all) {
            LocalDateTime start = next.getDateTime();
            LocalDateTime end = start.plus(next.getTalk().getDurationMinutes(), ChronoUnit.MINUTES);
            if (!isNotOverlapping(startTalk, endTalk, start, end)) {
                throw new BusyDateTimeException(
                        "Нельзя выбрать время " + toSimpleString(startTalk) + " для доклада с длительностью "
                                + duration + " минут в комнате " + schedule.getRoom() + ", поскольку период с "
                                + toSimpleString(start) + " по " + toSimpleString(end) + " уже занят");
            }
        }
    }
}