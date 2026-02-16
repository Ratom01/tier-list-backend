package com.example.TierListApi.controller;

import com.example.TierListApi.model.Character;
import com.example.TierListApi.model.Ranking;
import com.example.TierListApi.model.Skill;
import com.example.TierListApi.repo.RankingRepo;
import com.example.TierListApi.service.CharacterService;
import com.example.TierListApi.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    private final RankingService rankingService;
    private final CharacterService characterService;

    @Autowired
    public RankingController(RankingService rankingService, CharacterService characterService) {
        this.rankingService = rankingService;
        this.characterService = characterService;
    }

//    @GetMapping("/all")
//    public ResponseEntity<List<Ranking>> getAllRanking(){
//        List<Ranking> characters = rankingService.findAllRanking();
//
//        return new ResponseEntity<>(characters, HttpStatus.OK);
//    }
//
//    @GetMapping("/find/{id}")
//    public ResponseEntity<Ranking> getRankingById(@PathVariable("id") long id){
//        Ranking ranking = rankingService.findRankingrById(id);
//
//        return new ResponseEntity<>(ranking, HttpStatus.OK);
//    }
    @GetMapping("/all")
    public ResponseEntity<List<Ranking>> getRankingByCharacterId(){
        List<Ranking> rankings = rankingService.findAllRanking();

        return new ResponseEntity<>(rankings, HttpStatus.OK);
    }

    @GetMapping("/character/{characterId}")
    public ResponseEntity<Ranking> getRankingByCharacterId(@PathVariable("characterId") long characterId){
        Ranking ranking = rankingService.findRankingByCharacterId(characterId);

        return new ResponseEntity<>(ranking, HttpStatus.OK);
    }

    @PostMapping("/character/{characterId}/add")
    public ResponseEntity<Ranking> addRanking(@RequestBody Ranking ranking, @PathVariable long characterId){
        Character character = characterService.findCharacterById(characterId);
        ranking.setCharacter(character);
        Ranking newRanking = rankingService.addRanking(ranking);

        return new ResponseEntity<>(newRanking, HttpStatus.CREATED);
    }

    @PutMapping("/character/{characterId}/update")
    public ResponseEntity<Ranking> updateRanking(@RequestBody Ranking ranking, @PathVariable long characterId){
        Character character = characterService.findCharacterById(characterId);
        ranking.setCharacter(character);
        Ranking updateRanking = rankingService.updateRanking(ranking);

        return new ResponseEntity<>(updateRanking, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRanking(@PathVariable("id") long id){
        rankingService.deleteRanking(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
