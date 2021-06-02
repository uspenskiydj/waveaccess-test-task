package com.waveaccess.waveaccesstesttask.service;

import com.waveaccess.waveaccesstesttask.model.User;
import com.waveaccess.waveaccesstesttask.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.waveaccess.waveaccesstesttask.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }

    public void delete(Integer id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public User get(Integer id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<User> getAll() {
        return repository.getAll();
    }

    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        checkNotFoundWithId(repository.save(user), user.getId());
    }
}
