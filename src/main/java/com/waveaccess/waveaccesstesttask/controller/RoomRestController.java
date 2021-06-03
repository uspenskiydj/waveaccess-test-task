package com.waveaccess.waveaccesstesttask.controller;

import com.waveaccess.waveaccesstesttask.model.Room;
import com.waveaccess.waveaccesstesttask.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import static com.waveaccess.waveaccesstesttask.util.ValidationUtil.assureIdConsistent;
import static com.waveaccess.waveaccesstesttask.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = RoomRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RoomRestController {
    static final String REST_URL = "/rest/rooms";

    @Autowired
    private RoomService service;

    @GetMapping
    public List<Room> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Room get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Room> createWithLocation(@Valid @RequestBody Room room) {
        Room created = service.create(room);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Room room, @PathVariable int id) {
        assureIdConsistent(room, id);
        service.update(room);
    }
}
