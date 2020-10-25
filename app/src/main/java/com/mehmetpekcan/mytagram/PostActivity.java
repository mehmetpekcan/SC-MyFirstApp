package com.mehmetpekcan.mytagram;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class PostActivity extends AppCompatActivity {
  static final int CAPTURE_IMAGE = 0;
  ImageView postImage;
  EditText postMessage;



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_post);

    postImage = findViewById(R.id.postImage);
    postMessage = findViewById(R.id.postMessage);

    postImage.setOnClickListener(new View.OnClickListener() {
      public void onClick(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAPTURE_IMAGE);
      }
    });
  }

  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == CAPTURE_IMAGE && resultCode == Activity.RESULT_OK) {
      Bundle bundle = data.getExtras();
      Bitmap image = (Bitmap) bundle.get("data");
      postImage.setImageBitmap(image);
    }
  }

  public void handleNewPost(View view) {
    Intent intent = new Intent();
    Bundle bundle = new Bundle();

    bundle.putCharSequence("msg", postMessage.getText());
    bundle.putParcelable("bitmap", ((BitmapDrawable) postImage.getDrawable()).getBitmap());
    intent.putExtras(bundle);
    setResult(Activity.RESULT_OK, intent);
    finish();
  }

  public void handleCancelPost(View view) {
    setResult(Activity.RESULT_CANCELED);
    finish();
  }
}