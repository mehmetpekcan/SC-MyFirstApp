package com.mehmetpekcan.listviewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  Button arrayAdapterButton;
  Button customAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Navigation buttons
    arrayAdapterButton = findViewById(R.id.arrayAdapterButton);
    customAdapter = findViewById(R.id.customAdapterButton);
  }

  // Route changes handler
  public void changeRoute(View view) {
    switch (view.getId()) {
      case (R.id.arrayAdapterButton):
        Intent routeToArrayAdapter = new Intent(MainActivity.this, ArrayAdapterActivity.class);
        startActivity(routeToArrayAdapter);
        break;
      case (R.id.customAdapterButton):
        Intent routeToCustomAdapter = new Intent(MainActivity.this, CustomAdapterActivity.class);
        startActivity(routeToCustomAdapter);
        break;
    }
  }
}