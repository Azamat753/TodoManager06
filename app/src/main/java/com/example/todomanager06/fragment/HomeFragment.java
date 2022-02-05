package com.example.todomanager06.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todomanager06.App;
import com.example.todomanager06.R;
import com.example.todomanager06.adapter.HomeAdapter;
import com.example.todomanager06.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    String text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClickers();
        initAdapter();
    }

    private void initAdapter() {
        App.getApp().getDb().taskDao().getData().observe(getViewLifecycleOwner(), listTask -> {
            HomeAdapter homeAdapter = new HomeAdapter(listTask);
            binding.homeRecycler.setAdapter(homeAdapter);
        });
    }

    private void initClickers() {
        binding.openCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateTaskBottomSheetDialogFragment createTaskBottomSheetDialogFragment = new CreateTaskBottomSheetDialogFragment();
                createTaskBottomSheetDialogFragment.show(requireActivity().getSupportFragmentManager(), "");
            }
        });
        binding.profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(requireView()).navigate(R.id.profileFragment);
            }
        });
    }
}