package com.sh.maplestory.external.open_api.dto.res.character;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sh.maplestory.config.OpenAPIDeserializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonDeserialize(using = OpenAPIDeserializer.class)
public class CharacterItemEquipment {
    private LocalDateTime date;
    private String characterGender;
    private String characterClass;
    private long presetNo;

    @Data
    public static class Equipment {

    }
}
