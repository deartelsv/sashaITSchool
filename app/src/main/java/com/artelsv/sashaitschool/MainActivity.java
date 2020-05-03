package com.artelsv.sashaitschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.artelsv.sashaitschool.creatures.Hero;
import com.artelsv.sashaitschool.creatures.effects.Effect;

import java.util.ArrayList;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    //Timer Vars
    private final int UPDATETIME = 1000; //в миллесекундах
    ProgressBar progressTimer;
    ProgressTimerTask progressTimerTask;
    Timer timer;
    //
    //Hero
    Hero hero;
    //
    //Effects
    ArrayList<Effect> effects;
    //
    //Buttons
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    //
    //Fragment TextViews
    TextView textCoin;
    TextView textPower;
    TextView textProtection;
    TextView textHp;
    //
    //Inventory
    RecyclerView inventory_store;
    LinearLayoutManager gm;
    InvenotoryAdapter ia;

    //Fragments (это крч кастыль. Можно было умнее сделать. Но так проще)
    View inventoryFrag;
    View shopFrag;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //progressTimer.incrementProgressBy(25);
        startTimer();
    }

    private void startTimer(){

    }
    //init
    private void init(){
        initProgressTimer();
        initHero();
        initEffects();
        initFragmentTextViews();
        initInventoryStore();
        initFragments();
    }

    private void initProgressTimer(){ //Ход времени в игре

        progressTimer = findViewById(R.id.progressBar);
        progressTimerTask = new ProgressTimerTask(progressTimer);
        timer = new Timer();
        timer.scheduleAtFixedRate(progressTimerTask,0,UPDATETIME);
    }

    private void initHero(){
        hero = new Hero("Adventure", "тест", 10, 10, 1, 1);
    }

    private void initEffects(){
        effects = new ArrayList<Effect>();
        Effect effect = new Effect("Beat", 2, 2);
        effects.add(effect);
        effects.get(0).EffectCast(hero);
    }

    private void initFragmentTextViews(){
        textCoin = findViewById(R.id.textCoin);
        textHp = findViewById(R.id.textHp);
        textPower = findViewById(R.id.textPower);
        textProtection = findViewById(R.id.textProtection);
    }

    private void initInventoryStore(){
        inventory_store = findViewById(R.id.inventory_store);
        gm = new GridLayoutManager(this,2);
        inventory_store.setLayoutManager(gm);
        inventory_store.setHasFixedSize(true);
        ia = new InvenotoryAdapter(20);
        inventory_store.setAdapter(ia);

    }

    private void initFragments(){
        inventoryFrag = findViewById(R.id.fragmentInventory);
        shopFrag = findViewById(R.id.fragmentShop);

        shopFrag.setVisibility(View.INVISIBLE);
    }
    //
    //inGame
    private void updateStats(){
        textCoin.setText(hero.getMoney().toString());
        textProtection.setText(hero.getProtection().toString());
        textPower.setText(hero.getPower().toString());
        textHp.setText(hero.getHp().toString());
    }
    //

    //click listener
    public void button1Click(View view) { // чекаем нажатие кнопок
        switch (view.getId()){
            case R.id.button1: // 1
                Log.e("test",hero.toString());
                break;
            case R.id.button2: // 2
                effects.get(0).EffectCast(hero);
                updateStats();
                break;
            case R.id.button3: // 3

                break;
            case R.id.button4: // 4
                break;
            case R.id.shopButton:
                shopFrag.setVisibility(View.VISIBLE);
                inventoryFrag.setVisibility(View.INVISIBLE);
                break;
            case R.id.inventoryButton:
                shopFrag.setVisibility(View.INVISIBLE);
                inventoryFrag.setVisibility(View.VISIBLE);
                break;

        }

    }
}
