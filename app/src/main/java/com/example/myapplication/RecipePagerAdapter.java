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
            {"Pizza Margherita", "Spaghetti Carbonara", "Lasagna", "Risotto", "Ravioli",
                    "Gnocchi", "Tiramisu", "Panna Cotta"},
            {  "Paneer Butter Masala", "Biryani", "Chole Bhature",
                    "Masala Dosa", "Pav Bhaji", "Aloo Paratha", "Samosa", "Pani Puri"},
            {  "Sweet and Sour", "Fried Rice", "Spring Rolls", "Chow Mein",
                    "Dim Sum", "Hot and Sour Soup", "Szechuan Tofu", "Dumplings"},
            {  "Tacos", "Burritos", "Enchiladas",  "Quesadillas",
                    "Churros",  "Nachos", "Pozole", "Fajitas"},
            {  "Sushi", "Ramen", "Tempura", "Sashimi",
                    "Teriyaki Chicken", "Takoyaki", "Okonomiyaki",  "Matcha Ice Cream"},
            {  "Pad Thai", "Green Curry",  "Massaman Curry", "Som Tum (Papaya Salad)",
                    "Panang Curry", "Thai Fried Rice", "Satay", "Red Curry"},
            {  "Croissants", "Ratatouille", "Coq au Vin", "Bouillabaisse",
                    "Beef Bourguignon", "Macarons", "Quiche Lorraine", "Madeleines"},
            {  "Moussaka",  "Tzatziki", "Spanakopita", "Dolma",
                        "Greek Salad", "Baklava", "Gyro",  "Fasolada"},
            {   "Hummus", "Falafel", "Shawarma",  "Tabbouleh",
                    "Pita Bread", "Kofta", "Fattoush", "Lentil Soup", },
            {  "Kimchi", "Bibimbap", "Bulgogi", "Japchae",
                    "Korean Fried Chicken", "Samgyeopsal", "Kimchi Jjigae", "Hotteok"},
    };
    private final int[][] recipeImages = {
            {R.drawable.pizzamargherita, R.drawable.spaghetticarbonara, R.drawable.lasagna, R.drawable.risotto,
                    R.drawable.ravioli, R.drawable.gnocchi, R.drawable.tiramisu, R.drawable.pannacotta},
            {R.drawable.paneerbuttermasala, R.drawable.biryani, R.drawable.cholebhature, R.drawable.masaladosa,
                    R.drawable.pavbhaji, R.drawable.aooparatha, R.drawable.samosa, R.drawable.panipuri},
            {R.drawable.sweetandsours, R.drawable.friedrice, R.drawable.springrolls, R.drawable.chowmei,
                    R.drawable.dimsum, R.drawable.hotandsoursoup, R.drawable.szechuantofu, R.drawable.dumplings},
            {R.drawable.tacos, R.drawable.burritos, R.drawable.enchiladas, R.drawable.quesadillas,
                    R.drawable.churros, R.drawable.nachos, R.drawable.pozole, R.drawable.fajitas},
            {R.drawable.sushi, R.drawable.ramen, R.drawable.tempura, R.drawable.sashimi,
                    R.drawable.teriyakichicken, R.drawable.takoyaki, R.drawable.okonomiyaki, R.drawable.matchaicecream},
            {R.drawable.padthai, R.drawable.greencurry, R.drawable.massamancurry, R.drawable.somtum,
                    R.drawable.panangcurry, R.drawable.thaifriedrice, R.drawable.satay, R.drawable.redcurry},
            {R.drawable.croissants, R.drawable.ratatouille, R.drawable.coqauvin, R.drawable.bouillabaisse,
                    R.drawable.beefbourguignon, R.drawable.macarons, R.drawable.quichelorraine, R.drawable.madeleines},
            {R.drawable.moussaka, R.drawable.tzatziki, R.drawable.spanakopita, R.drawable.dolma,
                    R.drawable.greeksalad, R.drawable.baklava, R.drawable.gyro, R.drawable.fasolada},
            {R.drawable.hummus, R.drawable.falafel, R.drawable.shawarma, R.drawable.tabbouleh,
                    R.drawable.pitabread, R.drawable.kofta, R.drawable.fattoush, R.drawable.lentilsoup},
            {R.drawable.kimchi, R.drawable.bibimbap, R.drawable.bulgogi, R.drawable.japchae,
                    R.drawable.koreanfriedchicken, R.drawable.samgyeopsal, R.drawable.kimchijjigae, R.drawable.hotteok},
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

    public String[] getRecipeNames(int cuisineIndex) {
        return recipeNames[cuisineIndex]; // Return recipe names for the current cuisine
    }
}

//    public String[] getRecipeNames(int cuisineIndex) {
//        return recipeNames[cuisineIndex]; // Return recipe names for the current cuisine
//    }
//}

