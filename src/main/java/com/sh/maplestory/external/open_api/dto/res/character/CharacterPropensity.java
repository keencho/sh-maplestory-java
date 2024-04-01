package com.sh.maplestory.external.open_api.dto.res.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sh.maplestory.config.OpenAPIDeserializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@JsonDeserialize(using = OpenAPIDeserializer.class)
public class CharacterPropensity {
    private LocalDateTime date;
    private Long charismaLevel;
    private Long sensibilityLevel;
    private Long insightLevel;
    private Long willingnessLevel;
    private Long handicraftLevel;
    private Long charmLevel;

}
