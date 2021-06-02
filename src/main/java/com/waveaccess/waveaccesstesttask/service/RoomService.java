package com.waveaccess.waveaccesstesttask.service;

import com.waveaccess.waveaccesstesttask.model.Room;
import com.waveaccess.waveaccesstesttask.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
import static com.waveaccess.waveaccesstesttask.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RoomService {
    private final RoomRepository repository;

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    public Room create(Room room) {
        Assert.notNull(room, "room must not be null");
        return repository.save(room);
    }

    public void delete(Integer id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Room get(Integer id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<Room> getAll() {
        return repository.getAll();
    }

    public void update(Room room) {
        Assert.notNull(room, "room must not be null");
        checkNotFoundWithId(repository.save(room), room.getId());
    }
}
