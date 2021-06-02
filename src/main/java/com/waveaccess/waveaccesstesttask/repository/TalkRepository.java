package com.waveaccess.waveaccesstesttask.repository;

import com.waveaccess.waveaccesstesttask.model.Talk;
import java.util.List;

public interface TalkRepository {
    Talk save(Talk bank);

    boolean delete(Integer id);

    Talk get(Integer id);

    List<Talk> getAll();
}
