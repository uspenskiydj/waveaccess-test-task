package com.waveaccess.waveaccesstesttask.repository;

import com.waveaccess.waveaccesstesttask.model.Room;
import com.waveaccess.waveaccesstesttask.model.Schedule;

import java.util.List;

public interface ScheduleRepository {
    Schedule save(Schedule bank, int userId);

    boolean delete(Integer id, int userId);

    Schedule get(Integer id, int userId);

    List<Schedule> getAll(int userId);

    List<Schedule> getAll();

    List<Schedule> getAllByRoom(Room room);
}
