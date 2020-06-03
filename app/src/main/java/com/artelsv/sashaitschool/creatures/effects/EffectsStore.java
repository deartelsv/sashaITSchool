package com.artelsv.sashaitschool.creatures.effects;

import java.util.ArrayList;

public class EffectsStore {
    private ArrayList<Effect> effects;

    public EffectsStore() {
        init();
    }

    private void init() {
        effects = new ArrayList<>();

        initEffects();
    }

    private void initEffects(){
        Effect slot = new Effect("slot_empty", 2, 1);
        effects.add(slot);


    }
}
