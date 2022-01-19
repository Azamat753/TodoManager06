package com.example.todomanager06.boarding;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todomanager06.R;
import com.example.todomanager06.databinding.FragmentMainBoardBinding;
import com.example.todomanager06.model.ViewPagerModel;

import java.util.ArrayList;


public class MainBoardFragment extends Fragment implements ItemClickListener {
    private FragmentMainBoardBinding binding;
    ViewPagerAdapter adapter;
    ArrayList<ViewPagerModel> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBoardBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkOnShow();
        list.add(new ViewPagerModel("1", "1", R.drawable.todo_illustration));
        list.add(new ViewPagerModel("2", "2", R.drawable.todo_illustration));
        list.add(new ViewPagerModel("3", "3", R.drawable.todo_illustration));
        adapter = new ViewPagerAdapter(list, this);
        binding.viewpager.setAdapter(adapter);
    }

    private void checkOnShow() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared_presf",Context.MODE_PRIVATE);
        boolean isShow = sharedPreferences.getBoolean("isShow",false);
        if (isShow){
            Navigation.findNavController(requireView()).navigate(R.id.homeFragment);
        }
    }

    @Override
    public void itemClick() {
        Navigation.findNavController(requireView()).navigate(R.id.homeFragment);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared_presf",Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("isShow",true).apply();
    }
}