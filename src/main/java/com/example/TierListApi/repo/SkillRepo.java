package com.example.TierListApi.repo;

import com.example.TierListApi.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillRepo extends JpaRepository<Skill, Long> {
    void deleteById(long id);

    List<Skill> findByCharacterId(long id);
}
