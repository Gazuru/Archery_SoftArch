package hu.bme.aut.archerybe.datamodel.entity.converter;

import hu.bme.aut.archerybe.genapi.business.dto.BowType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BowTypeConverter implements AttributeConverter<BowType, String> {
    @Override
    public String convertToDatabaseColumn(BowType attribute) {
        return attribute != null ? attribute.getValue() : null;
    }

    @Override
    public BowType convertToEntityAttribute(String dbData) {
        return dbData != null ? BowType.fromValue(dbData) : null;
    }
}
