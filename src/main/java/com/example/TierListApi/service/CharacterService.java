package com.example.TierListApi.service;

import com.example.TierListApi.exception.NotFoundByIdException;
import com.example.TierListApi.model.Character;
import com.example.TierListApi.model.Filter;
import com.example.TierListApi.repo.CharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CharacterService {
    private final CharacterRepo characterRepo;

    @Autowired
    public CharacterService(CharacterRepo characterRepo) {
        this.characterRepo = characterRepo;
    }

    public List<Character> findAllCharacter(){
        return characterRepo.findAll();
    }

    public List<Character> getFilteredCharacters(Filter filter) {
        List<Character> allCharacters = characterRepo.findAll();
        System.out.println(filter);
        return allCharacters.stream()
                .filter(c -> filter.getRarityType() == null || c.getRarityType() == filter.getRarityType())
                .filter(c -> filter.getElementType() == null || c.getElementType() == filter.getElementType())
                .filter(c -> filter.getRifleType() == null || c.getRifleType() == filter.getRifleType())
                .filter(c -> filter.getAttackType() == null || c.getAttackType() == filter.getAttackType())
                .filter(c -> filter.getBurstType() == null || c.getBurstType() == filter.getBurstType())
                .filter(c -> filter.getManufacturerType() == null || c.getManufacturerType() == filter.getManufacturerType())
                .collect(Collectors.toList());
    }

    public Character addCharacter(Character character){
        return  characterRepo.save(character);
    }

    public Character updateCharacter(Character character){
        return characterRepo.save(character);
    }

    public void deleteCharacter(long id){
        characterRepo.deleteById(id);
    }

    public Character findCharacterById(long id){
        return characterRepo.findById(id).orElseThrow(() -> new NotFoundByIdException("Character by id "+id+" was not found"));
    }
}
