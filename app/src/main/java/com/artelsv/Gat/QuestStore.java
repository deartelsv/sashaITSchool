package com.artelsv.Gat;

import com.artelsv.Gat.creatures.Hero;
import com.artelsv.Gat.creatures.effects.Effect;

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
        int[] drawables12 = {drawables[1], drawables[1], drawables[1], drawables[1]};
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
        Effect[] effects18 = {new Effect(1, 7), nothing, nothing, nothing};
        Integer[] nextQuests18 = {18, 19, 7, 7};
        int[] drawables19 = {drawables[0], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("ХМ", "-Восстановить силы или продолжить?! ", 2, strings18, effects18, nextQuests18, drawables19));

        String[] strings19 = {"Дальше", "", "", ""}; //19
        Effect[] effects19 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests19 = {20, 7, 7, 7};
        int[] drawables20 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Путь", "-Вы Продолжайте путь", 1, strings19, effects19, nextQuests19, drawables20));





        //2 КВЕСТ
        //Дождливый день
        String[] strings20 = {"Дальше", "", "", ""}; //20
        Effect[] effects20 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests20 = {21, 7, 7, 7};
        int[] drawables21 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Дождливый день", "-Ничто не предвещало беды. Была хорошая погода, бабочки летали птички пели. Но вдруг что-то капнуло на меня! И как из ведра полил дождь. Нужно было найти укрытие. Рядом со мной начинался лес и я пошел туда.", 1, strings20, effects20, nextQuests20, drawables21));

        //Встреча с рыцарем в покоцанных доспехах
        String[] strings21 = {"Заговорить", "Убежать", "", ""}; //21
        Effect[] effects21 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests21 = {22, 29, 7, 7};
        int[] drawables22 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Встреча с рыцарем в покоцанных доспехах", "-Бродя по лесу я наткнулся небольшой домишко.Что ж выбора у меня не было и я зашел внутрь.В доме около затухающего камина, я увидел человека облаченного в доспехи.", 2, strings21, effects21, nextQuests21, drawables22));

        //Заговорить
        String[] strings22 = {"Ожидание ответа", "", "", ""}; //22
        Effect[] effects22 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests22 = {23, 7, 7, 7};
        int[] drawables23 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Разговор с рыцарем", "-Посмотрев на него , я испытал какую-то жалость и печаль..\n" + "Небольшой разваливающийся дом в котором тихо тлел камин, а перед ним сидел так тяжко человек... Я поздаровался, но в ответ было лишь молчание..\n" +
                "Но я не сдался и присев рядом с ним, я ждал, ждал того, что он заговорит.\n" + "Так и случилось, он рассказал свою историю -  историю о славной службе королю. Как тот сделал ему величественный подарок в знак его верности перед королевством, который рыцарь бережно прятал от других глаз. Но его предали и выкинули, как несчастную собаку из дома, а тот подарок так и остался спрятан от мира сего.\n" +
                "\n" + "Услышав эту историю, я предложил ему свою помощь.\n.", 1, strings22, effects22, nextQuests22, drawables23));

        //Успокоение
        String[] strings23 = {"Отправляемся!", "", "", ""}; // 23
        Effect[] effects23 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests23 = {24, 7, 7, 7};
        int[] drawables24 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Успокоение", "-Повернувшись ко мне рыцарь, посмеялся и заплакал. А я сидевший рядом в недоумении лишь тихо побил его по плечу, как обычно это делал мне отец. \n" +
                "Ранним утром, мы собрались и отправились к королевству, в котором служил наш рыцарь.\"", 1, strings23, effects23, nextQuests23, drawables24));

        //Повозка
        String[] strings24 = {"Помочь", "Пройти мимо", "", ""}; // 24
        Effect[] effects24 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests24 = {25, 27, 7, 7};
        int[] drawables25 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Повозка", "-Пошагивая с рыцарем по узкой тропинке, мы встретили тележку,что медленно тащил за собой человек", 2, strings24, effects24, nextQuests24, drawables25));

        //Помочь
        String[] strings25 = {"Дальше", "", "", ""}; // 25
        Effect[] effects25 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests25 = {26, 7, 7, 7};
        int[] drawables26 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Помощь", "-\"Рыцарь поглядел на меня и понял, что я собираюсь сделать.Хотел было меня уже обогнать, но я первый приуспел. Человек был несказанно рад, что мы решили ему помочь.\"", 1, strings25, effects25, nextQuests25, drawables26));


        //Конец помощи человеку
        String[] strings26 = {"Дальше", "", "", ""}; // 26 e
        Effect[] effects26 = {new Effect(5,2), nothing, nothing, nothing};
        Integer[] nextQuests26 = {28, 7, 7, 7};
        int[] drawables27= {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Прибытие", "-\"Путь был достаточно небольшой и мы управились за пару часов. В благодарность , человек подкинул мне пару медняков, но я взял лишь половину из того, что он мне дал. Затем мы продожили путь, а дальше решили отдохнуть.", 1, strings26, effects26, nextQuests26, drawables27));


        //Пройти мимо
        String[] strings27 = {"Дальше", "", "", ""}; // 27
        Effect[] effects27= {nothing, nothing, nothing, nothing};
        Integer[] nextQuests27 = {28, 7, 7, 7};
        int[] drawables28 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("И что?", "-Не обращая внимания мы прошли мимо.\nВесь день мы шли, шли, бывало что сворачивали не туда и возращались. ", 1, strings27, effects27, nextQuests27, drawables28));

        //Прибытие
        String[] strings28 = {"Дальше", "", "", ""}; // 28
        Effect[] effects28 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests28 = {30, 7, 7, 7};
        int[] drawables29 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Окончание Пути с рыцарем", "-На следующий день мы прибыли в пункт назначения , но перед собой я увидел лишь развалены. Рыцарь поведал мне, что служил он около 15 лет назад. И после того, как его бросили на королевство напали соседние страны, разрушив его до самого основания.\n" +
                "Он поблагодарил меня за то что я последовал за ним и расплатился со мной своим мечом. Мы попрощались и разошлись. ", 1, strings28, effects28, nextQuests28, drawables29));



        //Встреча с рыцарем в покоцанных доспехах, УБЕЖАТЬ
        String[] strings29 = {"В путь", "", "", ""}; // 29
        Effect[] effects29 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests29 = {30, 26, 7, 7};
        int[] drawables30 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Убежать", "-\"Резко развернувшись я пошел обратно к двери, медленно открыл ее и как дал деру, что пятки мои только сверкали.\n" +
                "Сказать , что я не испугался - это не сказать ничего.\"\n" + "\"Мой путь так и продолжился по темному лесу пока не прекратился этот дряной дождь\".\n ", 1, strings29, effects29, nextQuests29, drawables30));

        //ПОБОЧНЫЙ КВЕСТ
        String[] strings30 = {"Отдых", "Путь", "", ""}; //30е
        Effect[] effects30 = {new Effect(1,7), nothing, nothing, nothing};
        Integer[] nextQuests30 = {30, 31, 7, 7};
        int[] drawables31 = {drawables[0], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("ХМ", "-Отдых хорош с едой! ", 2, strings30, effects30, nextQuests30, drawables31));

        String[] strings31 = {"Дальше", "", "", ""}; //31
        Effect[] effects31 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests31 = {32, 7, 7, 7};
        int[] drawables32 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Путь", "-Вы Продолжайте путь", 1, strings31, effects31, nextQuests31, drawables32));







        //3 КВЕСТ

        //Встреча с дамой
        String[] strings32 = {"Пойти за ней", "Обойти", "", ""}; //32
        Effect[] effects32 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests32 = {33, 37, 7, 7};
        int[] drawables33 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Встреча с дамой", "-\"Проходя сквозь болота , я никак не ожидал, что встречу ее. Это была прекрасная девушка с длинными белыми волосами, как луна, с фигуркой, что каждая женщина бы позавидовала.Вот только это было весьма подозрительно, что в таком ужасном месте, ходит такое чудесное создание\"", 2, strings32, effects32, nextQuests32, drawables33));

        //Пойти за ней
        String[] strings33 = {"Дальше", "", "", ""}; //33
        Effect[] effects33 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests33 = {34, 7, 7, 7};
        int[] drawables34 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Пойти за ней", "-Подумав, а чего мне терять то? И направился я за ней.", 1, strings33, effects33, nextQuests33, drawables34));

        //Не заметил
        String[] strings34 = {"Кушать", "Не кушать", "", ""}; //34
        Effect[] effects34 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests34 = {35, 36, 7, 7};
        int[] drawables35 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Не заметил", "-Я даже не заметил как оказался в другом месте. Здесь было очень красиво,передо мной стоял стол накрытый на вид вкусной едой и чего там только не было. Девушка жестом показала мне сесть, что я добровольно и сделал. Сама же она была рядом и смотрела на меня с очень милой улыбкой.", 2, strings34, effects34, nextQuests34, drawables35));

        //Кушать
        String[] strings35 = {"Дальше", "", "", ""}; //35
        Effect[] effects35 = {new Effect(-50,1), nothing, nothing, nothing};
        Integer[] nextQuests35 = {38, 7, 7, 7};
        int[] drawables36 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Пора кушать", "-\"Я принялся за еду, она была очень приятна на вкус.\"\n" +
                "\"Но Через пару минут у меня начал болеть живот и кажется я упал в обморок. Когда проснулся мои жизненные силы оказались на исходе,  еда превратилась в гниль, девушка пропала, а я все также находился в болотной местности.\n" +
                "\"Я думаю, мне следует отдохнуть.А потом двинуться в путь.\"", 1, strings35, effects35, nextQuests35, drawables36));

        // Не Кушать
        String[] strings36 = {"Дальше", "", "", ""}; //36
        Effect[] effects36 = {new Effect(-30,1), nothing, nothing, nothing};
        Integer[] nextQuests36 = {38, 7, 7, 7};
        int[] drawables37 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Я на диете", "-Я посмотрел на нее и спросил, а в чем в подвох? Она молчала и смотрела на меня все с той же улыбкой.\"\n" +
                "\"Тут мне стало не по себе, я встал , уж было хотел бежать, но тут она меня схватила за руку и я увидел, что меня все также окружает болото, на столе лежит гниль, а девушка вовсе не девушка\"\n" +
                "\"Мои волосы встали дыбом, я пытался отцепить это, но не смог. Вдруг я начал ощущать слабость во всех конечностях, а потом и вовсе потерял сознание.\"\n" + "\n" + "\"Проснувшись я понял, что все моя жизненная энергия куда исчезла вместе с девушкой или не девушкой\"." + "\"Собравшись с силами, я встал и постарался как можно скорее отсюда убраться.\"", 1, strings36, effects36, nextQuests36, drawables37));



        //Обойти
        String[] strings37 = {"Дальше", "", "", ""}; //37
        Effect[] effects37 = {new Effect(-80,1), nothing, nothing, nothing};
        Integer[] nextQuests37 = {38, 7, 7, 7};
        int[] drawables38= {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Обойти", "-\"Думаю оно того не стоит.И собравшись идти обратно, я громко хрустнул веткой и девушка обернувшись в мою сторону, начала жадно смотреть на меня.Все мои конечности словно отказали от страха, я не знал что делать и куда деваться, а она была все ближе и ближе.Подойдя, она мне шепнула что-то очень страшное и непонятное для меня, но так как выбора у меня не было, мне пришлось согласиться\"\n" +
                "Оказывается это была ведьма и чтобы поддерживать свой молодой облик она забирала жизненную энергию у заплутавших дурачков, как я.", 1, strings37, effects37, nextQuests37, drawables37));

        //ПОБОЧНЫЙ КВЕСТ
        String[] strings38 = {"Отдых", "Путь", "", ""}; //38
        Effect[] effects38 = {new Effect(1,7), nothing, nothing, nothing};
        Integer[] nextQuests38 = {38, 39, 7, 7};
        int[] drawables39 = {drawables[0], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("ХМ", "-Восстановить силы или продолжить? ", 2, strings38, effects38, nextQuests38, drawables39));

        String[] strings39 = {"В путь ", "", "", ""}; //39
        Effect[] effects39 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests39 = {40, 7, 7, 7};
        int[] drawables40 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Путь", "-Вы Продолжайте путь", 1, strings39, effects39, nextQuests39, drawables40));






        //ГЛАВА 2
        String[] strings40 = {"В путь! ", "", "", ""}; //40
        Effect[] effects40 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests40 = {41, 7, 7, 7};
        int[] drawables41 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("ГЛАВА 2", "-Преодолев  часть пути вы начинаете понимать, что все не так просто как хотелось бы. Ведь впереди возможно ожидают еще более трудные вещи.", 1, strings40, effects40, nextQuests40, drawables41));

        //Странствующий бастард художник
        String[] strings41 = {"Выслушать", "", "", ""}; //41
        Effect[] effects41 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests41 = {42, 7, 7, 7};
        int[] drawables42 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Странствующий бастард художник", "-Проходя по мосту в далеке я увидел чуть незаметную фигуру и решил посмотреть что это.\n" +
                "Приближаясь увидел холст,кисти,цветную воду, краски и рядом стоящего человека, который словно открывает что-то неизведанное. Во мне вспыхнул интерес к этому и художников занимающийся творением сразу заметил это.\n" +
                "\n" + "Прежде чем я хотел что-то ему сказать, он меня опередил и предложил выслушить его историю.", 2, strings41, effects41, nextQuests41, drawables42));

        //Выслушать
        String[] strings42 = {"1", "", "", ""}; //42
        Effect[] effects42 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests42 = {43, 7, 7, 7};
        int[] drawables43 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Выслушать, вопросы", "-Ну, что ж дорогой спутник начнем же с самого начала. \n" +
                "Меня именовать Фритхоф 3-ий, я являюсь бастардом Вельгельма 7 и женщины, что была его любовницей. Моя мать умерла от оспы, когда я был мал, но она рассказывала мне о моем отце, его жене и королевстве, что медленно погибает в алчности и бедности жалких аристократов.\n" +"\n"+
                "1) Расскажи о своей матери \n" +
                "2) Почему твои картины такие волшебные, что ты хочешь ими передать?\n" +
                "3) Ты собираешься помочь королевству?\n" +
                "4) Почему ты решил мне  рассказать?", 1, strings42, effects42, nextQuests42, drawables43));

        //1 вопрос
        String[] strings43 = {"2", "", "", ""}; //43
        Effect[] effects43 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests43 = {44, 7, 7, 7};
        int[] drawables44 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("1 вопрос", "-Моя мать была добра ко мне. Учила всему, что сама могла. \n" +
                "Говорила, что ближним нужно помогать , жить верой и правдой, но мир не таков каким бы нам хотелось.\n" +"\n"+
                "2) Почему твои картины такие волшебные, что ты хочешь ими передать?\n" +
                "3) Ты собираешься помочь королевству?\n" +
                "4) Почему ты решил мне  рассказать?", 1, strings43, effects43, nextQuests43, drawables44));

        //2 вопрос
        String[] strings44 = {"3", "", "", ""}; //44
        Effect[] effects44 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests44 = {45, 7, 7, 7};
        int[] drawables45 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("2 вопрос", "-Я рисую с малых лет.\n" +
                "Однажды когда я увидел картину возле прилавка в магазине, на которой была изображена женщина жадно поедавшая хрустящие, сочные булочки, мне захотелось такую же. И я понял, что желание к этим булочкам побудила не сама картина, а та самая страсть вложенная художником, о которой он думал наверное вечерами и рисовал, что есть силы для того чтобы передать смысл и чувства, которые бурлили у него на душе. Ведь это простой рисунок и у меня никогда такого не было." +
                 "И я подумал ведь я тоже хочу также вдохновлять людей на какие-то поступки, чувства и мысли, как та самая картина возле прилавка в магазине, которая вдохновила меня.\n"+"\n"+
                "3) Ты собираешься помочь королевству?\n" +
                "4) Почему ты решил мне  рассказать?", 1, strings44, effects44, nextQuests44, drawables45));

        //3 вопрос
        String[] strings45 = {"4", "", "", ""}; //45
        Effect[] effects45 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests45 = {46, 7, 7, 7};
        int[] drawables46 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("3 вопрос", "-Моя цель спасти королевство от той нищиты, бедности и боли, что проживают люди сейчас.Я собираю последователей, которых я смог вдохновить своими картинами, чтоб дать отпор этой гнилой власти.\n" +"\n"+
                "4) Почему ты решил мне  рассказать?", 1, strings45, effects45, nextQuests45, drawables46));

        //4 вопрос
        String[] strings46 = {"ДА!", "ДА", "ДА!", "ДА!"}; //46
        Effect[] effects46 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests46 = {47, 47, 47, 47};
        int[] drawables47 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("3 вопрос", "-Я хочу тебе предложить свою роль того самого человека, что поможет мне осуществить затеянное.\n" +
                "\n" + "Желаешь ли ты присоединиться ко мне, чтоб спасти королевство от той самой гнили?\n.", 4, strings46, effects46, nextQuests46, drawables47));

        //ДА!!
        String[] strings47 = {"1", "2", "", ""}; //47
        Effect[] effects47 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests47 = {48, 49, 7, 7};
        int[] drawables48 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("да!!", "-Тогда выступаем ранним утром. Готовься! Спустя сутки..", 2, strings47, effects47, nextQuests47, drawables48));

        //Удалось
        String[] strings48 = {"Дальше", "", "", ""}; //48
        Effect[] effects48 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests48 = {50, 7, 7, 7};
        int[] drawables49= {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("да!!", "-С помощью бравых солдатов, героизма и мужества мы отвоевали потерянный замок.Браво!", 2, strings48, effects48, nextQuests48, drawables49));

        //Не удалось
        String[] strings49 = {"Дальше", "", "", ""}; //49
        Effect[] effects49 = {nothing, nothing, nothing, nothing};
        Integer[] nextQuests49 = {51, 7, 7, 7};
        int[] drawables50 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("да!!", "-Ваша небольшая, но мужественная коалиция была разгромлена.\n" +
                "\n" + "Бастард убит, вас сажают в тюрьму на все оставшуюся жизнь\n", 2, strings49, effects49, nextQuests49, drawables50));

        //1 концовка
        String[] strings50 = {"Restart", "", "", ""}; //50
        Effect[] effects50 = {new Effect(1,6), nothing, nothing, nothing};
        Integer[] nextQuests50= {0, 7, 7, 7};
        int[] drawables51 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Концовка!", "-Мой король предложил место при дворе. Такая честь дается единственный раз в жизни. Я принимаю!", 2, strings50, effects50, nextQuests50, drawables51));

        //2 концовка
        String[] strings51 = {"Restart", "", "", ""}; //51
        Effect[] effects51 = {new Effect(1,6), nothing, nothing, nothing};
        Integer[] nextQuests51 = {0, 7, 7, 7};
        int[] drawables52 = {drawables[1], drawables[1], drawables[1], drawables[1]};
        quests.add(new Quest("Концовка!!", "-Нашего героя кинули в тюрьму, где он провел всю оставшуюся жизнь", 2, strings51, effects51, nextQuests51, drawables52));


    }
}


