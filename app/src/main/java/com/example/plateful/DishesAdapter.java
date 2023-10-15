package com.example.plateful;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DishesAdapter extends ArrayAdapter<Dishes> {
    private LayoutInflater inflater;
    private int layout;
    private List<Dishes> dishes;
    DishesAdapter(Context context, int resource, List<Dishes> dishes) {
        super(context, resource, dishes);
        this.dishes = dishes;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);
        ImageView dishImg = view.findViewById(R.id.dish_img);
        TextView nameOfDishTxt = view.findViewById(R.id.name_of_dish_txt);
        TextView descriptionOfDishTxt = view.findViewById(R.id.description_of_dish_txt);
        Dishes dish = dishes.get(position);
        dishImg.setImageResource(dish.getDishImgResource());
        nameOfDishTxt.setText(dish.getNameOfDish());
        descriptionOfDishTxt.setText(dish.getDescriptionOfDish());
        return view;
    }
}
