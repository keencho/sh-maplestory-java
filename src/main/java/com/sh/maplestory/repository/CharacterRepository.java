package com.sh.maplestory.repository;

import com.sh.maplestory.model.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharacterRepository extends MongoRepository<Character, String> {
}
