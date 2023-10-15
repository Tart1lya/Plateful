package com.example.plateful;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DishDescription extends AppCompatActivity {
    public ArrayList<DescriptionOfDish> descriptionOfDishes = new ArrayList<DescriptionOfDish>();
    ListView listOfDescription;
    String descriptionOfDish;
    int [] arrBreakfast = {
            R.drawable.img_breakfast_1, R.drawable.img_breakfast_2, R.drawable.img_breakfast_3
    };
    int [] arrLunch = {
            R.drawable.img_lunch_1, R.drawable.img_lunch_2, R.drawable.img_lunch_3
    };
    int [] arrDinner = {
            R.drawable.img_dinner_1, R.drawable.img_dinner_2, R.drawable.img_dinner_3
    };
    int [] arrAllDishes = {
            R.drawable.img_breakfast_1, R.drawable.img_breakfast_2, R.drawable.img_breakfast_3,
            R.drawable.img_lunch_1, R.drawable.img_lunch_2, R.drawable.img_lunch_3,
            R.drawable.img_dinner_1, R.drawable.img_dinner_2, R.drawable.img_dinner_3
    };
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
    String [] arrAllDescriptions = {
            "Попробуйте приготовить это удивительное блюдо, оно станет прекрасным вариантом полезного и питательного завтрака для всей семьи!",
            "Солнечная яичница с тыквой не только поднимет настроение утром и напитает полезными микроэлементами, но также послужит прекрасным перекусом в течение дня, ведь готовится она очень просто и быстро!",
            "Нежный омлет сочно-ароматных овощей и пикантной феты, приготовленный на сковороде - это настоящее вкусовое наслаждение! С помощью этого блюда у вас появится возможность создать яркий, полезный и сытный завтрак без привычных яиц со сливочным маслом!",
            "Отведайте один раз, и вы уже не сможете жить без этого вкуснейшего греческого салата, который порадует вас вкусом.",
            "Перцы, фаршированные кускусом, представляют собой один из вариантов питательного и при этом очень полезного блюда, в котором сочные овощи отлично сочетаются с аппетитной крупой. Готовое блюдо получается сытным и полезным.",
            "Нежное и ароматное мясо куриной грудки, приготовленное на гриле или жареное на сковороде, не оставит вас равнодушным.",
            "Аппетитный и ароматный гуляш из нежной свинины с кукурузой будет незабываемым угощением для всей семьи. Это блюдо подходит для зимнего или осеннего времени года, когда так хочется согреться настоящим горячим ужином.",
            "Блюдо, которое не только вкусно, но и очень полезно. Приготовленное на сковороде, оно является идеальным выбором для тех, кто следит за своим здоровьем.",
            "Сливочная паста фетучини — это рецепт простого и быстрого блюда с интересными лимонными нотками. За короткое время получается вкусное, ароматное, сытное, аппетитное угощение в итальянском стиле."
    };
    String [] arrDescriptionsForBreakfast = {
            "Попробуйте приготовить это удивительное блюдо, оно станет прекрасным вариантом полезного и питательного завтрака для всей семьи!",
            "Солнечная яичница с тыквой не только поднимет настроение утром и напитает полезными микроэлементами, но также послужит прекрасным перекусом в течение дня, ведь готовится она очень просто и быстро!",
            "Нежный омлет сочно-ароматных овощей и пикантной феты, приготовленный на сковороде - это настоящее вкусовое наслаждение! С помощью этого блюда у вас появится возможность создать яркий, полезный и сытный завтрак без привычных яиц со сливочным маслом!"
    };
    String [] arrDescriptionsForLunch = {
            "Отведайте один раз, и вы уже не сможете жить без этого вкуснейшего греческого салата, который порадует вас вкусом.",
            "Перцы, фаршированные кускусом, представляют собой один из вариантов питательного и при этом очень полезного блюда, в котором сочные овощи отлично сочетаются с аппетитной крупой. Готовое блюдо получается сытным и полезным.",
            "Нежное и ароматное мясо куриной грудки, приготовленное на гриле или жареное на сковороде, не оставит вас равнодушным."
    };
    String [] arrDescriptionsForDinner = {
            "Аппетитный и ароматный гуляш из нежной свинины с кукурузой будет незабываемым угощением для всей семьи. Это блюдо подходит для зимнего или осеннего времени года, когда так хочется согреться настоящим горячим ужином.",
            "Блюдо, которое не только вкусно, но и очень полезно. Приготовленное на сковороде, оно является идеальным выбором для тех, кто следит за своим здоровьем.",
            "Сливочная паста фетучини — это рецепт простого и быстрого блюда с интересными лимонными нотками. За короткое время получается вкусное, ароматное, сытное, аппетитное угощение в итальянском стиле."
    };
    int timeStatus, index, buff;



    String [] arrNecessaryTimeForBreakfast = {
            "30 минут", "20 минут", "45 минут"
    };
    String [] arrCalorieCountForBreakfast = {
            "189", "110", "112"
    };
    String [] arrProteinCountForBreakfast = {
            "4", "5", "7"
    };
    String [] arrAmountOfFatForBreakfast = {
            "13", "4", "8"
    };
    String [] arrCarbohydrateCountForBreakfast = {
            "15", "4", "3"
    };
    String [] arrNecessaryIngredientsForBreakfast = {
            "Вода - 25г" + "\n" + "Кокосовое молоко - 50г" + "\n" + "Молотая корица - 1г" + "\n" +
                    "Миндаль жареный - 50г" + "\n" + "Семена льна - 11г" + "\n" + "Сушеная клюква - 25г" + "\n" +
                    "Яблоки «голден» - 175г" + "\n" + "Для подачи:" + "\n" + "Яблоки «голден» - 25г",
            "Тыква - 150г" + "\n" + "Яйцо - 2шт" + "\n" + "Чеснок - 1/2 зубчика" + "\n" + "Фета - 35г" + "\n" +
                    "Уксус яблочный - 1/2 чайной ложкм (по желанию)" + "\n" + "Зелень - 2 веточки (можно больше)" + "\n" +
                    "Масло растительное - 1/2 столовой ложки" + "\n" + "Специи - по вкусу" + "\n" + "Соль - по вкусу",
            "Куриное яйцо - 1шт" + "\n" + "Молоко 3,2% - 25г" + "\n" + "Соль - 1г" + "\n" + "Брокколи - 50г" + "\n" +
                    "Сливовидные помидоры - 25г" + "\n" + "Сыр фета - 15г" + "\n" + "Пармезан - 5г" + "\n" +
                    "Прованские травы - 1г" + "\n" + "Подсолнечное масло рафинированное - 2,5г"
    };
    String [] arrKitchenTypeForBreakfast = {
            "Европейская", "Европейская", "Итальянская"
    };
    String [] arrCommonAllergenForBreakfast = {
            "Орехи", "Яйцо", "Белок коровьего молока, Яйцо"
    };



    String [] arrNecessaryTimeForLunch = {
            "50 минут", "60 минут", "35 минут"
    };
    String [] arrCalorieCountForLunch = {
            "66", "93", "96"
    };
    String [] arrProteinCountForLunch = {
            "3", "4", "12"
    };
    String [] arrAmountOfFatForLunch = {
            "4", "4", "4"
    };
    String [] arrCarbohydrateCountForLunch = {
            "4", "9", "3"
    };
    String [] arrNecessaryIngredientsForLunch = {
            "Помидор - 53г" + "\n" + "Огурец - 33г" + "\n" + "Пекинская капуста - 133г" + "\n" +
                    "Болгарский перец - 50г" + "\n" + "Репчатый лук - 27г" + "\n" + "Сыр фета - 67г" + "\n" +
                    "Маслины - 33г" + "\n" + "Винный уксус белый - 1 столовая ложка" + "\n" +
                    "Лимонный сок - 1 столовая ложка" + "\n" + "Оливковое масло Extra Virgin - по вкусу" + "\n" +
                    "Соль - по вкусу" + "\n" + "Чёрный перец молотый - по вкусу" + "\n" +
                    "Сушёные травы - по вкусу" + "\n" + "Для украшения:" + "\n" + "Свежая зелень - по желанию",
            "Куриный бульон - 63г" + "\n" + "Брынза - 50г" + "\n" + "Кускус - 38г" + "\n" + "Болгарский перец - 150г" + "\n" +
                    "Репчатый лук - 20г" + "\n" + "Оливковое масло - 1/2 столовой ложки" + "\n" +
                    "Кабачок цукини - 75г" + "\n" + "Помидоры черри - 3шт" + "\n" + "Петрушка - 2г" + "\n" +
                    "Орегано - 1г" + "\n" + "Соль - по вкусу" + "\n" + "Чёрный перец молотый - по вкусу",
            "Куриное филе - 125г" + "\n" + "Соевый соус - 1 чайная ложка" + "\n" + "Растительное масло - 1/2 столовой ложки" + "\n" +
                    "Чеснок - 1/2 зубчика" + "\n" + "Соль - по вкусу" + "\n" + "Чёрный перец молотый - по вкусу" + "\n" +
                    "Для подачи:" + "\n" + "Болгарский перец - 75г" + "\n" + "Помидор - 40г"
    };
    String [] arrKitchenTypeForLunch = {
            "Греческая, европейская", "Русская", "Американская, европейская"
    };
    String [] arrCommonAllergenForLunch = {
            "Белок коровьего молока", "Белок коровьего молока, злаки, содержащие глютен", "Соя"
    };



    String [] arrNecessaryTimeForDinner = {
            "90 минут", "3 часа 20 минут", "15 минут"
    };
    String [] arrCalorieCountForDinner = {
            "135", "131", "250"
    };
    String [] arrProteinCountForDinner = {
            "6", "6", "8"
    };
    String [] arrAmountOfFatForDinner = {
            "10", "10", "14"
    };
    String [] arrCarbohydrateCountForDinner = {
            "5", "6", "22"
    };
    String [] arrNecessaryIngredientsForDinner = {
            "Свинина - 100г" + "\n" + "Консервированная кукуруза - 80г" + "\n" + "Сметана 15% жирности - 10г" + "\n" +
                    "Томатная паста - 9г" + "\n" + "Подсолнечное масло рафинированное - 7г" + "\n" + "Вода - 40г" + "\n" +
                    "Соль - по вкусу" + "\n" + "Чёрный перец молотый - по вкусу" + "\n" + "Для подачи:" + "\n" +
                    "Огурец - 20г" + "\n" + "Болгарский перец - 30г",
            "Говяжья вырезка - 100г" + "\n" + "Шампиньоны - 80г" + "\n" + "Болгарский перец - 75г" + "\n" +
                    "Стручковая фасоль - 50г" + "\n" + "Молотый имбирь - 7г" + "\n" + "Растительно масло - 26г" + "\n" +
                    "Перец чили - 8г" + "\n" + "Картофельный крахмал - 10г" + "\n" + "Говяжий бульон - 25г" + "\n" +
                    "Яблочный уксус - 1/2 столовой ложки" + "\n" + "Для маринада и подачи:" + "\n" +
                    "Соевый соус - 1,5 столовой ложки" + "\n" + "Лимонный сок - 1/2 столовой ложки" + "\n" +
                    "Чеснок - 1,5 зубчика" + "\n" + "Микрозелень - 15г",
            "Паста фетучини - 100г" + "\n" + "Сливочное масло - 1 столовая ложка" + "\n" + "Сливки 20% жирности" + "\n" +
                    "Пармезан - 25г" + "\n" + "Лимон - 1/2 штуки" + "\n" + "Соль - 2г" + "\n" + "Чёрный перец молотый - 1,5г" + "\n" +
                    "Для подачи:" + "\n" + "Базилик - 40г"
    };
    String [] arrKitchenTypeForDinner = {
            "Североамериканская", "Азиатская", "Европейская, итальянская"
    };
    String [] arrCommonAllergenForDinner = {
            "Белок коровьего молока", "Соя", "Белок коровьего молока, злаки, содержащие глютен"
    };



    String [] arrAllNecessaryTime = {
            "30 минут", "20 минут", "45 минут",
            "50 минут", "60 минут", "35 минут",
            "90 минут", "3 часа 20 минут", "15 минут"
    };
    String [] arrAllCalorieCount = {
            "189", "110", "112",
            "66", "93", "96",
            "135", "131", "250"
    };
    String [] arrAllProteinCount = {
            "4", "5", "7",
            "3", "4", "12",
            "6", "6", "8"
    };
    String [] arrAllAmountOfFat = {
            "13", "4", "8",
            "4", "4", "4",
            "10", "10", "14"
    };
    String [] arrAllCarbohydrateCount = {
            "15", "4", "3",
            "4", "9", "3",
            "5", "6", "22"
    };
    String [] arrAllNecessaryIngredients = {
            "Вода - 25г" + "\n" + "Кокосовое молоко - 50г" + "\n" + "Молотая корица - 1г" + "\n" +
                    "Миндаль жареный - 50г" + "\n" + "Семена льна - 11г" + "\n" + "Сушеная клюква - 25г" + "\n" +
                    "Яблоки «голден» - 175г" + "\n" + "Для подачи:" + "\n" + "Яблоки «голден» - 25г",
            "Тыква - 150г" + "\n" + "Яйцо - 2шт" + "\n" + "Чеснок - 1/2 зубчика" + "\n" + "Фета - 35г" + "\n" +
                    "Уксус яблочный - 1/2 чайной ложкм (по желанию)" + "\n" + "Зелень - 2 веточки (можно больше)" + "\n" +
                    "Масло растительное - 1/2 столовой ложки" + "\n" + "Специи - по вкусу" + "\n" + "Соль - по вкусу",
            "Куриное яйцо - 1шт" + "\n" + "Молоко 3,2% - 25г" + "\n" + "Соль - 1г" + "\n" + "Брокколи - 50г" + "\n" +
                    "Сливовидные помидоры - 25г" + "\n" + "Сыр фета - 15г" + "\n" + "Пармезан - 5г" + "\n" +
                    "Прованские травы - 1г" + "\n" + "Подсолнечное масло рафинированное - 2,5г",
            "Помидор - 53г" + "\n" + "Огурец - 33г" + "\n" + "Пекинская капуста - 133г" + "\n" +
                    "Болгарский перец - 50г" + "\n" + "Репчатый лук - 27г" + "\n" + "Сыр фета - 67г" + "\n" +
                    "Маслины - 33г" + "\n" + "Винный уксус белый - 1 столовая ложка" + "\n" +
                    "Лимонный сок - 1 столовая ложка" + "\n" + "Оливковое масло Extra Virgin - по вкусу" + "\n" +
                    "Соль - по вкусу" + "\n" + "Чёрный перец молотый - по вкусу" + "\n" +
                    "Сушёные травы - по вкусу" + "\n" + "Для украшения:" + "\n" + "Свежая зелень - по желанию",
            "Куриный бульон - 63г" + "\n" + "Брынза - 50г" + "\n" + "Кускус - 38г" + "\n" + "Болгарский перец - 150г" + "\n" +
                    "Репчатый лук - 20г" + "\n" + "Оливковое масло - 1/2 столовой ложки" + "\n" +
                    "Кабачок цукини - 75г" + "\n" + "Помидоры черри - 3шт" + "\n" + "Петрушка - 2г" + "\n" +
                    "Орегано - 1г" + "\n" + "Соль - по вкусу" + "\n" + "Чёрный перец молотый - по вкусу",
            "Куриное филе - 125г" + "\n" + "Соевый соус - 1 чайная ложка" + "\n" + "Растительное масло - 1/2 столовой ложки" + "\n" +
                    "Чеснок - 1/2 зубчика" + "\n" + "Соль - по вкусу" + "\n" + "Чёрный перец молотый - по вкусу" + "\n" +
                    "Для подачи:" + "\n" + "Болгарский перец - 75г" + "\n" + "Помидор - 40г",
            "Свинина - 100г" + "\n" + "Консервированная кукуруза - 80г" + "\n" + "Сметана 15% жирности - 10г" + "\n" +
                    "Томатная паста - 9г" + "\n" + "Подсолнечное масло рафинированное - 7г" + "\n" + "Вода - 40г" + "\n" +
                    "Соль - по вкусу" + "\n" + "Чёрный перец молотый - по вкусу" + "\n" + "Для подачи:" + "\n" +
                    "Огурец - 20г" + "\n" + "Болгарский перец - 30г",
            "Говяжья вырезка - 100г" + "\n" + "Шампиньоны - 80г" + "\n" + "Болгарский перец - 75г" + "\n" +
                    "Стручковая фасоль - 50г" + "\n" + "Молотый имбирь - 7г" + "\n" + "Растительно масло - 26г" + "\n" +
                    "Перец чили - 8г" + "\n" + "Картофельный крахмал - 10г" + "\n" + "Говяжий бульон - 25г" + "\n" +
                    "Яблочный уксус - 1/2 столовой ложки" + "\n" + "Для маринада и подачи:" + "\n" +
                    "Соевый соус - 1,5 столовой ложки" + "\n" + "Лимонный сок - 1/2 столовой ложки" + "\n" +
                    "Чеснок - 1,5 зубчика" + "\n" + "Микрозелень - 15г",
            "Паста фетучини - 100г" + "\n" + "Сливочное масло - 1 столовая ложка" + "\n" + "Сливки 20% жирности" + "\n" +
                    "Пармезан - 25г" + "\n" + "Лимон - 1/2 штуки" + "\n" + "Соль - 2г" + "\n" + "Чёрный перец молотый - 1,5г" + "\n" +
                    "Для подачи:" + "\n" + "Базилик - 40г"
    };
    String [] arrAllKitchenType = {
            "Европейская", "Европейская", "Итальянская",
            "Греческая, европейская", "Русская", "Американская, европейская",
            "Североамериканская", "Азиатская", "Европейская, итальянская"
    };
    String [] arrAllCommonAllergen = {
            "Орехи", "Яйцо", "Белок коровьего молока, Яйцо",
            "Белок коровьего молока", "Белок коровьего молока, злаки, содержащие глютен", "Соя",
            "Белок коровьего молока", "Соя", "Белок коровьего молока, злаки, содержащие глютен"
    };



    String choiceStatus = "Перешёл по рекам", nameOfDish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dish_description);
        listOfDescription = findViewById(R.id.list_of_discriptions);
        DescriptionOfDishAdapter descriptionOfDishAdapter = new DescriptionOfDishAdapter(this, R.layout.list_of_descriptions, descriptionOfDishes);
        listOfDescription.setAdapter(descriptionOfDishAdapter);
        ImageView dishInDescriptionImg = findViewById(R.id.dish_in_description_img);
        TextView nameOfDishInDescriptionTxt = findViewById(R.id.name_of_dish_in_description_txt);
        TextView descriptionOfDishInDescriptionTxt = findViewById(R.id.description_of_dish_in_description_txt);
        ImageButton goCookBtn = findViewById(R.id.go_cook_btn);
        ImageButton backInDescriptionBtn = findViewById(R.id.back_in_description_btn);
        choiceStatus = getIntent().getExtras().getString("choice_status");
        nameOfDish = getIntent().getExtras().getString("name_of_dish");
        if (choiceStatus.equals("Перешёл по рекам")) {
            timeStatus = getIntent().getExtras().getInt("time_status");
            index = getIntent().getExtras().getInt("index_key");
            if (timeStatus == 0) {
                dishInDescriptionImg.setImageResource(arrBreakfast[index]);
                nameOfDishInDescriptionTxt.setText(arrNameOfBreakfast[index]);
                descriptionOfDishInDescriptionTxt.setText(arrDescriptionsForBreakfast[index]);
                descriptionOfDishes.add(new DescriptionOfDish(arrNecessaryTimeForBreakfast[index],
                        arrCalorieCountForBreakfast[index], arrProteinCountForBreakfast[index],
                        arrAmountOfFatForBreakfast[index], arrCarbohydrateCountForBreakfast[index],
                        arrNecessaryIngredientsForBreakfast[index], arrKitchenTypeForBreakfast[index],
                        arrCommonAllergenForBreakfast[index]));

            } else if (timeStatus == 1) {
                dishInDescriptionImg.setImageResource(arrLunch[index]);
                nameOfDishInDescriptionTxt.setText(arrNameOfLunch[index]);
                descriptionOfDishInDescriptionTxt.setText(arrDescriptionsForLunch[index]);
                descriptionOfDishes.add(new DescriptionOfDish(arrNecessaryTimeForLunch[index],
                        arrCalorieCountForLunch[index], arrProteinCountForLunch[index],
                        arrAmountOfFatForLunch[index], arrCarbohydrateCountForLunch[index],
                        arrNecessaryIngredientsForLunch[index], arrKitchenTypeForLunch[index],
                        arrCommonAllergenForLunch[index]));
            }
            else if (timeStatus == 2) {
                dishInDescriptionImg.setImageResource(arrDinner[index]);
                nameOfDishInDescriptionTxt.setText(arrNameOfDinner[index]);
                descriptionOfDishInDescriptionTxt.setText(arrDescriptionsForDinner[index]);
                descriptionOfDishes.add(new DescriptionOfDish(arrNecessaryTimeForDinner[index],
                        arrCalorieCountForDinner[index], arrProteinCountForDinner[index],
                        arrAmountOfFatForDinner[index], arrCarbohydrateCountForDinner[index],
                        arrNecessaryIngredientsForDinner[index], arrKitchenTypeForDinner[index],
                        arrCommonAllergenForDinner[index]));
            }
        } else {
            for (int i = 0; i < arrNameOfDishes.length; i++) {
                if (nameOfDish.equals(arrNameOfDishes[i])) {
                    buff = i;
                    break;
                }
            }
            dishInDescriptionImg.setImageResource(arrAllDishes[buff]);
            nameOfDishInDescriptionTxt.setText(arrNameOfDishes[buff]);
            descriptionOfDishInDescriptionTxt.setText(arrAllDescriptions[buff]);
            descriptionOfDishes.add(new DescriptionOfDish(arrAllNecessaryTime[buff],
                    arrAllCalorieCount[buff], arrAllProteinCount[buff],
                    arrAllAmountOfFat[buff], arrAllCarbohydrateCount[buff],
                    arrAllNecessaryIngredients[buff], arrAllKitchenType[buff],
                    arrAllCommonAllergen[buff]));
        }
        backInDescriptionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(i);
                finish();
            }
        });
        goCookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Cooking.class);
                Intent g = new Intent(getApplicationContext(), CookingIsDone.class);
                i.putExtra("time_status_final", timeStatus);
                i.putExtra("index_final", index);
                i.putExtra("buff_final", buff);
                i.putExtra("choice_status_final", choiceStatus);
                if (choiceStatus.equals("Перешёл по рекам")) {
                    if (timeStatus == 0) {
                        descriptionOfDish = arrDescriptionsForBreakfast[index];
                        g.putExtra("description_of_dish", descriptionOfDish);
                    }
                    if (timeStatus == 1) {
                        descriptionOfDish = arrDescriptionsForLunch[index];
                        g.putExtra("description_of_dish", descriptionOfDish);
                    }
                    if (timeStatus == 2) {
                        descriptionOfDish = arrDescriptionsForDinner[index];
                        g.putExtra("description_of_dish", descriptionOfDish);
                    }
                } else {
                    descriptionOfDish = arrAllDescriptions[buff];
                    g.putExtra("description_of_dish", descriptionOfDish);
                }
                startActivity(i);
                finish();
            }
        });
    }
}