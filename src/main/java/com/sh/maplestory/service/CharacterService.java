package com.sh.maplestory.service;

import com.sh.maplestory.external.open_api.Client;
import com.sh.maplestory.external.open_api.dto.res.Response;
import com.sh.maplestory.model.Character;
import com.sh.maplestory.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    @Autowired
    Client client;

    @Autowired
    CharacterRepository characterRepository;

    public Character getCharacter(String characterName) {
        var character = characterRepository.findById(characterName).orElse(null);

        if (character == null) {
            var ocidRes = client.getOcid(characterName);

            if (!ocidRes.isSuccess()) {
                return null;
            }

            character = new Character();
            character.setCharacterName(characterName);
            character.setOcid(ocidRes.getData().getOcid());
        }

        var ocid = character.getOcid();
        character.setBasic(this.getData(client.getCharacterBasic(ocid, null)));

        return characterRepository.save(character);
    }

    private <T> T getData(Response<T> data) {
        if (!data.isSuccess()) {
            return null;
        }

        return data.getData();
    }

}
