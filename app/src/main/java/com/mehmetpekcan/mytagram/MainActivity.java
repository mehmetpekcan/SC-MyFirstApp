package com.mehmetpekcan.mytagram;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  List<Post> posts = new ArrayList<>();
  ListView userTimeline;
  static final int POST_REQUEST_CODE = 1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    userTimeline = findViewById(R.id.userTimeline);
    userTimeline.setAdapter(new PostAdapter(MainActivity.this, posts));

  }

  public void handleClickNewPost(View view) {
    Intent intent = new Intent(MainActivity.this, PostActivity.class);
    startActivityForResult(intent, POST_REQUEST_CODE);
  }

  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if(requestCode == POST_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
      Post newPost = new Post();
      newPost.setPostMessage(data.getCharSequenceArrayExtra("msg").toString());
      newPost.setPostImage((Bitmap) data.getParcelableExtra("bitmap"));
      posts.add(newPost);

      ((PostAdapter) userTimeline.getAdapter()).notifyDataSetChanged();
    }
  }
}