package com.example.TierListApi.service;

import com.example.TierListApi.exception.NotFoundByIdException;
import com.example.TierListApi.model.Character;
import com.example.TierListApi.model.Skill;
import com.example.TierListApi.repo.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private final SkillRepo skillRepo;

    @Autowired
    public SkillService(SkillRepo skillRepo) {
        this.skillRepo = skillRepo;
    }

    public List<Skill> findAllSkill(){
        return skillRepo.findAll();
    }

    public List<Skill> findSkillsByCharacterId(long id) {
        List<Skill> skills = skillRepo.findByCharacterId(id);
        if (skills.isEmpty()) {
            throw new NotFoundByIdException("No skills found for character id " + id);
        }

        return skills;
    }

    public Skill addSkill(Skill skill){
        return  skillRepo.save(skill);
    }

    public Skill updateSkill(Skill skill){
        return skillRepo.save(skill);
    }

    public void deleteSkill(long id){
        skillRepo.deleteById(id);
    }

    public Skill findSkillById(long id){
        return skillRepo.findById(id).orElseThrow(() -> new NotFoundByIdException("Skill by id "+id+" was not found"));
    }
}
