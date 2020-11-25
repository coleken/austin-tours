package com.example.austintours;

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
    String[] searchList = getResources().getStringArray(R.array.historyArray);
    ArrayList<Attraction> attractions = new ArrayList<>();
    int[] photos = attractionPhotos();
    final String splitBy = ";";
    int counter = 0;
    for (String str : searchList) {
      String[] attraction = str.split(splitBy);
      String name = attraction[0];
      String hours = attraction[1];
      String website = attraction[2];
      String address = attraction[3];
      attractions.add(new Attraction(name, hours, website, address, photos[counter]));
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
  private int[] attractionPhotos() {
    return new int[]{R.drawable.bullock_museum, R.drawable.lbj_library,
        R.drawable.neill_cochran_museum, R.drawable.washington_carver_museum,
        R.drawable.elisabet_ney_museum};
  }
}