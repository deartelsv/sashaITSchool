package com.artelsv.sashaitschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    final static boolean DEBUG = false;

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
    //Buttons and events shit
    TextView textView;
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
    TextView statsInfo;
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
        TextView ifInvInfo;
    //Quest shit
    QuestLoader questLoader;
    QuestStore questStore;
    Quest curQuest;

    GifImageView gifImageView;

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
        initEvents();
        initQuestLoader();
        initFonts();
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

//        progressTimerTask = new ProgressTimerTask(progressTimer);
//        timer = new Timer();
//        timer.scheduleAtFixedRate(progressTimerTask,0,UPDATETIME);
    }
    /*      Обновление прогрессбара
    output: FALSE - не происходит переход на новую главу
            TRUE  - переход на новую главу              */
    private boolean updateProgress(){

        if (progressTimer.getProgress() >= progressTimer.getMax()){
            return true;
        } else {
            progressTimer.incrementProgressBy(1);
        }
        return false;
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
        items.add(newItem = new Item("tew1", "t1es", 1, 0, effects.get(0), getDrawable(R.drawable.slot_head), true));
        items.add(newItem = new Item("tew2", "t2es", 2, 0, effects.get(0), getDrawable(R.drawable.slot_chest), true));
        items.add(newItem = new Item("tew3", "t3es", 3, 0, effects.get(0), getDrawable(R.drawable.slot_feet), true));
        items.add(newItem = new Item("tew4", "4tes", 4, 0, effects.get(0), getDrawable(R.drawable.slot_mainhand), true));
        items.add(newItem = new Item("tew5", "t5es", 5, 0, effects.get(0), getDrawable(R.drawable.slot_head), true));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head), true));
        items.add(newItem = new Item("tew6", "Sasha tak soidet7", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head), false));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head), true));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head), true));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head), true));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head), true));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head), true));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head), true));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head), false));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head), false));
        items.add(newItem = new Item("tew6", "t6es", 6, 0, effects.get(0), getDrawable(R.drawable.slot_head),false));
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

        ifInvInfo = findViewById(R.id.invItemInfo);
        statsInfo = findViewById(R.id.textStats);

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

    private void initQuestLoader(){
        int[] drawables = {R.drawable.koster_main, R.drawable.podlojka};
        gifImageView = findViewById(R.id.gifImageView);

        questLoader = new QuestLoader(textView, button1, button2, button3, button4);
        questStore = new QuestStore(drawables, hero);

        questLoader.loadQuest(questStore.getQuests().get(0));
        curQuest = questStore.getQuests().get(0);
    }

    private void initEvents(){
        textView = findViewById(R.id.textView);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
    }

    private void initFonts(){
        Typeface type = Typeface.createFromAsset(getAssets(),"19190.ttf");
        textCoin.setTypeface(type);
        textHp.setTypeface(type);
        textPower.setTypeface(type);
//        textProtection.setTypeface(type);
        textView.setTypeface(type);
        ifItemDesc.setTypeface(type);
        ifItemName.setTypeface(type);
        button1.setTypeface(type);
        button2.setTypeface(type);
        button3.setTypeface(type);
        button4.setTypeface(type);
        ifInvInfo.setTypeface(type);
        statsInfo.setTypeface(type);
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

            /*     КНОПКИ ИВЕНТОВ И ОБРАБОТКА НАЖАТИЙ
            Переход на новые квесты и каст эффектов*/
            case R.id.button1: // 1 Button 1
                if (DEBUG) {
                    Log.e("test", hero.toString());
                    Log.e("test", items.get(0).toString());
                }

                updateProgress();
                if (progressTimer.getProgress() == 5){
                    textView.setText("");
                }

                curQuest.getEffects()[0].EffectCast(hero);
                updateStats();
                gifImageView.setImageResource(curQuest.getDrawables()[0]);
                questLoader.loadQuest(questStore.getQuests().get(curQuest.getNextQuestID()[0]));
                curQuest = questStore.getQuests().get(curQuest.getNextQuestID()[0]);
                break;
            case R.id.button2: // 2 Button 2
                if (DEBUG) {
                    Effect effect = new Effect("test", 2, 2);
                    effect.EffectCast(hero);
                    updateStats();
                }

                updateProgress();
                if (progressTimer.getProgress() == 5){
                    textView.setText("");
                }

                curQuest.getEffects()[1].EffectCast(hero);
                updateStats();
                gifImageView.setImageResource(curQuest.getDrawables()[1]);
                //gifImageView.setImageResource(R.drawable.test);
                questLoader.loadQuest(questStore.getQuests().get(curQuest.getNextQuestID()[1]));
                curQuest = questStore.getQuests().get(curQuest.getNextQuestID()[1]);

                break;
            case R.id.button3: // 3 Button 3
                if (DEBUG) {

                }

                updateProgress();
                if (progressTimer.getProgress() == 5){
                    textView.setText("");
                }

                curQuest.getEffects()[2].EffectCast(hero);
                updateStats();
                gifImageView.setImageResource(curQuest.getDrawables()[2]);
                questLoader.loadQuest(questStore.getQuests().get(curQuest.getNextQuestID()[2]));
                curQuest = questStore.getQuests().get(curQuest.getNextQuestID()[2]);
                break;
            case R.id.button4: // 4 Button 4
                if (DEBUG) {

                }

                updateProgress();
                if (progressTimer.getProgress() == 5){
                    textView.setText("");
                }

                curQuest.getEffects()[3].EffectCast(hero);
                updateStats();
                gifImageView.setImageResource(curQuest.getDrawables()[3]);
                questLoader.loadQuest(questStore.getQuests().get(curQuest.getNextQuestID()[3]));
                curQuest = questStore.getQuests().get(curQuest.getNextQuestID()[3]);
                break;
            //кнопки ивентов

            case R.id.shopButton:
                shopFrag.setVisibility(View.VISIBLE);
                inventoryFrag.setVisibility(View.INVISIBLE);
                break;
            case R.id.inventoryButton:
                shopFrag.setVisibility(View.INVISIBLE);
                inventoryFrag.setVisibility(View.VISIBLE);
                break;
            case R.id.sellButton:
                ia.removeAt(selectedItem, getDrawable(R.drawable.slot));
                Log.e("test","sellButton");
                break;
            case R.id.useItemButton:
                ia.selected_item = selectedItem;

                Log.e("test", "test");

        }

    }
}
