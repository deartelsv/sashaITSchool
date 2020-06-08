package com.artelsv.Gat.items;

import com.artelsv.Gat.creatures.effects.Effect;

import java.util.ArrayList;

public class ItemsStore {
    ArrayList<Item> items;

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
