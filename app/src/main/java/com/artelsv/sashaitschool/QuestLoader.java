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
        textView.setText(quest.getName()+"\n"+quest.getDescription());
        button1.setText(quest.getAnswersText()[0]);
        button2.setText(quest.getAnswersText()[1]);
        button3.setText(quest.getAnswersText()[2]);
        button4.setText(quest.getAnswersText()[3]);
    }
}
