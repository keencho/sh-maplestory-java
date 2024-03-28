package com.sh.maplestory.external.open_api.dto.res.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CharacterAbility {
    private LocalDateTime date;

    @JsonProperty("ability_grade")
    private String abilityGrade;

    @JsonProperty("ability_info")
    private List<Info> abilityInfo;

    @JsonProperty("remain_fame")
    private long remainFame;

    @JsonProperty("preset_no")
    private long presetNo;

    @JsonProperty("ability_preset_1")
    private Preset abilityPreset1;

    @JsonProperty("ability_preset_2")
    private Preset abilityPreset2;

    @JsonProperty("ability_preset_3")
    private Preset abilityPreset3;

    @Data
    static class Preset {
        @JsonProperty("ability_preset_grade")
        private String abilityPresetGrade;

        @JsonProperty("ability_info")
        private List<Info> abilityInfo;
    }

    @Data
    static class Info {
        @JsonProperty("ability_no")
        private String abilityNo;

        @JsonProperty("ability_grade")
        private String abilityGrade;

        @JsonProperty("ability_value")
        private String abilityValue;
    }
}
