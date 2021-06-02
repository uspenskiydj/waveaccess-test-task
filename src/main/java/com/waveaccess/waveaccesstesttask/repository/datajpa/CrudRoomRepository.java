package com.waveaccess.waveaccesstesttask.repository.datajpa;

import com.waveaccess.waveaccesstesttask.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudRoomRepository extends JpaRepository<Room, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Room r WHERE r.id=:id")
    int delete(@Param("id") Integer id);
}
