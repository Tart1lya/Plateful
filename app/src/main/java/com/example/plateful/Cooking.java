package com.example.plateful;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cooking extends AppCompatActivity {
    String [] arrNameOfDishes = {"Яблочная каша", "Яичница с тыквой", "Фриттата с овощами и фетой",
            "Салат греческий с курицей", "Перцы, фаршированные кускусом", "Куриный стейк",
            "Тушеная свинина с кукурузой", "Говядина с овощами стир-фрай", "Сливочная паста фетучини"
    };
    String [] arrNameOfBreakfast = {"Яблочная каша", "Яичница с тыквой",
            "Фриттата с овощами и фетой"};
    String [] arrNameOfLunch = {"Салат греческий с курицей", "Перцы, фаршированные кускусом",
            "Куриный стейк"};
    String [] arrNameOfDinner = {"Тушеная свинина с кукурузой", "Говядина с овощами стир-фрай",
            "Сливочная паста фетучини"};
    int timeStatus, index, buff, progressStatus = 0;
    String choiceStatus, nameOfDish;
    String date, time;
    Cursor query;
    SQLiteDatabase db;
    DatabaseHelper databaseHelper;
    private static final String ID_INFO = "id_info";
    SharedPreferences settingsForId;
    int [] arrOfImgOfCookingApplePorridge = {
            R.drawable.first1, R.drawable.second1, R.drawable.third1, R.drawable.fourth1
    };
    int [] arrOfImgOfCookingScrambledEggsWithPumpkin = {
            R.drawable.first2, R.drawable.second2, R.drawable.third2, R.drawable.fourth2,
            R.drawable.fiveth2, R.drawable.sixth2, R.drawable.seventh2
    };
    int [] arrOfImgOfCookingFrittataWithVegetablesAndFeta = {
            R.drawable.first3, R.drawable.second3, R.drawable.third3, R.drawable.fourth3
    };
    int [] arrOfImgOfCookingGreekSaladWithChicken = {
            R.drawable.first4, R.drawable.second4, R.drawable.third4, R.drawable.fourth4,
            R.drawable.fiveth4, R.drawable.sixth4, R.drawable.seventh4, R.drawable.eighth4,
            R.drawable.nineth4, R.drawable.tenth4, R.drawable.eleventh4, R.drawable.twelveth4,
            R.drawable.thirteenth4
    };
    int [] arrOfImgOfCookingPeppersStuffedWithCouscous = {
            R.drawable.first5, R.drawable.second5, R.drawable.third5, R.drawable.fourth5,
            R.drawable.fiveth5
    };
    int [] arrOfImgOfCookingChickenSteak = {
            R.drawable.first6, R.drawable.second6, R.drawable.third6, R.drawable.fourth6
    };
    int [] arrOfImgOfCookingPorkStewWithCorn = {
            R.drawable.first7, R.drawable.second7, R.drawable.third7, R.drawable.fourth7
    };
    int [] arrOfImgOfCookingBeefWithVegetablesStirFry = {
            R.drawable.first8, R.drawable.second8, R.drawable.third8, R.drawable.fourth8,
            R.drawable.fiveth8
    };
    int [] arrOfImgOfCookingCreamyFettucciniPasta = {
            R.drawable.first9, R.drawable.second9, R.drawable.third9, R.drawable.fourth9
    };
    String [] arrOfRecipesOfCookingApplePorridge = {
            "Яблоки помойте, очистите от кожуры, удалите сердцевину. Половинку яблока для подачи нарежьте тонкими ломтиками.",
            "Подготовьте ингредиенты. Яблоки порежьте маленьким кубиком, переложите в небольшую кастрюлю и залейте кокосовым молоком, смешанным с питьевой негазированной водой. Миндаль и семена льна измельчите в блендере в крошку.",
            "Сварите кашу. Поставьте кастрюлю с яблоками на средний огонь, после закипания переключите огонь на минимальный и варите 15 минут. Разомните яблоки толкушкой или вилкой. Добавьте в кастрюлю измельченные миндаль и семена льна, сушеную клюкву и корицу, хорошо перемешайте.",
            "Подавайте яблочную кашу, украсив порцию ломтиками яблока."
    };
    String [] arrOfRecipesOfCookingScrambledEggsWithPumpkin = {
            "Подготовить все ингредиенты. Помыть и почистить тыкву от семечек и кожуры, а также почистить чеснок, помыть зелень и тщательно вымыть яйца. ",
            "Тыкву порезать кубиками, чеснок мелко порубить, зелень измельчить. ",
            "В сковороде разогреть растительное масло, добавить тыкву и пассеровать на среднем огне до готовности, периодически помешивая. Можно добавить немного кипятка и закрыть сковороду крышкой, чтобы сократить время приготовления. Необходимо, чтобы тыква была полностью готова. Время приготовления зависит от величины кусочков и от сорта тыквы. Примерно уходит на всё это 12 минут ",
            "Добавить чеснок, посолить, приправить и готовить около 2 минут на небольшом огне, помешивая. В конце добавить уксус и нагревать примерно 1 минуту. Всыпать измельчённую зелень (часть зелени оставить для подачи) и аккуратно перемешать.",
            "Влить в сковороду яйца по одному. Затем вилкой или лопаткой перемешать яйца, накрыть сковороду крышкой и довести яичницу до готовности, время от времени помешивая для равномерного приготовления. Здесь важно не пережарить яйца, иначе они могут стать суховатыми. Яичница должна оставаться нежной.",
            "Фету порезать на кубики. Можно просто раскорошить её вилкой. Если используете твёрдый сыр, то его лучше потереть на тёрке.",
            "Подавать яичницу с пылу, с жару, посыпав сверху фетой, зеленью и свежемолотым чёрным перцем. Можно дополнительно сбрызнуть яичницу оливковым или другим ароматным маслом и посыпать поджаренными кедровыми орехами или тыквенными семечками."
    };
    String [] arrOfRecipesOfCookingFrittataWithVegetablesAndFeta = {
            "Яйца взбиваем с молоком и немного подсаливаем.",
            "Помидоры разрезаем на 4-5 треугольников. Брокколи отвариваем 4 минуты.",
            "Форму смазываем растительным маслом. Яичную смесь выливаем в форму, выкладываем брокколи, помидоры, фету, посыпаем натертым сыром пармезан и выпекаем до золотистой корочки 15 минут при температуре 200 градусов.",
            "Подаем в горячем виде, по желанию перед подачей можно посыпать блюдо пармезаном."
    };
    String [] arrOfRecipesOfCookingGreekSaladWithChicken = {
            "Подготовьте все необходимые ингредиенты. Куриное филе и овощи помойте и просушите бумажным полотенцем. Лук и огурец очистите от кожуры. Маслины достаньте из банки и немного просушите. Фету достаньте из упаковки.",
            "Замаринуйте курицу. В миску выложите филе, добавьте винный уксус, оливковое масло, лимонный сок, соль, перец и сушеные травы. Накройте миску пищевой пленкой и оставьте филе мариноваться на 30 минут.",
            "В это время подготовьте овощи. У помидоров удалите плодоножку и нарежьте томаты дольками толщиной 1-1,5 см.",
            "У болгарского перца удалите плодоножку и нарежьте перец кубиком размером 1 см.",
            "Лук нарежьте полукольцами толщиной не более 2 мм.",
            "Листья пекинской капусты порвите руками или нарежьте крупно.",
            "Фету нарежьте на средние кубики.",
            "Куриное филе достаньте из маринада и нарежьте на кусочки размером 3 см.",
            "Огурец разрежьте вдоль, а затем нарежьте полумесяцами.",
            "Разогрейте сковороду с растительным маслом и обжарьте курицу 15 минут до готовности, не забывая помешивать.",
            "В глубокой миске соедините все овощи, филе, фету. Заправьте салат оливковым маслом, солью, перцем и специями. Перемешайте.",
            "Греческий салат готов. Подавайте салат, разложив по порционным тарелкам и украсив листиком свежего базилика.",
            "Подайте салат, выложив на салатные листья. Перед подачей сбрызните крем-бальзамиком."
    };
    String [] arrOfRecipesOfCookingPeppersStuffedWithCouscous = {
            "Бульон поместите на огонь и доведите до кипения. В глубокую миску выложите кускус, залейте его подготовленным бульоном и перемешайте. Дождитесь, пока крупа полностью впитает всю жидкость. Овощи и зелень тщательно промойте и просушите, используя бумажные полотенца. Лук и цукини очистите, а петрушку и брынзу измельчите. Также подготовьте кастрюлю, сковороду и форму для запекания.",
            "Подготовьте перцы. Срежьте у овощей верхушки, удалите семена и мембраны. В глубокую миску налейте холодную воду. В кастрюлю налейте воду, добавьте в нее соль и поместите на огонь. Дождитесь, когда вода закипит, а после опустите в нее подготовленные перцы. Подержите их в кастрюле около 5 минут, а затем сразу переложите в миску с холодной водой. После этого обсушите перцы бумажными полотенцами и отложите в сторону.",
            "Приготовьте начинку. На сковороду налейте оливковое масло и поместите на огонь разогреваться. В это же время нарежьте лук и цукини тонкими кусочками. Когда масло нагреется, выложите овощи и обжарьте их в течение 5-7 минут. Помидоры черри нарежьте четвертинками, а затем добавьте в сковороду. Туда же добавьте зелень и душицу. Потушите начинку еще 1-2 минуты, а затем снимите с огня. После этого добавьте в сковороду кускус и брынзу, приправьте смесь специями и перемешайте.",
            "Приготовьте блюдо. Духовку включите разогреваться до 200 градусов. Затем возьмите болгарские перцы и плотно начините их сырно-овощной смесью. Смажьте форму для запекания небольшим количеством масла, а после выложите подготовленные перцы. Отправьте блюдо в духовку на 20-25 минут до полной готовности.",
            "Готовые перцы подавайте сразу после приготовление. Выложите их на тарелку, полейте небольшим количеством сока, который выделился во время приготовления, а затем подайте к столу."
    };
    String [] arrOfRecipesOfCookingChickenSteak = {
            "Куриное филе тщательно промойте, просушите и очистите от пленок и лишних жилок. Овощи для подачи вымойте и обсушите. Чеснок очистите от шелухи и мелко порубите. Также подготовьте сковороду-гриль.",
            "Подготовьте курицу. Филе разрежьте вдоль на две равные части. Затем переложите мясо на рабочую поверхность и накройте пищевой пленкой. Используя молоток, отбейте филе, чтобы его толщина была одинаковой по всей поверхности. После этого переложите мясо в отдельную тарелку, залейте его растительным маслом и соевым соусом, добавьте измельченный чеснок и специи по вкусу. Обваляйте стейки в маринаде, а после оставьте их на 10 минут.",
            "Приготовьте стейки из курицы. Включите сковороду-гриль и дождитесь, когда она разогреется. Выложите филе на разогретую сковороду и обжарьте его в течение 3 минут с каждой стороны, чтобы появилась аппетитная корочка.",
            "Аппетитные стейки из курицы подавайте к столу сразу после приготовления. В качестве дополнения к блюду используйте свежие овощи. Перец очистите от семян и плодоножки и нарежьте ломтиками вдоль. Помидор нарежьте тонкими кружочками. После этого выложите овощи на тарелку вместе со стейками."
    };
    String [] arrOfRecipesOfCookingPorkStewWithCorn = {
            "Мясо помойте под проточной водой, обсушите бумажным полотенцем и порежьте на куски средней величины. Слейте жидкость из кукурузы, опрокинув ее на дуршлаг. Перец и огурец помойте, обсушите и нарежьте полосками.",
            "Обжарьте свинину. Разогрейте сковороду, добавьте масло и выложите мясо. Установите средний огонь. Дождитесь появления золотистой корочки, посолите и поперчите по вкусу.",
            "Завершите приготовление блюда. Добавьте на сковороду воду и томатную пасту. Уменьшите огонь, накройте крышкой и тушите в течение 1 часа. Снимите крышку, выложите сметану и кукурузу, подержите на огне еще 15 минут.",
            "Чтобы эффектно подать тушеную свинину с кукурузой, выложите ее на широкую тарелку и украсьте огурцом и перцем, нарезанными полосками."
    };
    String [] arrOfRecipesOfCookingBeefWithVegetablesStirFry = {
            "Говядину разморозьте, помойте, нарежьте на тонкие кусочки. Чеснок почистите и пропустите через пресс. Шампиньоны, помойте, нарежьте слайсами. Болгарский перец и перец чили помойте, удалите плодоножку и семена, нарежьте соломкой. Фасоль нарежьте по диагонали на 2-3 части в зависимости от длины. Подготовьте сковороду вок или обычную толстостенную глубокую сковороду.",
            "Приготовьте мясо. Кусочки говядины залейте соевым соусом, лимонным соком, добавьте чеснок. Хорошо перемешайте и уберите в холодильник на 3 часа. Раскалите на сковороде 1 ст. л. растительного масла, обжарьте мясо в течение 5 минут на сильном огне, постоянно перемешивая. Переложите мясо на тарелку.",
            "Приготовьте овощи. Разогрейте оставшееся растительное масло на той же сковороде. Обжарьте 2 минуты зеленую фасоль, добавьте шампиньоны и имбирь. Тщательно перемешайте, жарьте еще 3 минуты на сильном огне, часто помешивая. Добавьте болгарский перец и перец чили, готовьте еще 2 минуты.",
            "Доведите блюдо до готовности. Смешайте крахмал с говяжьим бульоном и яблочным уксусом. Верните в сковороду мясо, вылейте туда же бульон. Тщательно перемешайте и погрейте блюдо еще 2 минуты.",
            "Подавайте говядину с овощами стир-фрай, украсив порцию микрозеленью."
    };
    String [] arrOfRecipesOfCookingCreamyFettucciniPasta = {
            "Пармезан натрите на мелкой терке Лимон помойте, снимите цедру. Базилик помойте и обсушите.",
            "Сварите соус. Нагрейте в сотейнике сливки с цедрой лимона. Варите 3 минуты на медленном огне, постоянно помешивая. Добавьте к сливкам сливочное масло, соль, перец и пармезан, тщательно перемешайте.",
            "Приготовьте пасту. Отварите в подсоленной воде фетучини в течение 7 минут. Переложите пасту в соус, тщательно перемешайте. Если соус получился слишком густой, добавьте немного воды от макарон.",
            "Подавайте сливочную пасту фетучини, украсив порцию листиками базилика."
    };
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cooking);
        settingsForId = getSharedPreferences(ID_INFO, MODE_PRIVATE);
        databaseHelper = new DatabaseHelper(getApplicationContext());
        db = databaseHelper.getReadableDatabase();
        id = settingsForId.getInt(ID_INFO, 0);
        timeStatus = getIntent().getExtras().getInt("time_status_final");
        index = getIntent().getExtras().getInt("index_final");
        buff = getIntent().getExtras().getInt("buff_final");
        choiceStatus = getIntent().getExtras().getString("choice_status_final");
        ImageView cookingImg = findViewById(R.id.cooking_img);
        TextView progressOfCookingTxt = findViewById(R.id.progress_of_cooking_txt);
        TextView descriptionOfCookingTxt = findViewById(R.id.description_of_cooking_txt);
        ImageButton nextFinalBtn = findViewById(R.id.next_final_btn);
        if (choiceStatus.equals("Перешёл по рекам")) {
            if (timeStatus == 0) {
                nameOfDish = arrNameOfBreakfast[index];
            } else if (timeStatus == 1) {
                nameOfDish = arrNameOfLunch[index];
            } else if (timeStatus == 2) {
                nameOfDish = arrNameOfDinner[index];
            }
        } else {
            nameOfDish = arrNameOfDishes[buff];
        }
        if (nameOfDish.equals("Яблочная каша")) {
            cookingImg.setImageResource(arrOfImgOfCookingApplePorridge[progressStatus]);
            descriptionOfCookingTxt.setText(arrOfRecipesOfCookingApplePorridge[progressStatus]);
            progressStatus++;
            progressOfCookingTxt.setText(progressStatus + "/" + arrOfImgOfCookingApplePorridge.length);
        }
        else if (nameOfDish.equals("Яичница с тыквой")) {
            cookingImg.setImageResource(arrOfImgOfCookingScrambledEggsWithPumpkin[progressStatus]);
            descriptionOfCookingTxt.setText(arrOfRecipesOfCookingScrambledEggsWithPumpkin[progressStatus]);
            progressStatus++;
            progressOfCookingTxt.setText(progressStatus + "/" + arrOfImgOfCookingScrambledEggsWithPumpkin.length);
        }
        else if (nameOfDish.equals("Фриттата с овощами и фетой")) {
            cookingImg.setImageResource(arrOfImgOfCookingFrittataWithVegetablesAndFeta[progressStatus]);
            descriptionOfCookingTxt.setText(arrOfRecipesOfCookingFrittataWithVegetablesAndFeta[progressStatus]);
            progressStatus++;
            progressOfCookingTxt.setText(progressStatus + "/" + arrOfImgOfCookingFrittataWithVegetablesAndFeta.length);
        }
        else if (nameOfDish.equals("Салат греческий с курицей")) {
            cookingImg.setImageResource(arrOfImgOfCookingGreekSaladWithChicken[progressStatus]);
            descriptionOfCookingTxt.setText(arrOfRecipesOfCookingGreekSaladWithChicken[progressStatus]);
            progressStatus++;
            progressOfCookingTxt.setText(progressStatus + "/" + arrOfImgOfCookingGreekSaladWithChicken.length);
        }
        else if (nameOfDish.equals("Перцы, фаршированные кускусом")) {
            cookingImg.setImageResource(arrOfImgOfCookingPeppersStuffedWithCouscous[progressStatus]);
            descriptionOfCookingTxt.setText(arrOfRecipesOfCookingPeppersStuffedWithCouscous[progressStatus]);
            progressStatus++;
            progressOfCookingTxt.setText(progressStatus + "/" + arrOfImgOfCookingPeppersStuffedWithCouscous.length);
        }
        else if (nameOfDish.equals("Куриный стейк")) {
            cookingImg.setImageResource(arrOfImgOfCookingChickenSteak[progressStatus]);
            descriptionOfCookingTxt.setText(arrOfRecipesOfCookingChickenSteak[progressStatus]);
            progressStatus++;
            progressOfCookingTxt.setText(progressStatus + "/" + arrOfImgOfCookingChickenSteak.length);
        }
        else if (nameOfDish.equals("Тушеная свинина с кукурузой")) {
            cookingImg.setImageResource(arrOfImgOfCookingPorkStewWithCorn[progressStatus]);
            descriptionOfCookingTxt.setText(arrOfRecipesOfCookingPorkStewWithCorn[progressStatus]);
            progressStatus++;
            progressOfCookingTxt.setText(progressStatus + "/" + arrOfImgOfCookingPorkStewWithCorn.length);
        }
        else if (nameOfDish.equals("Говядина с овощами стир-фрай")) {
            cookingImg.setImageResource(arrOfImgOfCookingBeefWithVegetablesStirFry[progressStatus]);
            descriptionOfCookingTxt.setText(arrOfRecipesOfCookingBeefWithVegetablesStirFry[progressStatus]);
            progressStatus++;
            progressOfCookingTxt.setText(progressStatus + "/" + arrOfImgOfCookingBeefWithVegetablesStirFry.length);
        }
        else if (nameOfDish.equals("Сливочная паста фетучини")) {
            cookingImg.setImageResource(arrOfImgOfCookingCreamyFettucciniPasta[progressStatus]);
            descriptionOfCookingTxt.setText(arrOfRecipesOfCookingCreamyFettucciniPasta[progressStatus]);
            progressStatus++;
            progressOfCookingTxt.setText(progressStatus + "/" + arrOfImgOfCookingCreamyFettucciniPasta.length);
        }
        nextFinalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameOfDish.equals("Яблочная каша")) {
                    if (progressStatus == arrOfImgOfCookingApplePorridge.length) {
                        date = LocalDate.now().toString();
                        time = LocalTime.now().toString();
                        databaseHelper.addDish(getApplicationContext(), id, nameOfDish.trim(), date.trim(), time.trim());
                        Intent i = new Intent(getApplicationContext(), CookingIsDone.class);
                        i.putExtra("name_of_dish", nameOfDish);
                        startActivity(i);
                        finish();
                    } else {
                        cookingImg.setImageResource(arrOfImgOfCookingApplePorridge[progressStatus]);
                        descriptionOfCookingTxt.setText(arrOfRecipesOfCookingApplePorridge[progressStatus]);
                        progressStatus++;
                        progressOfCookingTxt.setText(progressStatus + "/" + arrOfImgOfCookingApplePorridge.length);
                    }

                }
                else if (nameOfDish.equals("Яичница с тыквой")) {
                    if (progressStatus == arrOfImgOfCookingScrambledEggsWithPumpkin.length) {
                        date = LocalDate.now().toString();
                        time = LocalTime.now().toString();
                        databaseHelper.addDish(getApplicationContext(), id, nameOfDish.trim(), date.trim(), time.trim());
                        Intent i = new Intent(getApplicationContext(), CookingIsDone.class);
                        i.putExtra("name_of_dish", nameOfDish);
                        startActivity(i);
                        finish();
                    } else {
                        cookingImg.setImageResource(arrOfImgOfCookingScrambledEggsWithPumpkin[progressStatus]);
                        descriptionOfCookingTxt.setText(arrOfRecipesOfCookingScrambledEggsWithPumpkin[progressStatus]);
                        progressStatus++;
                        progressOfCookingTxt.setText(progressStatus + "/" + arrOfImgOfCookingScrambledEggsWithPumpkin.length);
                    }
                }
                else if (nameOfDish.equals("Фриттата с овощами и фетой")) {
                    if (progressStatus == arrOfImgOfCookingFrittataWithVegetablesAndFeta.length) {
                        date = LocalDate.now().toString();
                        time = LocalTime.now().toString();
                        databaseHelper.addDish(getApplicationContext(), id, nameOfDish.trim(), date.trim(), time.trim());
                        Intent i = new Intent(getApplicationContext(), CookingIsDone.class);
                        i.putExtra("name_of_dish", nameOfDish);
                        startActivity(i);
                        finish();
                    } else {
                        cookingImg.setImageResource(arrOfImgOfCookingFrittataWithVegetablesAndFeta[progressStatus]);
                        descriptionOfCookingTxt.setText(arrOfRecipesOfCookingFrittataWithVegetablesAndFeta[progressStatus]);
                        progressStatus++;
                        progressOfCookingTxt.setText(progressStatus + "/" + arrOfImgOfCookingFrittataWithVegetablesAndFeta.length);
                    }
                }
                else if (nameOfDish.equals("Салат греческий с курицей")) {
                    if (progressStatus == arrOfImgOfCookingGreekSaladWithChicken.length) {
                        date = LocalDate.now().toString();
                        time = LocalTime.now().toString();
                        databaseHelper.addDish(getApplicationContext(), id, nameOfDish.trim(), date.trim(), time.trim());
                        Intent i = new Intent(getApplicationContext(), CookingIsDone.class);
                        i.putExtra("name_of_dish", nameOfDish);
                        startActivity(i);
                        finish();
                    } else {
                        cookingImg.setImageResource(arrOfImgOfCookingGreekSaladWithChicken[progressStatus]);
                        descriptionOfCookingTxt.setText(arrOfRecipesOfCookingGreekSaladWithChicken[progressStatus]);
                        progressStatus++;
                        progressOfCookingTxt.setText(progressStatus + "/" + arrOfImgOfCookingGreekSaladWithChicken.length);
                    }
                }
                else if (nameOfDish.equals("Перцы, фаршированные кускусом")) {
                    if (progressStatus == arrOfImgOfCookingPeppersStuffedWithCouscous.length) {
                        date = LocalDate.now().toString();
                        time = LocalTime.now().toString();
                        databaseHelper.addDish(getApplicationContext(), id, nameOfDish.trim(), date.trim(), time.trim());
                        Intent i = new Intent(getApplicationContext(), CookingIsDone.class);
                        i.putExtra("name_of_dish", nameOfDish);
                        startActivity(i);
                        finish();
                    } else {
                        cookingImg.setImageResource(arrOfImgOfCookingPeppersStuffedWithCouscous[progressStatus]);
                        descriptionOfCookingTxt.setText(arrOfRecipesOfCookingPeppersStuffedWithCouscous[progressStatus]);
                        progressStatus++;
                        progressOfCookingTxt.setText(progressStatus + "/" + arrOfImgOfCookingPeppersStuffedWithCouscous.length);
                    }
                }
                else if (nameOfDish.equals("Куриный стейк")) {
                    if (progressStatus == arrOfImgOfCookingChickenSteak.length) {
                        date = LocalDate.now().toString();
                        time = LocalTime.now().toString();
                        databaseHelper.addDish(getApplicationContext(), id, nameOfDish.trim(), date.trim(), time.trim());
                        Intent i = new Intent(getApplicationContext(), CookingIsDone.class);
                        i.putExtra("name_of_dish", nameOfDish);
                        startActivity(i);
                        finish();
                    } else {
                        cookingImg.setImageResource(arrOfImgOfCookingChickenSteak[progressStatus]);
                        descriptionOfCookingTxt.setText(arrOfRecipesOfCookingChickenSteak[progressStatus]);
                        progressStatus++;
                        progressOfCookingTxt.setText(progressStatus + "/" + arrOfImgOfCookingChickenSteak.length);
                    }
                }
                else if (nameOfDish.equals("Тушеная свинина с кукурузой")) {
                    if (progressStatus == arrOfImgOfCookingPorkStewWithCorn.length) {
                        date = LocalDate.now().toString();
                        time = LocalTime.now().toString();
                        databaseHelper.addDish(getApplicationContext(), id, nameOfDish.trim(), date.trim(), time.trim());
                        Intent i = new Intent(getApplicationContext(), CookingIsDone.class);
                        i.putExtra("name_of_dish", nameOfDish);
                        startActivity(i);
                        finish();
                    } else {
                        cookingImg.setImageResource(arrOfImgOfCookingPorkStewWithCorn[progressStatus]);
                        descriptionOfCookingTxt.setText(arrOfRecipesOfCookingPorkStewWithCorn[progressStatus]);
                        progressStatus++;
                        progressOfCookingTxt.setText(progressStatus + "/" + arrOfImgOfCookingPorkStewWithCorn.length);
                    }
                }
                else if (nameOfDish.equals("Говядина с овощами стир-фрай")) {
                    if (progressStatus == arrOfImgOfCookingBeefWithVegetablesStirFry.length) {
                        date = LocalDate.now().toString();
                        time = LocalTime.now().toString();
                        databaseHelper.addDish(getApplicationContext(), id, nameOfDish.trim(), date.trim(), time.trim());
                        Intent i = new Intent(getApplicationContext(), CookingIsDone.class);
                        i.putExtra("name_of_dish", nameOfDish);
                        startActivity(i);
                        finish();
                    } else {
                        cookingImg.setImageResource(arrOfImgOfCookingBeefWithVegetablesStirFry[progressStatus]);
                        descriptionOfCookingTxt.setText(arrOfRecipesOfCookingBeefWithVegetablesStirFry[progressStatus]);
                        progressStatus++;
                        progressOfCookingTxt.setText(progressStatus + "/" + arrOfImgOfCookingBeefWithVegetablesStirFry.length);
                    }
                }
                else if (nameOfDish.equals("Сливочная паста фетучини")) {
                    if (progressStatus == arrOfImgOfCookingCreamyFettucciniPasta.length) {
                        date = LocalDate.now().toString();
                        time = LocalTime.now().toString();
                        databaseHelper.addDish(getApplicationContext(), id, nameOfDish.trim(), date.trim(), time.trim());
                        Intent i = new Intent(getApplicationContext(), CookingIsDone.class);
                        i.putExtra("name_of_dish", nameOfDish);
                        startActivity(i);
                        finish();
                    } else {
                        cookingImg.setImageResource(arrOfImgOfCookingCreamyFettucciniPasta[progressStatus]);
                        descriptionOfCookingTxt.setText(arrOfRecipesOfCookingCreamyFettucciniPasta[progressStatus]);
                        progressStatus++;
                        progressOfCookingTxt.setText(progressStatus + "/" + arrOfImgOfCookingCreamyFettucciniPasta.length);
                    }
                }
            }
        });
    }
}