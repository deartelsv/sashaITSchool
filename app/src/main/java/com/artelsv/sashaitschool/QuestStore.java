package com.artelsv.sashaitschool;

import com.artelsv.sashaitschool.creatures.effects.Effect;

import java.util.ArrayList;

public class QuestStore {
    private ArrayList<Quest> quests;

    public QuestStore(ArrayList<Quest> quests) {
        this.quests = quests;

        init();
    }

    public QuestStore() {
        init();
    }

    private void init(){
        quests = new ArrayList<Quest>();

        initQuests();
    }

    public ArrayList<Quest> getQuests() {
        return quests;
    }

    private void initQuests(){
        String[] strings = {"test1", "test2", "test3", "test4"};
        Effect[] effects = {new Effect("name", 2, 2), new Effect("name", 2, 2), new Effect("name", 2, 2), new Effect("name", 2, 2)};
        Integer[] nextQuests = {1, 1, 1, 1};
        quests.add(new Quest("test", "test", 4, 1, strings, effects, nextQuests));

        String[] strings1 = {"te2st1", "test2", "test3", "test4"};
        Effect[] effects1 = {new Effect("name", 2, 2), new Effect("name", 2, 2), new Effect("name", 2, 2), new Effect("name", 2, 2)};
        Integer[] nextQuests1 = {0, 0, 0, 0};
        quests.add(new Quest("test", "test", 4, 1, strings1, effects1,nextQuests1));
    }
}
