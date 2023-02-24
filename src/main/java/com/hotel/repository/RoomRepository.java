package com.hotel.repository;

import com.hotel.domain.enums.StatusEnum;
import com.hotel.entities.Room;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    Room findByUniqueID(final Long uniqueID);
    List<Room> findAllByStatus(final StatusEnum status, final Pageable pageable);

}
