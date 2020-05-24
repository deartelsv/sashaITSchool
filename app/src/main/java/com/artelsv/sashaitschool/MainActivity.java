package com.artelsv.sashaitschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.artelsv.sashaitschool.creatures.Hero;
import com.artelsv.sashaitschool.creatures.effects.Effect;
import com.artelsv.sashaitschool.creatures.effects.EffectsStore;
import com.artelsv.sashaitschool.items.InvenotoryAdapter;
import com.artelsv.sashaitschool.items.Item;
import com.artelsv.sashaitschool.items.ItemsStore;

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
    //Shop
    RecyclerView shop_store;
    LinearLayoutManager gm_2;
    InvenotoryAdapter ia_2;
    //all items and effects
    ArrayList<Item> items;
    ArrayList<Effect> effects;
    //
    //Fragments (это крч кастыль. Можно было умнее сделать. Но так проще)
    View inventoryFrag;
    View shopFrag;
        //Fragments views
        Integer selectedItem;

        ImageButton sellItem;

        TextView ifItemName;
        TextView ifItemDesc;
    //
    private int currentApiVersion;

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
        initHideButtonsBar();
        initProgressTimer();
        initHero();
        initEffects();
        initItems();
        initFragmentTextViews();
        initInventoryStore();
        initShopStore();
        initFragments();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (currentApiVersion >= Build.VERSION_CODES.KITKAT && hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                    View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    } // НЕТРОГАТЬ БЛЯТЬ 2

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
        Effect newEffect;
        effects.add(newEffect = new Effect("heal", 1, 1));
        //Effects init

    }

    private void initItems(){ // Загрузка итемов
        items = new ArrayList<Item>();

        Item newItem;
        items.add(newItem = new Item("tew1", "t1es", 1, 0, effects.get(0), getDrawable(R.drawable.slot_head)));
        items.add(newItem = new Item("tew2", "t2es", 2, 0, effects.get(0), getDrawable(R.drawable.slot_chest)));
        items.add(newItem = new Item("tew3", "t3es", 3, 0, effects.get(0), getDrawable(R.drawable.slot_feet)));
        items.add(newItem = new Item("tew4", "4tes", 4, 0, effects.get(0), getDrawable(R.drawable.slot_mainhand)));
        items.add(newItem = new Item("tew5", "t5es", 5, 0, effects.get(0), getDrawable(R.drawable.slot_head)));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head)));
        items.add(newItem = new Item("tew6", "Sasha tak soidet7", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head)));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head)));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head)));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head)));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head)));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head)));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head)));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head)));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head)));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head)));
    }

    private void initHideButtonsBar(){
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
    } // НЕТРОГАТЬ БЛЯТЬ

    private void initFragmentTextViews(){
        textCoin = findViewById(R.id.textCoin);
        textHp = findViewById(R.id.textHp);
        textPower = findViewById(R.id.textPower);

        //inventory fragment
        ifItemDesc = findViewById(R.id.textView3);
        ifItemName = findViewById(R.id.textView4);
        sellItem = findViewById(R.id.sellButton);
    }

    private void initInventoryStore(){
        inventory_store = findViewById(R.id.inventory_store);
        gm = new GridLayoutManager(this,2);
        inventory_store.setLayoutManager(gm);
        inventory_store.setHasFixedSize(true);
        ia = new InvenotoryAdapter(items);
        inventory_store.setAdapter(ia);

        inventory_store.addOnItemTouchListener(new RecyclerTouchListener(this, inventory_store, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Log.e("test", String.valueOf(position));
                Log.e("test", items.get(position).toString());
                ifItemName.setText(items.get(position).getName());
                ifItemDesc.setText(items.get(position).getDesc());
                selectedItem = position;

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void initShopStore(){
        shop_store = findViewById(R.id.shop_store);
        gm_2 = new GridLayoutManager(this,2);
        shop_store.setLayoutManager(gm_2);
        shop_store.setHasFixedSize(true);
        ia_2 = new InvenotoryAdapter(items);
        shop_store.setAdapter(ia_2);

        shop_store.addOnItemTouchListener(new RecyclerTouchListener(this, shop_store, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Log.e("test", String.valueOf(position));
                Log.e("test", items.get(position).toString());
                ifItemName.setText(items.get(position).getName());
                ifItemDesc.setText(items.get(position).getDesc());
                selectedItem = position;

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
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
        textPower.setText(hero.getPower().toString());
        textHp.setText(hero.getHp().toString());
    }
    //

    //click listener
    public void button1Click(View view) { // чекаем нажатие кнопок
        switch (view.getId()){
            case R.id.button1: // 1
                Log.e("test",hero.toString());
                Log.e("test", items.get(0).toString());
                break;
            case R.id.button2: // 2
                Effect effect = new Effect("test", 2, 2);
                effect.EffectCast(hero);
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
            case R.id.sellButton:
                ia.removeAt(selectedItem, getDrawable(R.drawable.slot_secondaryhand));
                Log.e("test","sellButton");
                break;
        }

    }
}
