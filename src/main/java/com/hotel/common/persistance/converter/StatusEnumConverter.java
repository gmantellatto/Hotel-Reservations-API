package com.hotel.common.persistance.converter;

import com.hotel.domain.enums.StatusEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Objects;

@Converter
public class StatusEnumConverter implements AttributeConverter<StatusEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(final StatusEnum attribute) {
        if (Objects.isNull(attribute)) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public StatusEnum convertToEntityAttribute(final Integer dbData) {
        if (Objects.isNull(dbData)) {
            return null;
        }
        return StatusEnum.fromCode(dbData);
    }
}
