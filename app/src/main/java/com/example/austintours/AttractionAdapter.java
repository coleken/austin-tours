package com.example.austintours;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
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
    holder.hoursSunday.setText(attraction.getHoursSunday());
    holder.hoursMonday.setText(attraction.getHoursMonday());
    holder.hoursTuesday.setText(attraction.getHoursTuesday());
    holder.hoursWednesday.setText(attraction.getHoursWednesday());
    holder.hoursThursday.setText(attraction.getHoursThursday());
    holder.hoursFriday.setText(attraction.getHoursFriday());
    holder.hoursSaturday.setText(attraction.getHoursSaturday());
    holder.attractionAddress.setText(attraction.getAttractionAddress());
    holder.attractionPhoto.setImageResource(attraction.getAttractionPhoto());
  }

  @Override
  public int getItemCount() {
    return ATTRACTIONS.size();
  }

  public static class AttractionViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView hoursSunday;
    public TextView hoursMonday;
    public TextView hoursTuesday;
    public TextView hoursWednesday;
    public TextView hoursThursday;
    public TextView hoursFriday;
    public TextView hoursSaturday;
    public TextView attractionAddress;
    public ImageView attractionPhoto;

    public AttractionViewHolder(@NonNull View attractionItem) {
      super(attractionItem);
      name = attractionItem.findViewById(R.id.text_attraction_name);
      hoursSunday = attractionItem.findViewById(R.id.text_hours_sunday);
      hoursMonday = attractionItem.findViewById(R.id.text_hours_monday);
      hoursTuesday = attractionItem.findViewById(R.id.text_hours_tuesday);
      hoursWednesday = attractionItem.findViewById(R.id.text_hours_wednesday);
      hoursThursday = attractionItem.findViewById(R.id.text_hours_thursday);
      hoursFriday = attractionItem.findViewById(R.id.text_hours_friday);
      hoursSaturday = attractionItem.findViewById(R.id.text_hours_saturday);
      attractionAddress = attractionItem.findViewById(R.id.text_attraction_address);
      attractionPhoto = attractionItem.findViewById(R.id.image_attraction);
    }
  }
}
