package com.waveaccess.waveaccesstesttask.service;

import com.waveaccess.waveaccesstesttask.model.Schedule;
import com.waveaccess.waveaccesstesttask.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
import static com.waveaccess.waveaccesstesttask.util.ValidationUtil.checkNotFoundWithId;

@Service
public class ScheduleService {
    private final ScheduleRepository repository;

    public ScheduleService(ScheduleRepository repository) {
        this.repository = repository;
    }

    public Schedule create(Schedule schedule) {
        Assert.notNull(schedule, "schedule must not be null");
        return repository.save(schedule);
    }

    public void delete(Integer id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Schedule get(Integer id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<Schedule> getAll() {
        return repository.getAll();
    }

    public void update(Schedule schedule) {
        Assert.notNull(schedule, "schedule must not be null");
        checkNotFoundWithId(repository.save(schedule), schedule.getId());
    }
}
