package com.artelsv.sashaitschool;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.artelsv.sashaitschool.creatures.Hero;
import com.artelsv.sashaitschool.creatures.effects.Effect;
import com.artelsv.sashaitschool.items.InvenotoryAdapter;

import java.util.ArrayList;

public class QuestStore {
    private ArrayList<Quest> quests;
    private int[] drawables;
    private Hero hero;

    public QuestStore() {
        init();
    }

    public QuestStore(int[] drawables, Hero hero) {
        this.drawables = drawables;
        this.hero = hero;

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
        Effect nothing = new Effect("nothing", 0, 1);

        String[] strings = {"В путь!", "", "", ""};
        Effect[] effects = {new Effect("nothing", 0, 2), new Effect("nothing", 0, 2), new Effect("nothing", 0, 2), new Effect("nothing", 0, 2)};
        Integer[] nextQuests = {1, 1, 1, 1};
        int[] drawables1 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("ГЛАВА 1.", " - Не раздумывая главный герой достает свой походный мешок, который завалялся в самом темном уголке. Кладет туда карту, отмеченную ярко красным крестом. Горсть медных монет и столовый нож, чтобы отбиваться от злостных похитителей.\n" +
                "Присев на дорожку и вспомнив все то что с ним происходило в жизни, мысленно резко перечеркнул все, вздохнул и отправился в путь.", 1, 1, strings, effects, nextQuests, drawables1));

        String[] strings1 = {"Согласиться", "Отказаться", "Пройти мимо", "Стукнуть его"};
        Effect[] effects1 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests1 = {2, 13, 2, 2};
        int[] drawables2 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Высокий статный мужчина в пальто", "- \"Откуда не возьмись перед вами появлятся загадочный мужчина.  \"Здраствствуй, путник, меня называют высоким статным мужчиной в пальто! Если выполнишь мою просьбу,то в замен предлжу тебе что-то интересное\" - говорит он.", 4, 1, strings1, effects1,nextQuests1, drawables2));

        String[] strings2 = {"Дальше", "", " ", ""};
        Effect[] effects2 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests2 = {3, 3, 3, 3};
        int[] drawables3 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Принятия просьбы", "\"Достаточно приятно встретить такого добродушного путника в данных краях. Знаешь дед мой когда-то говорил, что всегда найдется человек , который поможет мне в трудную минуту.\n" +
                "Ну, что же  перейдем к делу! Недавно на меня напала свора ужасных разбойников. Мне пришлось отдать им свои кровные, но это не самое страшное.Одному из грязных оборванцев понравился мое пальто, а это для меня святое. Я боролся как мог, но они меня стукнули палкой и дело с концом.\n" +
                "Прошу добрый путник, помоги мне вернуть его обратно, иначе жизнь моя прервратится в ничто. В замен я конечно как и обещал предложу кое-что интересное.", 1, strings2, effects2, nextQuests2, drawables3));

        String[] strings3 = {"Сбежать", "Отдать деньги", "Сражаться", ""}; //3
        Effect[] effects3 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests3 = {4, 5, 6, 4}; // развлетвление
        int[] drawables4 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Разборка с разбойниками", "-Указав мне путь я смирно пошел выполнять обещянное. Не прошло и 10 минут как я добрался до разбойников", 3, strings3, effects3, nextQuests3, drawables4));

        String[] strings4 = {"Побег", "", "", ""}; //4
        Effect[] effects4 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests4 = {7, 7, 7, 7};
        int[] drawables5 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Сбежать", "-К сожалению вы расстроили нашего статного мужчину и теперь не увидите его никогда. Продолжайте свой путь", 1, strings4, effects4, nextQuests4, drawables5));

        String[] strings5 = {"Гордо уйти", "", "", ""}; //5 e
        Effect[] effects5 = {new Effect("money", -hero.getMoney(), 2), nothing, nothing, nothing};
        Integer[] nextQuests5 = {7, 7, 7, 7};
        int[] drawables6 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Отдать деньги", "-Отдав все монеты, вы гордо подняв голову, продолжили свой путь", 1, strings5, effects5, nextQuests5, drawables6));

        String[] strings6 = {"1", "2", "3", ""}; //6
        Effect[] effects6 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests6 = {7, 8, 9, 7}; // развлетвление
        int[] drawables7 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Драться", "-Вы стоите перед разбойниками и вам ничего не остается, кроме того, что бы применить один из 3 секретных приемов. Делайте выбор с умом.", 3, strings6, effects6, nextQuests6, drawables7));

        String[] strings7 = {"Дальше", "", "", ""}; //7 e
        Effect[] effects7 = {new Effect(10,2), nothing, nothing, nothing};
        Integer[] nextQuests7 = {10, 7, 7, 7};
        int[] drawables8 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Секретный прием №1", "-\"Потянув ручки в свой огромный мешок, вы достаете маленький столовый нож. Увидев это, разбойники начали визжать, отдавая все что у них есть.\"", 1, strings7, effects7, nextQuests7, drawables8));

        String[] strings8 = {"Дальше", "", "", ""}; //8
        Effect[] effects8 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests8 = {11, 7, 7, 7};
        int[] drawables9 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Секретный прием №2", "-Кажется на вас упала ветка и вы потеряли сознания, а также часть своего здоровья, но за ты вы кажется остались живы и без медняков. Поздравляю!", 1, strings8, effects8, nextQuests8, drawables9));

        String[] strings9 = {"Дальше", "", "", ""}; //9
        Effect[] effects9 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests9 = {12, 7, 7, 7};
        int[] drawables10 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Секретный прием №3", "-Не повезло, не фортануло, потому что вас затыкали палкой. Конец игры", 1, strings9, effects9, nextQuests9, drawables10));

        String[] strings10 = {"Дальше", "", "", ""}; //10
        Effect[] effects10 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests10 = {7, 7, 7, 7};
        int[] drawables11 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Возращение пальто", "-Мы победили разбойников, забрали пальто нашего прекрасного товарища и теперь мы можем закупаться зельями в магазине", 1, strings10, effects10, nextQuests10, drawables11));

        String[] strings11 = {"Дальше", "", "", ""}; //11
        Effect[] effects11 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests11 = {7, 7, 7, 7};
        int[] drawables12 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Падение палки", "-Мы пошли с пустыми руками к статному мужчине и все ему рассказали. На что он пожалел нас и сказал, что с ним такое часто бывает. Затем вы попрощались.", 1, strings11, effects11, nextQuests11, drawables12));

        String[] strings12 = {"", "", "", ""}; //12
        Effect[] effects12 = {new Effect("die", -hero.getHp(), 1), nothing, nothing, nothing};
        Integer[] nextQuests12 = {7, 7, 7, 7};
        int[] drawables13 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Смерть из-за палок", "-К сожалению ваш персонаж погиб из-за гнусных воров. Конец игры.", 1, strings12, effects12, nextQuests12, drawables13));

        //отказаться

        String[] strings13 = {"Дальше", "", "", ""}; //13
        Effect[] effects13 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests13 = {7, 7, 7, 7};
        int[] drawables14 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Отказ в просьбе", "-Статный мужчин пожав плечами произнес \"Жизнь дана на добрые дела, прощай путник\" и внезапно исчезает. А я продолжаю свою дорогу.", 1, strings13, effects13, nextQuests13, drawables14));

        String[] strings14 = {"Игнорировать", "", "", ""}; //14
        Effect[] effects14 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests14 = {15, 7, 7, 7};
        int[] drawables15 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Пройти мимо", "-Вы просто проходите мимо не обращая внимания", 1, strings14, effects14, nextQuests14, drawables15));

        String[] strings15 = {"1", "2", "3", ""}; //15
        Effect[] effects15= {nothing, nothing, nothing, nothing};
        Integer[] nextQuests15 = {16, 17, 18, 7};
        int[] drawables16= {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Смерть от падения", "-Внезапно вы спотыкаетесь \n С помощью своих навыков равновесия вы:", 1, strings15, effects15, nextQuests15, drawables16));

        String[] strings16 = {"Дальше", "", "", ""}; //16
        Effect[] effects16= {nothing, nothing, nothing, nothing};
        Integer[] nextQuests16 = {7, 7, 7, 7};
        int[] drawables17= {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Смерть от падения", "-Внезапно вы спотыкаетесь \n С помощью своих навыков равновесия вы:", 1, strings16, effects16, nextQuests16, drawables17));

        String[] strings17 = {"Дальше", "", "", ""}; //16
        Effect[] effects17= {nothing, nothing, nothing, nothing};
        Integer[] nextQuests17 = {7, 7, 7, 7};
        int[] drawables18= {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Смерть от падения", "-Внезапно вы спотыкаетесь \n С помощью своих навыков равновесия вы:", 1, strings16, effects16, nextQuests16, drawables17));

        String[] strings50 = {"Дальше", "", "", ""}; //16
        Effect[] effects50= {nothing, nothing, nothing, nothing};
        Integer[] nextQuests50 = {7, 7, 7, 7};
        int[] drawables51= {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Смерть", "-Внезапно вы спотыкаетесь \n С помощью своих навыков равновесия вы:", 1, strings16, effects16, nextQuests16, drawables17));
    }
}


