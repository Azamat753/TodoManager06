package com.example.todomanager06.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.RadioButton;

import com.example.todomanager06.App;
import com.example.todomanager06.R;
import com.example.todomanager06.databinding.FragmentCreateTaskBinding;
import com.example.todomanager06.model.TaskModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Calendar;

public class CreateTaskBottomSheetDialogFragment extends BottomSheetDialogFragment implements DatePickerDialog.OnDateSetListener {
    FragmentCreateTaskBinding binding;
    private int startYear;
    private int starthMonth;
    private int startDay;
    private String date;
    private String repeat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateTaskBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClickers();
    }

    private void initClickers() {
        binding.applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeToDataBase();
                dismiss();
            }
        });

        binding.chooseDateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
        binding.chooseRepeatTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRepeatDialog();
            }
        });
    }

    public void writeToDataBase() {
        String text = binding.taskEd.getText().toString();
        TaskModel taskModel = new TaskModel(text, date, repeat);
        App.getApp().getDb().taskDao().insert(taskModel);
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        startYear = calendar.get(Calendar.YEAR);
        starthMonth = calendar.get(Calendar.MONTH);
        startDay = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                requireContext(), this::onDateSet, startYear, starthMonth, startDay);
        datePickerDialog.show();
    }

    private void showRepeatDialog() {
        LayoutInflater inflater = LayoutInflater.from(requireContext());
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.repeat_dialog, null);
        Dialog alertDialog = new Dialog(requireContext());
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(view);
        alertDialog.show();
        RadioButton never = alertDialog.findViewById(R.id.never_radioBtn);
        RadioButton everyDay = alertDialog.findViewById(R.id.Every_day_btn);
        RadioButton everyWeer = alertDialog.findViewById(R.id.Every_week_btn);
        RadioButton everyMonth = alertDialog.findViewById(R.id.Every_month_btn);
        RadioButton everyYear = alertDialog.findViewById(R.id.Every_year_btn);
        RadioButton custom = alertDialog.findViewById(R.id.Custom_btn);
        never.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String never = "Never";
                binding.chooseRepeatTv.setText(never);
                repeat = never;
                alertDialog.dismiss();
            }
        });
        everyDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Every = "Every day";
                binding.chooseRepeatTv.setText(Every);
                repeat = Every;
                alertDialog.dismiss();
            }
        });
        everyWeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String week = "Every week";
                binding.chooseRepeatTv.setText(week);
                repeat = week;
                alertDialog.dismiss();
            }
        });
        everyMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String month = "Every month";
                binding.chooseRepeatTv.setText(month);
                repeat = month;
                alertDialog.dismiss();
            }
        });
        everyYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String year = "Every year";
                binding.chooseRepeatTv.setText(year);
                repeat = year;
                alertDialog.dismiss();
            }
        });
        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String custom = " Custom";
                binding.chooseRepeatTv.setText(custom);
                repeat = custom;
                alertDialog.dismiss();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        date = "" + day + "." + month + 1 + "." + year;
        binding.chooseDateTv.setText("" + day + "." + month + 1 + "." + year);
    }


}