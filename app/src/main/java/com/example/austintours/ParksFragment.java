package com.example.austintours;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.austintours.databinding.FragmentParksBinding;
import java.util.ArrayList;

public class ParksFragment extends Fragment {

  FragmentParksBinding binding;

  public ParksFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    binding = FragmentParksBinding.inflate(inflater, container, false);
    displayAttractionList(binding);
    return binding.getRoot();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    binding = null;
  }

  /**
   * Creates an array list of attraction objects.
   *
   * @param binding An instance of ParksFragment binding.
   */
  private void displayAttractionList(FragmentParksBinding binding) {
    String[] searchList = getResources().getStringArray(R.array.parksArray);
    ArrayList<Attraction> attractions = new ArrayList<>();
    int[] attractionPhotos = photoPaths();
    final String splitBy = ";";
    int counter = 0;
    for (String str : searchList) {
      String[] attraction = str.split(splitBy);
      String name = attraction[0];
      String hoursSunday = attraction[1];
      String hoursMonday = attraction[2];
      String hoursTuesday = attraction[3];
      String hoursWednesday = attraction[4];
      String hoursThursday = attraction[5];
      String hoursFriday = attraction[6];
      String hoursSaturday = attraction[7];
      String addressLineOne = attraction[8];
      attractions.add(new Attraction(name, hoursSunday, hoursMonday, hoursTuesday, hoursWednesday,
          hoursThursday, hoursFriday, hoursSaturday, addressLineOne, attractionPhotos[counter]));
      counter++;
    }
    RecyclerView recyclerView = binding.listAttractionItems;
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    AttractionAdapter recyclerAdapter = new AttractionAdapter(getContext(), attractions);
    recyclerView.setAdapter(recyclerAdapter);
  }

  /**
   * Returns an int array of image resource identifiers for the custom attraction object.
   *
   * @return An int array of image resource identifiers.
   */
  private int[] photoPaths() {
    return new int[]{R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background};
  }
}