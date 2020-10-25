package com.mehmetpekcan.mytagram;

import android.graphics.Bitmap;
import android.location.Location;

public class Post {
    private Bitmap postImage;
    private Location postLocation;
    private String postMessage;

  public Bitmap getPostImage() {
    return postImage;
  }

  public void setPostImage(Bitmap postImage) {
    this.postImage = postImage;
  }

  public Location getPostLocation() {
    return postLocation;
  }

  public void setPostLocation(Location postLocation) {
    this.postLocation = postLocation;
  }

  public String getPostMessage() {
    return postMessage;
  }

  public void setPostMessage(String postMessage) {
    this.postMessage = postMessage;
  }
}
