package com.artelsv.sashaitschool;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.artelsv.sashaitschool.creatures.effects.Effect;

import java.util.ArrayList;

public class QuestStore {
    private ArrayList<Quest> quests;
    private ArrayList<Drawable> drawables;

    public QuestStore() {
        init();
    }

    public QuestStore(ArrayList<Drawable> drawables) {
        this.drawables = drawables;

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
        Drawable[] drawables1 = {drawables.get(0), drawables.get(1), drawables.get(0), drawables.get(1)};
        quests.add(new Quest("test", "test", 4, 1, strings, effects, nextQuests, drawables1));

        String[] strings1 = {"te2st1", "test2", "test3", "test4"};
        Effect[] effects1 = {new Effect("name", 2, 2), new Effect("name", 2, 2), new Effect("name", 2, 2), new Effect("name", 2, 2)};
        Integer[] nextQuests1 = {0, 0, 0, 0};
        Drawable[] drawables2 = {drawables.get(0), drawables.get(1), drawables.get(0), drawables.get(1)};
        quests.add(new Quest("test", "test", 4, 1, strings1, effects1,nextQuests1, drawables2));
    }
}
