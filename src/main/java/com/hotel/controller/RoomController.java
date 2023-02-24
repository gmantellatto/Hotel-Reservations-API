package com.hotel.controller;

import com.hotel.domain.dto.RoomDto;
import com.hotel.domain.request.RoomRequest;
import com.hotel.domain.response.RoomResponse;
import com.hotel.service.RoomService;
import jakarta.validation.Valid;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping
    @Transactional
    public void registerRoom(@RequestBody @Valid RoomDto roomDto) {
        //System.out.println(roomDto.toString());
        roomService.save(roomDto);
    }

    @GetMapping
    public List<RoomResponse> listAvailableRooms(@PageableDefault(size = 3, sort = {"floor"}) Pageable pageable) {
        return roomService.listAvailableRooms(pageable);
    }

    @PutMapping
    @Transactional
    public void updateRoomStatus(@RequestBody @Valid RoomRequest roomRequest) {
        roomService.updateRoomStatus(roomRequest);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteRoom(@PathVariable Long id) {
        roomService.logicDeleteRoom(id);
    }

}
