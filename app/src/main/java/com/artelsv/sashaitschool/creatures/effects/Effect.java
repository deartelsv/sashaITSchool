package com.artelsv.sashaitschool.creatures.effects;

import com.artelsv.sashaitschool.creatures.Creature;
import com.artelsv.sashaitschool.creatures.Hero;

public class Effect {
    private String name;
    private Integer power;
    private Integer effectType;
    private Integer extraPower;
    private Integer extraEffectType = 0;

    public Effect(String name, Integer power, Integer effectType) {
        this.name = name;
        this.power = power;
        this.effectType = effectType;
    }

    public Effect(Integer power, Integer extraPower, Integer effectType, Integer extraEffectType) {
        this.power = power;
        this.extraPower = extraPower;
        this.effectType = effectType;
        this.extraEffectType = extraEffectType;
    }

    public Effect(Integer power, Integer effectType) {
        this.power = power;
        this.effectType = effectType;
    }

    public Effect(String name, Integer power, Integer extraPower, Integer effectType, Integer extraEffectType) {
        this.name = name;
        this.power = power;
        this.effectType = effectType;
        this.extraPower = extraPower;
        this.extraEffectType = extraEffectType;
    }

    public void EffectCast(Creature creature){
        //тут я определяю 5 типов эффектов
        // 1 - получение хп
        // 2 - получение денег
        // 3 - получение урона
        // 4 - получение выносливости
        // 5 - получение защиты
        // 6 - рестарт игры
        // 7 - восстановление хп до нач.значения

        switch (effectType){
            case 1:
                creature.hpRegen(power);
                break;
            case 2:
                creature.moneyInc(power);
                break;
            case 3:
                creature.damage(power);
                break;
            case 4:
                creature.powerInc(power);
                break;
            case 5:
                creature.protectionInc(power);
                break;
            case 6:
                creature.restart();
            case 7:
                creature.rest();
        }

        if (extraEffectType != 0) {
            switch (extraEffectType) {
                case 1:
                    creature.hpRegen(extraPower);
                    break;
                case 2:
                    creature.moneyInc(extraPower);
                    break;
                case 3:
                    creature.damage(extraPower);
                    break;
                case 4:
                    creature.powerInc(extraPower);
                    break;
                case 5:
                    creature.protectionInc(extraPower);
                    break;
                case 6:
                    creature.restart();
                case 7:
                    creature.rest();
            }
        }
    }
}
