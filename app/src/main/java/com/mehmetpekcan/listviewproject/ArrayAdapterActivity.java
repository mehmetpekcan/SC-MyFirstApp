package com.mehmetpekcan.listviewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ArrayAdapterActivity extends AppCompatActivity {

  String[] animals = {
          "Ant", "Bear", "Bird", "Cat", "Dog",
          "Donkey", "Elephant", "Giraffe", "Goat",
          "Monkey", "Pig","Rat","Fish","Eagle"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_array_adapter);

    ListView listView = findViewById(R.id.basicList);

    // Instead of using 'simple_list_item_1' layout, any layout can be used. For simplicity
    // this time, i did use 'simple_list_item_1' layout which is default came with android.
    ArrayAdapter<String> basicListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, animals);
    listView.setAdapter(basicListAdapter);


    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getBaseContext(), animals[position], Toast.LENGTH_SHORT).show();
      }
    });
  }
}