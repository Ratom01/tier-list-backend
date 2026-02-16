package com.example.TierListApi.controller;

import com.example.TierListApi.enums.*;
import com.example.TierListApi.model.Character;
import com.example.TierListApi.model.Filter;
import com.example.TierListApi.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {
    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping("/all")
    public ResponseEntity<List<Character>> getAllCharacter(@RequestBody(required = false) Filter filter){
        if(filter == null){
            System.out.println("Sima");
            List<Character> characters = characterService.findAllCharacter();

            return new ResponseEntity<>(characters, HttpStatus.OK);
        }
        System.out.println("filtered");
        List<Character> characters = characterService.getFilteredCharacters(filter);

        return new ResponseEntity<>(characters, HttpStatus.OK);

    }
//    @GetMapping("/all")
//    public ResponseEntity<List<Character>> getAllCharacter(
//            @RequestParam(required = false) String rarityType,
//            @RequestParam(required = false) String elementType,
//            @RequestParam(required = false) String rifleType,
//            @RequestParam(required = false) String attackType,
//            @RequestParam(required = false) String burstType,
//            @RequestParam(required = false) String manufacturerType
//    ) {
//        Filter filter = new Filter(
//                rarityType == null ? null : RarityType.valueOf(rarityType),
//                elementType == null ? null : ElementType.valueOf(elementType),
//                rifleType == null ? null : RifleType.valueOf(rifleType),
//                attackType == null ? null : AttackType.valueOf(attackType),
//                burstType == null ? null : BurstType.valueOf(burstType),
//                manufacturerType == null ? null : ManufacturerType.valueOf(manufacturerType)
//        );
//
//        if (filter.isEmpty()) {
//            System.out.println("Sima");
//            List<Character> characters = characterService.findAllCharacter();
//            return new ResponseEntity<>(characters, HttpStatus.OK);
//        }
//        System.out.println("Filtered");
//        List<Character> characters = characterService.getFilteredCharacters(filter);
//        return new ResponseEntity<>(characters, HttpStatus.OK);
//    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable("id") long id){
        Character character = characterService.findCharacterById(id);

        return new ResponseEntity<>(character, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Character> addCharacter(@RequestBody Character character){
        Character newCharacter = characterService.addCharacter(character);

        return new ResponseEntity<>(newCharacter, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Character> updateCharacter(@RequestBody Character character){
        Character updateCharacter = characterService.updateCharacter(character);

        return new ResponseEntity<>(updateCharacter, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCharacter(@PathVariable("id") long id){
        characterService.deleteCharacter(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
