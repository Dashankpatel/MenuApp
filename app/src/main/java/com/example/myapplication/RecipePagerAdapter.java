package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class RecipePagerAdapter extends PagerAdapter {

    private final Context context;
    private final int cuisineIndex;

    private final String[][] recipeNames = {
            {"Pizza", "Pasta", "Tiramisu", "Risotto", "Lasagna", "Bruschetta", "Focaccia", "Gelato"},
            // Add similar arrays for other cuisines
    };
    private final int[][] recipeImages = {
            {R.drawable.pizza, R.drawable.pasta, R.drawable.tiramisu, R.drawable.risotto, R.drawable.lasagna, R.drawable.bruschetta, R.drawable.focaccia, R.drawable.gelato},
            // Add similar arrays for other cuisines
    };

    public RecipePagerAdapter(Context context, int cuisineIndex) {
        this.context = context;
        this.cuisineIndex = cuisineIndex;
    }

    @Override
    public int getCount() {
        return recipeNames[cuisineIndex].length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recipe_slider, container, false);

        ImageView imageView = view.findViewById(R.id.recipe_image);
        TextView textView = view.findViewById(R.id.recipe_name);

        imageView.setImageResource(recipeImages[cuisineIndex][position]);
        textView.setText(recipeNames[cuisineIndex][position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }



}
