package com.mehmetpekcan.listviewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomAdapterActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_custom_adapter);

    ListView customListView = findViewById(R.id.customListView);
    Animal dog = new Animal("dog", R.drawable.dog);
    Animal cat = new Animal("cat", R.drawable.cat);
    Animal spider = new Animal("spider", R.drawable.spider);
    Animal mouse = new Animal("mouse", R.drawable.mouse);

    ArrayList<Animal> animals = new ArrayList<>();
    animals.add(dog);
    animals.add(cat);
    animals.add(spider);
    animals.add(mouse);

    AnimalListAdapter animalListAdapter = new AnimalListAdapter(this, R.layout.custom_adapter_layout, animals);
    customListView.setAdapter(animalListAdapter);
  }
}