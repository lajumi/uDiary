package com.lajumi.udiary;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class AddItemSheet extends BottomSheetDialogFragment {

    private final MainActivity _mainActivity;
    private EditText _inputAddEntry;
    public AddItemSheet(MainActivity mainActivity) {
        _mainActivity = mainActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.row_add_item, container, false);

        Button btnAddDefault = v.findViewById(R.id.btnAddDefault);
        Button btnAdd1 = v.findViewById(R.id.btnAdd1);
        Button btnAdd2 = v.findViewById(R.id.btnAdd2);
        Button btnAdd3 = v.findViewById(R.id.btnAdd3);
        Button btnAdd4 = v.findViewById(R.id.btnAdd4);
        Button btnAdd5 = v.findViewById(R.id.btnAdd5);
        Button btnAdd6 = v.findViewById(R.id.btnAdd6);
        _inputAddEntry = v.findViewById(R.id.inputAddEntry);

        btnAdd1.setOnClickListener((view) -> addItem(Item.COLOR1));
        btnAdd2.setOnClickListener((view) -> addItem(Item.COLOR2));
        btnAdd3.setOnClickListener((view) -> addItem(Item.COLOR3));
        btnAdd4.setOnClickListener((view) -> addItem(Item.COLOR4));
        btnAdd5.setOnClickListener((view) -> addItem(Item.COLOR5));
        btnAdd6.setOnClickListener((view) -> addItem(Item.COLOR6));
        btnAddDefault.setOnClickListener((view) -> addItem(Item.COLOR_DEFAULT));

        return v;
    }
    private void addItem(int color) {
        String input = _inputAddEntry.getText().toString();
        _mainActivity.insertItem(0, new Item(input, color));
        dismiss();
    }
}























