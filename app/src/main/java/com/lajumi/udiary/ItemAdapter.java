package com.lajumi.udiary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private ArrayList<Item> _itemList;

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView _textView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            _textView = itemView.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return _textView;
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
        ItemViewHolder ivh = new ItemViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item currentItem = _itemList.get(position);

        holder.getTextView().setText(currentItem.getText());
        holder.getTextView().setTextColor(currentItem.getColor());
    }

    @Override
    public int getItemCount() {
        return _itemList.size();
    }
}















