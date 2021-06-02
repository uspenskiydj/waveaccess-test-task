package com.waveaccess.waveaccesstesttask.repository.datajpa;

import com.waveaccess.waveaccesstesttask.model.Room;
import com.waveaccess.waveaccesstesttask.repository.RoomRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class DataJpaRoomRepository implements RoomRepository {
    private final CrudRoomRepository crudRoomRepository;

    public DataJpaRoomRepository(CrudRoomRepository crudRoomRepository) {
        this.crudRoomRepository = crudRoomRepository;
    }

    @Override
    @Transactional
    public Room save(Room room) {
        return crudRoomRepository.save(room);
    }

    @Override
    public boolean delete(Integer id) {
        return crudRoomRepository.delete(id) != 0;
    }

    @Override
    public Room get(Integer id) {
        return crudRoomRepository.findById(id).orElse(null);
    }

    @Override
    public List<Room> getAll() {
        return crudRoomRepository.findAll();
    }
}
