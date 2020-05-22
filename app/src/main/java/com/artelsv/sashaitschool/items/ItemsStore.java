package com.artelsv.sashaitschool.items;

import android.media.Image;

import com.artelsv.sashaitschool.creatures.effects.Effect;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class ItemsStore {
    //static ArrayList<Item> items;

    public ItemsStore(ArrayList<Item> items, ArrayList<Effect> effects)
    {
        init();
        initItems(items,effects);
    }

    private void init() {

    }

    private void initItems(ArrayList<Item> items, ArrayList<Effect> effects){
        Item newItem;

        //items.add(newItem = new Item("test", "test", 1, 1, effects.get(0)), );

    }
}
