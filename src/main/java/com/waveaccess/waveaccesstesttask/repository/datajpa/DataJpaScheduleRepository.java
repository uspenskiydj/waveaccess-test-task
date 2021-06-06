package com.waveaccess.waveaccesstesttask.repository.datajpa;

import com.waveaccess.waveaccesstesttask.model.Room;
import com.waveaccess.waveaccesstesttask.model.Schedule;
import com.waveaccess.waveaccesstesttask.repository.ScheduleRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class DataJpaScheduleRepository implements ScheduleRepository {
    private final CrudScheduleRepository crudScheduleRepository;
    private final CrudUserRepository crudUserRepository;

    public DataJpaScheduleRepository(CrudScheduleRepository crudScheduleRepository, CrudUserRepository crudUserRepository) {
        this.crudScheduleRepository = crudScheduleRepository;
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    @Transactional
    public Schedule save(Schedule schedule, int userId) {
        if (!(schedule.getId() == null) && get(schedule.getId(), userId) == null) {
            return null;
        }
        schedule.setUser(crudUserRepository.getById(userId));
        return crudScheduleRepository.save(schedule);
    }

    @Override
    public boolean delete(Integer id, int userId) {
        return crudScheduleRepository.deleteByUserIdAndId(userId, id) != 0;
    }

    @Override
    public Schedule get(Integer id, int userId) {
        return crudScheduleRepository.findByUserIdAndId(userId, id);
    }

    @Override
    public List<Schedule> getAll(int userId) {
        return crudScheduleRepository.findByUserId(userId);
    }

    @Override
    public List<Schedule> getAll() {
        return crudScheduleRepository.findAll();
    }

    @Override
    public List<Schedule> getAllByRoom(Room room) {
        return crudScheduleRepository.getAllByRoom(room);
    }
}
