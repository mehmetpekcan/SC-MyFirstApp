package com.mehmetpekcan.mybrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
  WebView webView;
  Button goButton;
  EditText urlInput;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    webView = findViewById(R.id.webView);
    goButton = findViewById(R.id.goButton);
    urlInput = findViewById(R.id.addressArea);

    webView.setWebViewClient(new WebViewClient());

    if (getIntent() != null && getIntent().getData() != null) {
      urlInput.setText(getIntent().getData().toString());
      webView.loadUrl(getIntent().getData().toString());
    }


    goButton.setOnClickListener(new View.OnClickListener() {
      public void onClick(View view) {
        handleGo();
      }
    });
  }

  public void handleGo() {
    String url = String.format("http://%s", urlInput.getText().toString());
    webView.loadUrl(url);
  }

  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate(R.menu.menu, menu);
    return super.onCreateOptionsMenu(menu);
  }
}