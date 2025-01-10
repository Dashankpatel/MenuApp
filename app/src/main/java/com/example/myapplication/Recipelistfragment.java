package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


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

        int cuisineIndex = getArguments().getInt(ARG_CUISINE_INDEX);
        ViewPager viewPager = view.findViewById(R.id.recipe_view_pager);
        RecipePagerAdapter adapter = new RecipePagerAdapter(getContext(), cuisineIndex);
        viewPager.setAdapter(adapter);

        return view;
    }
}