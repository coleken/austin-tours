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
import com.example.austintours.databinding.FragmentHistoryBinding;
import java.util.ArrayList;

/**
 * A fragment for history attractions.
 */
public class HistoryFragment extends Fragment {

  FragmentHistoryBinding binding;

  public HistoryFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    binding = FragmentHistoryBinding.inflate(inflater, container, false);
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
   * @param binding An instance of HistoryFragmentBinding.
   */
  private void displayAttractionList(FragmentHistoryBinding binding) {
    String[][] historyArray = getHistoryArray();
    ArrayList<Attraction> attractions = new ArrayList<>();
    TypedArray photos = getAttractionPhotos();
    int counter = 0;
    for (String[] str : historyArray) {
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
  private String[][] getHistoryArray() {
    return new String[][]{getResources().getStringArray(R.array.bullock_museum),
        getResources().getStringArray(R.array.lbj_library),
        getResources().getStringArray(R.array.neill_cochran_museum),
        getResources().getStringArray(R.array.washington_carver_museum),
        getResources().getStringArray(R.array.elisabet_ney_museum)};
  }

  /**
   * Returns a typed array of images for the custom attraction objects.
   *
   * @return A typed array of images.
   */
  private TypedArray getAttractionPhotos() {
    return getResources().obtainTypedArray(R.array.history_photos);
  }
}