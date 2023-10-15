package com.example.plateful;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class MainMenu extends AppCompatActivity {
    public ArrayList<Dishes> dishes = new ArrayList<Dishes>();
    ListView listOfDishes;
    private static final LocalTime DAY_TIME = LocalTime.of(12,0);
    private static final LocalTime EVENING_TIME = LocalTime.of(17,0);
    private static final LocalTime NIGHT_TIME = LocalTime.of(23,0);
    int progressStatus = 0;
    int buffRandom;
    String timeStatus;
    TextView whichMealTxt;
    LocalTime localTime;
    ImageView recDishesImg;
    int i = 0;
    int numberOfImgInRandArray = 0;
    Random r = new Random();
    String choiceStatus = "Перешёл по рекам";
    int [] arrRecommendedBreakfast = new int[3];
    int [] arrRecommendedLunch = new int[3];
    int [] arrRecommendedDinner = new int[3];
    int timeStatusVar;
    String nameOfDishVar;
    String [] arrNameOfDishes = {"Яблочная каша", "Яичница с тыквой", "Фриттата с овощами и фетой",
            "Салат греческий с курицей", "Перцы, фаршированные кускусом", "Куриный стейк",
            "Тушеная свинина с кукурузой", "Говядина с овощами стир-фрай", "Сливочная паста фетучини"
    };
    int [] arrProgress = {
            R.drawable.first_active, R.drawable.second_active, R.drawable.third_active
    };

    int [] arrBreakfast = {
            R.drawable.img_breakfast_1, R.drawable.img_breakfast_2, R.drawable.img_breakfast_3
    };
    int [] arrLunch = {
            R.drawable.img_lunch_1, R.drawable.img_lunch_2, R.drawable.img_lunch_3
    };
    int [] arrDinner = {
            R.drawable.img_dinner_1, R.drawable.img_dinner_2, R.drawable.img_dinner_3
    };
    int [] arrIndexesOfRecImg = new int[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_menu);
        ImageButton profileBtn = findViewById(R.id.profile_btn);
        ImageButton prevBtn = findViewById(R.id.prev_btn);
        ImageButton nextBtn = findViewById(R.id.next_btn);
        ImageButton breakfastBtn = findViewById(R.id.breakfast_btn);
        ImageButton lunchBtn = findViewById(R.id.lunch_btn);
        ImageButton dinnerBtn = findViewById(R.id.dinner_btn);
        ImageButton favouritesBtn = findViewById(R.id.favourites_btn);
        ImageView progressImg = findViewById(R.id.progress_img);
        listOfDishes = findViewById(R.id.list_of_dishes_main);
        DishesAdapter dishesAdapter = new DishesAdapter(this, R.layout.list_of_dishes, dishes);
        listOfDishes.setAdapter(dishesAdapter);
        recDishesImg = findViewById(R.id.rec_dishes_img);
        whichMealTxt = findViewById(R.id.which_meal_txt);
        progressImg.setImageResource(arrProgress[progressStatus]);
        localTime = LocalTime.now();
        getTime(localTime);
        if (timeStatus.equals("Утро")) {
            timeStatusVar = 0;
            buffRandom = r.nextInt(arrBreakfast.length);
            while (numberOfImgInRandArray != 3) {
                while (true) {
                    if (arrBreakfast[buffRandom] != 0) {
                        arrRecommendedBreakfast[numberOfImgInRandArray] = arrBreakfast[buffRandom];
                        arrIndexesOfRecImg[numberOfImgInRandArray] = buffRandom;
                        arrBreakfast[buffRandom] = 0;
                        break;
                    } else {
                        buffRandom = r.nextInt(arrBreakfast.length);
                    }
                }
                numberOfImgInRandArray++;
            }
            recDishesImg.setImageResource(arrRecommendedBreakfast[progressStatus]);
        } else if (timeStatus.equals("День")) {
            timeStatusVar = 1;
            buffRandom = r.nextInt(arrLunch.length);
            while (numberOfImgInRandArray != 3) {
                while (true) {
                    if (arrLunch[buffRandom] != 0) {
                        arrRecommendedLunch[numberOfImgInRandArray] = arrLunch[buffRandom];
                        arrIndexesOfRecImg[numberOfImgInRandArray] = buffRandom;
                        arrLunch[buffRandom] = 0;
                        break;
                    } else {
                        buffRandom = r.nextInt(arrLunch.length);
                    }
                }
                numberOfImgInRandArray++;
            }
            recDishesImg.setImageResource(arrRecommendedLunch[progressStatus]);
        } else if (timeStatus.equals("Вечер")) {
            timeStatusVar = 2;
            buffRandom = r.nextInt(arrDinner.length);
            while (numberOfImgInRandArray != 3) {
                while (true) {
                    if (arrDinner[buffRandom] != 0) {
                        arrRecommendedDinner[numberOfImgInRandArray] = arrDinner[buffRandom];
                        arrIndexesOfRecImg[numberOfImgInRandArray] = buffRandom;
                        arrDinner[buffRandom] = 0;
                        break;
                    } else {
                        buffRandom = r.nextInt(arrDinner.length);
                    }
                }
                numberOfImgInRandArray++;
            }
            recDishesImg.setImageResource(arrRecommendedDinner[progressStatus]);
        }
        addDishes();
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressStatus++;
                if (progressStatus == 3) {
                    progressStatus = 0;
                    progressImg.setImageResource(arrProgress[progressStatus]);
                    if (timeStatus.equals("Утро")) {
                        recDishesImg.setImageResource(arrRecommendedBreakfast[progressStatus]);
                    } else if (timeStatus.equals("День")) {
                        recDishesImg.setImageResource(arrRecommendedLunch[progressStatus]);
                    } else if (timeStatus.equals("Вечер")) {
                        recDishesImg.setImageResource(arrRecommendedDinner[progressStatus]);
                    }
                } else {
                    progressImg.setImageResource(arrProgress[progressStatus]);
                    if (timeStatus.equals("Утро")) {
                        recDishesImg.setImageResource(arrRecommendedBreakfast[progressStatus]);
                    } else if (timeStatus.equals("День")) {
                        recDishesImg.setImageResource(arrRecommendedLunch[progressStatus]);
                    } else if (timeStatus.equals("Вечер")) {
                        recDishesImg.setImageResource(arrRecommendedDinner[progressStatus]);
                    }
                }
            }
        });
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressStatus--;
                if (progressStatus == -1) {
                    progressStatus = 2;
                    progressImg.setImageResource(arrProgress[progressStatus]);
                    if (timeStatus.equals("Утро")) {
                        recDishesImg.setImageResource(arrRecommendedBreakfast[progressStatus]);
                    } else if (timeStatus.equals("День")) {
                        recDishesImg.setImageResource(arrRecommendedLunch[progressStatus]);
                    } else if (timeStatus.equals("Вечер")) {
                        recDishesImg.setImageResource(arrRecommendedDinner[progressStatus]);
                    }
                } else {
                    progressImg.setImageResource(arrProgress[progressStatus]);
                    if (timeStatus.equals("Утро")) {
                        recDishesImg.setImageResource(arrRecommendedBreakfast[progressStatus]);
                    } else if (timeStatus.equals("День")) {
                        recDishesImg.setImageResource(arrRecommendedLunch[progressStatus]);
                    } else if (timeStatus.equals("Вечер")) {
                        recDishesImg.setImageResource(arrRecommendedDinner[progressStatus]);
                    }
                }
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Profile.class);
                startActivity(i);
                finish();
            }
        });
        breakfastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < dishes.size(); i++) {
                    dishesAdapter.remove(dishes.get(i));
                }
                dishes.clear();
                dishesAdapter.notifyDataSetChanged();
                dishes.add(new Dishes("Яблочная каша",
                        "Попробуйте приготовить это удивительное блюдо, оно станет прекрасным вариантом полезного и питательного завтрака для всей семьи!",
                        R.drawable.img_breakfast_1));
                dishes.add(new Dishes("Яичница с тыквой",
                        "Солнечная яичница с тыквой не только поднимет настроение утром и напитает полезными микроэлементами, но также послужит прекрасным перекусом в течение дня, ведь готовится она очень просто и быстро!",
                        R.drawable.img_breakfast_2));
                dishes.add(new Dishes("Фриттата с овощами и фетой",
                        "Нежный омлет сочно-ароматных овощей и пикантной феты, приготовленный на сковороде - это настоящее вкусовое наслаждение! С помощью этого блюда у вас появится возможность создать яркий, полезный и сытный завтрак без привычных яиц со сливочным маслом!",
                        R.drawable.img_breakfast_3));
            }
        });
        lunchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < dishes.size(); i++) {
                    dishesAdapter.remove(dishes.get(i));
                }
                dishes.clear();
                dishesAdapter.notifyDataSetChanged();
                dishes.add(new Dishes("Салат греческий с курицей",
                        "Отведайте один раз, и вы уже не сможете жить без этого вкуснейшего греческого салата, который порадует вас вкусом",
                        R.drawable.img_lunch_1));
                dishes.add(new Dishes("Перцы, фаршированные кускусом",
                        "Перцы, фаршированные кускусом, представляют собой один из вариантов питательного и при этом очень полезного блюда, в котором сочные овощи отлично сочетаются с аппетитной крупой. Готовое блюдо получается сытным и полезным.", R.drawable.img_lunch_2));
                dishes.add(new Dishes("Куриный стейк",
                        "Нежное и ароматное мясо куриной грудки, приготовленное на гриле или жареное на сковороде, не оставит вас равнодушным.",
                        R.drawable.img_lunch_3));
            }
        });
        dinnerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < dishes.size(); i++) {
                    dishesAdapter.remove(dishes.get(i));
                }
                dishes.clear();
                dishesAdapter.notifyDataSetChanged();
                dishes.add(new Dishes("Тушеная свинина с кукурузой",
                        "Аппетитный и ароматный гуляш из нежной свинины с кукурузой будет незабываемым угощением для всей семьи. Это блюдо подходит для зимнего или осеннего времени года, когда так хочется согреться настоящим горячим ужином.",
                        R.drawable.img_dinner_1));
                dishes.add(new Dishes("Говядина с овощами стир-фрай",
                        "Блюдо, которое не только вкусно, но и очень полезно. Приготовленное на сковороде, оно является идеальным выбором для тех, кто следит за своим здоровьем.",
                        R.drawable.img_dinner_2));
                dishes.add(new Dishes("Сливочная паста фетучини",
                        "Сливочная паста фетучини — это рецепт простого и быстрого блюда с интересными лимонными нотками. За короткое время получается вкусное, ароматное, сытное, аппетитное угощение в итальянском стиле.",
                        R.drawable.img_dinner_3));
            }
        });
        favouritesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        listOfDishes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView nameOfDishTxt = (TextView) view.findViewById(R.id.name_of_dish_txt);
                if (l == 0) {
                    while (true) {
                        if (nameOfDishTxt.getText().toString().equals(arrNameOfDishes[i])) {
                            Intent g = new Intent(getApplicationContext(), DishDescription.class);
                            g.putExtra("name_of_dish", nameOfDishTxt.getText().toString());
                            choiceStatus = "Перешёл по списку";
                            g.putExtra("choice_status", choiceStatus);
                            startActivity(g);
                            finish();
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                else if (l == 1) {
                    while (true) {
                        if (nameOfDishTxt.getText().toString().equals(arrNameOfDishes[i])) {
                            Intent g = new Intent(getApplicationContext(), DishDescription.class);
                            g.putExtra("name_of_dish", nameOfDishTxt.getText().toString());
                            choiceStatus = "Перешёл по списку";
                            g.putExtra("choice_status", choiceStatus);
                            startActivity(g);
                            finish();
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                else if (l == 2) {
                    while (true) {
                        if (nameOfDishTxt.getText().toString().equals(arrNameOfDishes[i])) {
                            Intent g = new Intent(getApplicationContext(), DishDescription.class);
                            g.putExtra("name_of_dish", nameOfDishTxt.getText().toString());
                            choiceStatus = "Перешёл по списку";
                            g.putExtra("choice_status", choiceStatus);
                            startActivity(g);
                            finish();
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
        });
        recDishesImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent g = new Intent(getApplicationContext(), DishDescription.class);
                choiceStatus = "Перешёл по рекам";
                g.putExtra("choice_status", choiceStatus);
                g.putExtra("time_status", timeStatusVar);
                g.putExtra("index_key", arrIndexesOfRecImg[progressStatus]);
                startActivity(g);
                finish();
            }
        });
    }
    public String getTime(LocalTime curTime) {
        if (curTime.isBefore(DAY_TIME)) {
            whichMealTxt.setText("Рекомендуем к завтраку");
            timeStatus = "Утро";
        }
        else if (curTime.isBefore(EVENING_TIME)) {
            whichMealTxt.setText("Рекомендуем к обеду");
            timeStatus = "День";
        }
        else if (curTime.isBefore(NIGHT_TIME)) {
            whichMealTxt.setText("Рекомендуем к ужину");
            timeStatus = "Вечер";
        }
        return null;
    }
    private void addDishes() {
        if (timeStatus.equals("Утро")) {
            dishes.add(new Dishes("Яблочная каша",
                    "Попробуйте приготовить это удивительное блюдо, оно станет прекрасным вариантом полезного и питательного завтрака для всей семьи!",
                    R.drawable.img_breakfast_1));
            dishes.add(new Dishes("Яичница с тыквой",
                    "Солнечная яичница с тыквой не только поднимет настроение утром и напитает полезными микроэлементами, но также послужит прекрасным перекусом в течение дня, ведь готовится она очень просто и быстро!",
                    R.drawable.img_breakfast_2));
            dishes.add(new Dishes("Фриттата с овощами и фетой", "Нежный омлет сочно-ароматных овощей и пикантной феты, приготовленный на сковороде - это настоящее вкусовое наслаждение! С помощью этого блюда у вас появится возможность создать яркий, полезный и сытный завтрак без привычных яиц со сливочным маслом!",
                    R.drawable.img_breakfast_3));
        }
        else if (timeStatus.equals("День")) {
            dishes.add(new Dishes("Салат греческий с курицей", "Отведайте один раз, и вы уже не сможете жить без этого вкуснейшего греческого салата, который порадует вас вкусом",
                    R.drawable.img_lunch_1));
            dishes.add(new Dishes("Перцы, фаршированные кускусом",
                    "Перцы, фаршированные кускусом, представляют собой один из вариантов питательного и при этом очень полезного блюда, в котором сочные овощи отлично сочетаются с аппетитной крупой. Готовое блюдо получается сытным и полезным.", R.drawable.img_lunch_2));
            dishes.add(new Dishes("Куриный стейк",
                    "Нежное и ароматное мясо куриной грудки, приготовленное на гриле или жареное на сковороде, не оставит вас равнодушным.",
                    R.drawable.img_lunch_3));
        }
        else if (timeStatus.equals("Вечер")) {
            dishes.add(new Dishes("Тушеная свинина с кукурузой",
                    "Аппетитный и ароматный гуляш из нежной свинины с кукурузой будет незабываемым угощением для всей семьи. Это блюдо подходит для зимнего или осеннего времени года, когда так хочется согреться настоящим горячим ужином.",
                    R.drawable.img_dinner_1));
            dishes.add(new Dishes("Говядина с овощами стир-фрай",
                    "Блюдо, которое не только вкусно, но и очень полезно. Приготовленное на сковороде, оно является идеальным выбором для тех, кто следит за своим здоровьем.",
                    R.drawable.img_dinner_2));
            dishes.add(new Dishes("Сливочная паста фетучини",
                    "Сливочная паста фетучини — это рецепт простого и быстрого блюда с интересными лимонными нотками. За короткое время получается вкусное, ароматное, сытное, аппетитное угощение в итальянском стиле.",
                    R.drawable.img_dinner_3));
        }
    }
}