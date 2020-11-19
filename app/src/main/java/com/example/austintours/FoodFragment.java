package com.example.austintours;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.austintours.databinding.FragmentFoodBinding;
import java.util.ArrayList;

public class FoodFragment extends Fragment {

  FragmentFoodBinding binding;

  public FoodFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    binding = FragmentFoodBinding.inflate(inflater, container, false);
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
   * @param binding An instance of FoodFragmentBinding.
   */
  private void displayAttractionList(FragmentFoodBinding binding) {
    String[] searchList = getResources().getStringArray(R.array.foodArray);
    ArrayList<Attraction> attractions = new ArrayList<>();
    int[] attractionPhotos = photoPaths();
    final String splitBy = ";";
    int counter = 0;
    for (String str : searchList) {
      String[] attraction = str.split(splitBy);
      String name = attraction[0];
      String hoursOfOperation = attraction[1];
      String address = attraction[2];
      attractions.add(new Attraction(name, hoursOfOperation, address, attractionPhotos[counter]));
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
        R.drawable.ic_launcher_background, R.drawable.perrys_steakhouse,
        R.drawable.hula_hut, R.drawable.trulucks_seafood};
  }
}