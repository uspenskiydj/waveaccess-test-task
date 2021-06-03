package com.waveaccess.waveaccesstesttask.service;

import com.waveaccess.waveaccesstesttask.model.Room;
import com.waveaccess.waveaccesstesttask.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
import static com.waveaccess.waveaccesstesttask.util.ValidationUtil.checkNew;
import static com.waveaccess.waveaccesstesttask.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RoomService {
    private final RoomRepository repository;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    public Room create(Room room) {
        log.info("create from {}", room);
        checkNew(room);
        Assert.notNull(room, "room must not be null");
        return repository.save(room);
    }

    public void delete(Integer id) {
        log.info("delete {}", id);
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Room get(Integer id) {
        log.info("get {}", id);
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<Room> getAll() {
        log.info("getAll");
        return repository.getAll();
    }

    public void update(Room room) {
        log.info("update {} with id={}", room, room.getId());
        Assert.notNull(room, "room must not be null");
        checkNotFoundWithId(repository.save(room), room.getId());
    }
}
