package com.example.TierListApi.model;

import com.example.TierListApi.enums.SkillType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
@Entity
public class Skill {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonBackReference
    private Character character;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SkillType type;
    @Column(nullable = false)
    private boolean active;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    private Integer ammo;
    private Integer reloadTime;
    private Integer cooldown;

    public Skill(){}
    public Skill(Long id, Character character, String name, SkillType type, boolean active, String description, Integer ammo, Integer reloadTime, Integer cooldown) {
        this.id = id;
        this.character = character;
        this.name = name;
        this.type = type;
        this.active = active;
        this.description = description;
        this.ammo = ammo;
        this.reloadTime = reloadTime;
        this.cooldown = cooldown;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SkillType getType() {
        return type;
    }

    public void setType(SkillType type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmmo() {
        return ammo;
    }

    public void setAmmo(Integer ammo) {
        this.ammo = ammo;
    }

    public Integer getReloadTime() {
        return reloadTime;
    }

    public void setReloadTime(Integer reloadTime) {
        this.reloadTime = reloadTime;
    }

    public Integer getCooldown() {
        return cooldown;
    }

    public void setCooldown(Integer cooldown) {
        this.cooldown = cooldown;
    }
}
