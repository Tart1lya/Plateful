package com.example.plateful;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DescriptionOfDishAdapter extends ArrayAdapter<DescriptionOfDish> {
    private LayoutInflater inflater;
    private int layout;
    private List<DescriptionOfDish> descriptionOfDishes;
    DescriptionOfDishAdapter(Context context, int resource, List<DescriptionOfDish> descriptionOfDishes) {
        super(context, resource, descriptionOfDishes);
        this.descriptionOfDishes = descriptionOfDishes;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);
        TextView necessaryTimeDescriptionTxt = view.findViewById(R.id.necessary_time_description_txt);
        TextView calorieCountDescriptionTxt = view.findViewById(R.id.calorie_count_description_txt);
        TextView proteinCountDescriptionTxt = view.findViewById(R.id.protein_count_description_txt);
        TextView amountOfFatDescriptionTxt = view.findViewById(R.id.amount_of_fat_description_txt);
        TextView carbohydrateCountDescriptionTxt = view.findViewById(R.id.carbohydrate_count_description_txt);
        TextView necessaryIngredientsDescriptionTxt = view.findViewById(R.id.necessary_ingredients_description_txt);
        TextView kitchenTypeDescriptionTxt = view.findViewById(R.id.kitchen_type_description_txt);
        TextView commonAllergenDescriptionTxt = view.findViewById(R.id.common_allergen_description_txt);
        DescriptionOfDish descriptionOfDish = descriptionOfDishes.get(position);
        necessaryTimeDescriptionTxt.setText(descriptionOfDish.getNecessaryTime());
        calorieCountDescriptionTxt.setText(descriptionOfDish.getCalorieCount());
        proteinCountDescriptionTxt.setText(descriptionOfDish.getProteinCount());
        amountOfFatDescriptionTxt.setText(descriptionOfDish.getAmountOfFat());
        carbohydrateCountDescriptionTxt.setText(descriptionOfDish.getCarbohydrateCount());
        necessaryIngredientsDescriptionTxt.setText(descriptionOfDish.getNecessaryIngredients());
        kitchenTypeDescriptionTxt.setText(descriptionOfDish.getKitchenType());
        commonAllergenDescriptionTxt.setText(descriptionOfDish.getCommonAllergen());
        return view;
    }
}
