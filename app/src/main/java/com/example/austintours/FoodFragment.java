package com.example.austintours;

import android.content.res.TypedArray;
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

/**
 * A fragment for food attractions.
 */
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
    ArrayList<Attraction> attractions = new ArrayList<>();
    String[][] foodArray = getFoodArray();
    TypedArray photos = getAttractionPhotos();
    int counter = 0;
    for (String[] str : foodArray) {
      attractions.add(new Attraction(str[0], str[1], str[2], str[3], photos.getDrawable(counter)));
      counter++;
    }
    RecyclerView recyclerView = binding.listAttractionItems;
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    AttractionAdapter recyclerAdapter = new AttractionAdapter(getContext(), attractions);
    recyclerView.setAdapter(recyclerAdapter);
  }

  /**
   * Returns an array of string arrays that contain attraction information.
   *
   * @return An array of string arrays
   */
  private String[][] getFoodArray() {
    return new String[][]{getResources().getStringArray(R.array.kerbey_lane_cafe),
        getResources().getStringArray(R.array.snooze_eatery),
        getResources().getStringArray(R.array.south_congress_cafe),
        getResources().getStringArray(R.array.perrys_grille),
        getResources().getStringArray(R.array.hula_hut),
        getResources().getStringArray(R.array.trulucks_seafood)};
  }

  /**
   * Returns a typed array of images for the custom attraction objects.
   *
   * @return A typed array of images.
   */
  private TypedArray getAttractionPhotos() {
    return getResources().obtainTypedArray(R.array.food_photos);
  }
}