package com.waveaccess.waveaccesstesttask.repository.datajpa;

import com.waveaccess.waveaccesstesttask.model.Talk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudTalkRepository extends JpaRepository<Talk, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Talk t WHERE t.id=:id")
    int delete(@Param("id") Integer id);
}
