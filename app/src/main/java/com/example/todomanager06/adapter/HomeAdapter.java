package com.example.todomanager06.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todomanager06.databinding.ItemTaskBinding;
import com.example.todomanager06.model.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {

    private ItemTaskBinding binding;

    List<TaskModel> list;

    public HomeAdapter(List<TaskModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new HomeHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class HomeHolder extends RecyclerView.ViewHolder {

        public HomeHolder(@NonNull ItemTaskBinding binding) {
            super(binding.getRoot());

        }

        public void onBind(TaskModel model) {
            binding.titleTv.setText(model.getTask());
            binding.dateTv.setText(model.getDate());
            binding.repeatTv.setText(model.getRepeat());
        }
    }

}
