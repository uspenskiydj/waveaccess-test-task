package com.waveaccess.waveaccesstesttask.service;

import com.waveaccess.waveaccesstesttask.model.Talk;
import com.waveaccess.waveaccesstesttask.repository.TalkRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
import static com.waveaccess.waveaccesstesttask.util.ValidationUtil.checkNotFoundWithId;

@Service
public class TalkService {
    private final TalkRepository repository;

    public TalkService(TalkRepository repository) {
        this.repository = repository;
    }

    public Talk create(Talk talk) {
        Assert.notNull(talk, "talk must not be null");
        return repository.save(talk);
    }

    public void delete(Integer id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Talk get(Integer id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<Talk> getAll() {
        return repository.getAll();
    }

    public void update(Talk talk) {
        Assert.notNull(talk, "talk must not be null");
        checkNotFoundWithId(repository.save(talk), talk.getId());
    }
}
