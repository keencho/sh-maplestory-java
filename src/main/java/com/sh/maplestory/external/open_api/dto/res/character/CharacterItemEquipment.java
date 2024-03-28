package com.sh.maplestory.external.open_api.dto.res.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CharacterItemEquipment {
    private LocalDateTime date;

    @JsonProperty("character_gender")
    private String characterGender;

    @JsonProperty("character_class")
    private String characterClass;

    @JsonProperty("preset_no")
    private long presetNo;

    @Data
    static class Equipment {

    }
}
