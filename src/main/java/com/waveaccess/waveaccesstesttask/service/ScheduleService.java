package com.waveaccess.waveaccesstesttask.service;

import com.waveaccess.waveaccesstesttask.model.Schedule;
import com.waveaccess.waveaccesstesttask.repository.ScheduleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;

import static com.waveaccess.waveaccesstesttask.util.ValidationUtil.checkNew;
import static com.waveaccess.waveaccesstesttask.util.ValidationUtil.checkNotFoundWithId;

@Service
public class ScheduleService {
    private final ScheduleRepository repository;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public ScheduleService(ScheduleRepository repository) {
        this.repository = repository;
    }

    public Schedule create(Schedule schedule) {
        log.info("create from {}", schedule);
        checkNew(schedule);
        Assert.notNull(schedule, "schedule must not be null");
        return repository.save(schedule);
    }

    public void delete(Integer id) {
        log.info("delete {}", id);
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Schedule get(Integer id) {
        log.info("get {}", id);
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<Schedule> getAll() {
        log.info("getAll");
        return repository.getAll();
    }

    public void update(Schedule schedule) {
        log.info("update {} with id={}", schedule, schedule.getId());
        Assert.notNull(schedule, "schedule must not be null");
        checkNotFoundWithId(repository.save(schedule), schedule.getId());
    }
}
