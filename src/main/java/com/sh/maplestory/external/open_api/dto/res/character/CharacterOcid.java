package com.sh.maplestory.external.open_api.dto.res.character;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sh.maplestory.config.OpenAPIDeserializer;
import lombok.Data;

@Data
@JsonDeserialize(using = OpenAPIDeserializer.class)
public class CharacterOcid {
    private String ocid;
}
