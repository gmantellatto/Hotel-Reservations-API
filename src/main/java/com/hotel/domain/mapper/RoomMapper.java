package com.hotel.domain.mapper;

import com.hotel.domain.dto.RoomDto;
import com.hotel.domain.response.RoomResponse;
import com.hotel.entities.Room;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomDto toDto(final Room entity);

    Room toEntity(final RoomDto dto);

    List<RoomDto> toDtoList(final List<Room> entity);

    List<RoomResponse> toResponseList(final List<Room> entity);
}
