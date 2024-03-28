package com.sh.maplestory.external.open_api.dto.res.character;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CharacterPopularity {
    private LocalDateTime date;
    private long popularity;
}
