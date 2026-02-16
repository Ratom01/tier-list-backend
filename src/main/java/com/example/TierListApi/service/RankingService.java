package com.example.TierListApi.service;

import com.example.TierListApi.exception.NotFoundByIdException;
import com.example.TierListApi.model.Character;
import com.example.TierListApi.model.Ranking;
import com.example.TierListApi.model.Skill;
import com.example.TierListApi.repo.RankingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {
    private final RankingRepo rankingRepo;

    @Autowired
    public RankingService(RankingRepo rankingRepo) {
        this.rankingRepo = rankingRepo;
    }

    public List<Ranking> findAllRanking(){
        return rankingRepo.findAll();
    }

    public Ranking findRankingByCharacterId(long id){
        List<Ranking> rankings = rankingRepo.findByCharacterId(id);
        if (rankings.isEmpty()) {
            throw new NotFoundByIdException("No ranking found for character id " + id);
        }

        return rankings.get(0);
    }

    public Ranking addRanking(Ranking ranking){
        return  rankingRepo.save(ranking);
    }

    public Ranking updateRanking(Ranking ranking){
        return rankingRepo.save(ranking);
    }

    public void deleteRanking(long id){
        rankingRepo.deleteById(id);
    }

    public Ranking findRankingById(long id){
        return rankingRepo.findById(id).orElseThrow(() -> new NotFoundByIdException("Ranking by id "+id+" was not found"));
    }

}
