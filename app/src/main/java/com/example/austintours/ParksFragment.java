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
    String[] searchList = getResources().getStringArray(R.array.parksArray);
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
    return new int[]{R.drawable.mount_bonnell, R.drawable.emma_long_park,
        R.drawable.zilker_park, R.drawable.mckinney_falls};
    /*
     * Attraction Photo Image Sources
     *
     * File Name: mount_bonnell.png
     * Original Name: megan-markham-s9vKj39D6jA-unsplash.jpg
     * Artist/Owner: Megan Markham
     * File URL: https://unsplash.com/photos/s9vKj39D6jA
     * Date Retrieved: Monday, November 16th, 2020
     *
     * File Name: emma_long_park.png
     * Original Name: GettyImages-155015268-5b31274d8e1b6e003695036e.webp
     * Artist/Owner: JodiJacobson / Getty Images
     * File URL: https://www.tripsavvy.com/emma-long-park-austin-texas-complete-guide-4167619
     * Date Retrieved: Tuesday, November 27th, 2020
     *
     * File Name: zilker_park.png
     * Original Name: GettyImages-500491816-5a830da3c6733500377bd4e4.webp
     * Artist/Owner: RoschetzkyIstockPhoto / Getty Images
     * File URL: https://www.tripsavvy.com/the-top-things-to-do-in-zilker-park-in-austin-4158303
     * Date Retrieved: Tuesday, November 17th, 2020
     *
     * File Name: mckinney_falls
     * Original Name: mckinney-falls-state-park-1126832088-b484fa59bded43fcb24e76ca5f147b8a.webp
     * Artist/Owner: ShengYing Lin / Getty Images
     * File URL: mckinney-falls-state-park-1126832088-b484fa59bded43fcb24e76ca5f147b8a.webp
     * Date Retrieved: Tuesday, November 17th, 2020
     */
  }
}