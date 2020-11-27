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
    /*
     * Attraction Photo Image Sources
     *
     * File Name: bullock_museum.png
     * Original Name: bullock-texas-state-history.jpg
     * Artist/Owner: r678
     * File URL: https://media-cdn.tripadvisor.com/media/photo-o/08/89/64/e5/bullock-texas-state-history.jpg
     * Date Retrieved: Friday, November 20th, 2020
     *
     * File Name: lbj_library.png
     * Original Name: lbj-presdiential-library.jpg
     * Artist/Owner: Jay Godwin
     * File URL: https://media-cdn.tripadvisor.com/media/photo-o/0a/aa/6e/8a/lbj-presidential-library.jpg
     * Date Retrieved: Friday, November 20th, 2020
     *
     * File Name: neil_cochran_museum.png
     * Original Name: the-neill-cochran-museum.jpg
     * Artist/Owner: Rolf A.
     * File URL: https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0a/f0/86/f6/the-neill-cochran-museum.jpg?w=1100&h=-1&s=1
     * Date Retrieved: Friday, November 20th, 2020
     *
     * File Name: washington_carver_museum.png
     * Original Name: photo0jpg.jpg
     * Artist/Owner: Clayton O.
     * File URL: https://dynamic-media-cdn.tripadvisor.com/media/photo-o/12/29/98/69/photo0jpg.jpg?w=1100&h=700&s=1
     * Date Retrieved: Friday, November 20th, 2020
     *
     * File Name: elisabet_ney_museum.png
     * Original Name: 011-59ae5420b2f0df7_59ae552f-dcbf-c79b-649acd5263c3f9ca.jpg
     * Artist/Owner: austintexas.org
     * File URL: https://assets.simpleviewinc.com/simpleview/image/upload/crm/austin/011-59ae5420b2f0df7_59ae552f-dcbf-c79b-649acd5263c3f9ca.jpg
     * Date Retrieved: Monday, November 23rd, 2020
     */
  }
}