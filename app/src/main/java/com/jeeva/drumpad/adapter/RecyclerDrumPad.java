package com.jeeva.drumpad.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jeeva.drumpad.DrumPadData;
import com.jeeva.drumpad.databinding.RecyclerDrumBinding;
import com.jeeva.drumpad.listener.ClickListener;

import java.util.List;

public class RecyclerDrumPad extends RecyclerView.Adapter<RecyclerDrumPad.ViewHolder> {

    List<DrumPadData> drumPadData;
    ClickListener clickListener;

    public RecyclerDrumPad(List<DrumPadData> drumPadData,ClickListener clickListener) {
        this.clickListener = clickListener;
        this.drumPadData = drumPadData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerDrumBinding recyclerDrumBinding = RecyclerDrumBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        recyclerDrumBinding.drum.setHeight((parent.getMeasuredHeight() / 3) - 50);
        return new ViewHolder(recyclerDrumBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.recyclerDrumBinding.setDrumpad(drumPadData.get(position));
    }

    @Override
    public int getItemCount() {
        return drumPadData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerDrumBinding recyclerDrumBinding;

        public ViewHolder(@NonNull RecyclerDrumBinding recyclerDrumBinding) {
            super(recyclerDrumBinding.getRoot());
            this.recyclerDrumBinding = recyclerDrumBinding;
            recyclerDrumBinding.drum.setOnClickListener(v -> clickListener.btnOnClick(getAdapterPosition()));
        }
    }
}