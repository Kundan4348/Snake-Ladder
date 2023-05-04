package com.ludo.Snake.and.Ladder.model

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.core.type.TypeReference
import com.ludo.Snake.and.Ladder.Util.Utilities
import groovy.util.logging.Slf4j
import jakarta.persistence.AttributeConverter

@Slf4j
class GenericListConverter<T> implements AttributeConverter<List<T>, String> {

    @Override
    String convertToDatabaseColumn(List<T> Object) {
        try {
            return Utilities.objectMapper().writeValueAsString(Object)
        } catch ( JsonProcessingException ex) {
            log.info("Exception occurred while converting DBColumn. Exception [{}]", ex.getLocalizedMessage())
        }
    }

    @Override
    List<T> convertToEntityAttribute(String dbData) {
        if(dbData == '{}' || dbData == null) {
            return null
        }

        try {
            return Utilities.objectMapper().readValue(dbData, new TypeReference<List<T>>() {})
        } catch ( Exception ex) {
            log.info("Exception occurred while parsing generic list DBColumn. Exception: [{}]", ex.getLocalizedMessage())
        }
    }
}
