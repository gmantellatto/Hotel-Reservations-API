package com.hotel.domain.request;

import com.hotel.domain.enums.StatusEnum;
import jakarta.validation.constraints.NotNull;

public class RoomRequest {

    @NotNull
    private Long uniqueID;

    private String name;

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

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
