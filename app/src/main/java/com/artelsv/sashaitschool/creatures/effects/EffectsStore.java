package com.artelsv.sashaitschool.creatures.effects;

import java.util.ArrayList;

public class EffectsStore {
    //public static ArrayList<Effect> effects;

    public EffectsStore(ArrayList<Effect> effects) {
        init();
        initEffects(effects);
    }

    private void init() {
        //initEffects();
    }

    private void initEffects(ArrayList<Effect> effects){
        Effect slot = new Effect("slot_empty", 2, 1);
        effects.add(slot);


    }
}
