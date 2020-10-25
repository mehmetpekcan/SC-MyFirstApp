package com.mehmetpekcan.mytagram;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends BaseAdapter {
  List<Post> posts;
  LayoutInflater inflater;


  public PostAdapter(Activity activity, List<Post> posts) {
    this.posts = posts;
    this.inflater = activity.getLayoutInflater();
  }

  public int getCount() {
    return this.posts.size();
  }

  public Object getItem(int position) {
    return this.posts.get(position);
  }

  public long getItemId(int position) {
    return position;
  }

  public View getView(int position, View convertView, ViewGroup parent) {
    View rowView = this.inflater.inflate(R.layout.row, null);
    EditText postMessage = rowView.findViewById(R.id.postMessage);
    TextView postLocation = rowView.findViewById(R.id.postLocation);
    ImageView postImage = rowView.findViewById(R.id.postImage);

    Post post = posts.get(position);
    postMessage.setText(post.getPostMessage());
    postImage.setImageBitmap(post.getPostImage());

    if (post.getPostLocation() != null) {
      postLocation.setText("Location will be implement next lessons.");
    }

    return rowView;
  }
}
