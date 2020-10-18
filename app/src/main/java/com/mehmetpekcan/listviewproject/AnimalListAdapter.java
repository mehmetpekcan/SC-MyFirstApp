package com.mehmetpekcan.listviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AnimalListAdapter extends ArrayAdapter<Animal> {
  private Context animalContext;
  int mResource;

  public AnimalListAdapter(Context context, int resource, ArrayList<Animal> objects) {
    super(context, resource, objects);
    animalContext = context;
    mResource = resource;
  }

  @Override
  public View getView(int position, View view, ViewGroup viewGroup) {
    String name = getItem(position).getName();
    Integer imageID = getItem(position).getImageID();

    Animal animal = new Animal(name, imageID);
    LayoutInflater inflater = LayoutInflater.from(animalContext);
    view = inflater.inflate(mResource, viewGroup, false);

    TextView animalName = view.findViewById(R.id.customTextView);
    ImageView animalImage = view.findViewById(R.id.customImageView);

    animalName.setText(animal.getName());
    animalImage.setImageResource(animal.getImageID());

    return view;
  }
}
