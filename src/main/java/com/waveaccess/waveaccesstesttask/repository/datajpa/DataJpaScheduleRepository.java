package com.waveaccess.waveaccesstesttask.repository.datajpa;

import com.waveaccess.waveaccesstesttask.model.Schedule;
import com.waveaccess.waveaccesstesttask.repository.ScheduleRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class DataJpaScheduleRepository implements ScheduleRepository {
    private final CrudScheduleRepository crudScheduleRepository;

    public DataJpaScheduleRepository(CrudScheduleRepository crudScheduleRepository) {
        this.crudScheduleRepository = crudScheduleRepository;
    }

    @Override
    @Transactional
    public Schedule save(Schedule schedule) {
        return crudScheduleRepository.save(schedule);
    }

    @Override
    public boolean delete(Integer id) {
        return crudScheduleRepository.delete(id) != 0;
    }

    @Override
    public Schedule get(Integer id) {
        return crudScheduleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Schedule> getAll() {
        return crudScheduleRepository.findAll();
    }
}
