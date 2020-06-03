package com.artelsv.sashaitschool;

import com.artelsv.sashaitschool.creatures.Hero;
import com.artelsv.sashaitschool.creatures.effects.Effect;

public class Quest {
    private String name;
    private String description;
    private Integer countOfAnswers;
    private Integer rightAnswer;
    private String[] answersText;
    private Effect[] effects;
    private Integer[] nextQuestID;


    public Quest(String name, String description, Integer countOfAnswers, Integer rightAnswer, String[] answersText, Effect[] effects, Integer[] nextQuestID) {
        this.name = name;
        this.description = description;
        this.countOfAnswers = countOfAnswers;
        this.rightAnswer = rightAnswer;
        this.answersText = answersText;
        this.effects = effects;
        this.nextQuestID = nextQuestID;

        init();
    }

    public Quest(String name, String description, Integer countOfAnswers, String[] answersText, Effect[] effects, Integer[] nextQuestID) {
        this.name = name;
        this.description = description;
        this.countOfAnswers = countOfAnswers;
        this.answersText = answersText;
        this.effects = effects;
        this.nextQuestID = nextQuestID;
    }

    private void init(){

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCountOfAnswers() {
        return countOfAnswers;
    }

    public Integer getRightAnswer() {
        return rightAnswer;
    }

    public String[] getAnswersText() {
        return answersText;
    }

    public Effect[] getEffects() {
        return effects;
    }

    public Integer[] getNextQuestID() {
        return nextQuestID;
    }

    public boolean setAnswer(byte answer, Hero hero){
        boolean ret = false;
        switch (answer){
            case 1:
                if (answer == rightAnswer) {
                    ret = true;
                    effects[0].EffectCast(hero);
                }
                break;
            case 2:
                if (answer == rightAnswer) {
                    ret = true;
                    effects[1].EffectCast(hero);
                }
                break;
            case 3:
                if (answer == rightAnswer) {
                    ret = true;
                    effects[2].EffectCast(hero);
                }
                break;
            case 4:
                if (answer == rightAnswer) {
                    ret = true;
                    effects[3].EffectCast(hero);
                }
                break;
        }

        return ret;
    }
}
