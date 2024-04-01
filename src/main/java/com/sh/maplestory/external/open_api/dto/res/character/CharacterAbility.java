package com.sh.maplestory.external.open_api.dto.res.character;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sh.maplestory.config.OpenAPIDeserializer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonDeserialize(using = OpenAPIDeserializer.class)
public class CharacterAbility {
    private LocalDateTime date;
    private String abilityGrade;
    private List<Info> abilityInfo;
    private long remainFame;
    private long presetNo;
    private Preset abilityPreset1;
    private Preset abilityPreset2;
    private Preset abilityPreset3;

    @Data
    public static class Preset {
        private String abilityPresetGrade;
        private List<Info> abilityInfo;
    }

    @Data
    public static class Info {
        private String abilityNo;
        private String abilityGrade;
        private String abilityValue;
    }
}
