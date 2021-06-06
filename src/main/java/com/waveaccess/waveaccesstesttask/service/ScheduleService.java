package com.waveaccess.waveaccesstesttask.service;

import com.waveaccess.waveaccesstesttask.model.Room;
import com.waveaccess.waveaccesstesttask.model.Schedule;
import com.waveaccess.waveaccesstesttask.repository.ScheduleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
import static com.waveaccess.waveaccesstesttask.util.ValidationUtil.*;

@Service
public class ScheduleService {
    private final ScheduleRepository repository;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public ScheduleService(ScheduleRepository repository) {
        this.repository = repository;
    }

    public Schedule create(Schedule schedule, int userId) {
        log.info("create from {} with userId={}", schedule, userId);
        Assert.notNull(schedule, "schedule must not be null");
        checkNew(schedule);
        checkIfBusyDateTime(schedule, getAllByRoom(schedule.getRoom()));
        return repository.save(schedule, userId);
    }

    public void delete(Integer id, int userId) {
        log.info("delete {} with userId={}", id, userId);
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    public Schedule get(Integer id, int userId) {
        log.info("get {} with userId={}", id, userId);
        return checkNotFoundWithId(repository.get(id, userId), id);
    }

    public List<Schedule> getAll() {
        log.info("getAll");
        return repository.getAll();
    }

    public List<Schedule> getAll(int userId) {
        log.info("getAll with userId={}", userId);
        return repository.getAll(userId);
    }

    public List<Schedule> getAllByRoom(Room room) {
        log.info("getAllByRoom");
        return repository.getAllByRoom(room);
    }

    public void update(Schedule schedule, int id, int userId) {
        log.info("update {} with id={} with userId={}", schedule, schedule.getId(), userId);
        Assert.notNull(schedule, "schedule must not be null");
        assureIdConsistent(schedule, id);
        checkIfBusyDateTime(schedule, getAllByRoom(schedule.getRoom()));
        checkNotFoundWithId(repository.save(schedule, userId), schedule.getId());
    }
}
