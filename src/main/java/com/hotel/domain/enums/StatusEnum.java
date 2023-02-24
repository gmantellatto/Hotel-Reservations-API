package com.hotel.domain.enums;

import static java.util.Arrays.stream;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.toMap;

import java.util.HashMap;
import java.util.Map;

public enum StatusEnum {

    AVAILABLE(0, "DISPONÍVEL"),
    BOOKED(1, "RESERVADO"),
    OCCUPIED(2, "OCUPADO"),
    CLEANNING(3, "LIMPEZA"),
    MAINTENCE(4, "EM MANUTENÇÃO"),
    UNAVAILABLE(5, "INDISPONÍVEL");

    private static final Map<Integer, StatusEnum> TYPE = new HashMap<>(values().length);

    static {
        TYPE.putAll(stream(values()).collect(toMap(StatusEnum::getCode, identity())));
    }

    private final Integer code;
    private final String status;

    StatusEnum(final Integer code, final String status) {
        this.code = code;
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public static StatusEnum fromCode(final int code) {
        return TYPE.get(code);
    }

    public String getStatus() {
        return status;
    }
}
