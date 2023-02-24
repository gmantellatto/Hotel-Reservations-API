package com.hotel.domain.dto;

import com.hotel.domain.enums.StatusEnum;

public class RoomDtoMother {

    public static RoomDto getAvailableRoomDto() {
        final RoomDto dto = getBaseRoomDto();

        dto.setStatus(StatusEnum.AVAILABLE);

        return dto;
    }

    private static RoomDto getBaseRoomDto() {
        final RoomDto dto = new RoomDto();

        dto.setUniqueID(1L);
        dto.setName("Room Test");
        dto.setFloor(1L);
        dto.setNumber(100L);

        return dto;
    }

}
