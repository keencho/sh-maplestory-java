package com.sh.maplestory.external.open_api.dto.res.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CharacterPropensity {
    private LocalDateTime date;

    @JsonProperty("charisma_level")
    private Long charismaLevel;

    @JsonProperty("sensibility_level")
    private Long sensibilityLevel;

    @JsonProperty("insight_level")
    private Long insightLevel;

    @JsonProperty("willingness_level")
    private Long willingnessLevel;

    @JsonProperty("handicraft_level")
    private Long handicraftLevel;

    @JsonProperty("charm_level")
    private Long charmLevel;

}
