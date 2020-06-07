package com.artelsv.sashaitschool.creatures;

import com.artelsv.sashaitschool.creatures.effects.Effect;

public class Creature {
    private String name; // имя существа
    private String description; // Описание существа
    private Integer money; // деньги. Пытаюсь упростить себе жизнь.
    private Integer hp; // хп существа
    private Integer power; // сила существа, влияет на атаку
    private Integer protection; // защита существа

    public Creature(String name, String description,Integer money, Integer hp, Integer power, Integer protection) {
        this.name = name;
        this.description = description;
        this.money = money;
        this.hp = hp;
        this.power = power;
        this.protection = protection;
    }

    public void moneyInc(int value){
        money = money + value;
    }

    public void hpRegen(int value){
        hp = hp + value;
    }

    public void damage(int value){
        hp = hp - value;
    }

    public void powerInc(int value){
        power = power + value;
    }

    public void protectionInc(int value){
        protection = protection + value;
    }

    public void restart(){
        hp = 100;
        money = 10;
        power = 1;
    }

    public String toString(){
        return ("\nname = " + this.name +
                "\ndesc = " + this.description +
                "\nhp = " + this.hp +
                "\nmoney = " + this.money +
                "\npower = " + this.power +
                "\nprotection = " + this.protection);
    }

    public void setEffect(Effect effect){

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getPower() {
        return power;
    }

    public Integer getProtection() {
        return protection;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
