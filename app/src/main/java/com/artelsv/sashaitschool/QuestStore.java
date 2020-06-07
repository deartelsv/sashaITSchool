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

        //НАЧАЛО


        String[] strings = {"В путь!", "", "", ""};
        Effect[] effects = {new Effect("nothing", 0, 2), new Effect("nothing", 0, 2), new Effect("nothing", 0, 2), new Effect("nothing", 0, 2)};
        Integer[] nextQuests = {1, 1, 1, 1};
        int[] drawables1 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("ГЛАВА 1.", " - Не раздумывая главный герой достает свой походный мешок, который завалялся в самом темном уголке. Кладет туда карту, отмеченную ярко красным крестом. Горсть медных монет и столовый нож, чтобы отбиваться от злостных похитителей.\n" +
                "Присев на дорожку и вспомнив все то что с ним происходило в жизни, мысленно резко перечеркнул все, вздохнул и отправился в путь.", 1, 1, strings, effects, nextQuests, drawables1));

        //1 КВЕСТ
        //Высокий статный мужчина
        String[] strings1 = {"Согласиться", "Отказаться", "Пройти мимо", "Стукнуть его"};
        Effect[] effects1 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests1 = {2, 13, 14, 16};
        int[] drawables2 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Высокий статный мужчина в пальто", "- \"Откуда не возьмись перед вами появлятся загадочный мужчина.  \"Здраствствуй, путник, меня называют высоким статным мужчиной в пальто! Если выполнишь мою просьбу,то в замен предлжу тебе что-то интересное\" - говорит он.", 4, 1, strings1, effects1,nextQuests1, drawables2));

        //Высокий статный мужчина, принятие
        String[] strings2 = {"Дальше", "", " ", ""};
        Effect[] effects2 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests2 = {3, 3, 3, 3};
        int[] drawables3 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Принятия просьбы", "\"Достаточно приятно встретить такого добродушного путника в данных краях. Знаешь дед мой когда-то говорил, что всегда найдется человек , который поможет мне в трудную минуту.\n" +
                "Ну, что же  перейдем к делу! Недавно на меня напала свора ужасных разбойников. Мне пришлось отдать им свои кровные, но это не самое страшное.Одному из грязных оборванцев понравился мое пальто, а это для меня святое. Я боролся как мог, но они меня стукнули палкой и дело с концом.\n" +
                "Прошу добрый путник, помоги мне вернуть его обратно, иначе жизнь моя прервратится в ничто. В замен я конечно как и обещал предложу кое-что интересное.", 1, strings2, effects2, nextQuests2, drawables3));


        //Разборка с разбойниками
        String[] strings3 = {"Сбежать", "Отдать деньги", "Сражаться", ""}; //3
        Effect[] effects3 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests3 = {4, 5, 6, 4}; // развлетвление
        int[] drawables4 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Разборка с разбойниками", "-Указав мне путь я смирно пошел выполнять обещянное. Не прошло и 10 минут как я добрался до разбойников", 3, strings3, effects3, nextQuests3, drawables4));

        //побег
        String[] strings4 = {"Продолжить путь", "", "", ""}; //4
        Effect[] effects4 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests4 = {18, 7, 7, 7};
        int[] drawables5 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Сбежать", "-К сожалению вы расстроили нашего статного мужчину и теперь не увидите его никогда. Продолжайте свой путь", 1, strings4, effects4, nextQuests4, drawables5));

        //Отдать монеты
        String[] strings5 = {"Гордо уйти", "", "", ""}; //5 e
        Effect[] effects5 = {new Effect("money", -hero.getMoney(), 2), nothing, nothing, nothing};
        Integer[] nextQuests5 = {18, 7, 7, 7};
        int[] drawables6 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Отдать деньги", "-Отдав все монеты, вы гордо подняв голову, продолжили свой путь", 1, strings5, effects5, nextQuests5, drawables6));

        //Битыва
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

        String[] strings8 = {"Дальше", "", "", ""}; //8 e
        Effect[] effects8 = {new Effect(-hero.getHp()/2,-hero.getMoney(),1,2), nothing, nothing, nothing};
        Integer[] nextQuests8 = {11, 7, 7, 7};
        int[] drawables9 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Секретный прием №2", "-Кажется на вас упала ветка и вы потеряли сознания, а также часть своего здоровья, но за ты вы кажется остались живы и без медняков. Поздравляю!", 1, strings8, effects8, nextQuests8, drawables9));

        String[] strings9 = {"Дальше", "", "", ""}; //9 e
        Effect[] effects9 = {new Effect("die", -hero.getHp(), 1), nothing, nothing, nothing};
        Integer[] nextQuests9 = {17, 7, 7, 7};
        int[] drawables10 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Секретный прием №3", "-Не повезло, не фортануло, потому что вас затыкали палкой. Конец игры", 1, strings9, effects9, nextQuests9, drawables10));

        //После битывы
        String[] strings10 = {"Дальше", "", "", ""}; //10 e
        Effect[] effects10 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests10 = {18, 7, 7, 7};
        int[] drawables11 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Возращение пальто", "-Мы победили разбойников, забрали пальто нашего прекрасного товарища и теперь мы можем закупаться зельями в магазине", 1, strings10, effects10, nextQuests10, drawables11));

        String[] strings11 = {"Дальше", "", "", ""}; //11
        Effect[] effects11 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests11 = {18, 7, 7, 7};
        int[] drawables12 = {drawables[0], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Падение палки", "-Мы пошли с пустыми руками к статному мужчине и все ему рассказали. На что он пожалел нас и сказал, что с ним такое часто бывает. Затем вы попрощались.", 1, strings11, effects11, nextQuests11, drawables12));

        String[] strings12 = {"", "", "", ""}; //12
        Effect[] effects12 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests12 = {17, 7, 7, 7};
        int[] drawables13 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Смерть из-за палок", "-К сожалению ваш персонаж погиб из-за гнусных воров. Конец игры.", 1, strings12, effects12, nextQuests12, drawables13));


        //Отказать статному мужчине
        String[] strings13 = {"Продолжить путь", "", "", ""}; //13
        Effect[] effects13 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests13 = {18, 7, 7, 7};
        int[] drawables14 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Отказ в просьбе", "-Статный мужчин пожав плечами произнес \"Жизнь дана на добрые дела, прощай путник\" и внезапно исчезает. А я продолжаю свою дорогу.", 1, strings13, effects13, nextQuests13, drawables14));

        //Пройти мимо статного мужчины
        String[] strings14 = {"Продолижть путь", "", "", ""}; //14
        Effect[] effects14 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests14 = {15, 7, 7, 7};
        int[] drawables15 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Пройти мимо", "-Вы просто проходите мимо не обращая внимания", 1, strings14, effects14, nextQuests14, drawables15));

        //Падение
        String[] strings15 = {"Продолжить путь", "", "", ""}; //15
        Effect[] effects15 = {new Effect(-5,1), nothing, nothing, nothing};
        Integer[] nextQuests15 = {18, 7, 7, 7};
        int[] drawables16 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Падения", "-Внезапно вы спотыкаетесь и получайте незначительный урон. Вот что делает с людьми невнимательность.", 1, strings15, effects15, nextQuests15, drawables16));

        //Неудачная битва
        String[] strings16 = {"Дальше", "", "", ""}; //16
        Effect[] effects16 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests16 = {18, 7, 7, 7};
        int[] drawables17 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Неудачная битва", "-Вы медленно достаете свое оружие из мешка и начинаете махать перед носом вашего оппонента. На что он странно смотрит на вас, разварачивается и уходит в даль. Вы стоите в недоумении несколько минут, а затем вновь продолжайте свой путь как-будто ничего и не было.", 1, strings16, effects16, nextQuests16, drawables17));

        //СМЕРТЬ
        String[] strings17 = {"Начать заново", "", "", ""}; //17
        Effect[] effects17 = {new Effect(1, 6), nothing, nothing, nothing, nothing, nothing, nothing};
        Integer[] nextQuests17 = {0, 0, 0, 0};
        int[] drawables18 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Смерть", "-Конец игры", 1, strings17, effects17, nextQuests17, drawables18));

        //ПОБОЧНЫЙ КВЕСТ
        String[] strings18 = {"Отдых", "Путь", "", ""}; //18
        Effect[] effects18 = {new Effect(1,7), nothing, nothing, nothing};
        Integer[] nextQuests18 = {19, 19, 7, 7};
        int[] drawables19 = {drawables[0], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Путь", "-Восстановить силы или продолжить?! ", 2, strings18, effects18, nextQuests18, drawables19));

        String[] strings19 = {"Дальше", "", "", ""}; //19
        Effect[] effects19 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests19 = {20, 7, 7, 7};
        int[] drawables20 = {drawables[0], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Путь", "-Вы Продолжайте путь", 1, strings19, effects19, nextQuests19, drawables20));





        //2 КВЕСТ
        //Дождливый день
        String[] strings20 = {"Дальше", "", "", ""}; //20
        Effect[] effects20 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests20 = {21, 7, 7, 7};
        int[] drawables21 = {drawables[0], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Дождливый день", "-Ничто не предвещало беды. Была хорошая погода, бабочки летали птички пели. Но вдруг что-то капнуло на меня! И как из ведра полил дождь. Нужно было найти укрытие. Рядом со мной начинался лес и я пошел туда.", 1, strings20, effects20, nextQuests20, drawables21));

        //Встреча с рыцарем в покоцанных доспехах
        String[] strings21 = {"Заговорить", "Убежать", "", ""}; //21
        Effect[] effects21 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests21 = {22, 29, 7, 7};
        int[] drawables22 = {drawables[0], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Встреча с рыцарем в покоцанных доспехах", "-Бродя по лесу я наткнулся небольшой домишко.Что ж выбора у меня не было и я зашел внутрь.В доме около затухающего камина, я увидел человека облаченного в доспехи.", 2, strings21, effects21, nextQuests21, drawables22));

        //Заговорить
        String[] strings22 = {"Ожидание ответа", "", "", ""}; //22
        Effect[] effects22 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests22 = {23, 7, 7, 7};
        int[] drawables23 = {drawables[0], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Разговор с рыцарем", "-Посмотрев на него , я испытал какую-то жалость и печаль..\n" + "Небольшой разваливающийся дом в котором тихо тлел камин, а перед ним сидел так тяжко человек... Я поздаровался, но в ответ было лишь молчание..\n" +
                "Но я не сдался и присев рядом с ним, я ждал, ждал того, что он заговорит.\n" + "Так и случилось, он рассказал свою историю -  историю о славной службе королю. Как тот сделал ему величественный подарок в знак его верности перед королевством, который рыцарь бережно прятал от других глаз. Но его предали и выкинули, как несчастную собаку из дома, а тот подарок так и остался спрятан от мира сего.\n" +
                "\n" + "Услышав эту историю, я предложил ему свою помощь.\n.", 1, strings22, effects22, nextQuests22, drawables23));

        //Успокоение
        String[] strings23 = {"Отправляемся!", "", "", ""}; // 23
        Effect[] effects23 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests23 = {24, 7, 7, 7};
        int[] drawables24 = {drawables[0], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Успокоение", "-Повернувшись ко мне рыцарь, посмеялся и заплакал. А я сидевший рядом в недоумении лишь тихо побил его по плечу, как обычно это делал мне отец. \n" +
                "Ранним утром, мы собрались и отправились к королевству, в котором служил наш рыцарь.\"", 1, strings23, effects23, nextQuests23, drawables24));

        //Повозка
        String[] strings24 = {"Помочь", "Пройти мимо", "", ""}; // 24
        Effect[] effects24 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests24 = {25, 26, 7, 7};
        int[] drawables25 = {drawables[0], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Повозка", "-Пошагивая с рыцарем по узкой тропинке, мы встретили тележку,что медленно тащил за собой человек", 2, strings24, effects24, nextQuests24, drawables25));

        //Помочь
        String[] strings25 = {"Дальше", "", "", ""}; // 25
        Effect[] effects25 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests25 = {26, 7, 7, 7};
        int[] drawables26 = {drawables[0], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Помощь", "-\"Рыцарь поглядел на меня и понял, что я собираюсь сделать.Хотел было меня уже обогнать, но я первый приуспел. Человек был несказанно рад, что мы решили ему помочь.\"", 1, strings25, effects25, nextQuests25, drawables26));

        //Конец помощи человеку
        String[] strings26 = {"Дальше", "", "", ""}; // 26 e
        Effect[] effects26 = {new Effect(5,2), nothing, nothing, nothing};
        Integer[] nextQuests26 = {27, 7, 7, 7};
        int[] drawables27= {drawables[0], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Прибытие", "-\"Путь был достаточно небольшой и мы управились за пару часов. В благодарность , человек подкинул мне пару медняков, но я взял лишь половину из того, что он мне дал. Затем мы продожили путь, а дальше решили отдохнуть.", 1, strings26, effects26, nextQuests26, drawables27));


        //Пройти мимо
        String[] strings27 = {"Дальше", "", "", ""}; // 27
        Effect[] effects27= {nothing, nothing, nothing, nothing};
        Integer[] nextQuests27 = {28, 7, 7, 7};
        int[] drawables28 = {drawables[0], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("И что?", "-Не обращая внимания мы прошли мимо.\nВесь день мы шли, шли, бывало что сворачивали не туда и возращались. ", 1, strings27, effects27, nextQuests27, drawables28));

        //Прибытие
        String[] strings28 = {"Дальше", "", "", ""}; // 28
        Effect[] effects28 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests28 = {30, 7, 7, 7};
        int[] drawables29 = {drawables[0], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Окончание Пути с рыцарем", "-На следующий день мы прибыли в пункт назначения , но перед собой я увидел лишь развалены. Рыцарь поведал мне, что служил он около 15 лет назад. И после того, как его бросили на королевство напали соседние страны, разрушив его до самого основания.\n" +
                "Он поблагодарил меня за то что я последовал за ним и расплатился со мной своим мечом. Мы попрощались и разошлись. ", 1, strings28, effects28, nextQuests28, drawables29));




        //Встреча с рыцарем в покоцанных доспехах, УБЕЖАТЬ
        String[] strings29 = {"В путь", "", "", ""}; // 29
        Effect[] effects29 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests29 = {30, 26, 7, 7};
        int[] drawables30 = {drawables[0], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Убежать", "-\"Резко развернувшись я пошел обратно к двери, медленно открыл ее и как дал деру, что пятки мои только сверкали.\n" +
                "Сказать , что я не испугался - это не сказать ничего.\"\n" + "\"Мой путь так и продолжился по темному лесу пока не прекратился этот дряной дождь\".\n ", 1, strings29, effects29, nextQuests29, drawables30));

        //ПОБОЧНЫЙ КВЕСТ
        /*String[] strings30 = {"Отдых", "Путь", "", ""}; //30
        Effect[] effects30 = {new Effect(1,7), nothing, nothing, nothing};
        Integer[] nextQuests30 = {19, 7, 7, 7};
        int[] drawables31 = {drawables[0], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Путь", "-Отдых хорош с едой! ", 2, strings30, effects30, nextQuests30, drawables31));

        String[] strings31 = {"Дальше", "", "", ""}; //31
        Effect[] effects31 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests31 = {20, 7, 7, 7};
        int[] drawables32 = {drawables[0], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Путь", "-Вы Продолжайте путь", 1, strings31, effects31, nextQuests31, drawables32));
*/



        //3 КВЕСТ
        String[] strings32 = {"Дальше", "", "", ""}; //32
        Effect[] effects32 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests32 = {20, 7, 7, 7};
        int[] drawables33 = {drawables[0], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Путь", "-Вы Продолжайте путь", 1, strings32, effects32, nextQuests32, drawables33));








    }
}


