package com.sh.maplestory.controller;

import com.sh.maplestory.model.Character;
import com.sh.maplestory.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping
    public Character getCharacter(@RequestParam String characterName) {
        return characterService.getCharacter(characterName);
    }
}
