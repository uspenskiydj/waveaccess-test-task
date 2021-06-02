package com.waveaccess.waveaccesstesttask.repository.datajpa;

import com.waveaccess.waveaccesstesttask.model.User;
import com.waveaccess.waveaccesstesttask.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class DataJpaUserRepository implements UserRepository {
    private final CrudUserRepository crudUserRepository;

    public DataJpaUserRepository(CrudUserRepository crudUserRepository) {
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    @Transactional
    public User save(User user) {
        return crudUserRepository.save(user);
    }

    @Override
    public boolean delete(Integer id) {
        return crudUserRepository.delete(id) != 0;
    }

    @Override
    public User get(Integer id) {
        return crudUserRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return crudUserRepository.findAll();
    }
}
