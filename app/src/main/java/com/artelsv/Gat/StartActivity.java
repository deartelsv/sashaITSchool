package com.artelsv.Gat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    private int currentApiVersion;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) { //Скрытие копок,возможность достать
        super.onWindowFocusChanged(hasFocus);
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT && hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                    View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    private void initHideButtonsBar(){  //Скрытие кнопок телефона
        currentApiVersion = android.os.Build.VERSION.SDK_INT;
        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT) {
            getWindow().getDecorView().setSystemUiVisibility(flags);
            final View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                @Override
                public void onSystemUiVisibilityChange(int visibility) {
                    if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                        decorView.setSystemUiVisibility(flags);
                    }
                }
            });
        }
    } // НЕТРОГАТЬ

    TextView startText;

    final Animation in = new AlphaAnimation(0.0f, 1.0f); //Анимация букав свет-в тень
    final Animation out = new AlphaAnimation(1.0f, 0.0f);

    Boolean test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        initHideButtonsBar();

        startText = findViewById(R.id.textView5);
        Typeface type = Typeface.createFromAsset(getAssets(),"19190.ttf");
        startText.setTypeface(type);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        test = false;


//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
    }

    public void startActiveClick(View view){ //Обработчик нажатий на активность
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (test == true) {
            skip();
        }

        in.setDuration(3000);// длительность появления и исчезания текста


        out.setDuration(3000);
        out.setRepeatMode(0);

        out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startText.setAlpha(0f);
                startText.setTextSize(18);
                startText.setText("Неизвестно какой век, год, время, местоположение.\n" +
                        "Это история будет рассказывать нам о сам простом человеке, что усомнился в своей жизни и потерял смысл своего существования.\n" +
                        "Он бросает все и отправляется в далекое путешествие на поиски того, что может хоть как-то возобновить ее.");
                startText.setAlpha(1f);
                startText.startAnimation(in);

                test = true;

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        startText.setAnimation(out);
        //startText.setAlpha(0f);
        if (test == false) {
            startText.setText("ГАТЬ");
        }
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
    }

    private void skip(){ //След.активность
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
