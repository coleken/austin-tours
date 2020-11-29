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
import com.example.austintours.databinding.FragmentParksBinding;
import java.util.ArrayList;

/**
 * A fragment for parks attractions.
 */
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
   * @param binding An instance of ParksFragmentBinding.
   */
  private void displayAttractionList(FragmentParksBinding binding) {
    ArrayList<Attraction> attractions = new ArrayList<>();
    String[][] parksArray = getParksArray();
    TypedArray photos = getAttractionPhotos();
    int counter = 0;
    for (String[] str : parksArray) {
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
  private String[][] getParksArray() {
    return new String[][]{getResources().getStringArray(R.array.mount_bonnell),
        getResources().getStringArray(R.array.emma_long_park),
        getResources().getStringArray(R.array.zilker_park),
        getResources().getStringArray(R.array.mckinney_falls)};
  }

  /**
   * Returns a typed array of images for the custom attraction objects.
   *
   * @return A typed array of images.
   */
  private TypedArray getAttractionPhotos() {
    return getResources().obtainTypedArray(R.array.parks_photos);
  }
}