package com.waveaccess.waveaccesstesttask.service;

import com.waveaccess.waveaccesstesttask.model.Talk;
import com.waveaccess.waveaccesstesttask.repository.TalkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
import java.util.Set;

import static com.waveaccess.waveaccesstesttask.util.ValidationUtil.*;

@Service
public class TalkService {
    private final TalkRepository repository;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public TalkService(TalkRepository repository) {
        this.repository = repository;
    }

    public Talk create(Talk talk, int userId) {
        log.info("create from {} with userId={}", talk, userId);
        checkNew(talk);
        Assert.notNull(talk, "talk must not be null");
        return repository.save(talk, userId);
    }

    public void delete(Integer id, int userId) {
        log.info("delete {} with userId={}", id, userId);
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    public Talk get(Integer id, int userId) {
        log.info("get {} with userId={}", id, userId);
        return checkNotFoundWithId(repository.get(id, userId), id);
    }

    public List<Talk> getAll(int userId) {
        log.info("getAll with userId={}", userId);
        return repository.getAll(userId);
    }

    public void update(Talk talk, int id, int userId) {
        log.info("update {} with id={} with userId={}", talk, id, userId);
        Assert.notNull(talk, "talk must not be null");
        assureIdConsistent(talk, id);
        checkNotFoundWithId(repository.save(talk, userId), id);
    }
}
