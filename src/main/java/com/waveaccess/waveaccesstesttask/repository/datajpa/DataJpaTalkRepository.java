package com.waveaccess.waveaccesstesttask.repository.datajpa;

import com.waveaccess.waveaccesstesttask.model.Talk;
import com.waveaccess.waveaccesstesttask.model.User;
import com.waveaccess.waveaccesstesttask.repository.TalkRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Repository
public class DataJpaTalkRepository implements TalkRepository {
    private final CrudTalkRepository crudTalkRepository;
    private final CrudUserRepository crudUserRepository;

    public DataJpaTalkRepository(CrudTalkRepository crudTalkRepository, CrudUserRepository crudUserRepository) {
        this.crudTalkRepository = crudTalkRepository;
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    @Transactional
    public Talk save(Talk talk, int userId) {
        if (!(talk.getId() == null) && get(talk.getId(), userId) == null) {
            return null;
        }
        talk.getUsers().add(crudUserRepository.getById(userId));
        return crudTalkRepository.save(talk);
    }

    @Override
    public boolean delete(Integer id, int userId) {
        return crudTalkRepository.deleteByUsers_IdAndId(userId, id) != 0;
    }

    @Override
    public Talk get(Integer id, int userId) {
        return crudTalkRepository.findByUsers_IdAndId(userId, id);
    }

    @Override
    public List<Talk> getAll(int userId) {
        return crudTalkRepository.findByUsers_Id(userId);
    }
}
