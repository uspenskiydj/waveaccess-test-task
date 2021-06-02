package com.waveaccess.waveaccesstesttask.service;

import com.waveaccess.waveaccesstesttask.model.Talk;
import com.waveaccess.waveaccesstesttask.repository.TalkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
import static com.waveaccess.waveaccesstesttask.util.ValidationUtil.checkNotFoundWithId;

@Service
public class TalkService {
    private final TalkRepository repository;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public TalkService(TalkRepository repository) {
        this.repository = repository;
    }

    public Talk create(Talk talk) {
        log.info("create from {}", talk);
        Assert.notNull(talk, "talk must not be null");
        return repository.save(talk);
    }

    public void delete(Integer id) {
        log.info("delete {}", id);
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Talk get(Integer id) {
        log.info("get {}", id);
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<Talk> getAll() {
        log.info("getAll");
        return repository.getAll();
    }

    public void update(Talk talk, int id) {
        log.info("update {} with id={}", talk, id);
        Assert.notNull(talk, "talk must not be null");
        checkNotFoundWithId(repository.save(talk), talk.getId());
    }
}
