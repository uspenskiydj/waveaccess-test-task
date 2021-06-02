package com.waveaccess.waveaccesstesttask.repository.datajpa;

import com.waveaccess.waveaccesstesttask.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudScheduleRepository extends JpaRepository<Schedule, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Schedule s WHERE s.id=:id")
    int delete(@Param("id") Integer id);
}
