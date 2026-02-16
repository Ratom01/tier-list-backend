package com.example.TierListApi.controller;

import com.example.TierListApi.model.Character;
import com.example.TierListApi.model.Skill;
import com.example.TierListApi.service.CharacterService;
import com.example.TierListApi.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {
    private final SkillService skillService;
    private final CharacterService characterService;

    @Autowired
    public SkillController(SkillService skillService, CharacterService characterService) {
        this.skillService = skillService;
        this.characterService = characterService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Skill>> getAllSkill(){
        List<Skill> skills = skillService.findAllSkill();

        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable("id") long id){
        Skill skill = skillService.findSkillById(id);

        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @GetMapping("/character/{characterId}")
    public ResponseEntity<List<Skill>> getSkillsByCharacterId(@PathVariable("characterId") long characterId){
        List<Skill> skills = skillService.findSkillsByCharacterId(characterId);

        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

    @PostMapping("/character/{characterId}/add")
    public ResponseEntity<Skill> addSkill(@RequestBody Skill skill, @PathVariable("characterId") long characterId){
        Character character = characterService.findCharacterById(characterId);
        skill.setCharacter(character);
        Skill newSkill = skillService.addSkill(skill);

        return new ResponseEntity<>(newSkill, HttpStatus.CREATED);
    }

    @PutMapping("/character/{characterId}/update")
    public ResponseEntity<Skill> updateSkill(@RequestBody Skill skill, @PathVariable("characterId") long characterId){
        Character character = characterService.findCharacterById(characterId);
        skill.setCharacter(character);
        Skill updateSkill = skillService.updateSkill(skill);

        return new ResponseEntity<>(updateSkill, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable("id") long id){
        skillService.deleteSkill(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
