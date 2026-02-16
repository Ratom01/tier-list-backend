package com.example.TierListApi.repo;

import com.example.TierListApi.model.Ranking;
import com.example.TierListApi.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RankingRepo extends JpaRepository<Ranking, Long> {
    void deleteById(long id);

    List<Ranking> findByCharacterId(long id);
}
