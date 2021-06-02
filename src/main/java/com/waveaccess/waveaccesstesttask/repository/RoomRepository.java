package com.waveaccess.waveaccesstesttask.repository;

import com.waveaccess.waveaccesstesttask.model.Room;

import java.util.List;

public interface RoomRepository {
    Room save(Room bank);

    boolean delete(Integer id);

    Room get(Integer id);

    List<Room> getAll();
}
