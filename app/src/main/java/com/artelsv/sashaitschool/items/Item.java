package com.artelsv.sashaitschool.items;

import android.graphics.drawable.Drawable;
import android.media.Image;

import com.artelsv.sashaitschool.creatures.effects.Effect;

public class Item {
    private String name;
    private String desc;
    private Integer price;
    private Integer type;
    private Effect effect;
    private boolean equip;
    private Drawable icon;

    public Item(String name, String desc, Integer price, Integer type, Effect effect, Drawable icon, boolean equip) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.type = type;
        this.effect = effect;
        this.icon = icon;
        this.equip = equip;
    }

    public Item(String name, String desc, Integer price, Integer type, Drawable icon, boolean equip) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.type = type;
        this.icon = icon;
        this.equip = equip;
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

    public Drawable getIcon() {
        return icon;
    }

    public Integer getType() {
        return type;
    }

    public boolean isEquip() {
        return equip;
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
