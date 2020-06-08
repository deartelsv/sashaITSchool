package com.artelsv.Gat;

import android.widget.ProgressBar;

import java.util.TimerTask;

public class ProgressTimerTask extends TimerTask {
    private final int STEP = 1;

    private ProgressBar progressTimer;
    public ProgressTimerTask(ProgressBar progressTimer){
        this.progressTimer = progressTimer;
        //test();
    }

    private void test(){
        progressTimer.incrementProgressBy(50);
    }

    @Override
    public void run() {
        progressTimer.incrementProgressBy(STEP);
    }
}
