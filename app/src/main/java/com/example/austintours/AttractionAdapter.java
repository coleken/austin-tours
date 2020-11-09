package com.example.austintours;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AttractionAdapter extends
    RecyclerView.Adapter<AttractionAdapter.AttractionViewHolder> {

  // TODO add attractions list
  // TODO add method logic

  @NonNull
  @Override
  public AttractionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return null;
  }

  @Override
  public void onBindViewHolder(@NonNull AttractionViewHolder holder, int position) {

  }

  @Override
  public int getItemCount() {
    return 0;
  }

  public static class AttractionViewHolder extends RecyclerView.ViewHolder {

    public AttractionViewHolder(@NonNull View attractionItem) {
      super(attractionItem);
    }
  }
}
