package com.waveaccess.waveaccesstesttask.repository;

import com.waveaccess.waveaccesstesttask.model.User;
import java.util.List;

public interface UserRepository {
    User save(User bank);

    boolean delete(Integer id);

    User get(Integer id);

    List<User> getAll();

    User getByEmail(String email);
}
