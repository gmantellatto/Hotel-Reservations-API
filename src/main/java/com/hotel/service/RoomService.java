package com.hotel.service;

import com.hotel.domain.dto.RoomDto;
import com.hotel.domain.enums.StatusEnum;
import com.hotel.domain.mapper.RoomMapper;
import com.hotel.domain.request.RoomRequest;
import com.hotel.domain.response.RoomResponse;
import com.hotel.entities.Room;
import com.hotel.repository.RoomRepository;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private static final Logger LOG = LoggerFactory.getLogger(RoomService.class);

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomService(final RoomRepository roomRepository, final RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    public void save(RoomDto dto) {
        final Room entity = roomMapper.toEntity(dto);
        roomRepository.save(entity);

        LOG.debug("Finished to save new room: id [{}]", entity.getName());
    }

    public List<RoomResponse> listAvailableRooms(Pageable pageable) {
        final List<Room> entity = roomRepository.findAllByStatus(StatusEnum.AVAILABLE, pageable);

        LOG.info("Finished to save new room: id [{}]", entity.get(0).getName());
        System.out.println(entity.get(0).getNumber());
        return roomMapper.toResponseList(entity);

    }

    public void updateRoomStatus(RoomRequest roomRequest) {
        LOG.info("Starting update process for room id: [{}]", roomRequest.getUniqueID());
        Room entity = roomRepository.findByUniqueID(roomRequest.getUniqueID());
        validateRoom(entity);
        RoomDto roomDto = roomMapper.toDto(entity);


        roomDto.setStatus(roomRequest.getStatus());

        LOG.info("Finished update process for room id: [{}]", roomRequest.getUniqueID());

        save(roomDto);
    }

    public void logicDeleteRoom(Long id) {
        LOG.info("Starting logic delete process for room id: [{}]", id);

        final Room entity = roomRepository.findByUniqueID(id);
        validateRoom(entity);
        RoomDto dto = roomMapper.toDto(entity);

        dto.setStatus(StatusEnum.UNAVAILABLE);

        save(dto);

        LOG.info("Finished logic delete process for room whit id [{}], room status: [{}].", dto.getUniqueID(), dto.getStatus().getStatus());
    }

    private void validateRoom(Room room) {
        if (Objects.isNull(room)) {
            throw new NullPointerException();
        }
        if (Objects.isNull(room.getStatus())) {
            throw new ArithmeticException("status is null");
        }
    }
}
