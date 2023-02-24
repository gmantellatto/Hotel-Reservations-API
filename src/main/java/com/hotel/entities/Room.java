package com.hotel.entities;

import static jakarta.persistence.GenerationType.IDENTITY;

import com.hotel.common.persistance.converter.StatusEnumConverter;
import com.hotel.domain.enums.StatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "hotel_room")
public class Room {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ROOM_ID", unique = true, nullable = false, precision = 38)
    private Long uniqueID;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "FLOOR")
    private Long floor;

    @NotNull
    @Column(name = "NUMBER")
    private Long number;

    @NotNull
    @Column(name = "STATUS")
    @Convert(converter = StatusEnumConverter.class)
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
}
