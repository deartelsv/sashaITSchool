package com.artelsv.sashaitschool;

import android.media.Image;

import com.artelsv.sashaitschool.creatures.effects.Effect;

public class Item {
    private String name;
    private String desc;
    private Integer price;
    private Byte type;
    private Effect effect;
    private Image icon;

    public Item(String name, String desc, Integer price, Byte type, Effect effect, Image icon) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.type = type;
        this.effect = effect;
        this.icon = icon;

    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getPrice() {
        return price;
    }

    public Effect getEffect() {
        return effect;
    }

    public Image getIcon() {
        return icon;
    }

    public Byte getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", effect=" + effect +
                ", icon=" + icon +
                '}';
    }
}
