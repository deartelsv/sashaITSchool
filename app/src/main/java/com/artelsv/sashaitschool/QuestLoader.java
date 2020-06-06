package com.artelsv.sashaitschool;

import android.widget.Button;
import android.widget.TextView;

public class QuestLoader {
    private TextView textView;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    public QuestLoader(TextView textView, Button button1, Button button2, Button button3, Button button4) {
        this.textView = textView;

        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.button4 = button4;
    }

    public void loadQuest(Quest quest) {

        if (quest.getCountOfAnswers() == 1){
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);

            button2.setAlpha(0.5f);
            button3.setAlpha(0.5f);
            button4.setAlpha(0.5f);
        }

        if (quest.getCountOfAnswers() == 2){
            button2.setEnabled(true);
            button3.setEnabled(false);
            button4.setEnabled(false);

            button2.setAlpha(1f);
            button3.setAlpha(0.5f);
            button4.setAlpha(0.5f);
        }

        if (quest.getCountOfAnswers() == 3){
            button2.setEnabled(true);
            button3.setEnabled(true);
            button4.setEnabled(false);

            button2.setAlpha(1f);
            button3.setAlpha(1f);
            button4.setAlpha(0.5f);
        }

        if (quest.getCountOfAnswers() == 4){
            button2.setEnabled(true);
            button3.setEnabled(true);
            button4.setEnabled(true);

            button2.setAlpha(1f);
            button3.setAlpha(1f);
            button4.setAlpha(1f);
        }

        textView.append(quest.getName()+"\n"+quest.getDescription()+"\n"+"---"+"\n");
        button1.setText(quest.getAnswersText()[0]);
        button2.setText(quest.getAnswersText()[1]);
        button3.setText(quest.getAnswersText()[2]);
        button4.setText(quest.getAnswersText()[3]);
    }
}
