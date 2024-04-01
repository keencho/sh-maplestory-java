package com.sh.maplestory.external.open_api.dto.res.character;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sh.maplestory.config.OpenAPIDeserializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonDeserialize(using = OpenAPIDeserializer.class)
public class CharacterPopularity {
    private LocalDateTime date;
    private long popularity;
}
