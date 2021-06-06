package com.waveaccess.waveaccesstesttask.repository;

import com.waveaccess.waveaccesstesttask.model.Talk;
import java.util.List;
import java.util.Set;

public interface TalkRepository {
    Talk save(Talk bank, int userId);

    boolean delete(Integer id, int userId);

    Talk get(Integer id, int userId);

    List<Talk> getAll(int userId);
}
