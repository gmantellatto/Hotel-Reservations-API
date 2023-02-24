package com.hotel.domain.dto;

import com.hotel.domain.enums.StatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RoomDto {

    private Long uniqueID;
    @NotBlank
    private String name;
    @NotNull
    private Long floor;
    @NotNull
    private Long number;
    @NotNull
    private StatusEnum status;


    public Long getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(Long uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFloor() {
        return floor;
    }

    public void setFloor(Long floor) {
        this.floor = floor;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RoomDto{" +
                "uniqueID=" + uniqueID +
                ", name='" + name + '\'' +
                ", floor=" + floor +
                ", number=" + number +
                ", status=" + status +
                '}';
    }
}
