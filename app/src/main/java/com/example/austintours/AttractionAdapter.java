package com.example.austintours;

import static android.widget.Toast.makeText;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AttractionAdapter extends
    RecyclerView.Adapter<AttractionAdapter.AttractionViewHolder> {

  private final Context CONTEXT;
  private final ArrayList<Attraction> ATTRACTIONS;

  public AttractionAdapter(Context context, ArrayList<Attraction> attractions) {
    this.CONTEXT = context;
    this.ATTRACTIONS = attractions;
  }

  @NonNull
  @Override
  public AttractionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.attraction_item, parent, false);
    return new AttractionViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull AttractionViewHolder holder, int position) {
    Attraction attraction = ATTRACTIONS.get(position);
    holder.name.setText(attraction.getName());
    holder.address.setText(attraction.getAddress());
    holder.photo.setImageResource(attraction.getAttractionPhoto());
    holder.hoursOfOperation.setOnClickListener(
        view -> makeText(CONTEXT, attraction.getHoursOfOperation(), Toast.LENGTH_LONG).show());
  }

  @Override
  public int getItemCount() {
    return ATTRACTIONS.size();
  }

  public static class AttractionViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView hoursOfOperation;
    public TextView address;
    public ImageView photo;

    public AttractionViewHolder(@NonNull View attractionItem) {
      super(attractionItem);
      name = attractionItem.findViewById(R.id.text_attraction_name);
      hoursOfOperation = attractionItem.findViewById(R.id.text_attraction_availability);
      address = attractionItem.findViewById(R.id.text_attraction_address);
      photo = attractionItem.findViewById(R.id.image_attraction);
    }
  }
}
