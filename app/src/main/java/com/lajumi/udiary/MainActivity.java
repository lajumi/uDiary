package com.lajumi.udiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String ITEM_LIST = "_itemList";
    private ArrayList<Item> _itemList;
    private FloatingActionButton _fab;
    private RecyclerView _recyclerView;
    private RecyclerView.Adapter<ItemAdapter.ItemViewHolder> _adapter;
    private RecyclerView.LayoutManager _layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();
        createRecyclerView();

        _fab = findViewById(R.id.fab);
        _fab.setOnClickListener((v) -> {
            AddItemSheet addItemSheet = new AddItemSheet(this);
            addItemSheet.show(getSupportFragmentManager(), "TAG");
        });

        createSwipeFunctionality();
    }



    public void insertItem(int position, Item item) {
        _itemList.add(position, item);
        _adapter.notifyItemInserted(position);
        saveData();
    }
    public void removeItem(int position) {
        _itemList.remove(position);
        _adapter.notifyItemRemoved(position);
        saveData();
    }









    private void saveData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(_itemList);
        editor.putString(ITEM_LIST, json);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(ITEM_LIST, null);
        Type type = new TypeToken<ArrayList<Item>>() {}.getType();
        _itemList = gson.fromJson(json, type);

        if (_itemList == null) {
            _itemList = new ArrayList<>();
        }
    }

    private void createRecyclerView() {
        _recyclerView = findViewById(R.id.recyclerView);
        //_recyclerView.setHasFixedSize(true);
        _layoutManager = new LinearLayoutManager(this);
        _adapter = new ItemAdapter(_itemList);

        _recyclerView.setLayoutManager(_layoutManager);
        _recyclerView.setAdapter(_adapter);
    }

    private void createSwipeFunctionality() {
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                removeItem(position);
            }
        }).attachToRecyclerView(_recyclerView);
    }
}
















