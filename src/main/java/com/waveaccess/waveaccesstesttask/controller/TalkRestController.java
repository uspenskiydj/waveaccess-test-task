package com.waveaccess.waveaccesstesttask.controller;

import com.waveaccess.waveaccesstesttask.model.Talk;
import com.waveaccess.waveaccesstesttask.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static com.waveaccess.waveaccesstesttask.security.SecurityUtil.authUserId;
import static com.waveaccess.waveaccesstesttask.util.ValidationUtil.assureIdConsistent;

@RestController
@RequestMapping(value = TalkRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class TalkRestController {
    static final String REST_URL = "/rest/profile/talks";

    @Autowired
    private TalkService service;

    @GetMapping
    public List<Talk> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Talk get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Talk> createWithLocation(@Valid @RequestBody Talk talk) {
        Talk created = service.create(talk);
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
    public void update(@Valid @RequestBody Talk talk, @PathVariable int id) {
        service.update(talk, id);
    }
}
