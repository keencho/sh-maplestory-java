package com.sh.maplestory.external.open_api.dto.res.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CharacterHyperStat {
    private LocalDateTime date;

    @JsonProperty("character_class")
    private String characterClass;

    @JsonProperty("use_preset_no")
    private String usePresetNo;

    @JsonProperty("use_available_hyper_stat")
    private long useAvailableHyperStat;

    @JsonProperty("hyper_stat_preset_1")
    private List<Preset> hyperStatPreset1;

    @JsonProperty("hyper_stat_preset_1_remain_point")
    private long hyperStatPreset1RemainPoint;

    @JsonProperty("hyper_stat_preset_2")
    private List<Preset> hyperStatPreset2;

    @JsonProperty("hyper_stat_preset_2_remain_point")
    private long hyperStatPreset2RemainPoint;

    @JsonProperty("hyper_stat_preset_3")
    private List<Preset> hyperStatPreset3;

    @JsonProperty("hyper_stat_preset_3_remain_point")
    private long hyperStatPreset3RemainPoint;

    @Data
    static class Preset {

        @JsonProperty("stat_type")
        private String statType;

        @JsonProperty("stat_point")
        private long statPoint;

        @JsonProperty("stat_level")
        private long statLevel;

        @JsonProperty("stat_increase")
        private String statIncrease;
    }
}
