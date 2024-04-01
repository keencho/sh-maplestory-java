package com.sh.maplestory.external.open_api.dto.res.character;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sh.maplestory.config.OpenAPIDeserializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonDeserialize(using = OpenAPIDeserializer.class)
public class CharacterBasic {
    private LocalDateTime date;
    private String characterName;
    private String worldName;
    private String characterGender;
    private String characterClass;
    private String characterClassLevel;
    private String characterLevel;
    private String characterExp;
    private String characterExpRate;
    private String characterGuildName;
    private String characterImage;

}
