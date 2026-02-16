package com.example.TierListApi.repo;

import com.example.TierListApi.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CharacterRepo extends JpaRepository<Character, Long> {
    void deleteById(long id);
    @Query("""
        SELECT c FROM Character c
        WHERE (:rarityType IS NULL OR c.rarityType = :rarityType)
        AND (:elementType IS NULL OR c.elementType = :elementType)
        AND (:rifleType IS NULL OR c.rifleType = :rifleType)
        AND (:attackType IS NULL OR c.attackType = :attackType)
        AND (:burstType IS NULL OR c.burstType = :burstType)
        AND (:manufacturerType IS NULL OR c.manufacturerType = :manufacturerType)
    """)
    List<Character> findFiltered(
            String rarityType,
            String elementType,
            String rifleType,
            String attackType,
            String burstType,
            String manufacturerType
    );
}
