package com.artelsv.sashaitschool;

import com.artelsv.sashaitschool.creatures.Hero;

public class Quest {
    private String name;
    private String description;
    private byte countOfAnswers;
    private byte rightAnswer;
    private String[] answersText;
    private int[] effects;


    public Quest(String name, String description, byte countOfAnswers, byte rightAnswer, String[] answersText, int[] effects) {
        this.name = name;
        this.description = description;
        this.countOfAnswers = countOfAnswers;
        this.rightAnswer = rightAnswer;
        this.answersText = answersText;
        this.effects = effects;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public byte getCountOfAnswers() {
        return countOfAnswers;
    }

    public byte getRightAnswer() {
        return rightAnswer;
    }

    public boolean setAnswer(byte answer, Hero hero){
        switch (answer){
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }

        return true;
    }
}
