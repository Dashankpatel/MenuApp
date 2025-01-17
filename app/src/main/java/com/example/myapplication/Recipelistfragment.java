package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class Recipelistfragment extends Fragment {

    private static final String ARG_CUISINE_INDEX = "cuisine_index";

    public static Recipelistfragment newInstance(int cuisineIndex) {
        Recipelistfragment fragment = new Recipelistfragment();
        Bundle args = new Bundle();
        args.putInt(ARG_CUISINE_INDEX, cuisineIndex);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_r_ecipelistfragment, container, false);

        TabLayout tabLayout = view.findViewById(R.id.tb);

        int cuisineIndex = getArguments().getInt(ARG_CUISINE_INDEX);
        ViewPager viewPager = view.findViewById(R.id.recipe_view_pager);
        RecipePagerAdapter adapter = new RecipePagerAdapter(getContext(), cuisineIndex);
        viewPager.setAdapter(adapter);

        for (String recipeName : adapter.getRecipeNames(cuisineIndex)) {
            tabLayout.addTab(tabLayout.newTab().setText(recipeName));
        }

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        return view;
    }
}

//
//        // Dynamically add tabs for each recipe name in the adapter
//        for (String recipeName : adapter.getRecipeNames(cuisineIndex)) {
//            tabLayout.addTab(tabLayout.newTab().setText(recipeName));
//        }
//
//        // Link TabLayout and ViewPager
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//            }
//        });
//
//        return view;
//    }
//}


