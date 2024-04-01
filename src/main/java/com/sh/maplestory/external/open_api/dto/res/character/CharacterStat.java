package com.sh.maplestory.external.open_api.dto.res.character;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sh.maplestory.config.OpenAPIDeserializer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonDeserialize(using = OpenAPIDeserializer.class)
public class CharacterStat {
    private LocalDateTime date;
    private String characterClass;
    private List<FinalStat> finalStats;
    private long remainAp;

    @Data
    public static class FinalStat {
        private String statName;
        private String statValue;
    }

}
