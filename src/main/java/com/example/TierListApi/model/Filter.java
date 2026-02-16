package com.example.TierListApi.model;

import com.example.TierListApi.enums.AttackType;
import com.example.TierListApi.enums.BurstType;
import com.example.TierListApi.enums.ElementType;
import com.example.TierListApi.enums.ManufacturerType;
import com.example.TierListApi.enums.RarityType;
import com.example.TierListApi.enums.RifleType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class Filter {
    @Enumerated(EnumType.STRING)
    private RarityType rarityType;
    @Enumerated(EnumType.STRING)
    private ElementType elementType;
    @Enumerated(EnumType.STRING)
    private RifleType rifleType;
    @Enumerated(EnumType.STRING)
    private AttackType attackType;
    @Enumerated(EnumType.STRING)
    private BurstType burstType;
    @Enumerated(EnumType.STRING)
    private ManufacturerType manufacturerType;

    public Filter(){}
    public Filter(RarityType rarityType, ElementType elementType, RifleType rifleType, AttackType attackType, BurstType burstType, ManufacturerType manufacturerType) {
        this.rarityType = rarityType;
        this.elementType = elementType;
        this.rifleType = rifleType;
        this.attackType = attackType;
        this.burstType = burstType;
        this.manufacturerType = manufacturerType;
    }

    public RarityType getRarityType() {
        return rarityType;
    }

    public void setRarityType(RarityType rarityType) {
        this.rarityType = rarityType;
    }

    public ElementType getElementType() {
        return elementType;
    }

    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

    public RifleType getRifleType() {
        return rifleType;
    }

    public void setRifleType(RifleType rifleType) {
        this.rifleType = rifleType;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }

    public BurstType getBurstType() {
        return burstType;
    }

    public void setBurstType(BurstType burstType) {
        this.burstType = burstType;
    }

    public ManufacturerType getManufacturerType() {
        return manufacturerType;
    }

    public void setManufacturerType(ManufacturerType manufacturerType) {
        this.manufacturerType = manufacturerType;
    }

    public boolean isEmpty() {
        return rarityType == null &&
                elementType == null &&
                rifleType == null &&
                attackType == null &&
                burstType == null &&
                manufacturerType == null;
    }
}
