package com.waveaccess.waveaccesstesttask.repository;

import com.waveaccess.waveaccesstesttask.model.Room;
import com.waveaccess.waveaccesstesttask.model.Schedule;

import java.util.List;

public interface ScheduleRepository {
    Schedule save(Schedule bank);

    boolean delete(Integer id);

    Schedule get(Integer id);

    List<Schedule> getAll();

    List<Schedule> getAllByRoom(Room room);
}
