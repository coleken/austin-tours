package com.example.austintours;

import static android.widget.Toast.makeText;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AttractionAdapter extends
    RecyclerView.Adapter<AttractionAdapter.AttractionViewHolder> {

  private final Context CONTEXT;
  private final ArrayList<Attraction> ATTRACTIONS;

  /**
   * AttractionAdapter constructor for recycler view.
   *
   * @param context     An instance of context.
   * @param attractions An array list of custom attraction objects.
   */
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
    // Underline and set address text
    SpannableString address = formatText(attraction.getAddress());
    holder.address.setText(address);
    // Shows the attraction location in maps
    holder.address.setOnClickListener(view -> CONTEXT.startActivity(new Intent(Intent.ACTION_VIEW,
        Uri.parse(CONTEXT.getResources().getString(R.string.geoUri) + attraction.getAddress()))));
    // Underline and set website text
    SpannableString website = formatText(CONTEXT.getResources().getString(R.string.website));
    holder.website.setText(website);
    // Shows the attraction website
    holder.website.setOnClickListener(view -> CONTEXT
        .startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(attraction.getWebsite()))));
    // Underline and set website text
    SpannableString hours = formatText(CONTEXT.getResources().getString(R.string.hours));
    holder.hours.setText(hours);
    // Displays the hours of operation in a toast message
    holder.hours.setOnClickListener(
        view -> makeText(CONTEXT, attraction.getHours(), Toast.LENGTH_LONG).show());
    holder.photo.setImageDrawable(ContextCompat.getDrawable(CONTEXT, attraction.getPhoto()));
  }

  /**
   * Returns a spannable string with the attraction item underlined.
   *
   * @param attractionInfo A String containing attraction item information.
   * @return A spannable string with the attraction item information.
   */
  @NonNull
  private SpannableString formatText(String attractionInfo) {
    SpannableString UnderlinedInfo = new SpannableString(attractionInfo);
    UnderlinedInfo.setSpan(new UnderlineSpan(), 0, UnderlinedInfo.length(), 0);
    return UnderlinedInfo;
  }

  @Override
  public int getItemCount() {
    return ATTRACTIONS.size();
  }

  /**
   * Defines the view holder for the AttractionAdapter class.
   */
  public static class AttractionViewHolder extends RecyclerView.ViewHolder {

    final public TextView name;
    final public TextView hours;
    final public TextView website;
    final public TextView address;
    final public ImageView photo;

    /**
     * Defines the attraction items for the attraction adapter class.
     *
     * @param attractionItem An instance of View
     */
    public AttractionViewHolder(@NonNull View attractionItem) {
      super(attractionItem);
      name = attractionItem.findViewById(R.id.text_attraction_name);
      hours = attractionItem.findViewById(R.id.text_attraction_availability);
      address = attractionItem.findViewById(R.id.text_attraction_address);
      website = attractionItem.findViewById(R.id.text_attraction_website);
      photo = attractionItem.findViewById(R.id.image_attraction);
    }
  }
}
