package com.waveaccess.waveaccesstesttask.service;

import com.waveaccess.waveaccesstesttask.model.User;
import com.waveaccess.waveaccesstesttask.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
import static com.waveaccess.waveaccesstesttask.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserService {
    private final UserRepository repository;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        log.info("create from {}", user);
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }

    public void delete(Integer id) {
        log.info("delete {}", id);
        checkNotFoundWithId(repository.delete(id), id);
    }

    public User get(Integer id) {
        log.info("get {}", id);
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<User> getAll() {
        log.info("getAll");
        return repository.getAll();
    }

    public void update(User user, int id) {
        log.info("update {} with id={}", user, id);
        Assert.notNull(user, "user must not be null");
        checkNotFoundWithId(repository.save(user), id);
    }
}
