package com.hotel.domain.mapper;

import com.hotel.domain.dto.RoomDto;
import com.hotel.domain.enums.StatusEnum;
import com.hotel.domain.response.RoomResponse;
import com.hotel.entities.Room;
import java.util.Arrays;
import java.util.List;
import org.mapstruct.factory.Mappers;
import org.testng.annotations.Test;

import static com.hotel.domain.dto.RoomDtoMother.getAvailableRoomDto;
import static com.hotel.entity.RoomMother.getAvailableRoom;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

public class RoomMapperTest {

    private static final Integer INDEX_ZERO = 0;
    private static final Integer INDEX_ONE = 1;

    private final RoomMapper roomMapper = Mappers.getMapper(RoomMapper.class);

    @Test
    public void shouldMapperToRoomNull() {
        final RoomDto dto = null;
        final Room entity = roomMapper.toEntity(dto);

        assertNull(entity);
    }

    @Test
    public void shouldMapperToRoom() {
        final RoomDto dto = getAvailableRoomDto();

        final Room entity = roomMapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals(entity.getUniqueID(), 1L);
        assertEquals(entity.getStatus(), StatusEnum.AVAILABLE);
        assertEquals(entity.getName(), "Room Test");
        assertEquals(entity.getNumber(), 100L);
        assertEquals(entity.getFloor(), 1L);
    }

    @Test
    public void shouldMapperToRoomDtoNull() {
        final RoomDto dto = roomMapper.toDto(null);

        assertNull(dto);
    }

    @Test
    public void shouldMapperToRoomDto() {
        final Room entity = getAvailableRoom();
        final RoomDto dto = roomMapper.toDto(entity);


        assertNotNull(dto);
        assertEquals(dto.getUniqueID(), 1L);
        assertEquals(dto.getStatus(), StatusEnum.AVAILABLE);
        assertEquals(dto.getName(), "Room Test");
        assertEquals(dto.getNumber(), 100L);
        assertEquals(dto.getFloor(), 1L);
    }

    @Test
    public void shouldMapperToResponseListNull() {
        final List<RoomResponse> result = roomMapper.toResponseList(null);

        assertNull(result);
    }

    @Test
    public void shouldMapperToResponseList() {
        final List<Room> entityList = Arrays.asList(
                getAvailableRoom(),
                getAvailableRoom()
        );

        final List<RoomResponse> result = roomMapper.toResponseList(entityList);

        assertEquals(entityList.size(), result.size());
        assertEquals(entityList.get(INDEX_ZERO).getFloor(), result.get(INDEX_ZERO).getFloor());
        assertEquals(entityList.get(INDEX_ZERO).getNumber(), result.get(INDEX_ZERO).getNumber());
        assertEquals(entityList.get(INDEX_ZERO).getName(), result.get(INDEX_ZERO).getName());
        assertEquals(entityList.get(INDEX_ZERO).getStatus(), result.get(INDEX_ZERO).getStatus());
        assertEquals(entityList.get(INDEX_ZERO).getUniqueID(), result.get(INDEX_ZERO).getUniqueID());
        assertEquals(entityList.get(INDEX_ONE).getFloor(), result.get(INDEX_ONE).getFloor());
        assertEquals(entityList.get(INDEX_ONE).getNumber(), result.get(INDEX_ONE).getNumber());
        assertEquals(entityList.get(INDEX_ONE).getName(), result.get(INDEX_ONE).getName());
        assertEquals(entityList.get(INDEX_ONE).getStatus(), result.get(INDEX_ONE).getStatus());
        assertEquals(entityList.get(INDEX_ONE).getUniqueID(), result.get(INDEX_ONE).getUniqueID());
    }

    @Test
    public void shouldMapperToDtoListNull() {
        final List<RoomDto> result = roomMapper.toDtoList(null);

        assertNull(result);
    }

    @Test
    public void shouldMapperToDtoList() {
        final List<Room> entityList = Arrays.asList(
                getAvailableRoom(),
                getAvailableRoom()
        );

        final List<RoomDto> result = roomMapper.toDtoList(entityList);

        assertEquals(entityList.size(), result.size());
        assertEquals(entityList.get(INDEX_ZERO).getFloor(), result.get(INDEX_ZERO).getFloor());
        assertEquals(entityList.get(INDEX_ZERO).getNumber(), result.get(INDEX_ZERO).getNumber());
        assertEquals(entityList.get(INDEX_ZERO).getName(), result.get(INDEX_ZERO).getName());
        assertEquals(entityList.get(INDEX_ZERO).getStatus(), result.get(INDEX_ZERO).getStatus());
        assertEquals(entityList.get(INDEX_ZERO).getUniqueID(), result.get(INDEX_ZERO).getUniqueID());
        assertEquals(entityList.get(INDEX_ONE).getFloor(), result.get(INDEX_ONE).getFloor());
        assertEquals(entityList.get(INDEX_ONE).getNumber(), result.get(INDEX_ONE).getNumber());
        assertEquals(entityList.get(INDEX_ONE).getName(), result.get(INDEX_ONE).getName());
        assertEquals(entityList.get(INDEX_ONE).getStatus(), result.get(INDEX_ONE).getStatus());
        assertEquals(entityList.get(INDEX_ONE).getUniqueID(), result.get(INDEX_ONE).getUniqueID());
    }

}
