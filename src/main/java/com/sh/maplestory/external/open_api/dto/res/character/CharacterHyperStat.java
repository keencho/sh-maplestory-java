package com.sh.maplestory.external.open_api.dto.res.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sh.maplestory.config.OpenAPIDeserializer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonDeserialize(using = OpenAPIDeserializer.class)
public class CharacterHyperStat {
    private LocalDateTime date;
    private String characterClass;
    private String usePresetNo;
    private long useAvailableHyperStat;
    private List<Preset> hyperStatPreset1;
    private long hyperStatPreset1RemainPoint;
    private List<Preset> hyperStatPreset2;
    private long hyperStatPreset2RemainPoint;
    private List<Preset> hyperStatPreset3;
    private long hyperStatPreset3RemainPoint;

    @Data
    public static class Preset {
        private String statType;
        private long statPoint;
        private long statLevel;
        private String statIncrease;
    }
}
