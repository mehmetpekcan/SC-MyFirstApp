package com.mehmetpekcan.listviewproject;

import android.graphics.drawable.Drawable;

public class Animal {
  private int imageID;
  private String name;

  public Animal(String name, int imageID) {
    this.name = name;
    this.imageID = imageID;
  }

  public String getName() {
    return this.name;
  }

  public int getImageID() {
    return this.imageID;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setImageID(int imageID) {
    this.imageID = imageID;
  }
}
