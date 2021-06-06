package com.waveaccess.waveaccesstesttask.repository.datajpa;

import com.waveaccess.waveaccesstesttask.model.Talk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudTalkRepository extends JpaRepository<Talk, Integer> {

    @Transactional
    @Modifying
    int deleteByUsers_IdAndId(int userId, int id);

    List<Talk> findByUsers_Id(int userId);

    Talk findByUsers_IdAndId(int userId, int id);
}
