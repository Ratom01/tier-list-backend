package com.example.TierListApi.model;

import com.example.TierListApi.enums.*;
import com.example.TierListApi.enums.AttackType;
import com.example.TierListApi.enums.RifleType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String imgUrl;
    @Enumerated(EnumType.STRING)
    private BurstType burstType;
    @Enumerated(EnumType.STRING)
    private ElementType elementType;
    @Enumerated(EnumType.STRING)
    private AttackType attackType;
    @Enumerated(EnumType.STRING)
    private ManufacturerType manufacturerType;
    @Enumerated(EnumType.STRING)
    private RarityType rarityType;
    @Enumerated(EnumType.STRING)
    private RifleType rifleType;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Skill> skills;
    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    private Ranking ranking;

    public Character(){}

    public Character(String name, String imgUrl, BurstType burstType, ElementType elementType, AttackType attackType, ManufacturerType manufacturerType, RarityType rarityType, RifleType rifleType, String description, List<Skill> skills) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.burstType = burstType;
        this.elementType = elementType;
        this.attackType = attackType;
        this.manufacturerType = manufacturerType;
        this.rarityType = rarityType;
        this.rifleType = rifleType;
        this.description = description;
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public BurstType getBurstType() {
        return burstType;
    }

    public void setBurstType(BurstType burstType) {
        this.burstType = burstType;
    }

    public ElementType getElementType() {
        return elementType;
    }

    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }

    public ManufacturerType getManufacturerType() {
        return manufacturerType;
    }

    public void setManufacturerType(ManufacturerType manufacturerType) {
        this.manufacturerType = manufacturerType;
    }

    public RarityType getRarityType() {
        return rarityType;
    }

    public void setRarityType(RarityType rarityType) {
        this.rarityType = rarityType;
    }

    public RifleType getRifleType() {
        return rifleType;
    }

    public void setRifleType(RifleType rifleType) {
        this.rifleType = rifleType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
