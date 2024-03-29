package com.sh.maplestory.model;

import com.sh.maplestory.external.open_api.dto.res.character.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "character")
@Data
@NoArgsConstructor
public class Character {

    @Id
    private String characterName;

    private String ocid;

    private CharacterPopularity popularity;

    private CharacterStat stat;

    private CharacterHyperStat hyperStat;

    private CharacterPropensity characterPropensity;

    private CharacterBasic basic;

    private CharacterAbility ability;

}
