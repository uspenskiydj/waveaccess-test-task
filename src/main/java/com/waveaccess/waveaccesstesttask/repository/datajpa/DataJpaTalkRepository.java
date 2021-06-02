package com.waveaccess.waveaccesstesttask.repository.datajpa;

import com.waveaccess.waveaccesstesttask.model.Talk;
import com.waveaccess.waveaccesstesttask.repository.TalkRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class DataJpaTalkRepository implements TalkRepository {
    private final CrudTalkRepository crudTalkRepository;

    public DataJpaTalkRepository(CrudTalkRepository crudTalkRepository) {
        this.crudTalkRepository = crudTalkRepository;
    }

    @Override
    @Transactional
    public Talk save(Talk talk) {
        return crudTalkRepository.save(talk);
    }

    @Override
    public boolean delete(Integer id) {
        return crudTalkRepository.delete(id) != 0;
    }

    @Override
    public Talk get(Integer id) {
        return crudTalkRepository.findById(id).orElse(null);
    }

    @Override
    public List<Talk> getAll() {
        return crudTalkRepository.findAll();
    }
}
