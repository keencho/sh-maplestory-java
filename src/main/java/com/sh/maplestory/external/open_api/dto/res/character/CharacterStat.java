package com.sh.maplestory.external.open_api.dto.res.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CharacterStat {
    private LocalDateTime date;

    @JsonProperty("character_class")
    private String characterClass;

    @JsonProperty("final_stat")
    private List<FinalStat> finalStats;

    @JsonProperty("remain_ap")
    private long remainAp;

    @Data
    static class FinalStat {

        @JsonProperty("stat_name")
        private String statName;

        @JsonProperty("stat_value")
        private String statValue;
    }

}
