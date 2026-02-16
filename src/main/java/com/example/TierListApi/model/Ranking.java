package com.example.TierListApi.model;

import com.example.TierListApi.enums.RankType;
import jakarta.persistence.*;

@Entity
public class Ranking {
    @Id
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "character_id")
    private Character character;
    private String rankImgUrl;
    @Enumerated(EnumType.STRING)
    private RankType story;
    @Enumerated(EnumType.STRING)
    private RankType boss;
    @Enumerated(EnumType.STRING)
    private RankType pvp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public String getRankImgUrl() {
        return rankImgUrl;
    }

    public void setRankImgUrl(String rankImgUrl) {
        this.rankImgUrl = rankImgUrl;
    }

    public RankType getStory() {
        return story;
    }

    public void setStory(RankType story) {
        this.story = story;
    }

    public RankType getBoss() {
        return boss;
    }

    public void setBoss(RankType boss) {
        this.boss = boss;
    }

    public RankType getPvp() {
        return pvp;
    }

    public void setPvp(RankType pvp) {
        this.pvp = pvp;
    }
}
