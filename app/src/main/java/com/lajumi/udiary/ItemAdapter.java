package com.lajumi.udiary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private final ArrayList<Item> _itemList;

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView textTextView;
        public TextView timeTextView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textTextView = itemView.findViewById(R.id.textTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
        }
    }

    public ItemAdapter(ArrayList<Item> itemList)
    {
        _itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item currentItem = _itemList.get(position);

        holder.textTextView.setText(currentItem.getText());
        holder.textTextView.setTextColor(currentItem.getColor());
        try {
            holder.timeTextView.setText(currentItem.getTime());
        } catch (Exception e) {
            holder.timeTextView.setText("??:??");
        }


    }

    @Override
    public int getItemCount() {
        return _itemList.size();
    }
}















