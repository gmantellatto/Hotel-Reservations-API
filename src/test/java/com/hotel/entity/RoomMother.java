package com.hotel.entity;

import com.hotel.domain.dto.RoomDto;
import com.hotel.domain.enums.StatusEnum;
import com.hotel.entities.Room;

public class RoomMother {

    public static Room getAvailableRoom() {
        final Room entity = getBaseRoom();

        entity.setStatus(StatusEnum.AVAILABLE);

        return entity;
    }

    private static Room getBaseRoom() {
        final Room entity = new Room();

        entity.setUniqueID(1L);
        entity.setName("Room Test");
        entity.setFloor(1L);
        entity.setNumber(100L);

        return entity;
    }
}
