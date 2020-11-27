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
    return new int[]{R.drawable.kerbey_lane, R.drawable.snooze_an_am,
        R.drawable.south_congress_cafe, R.drawable.perrys_steakhouse,
        R.drawable.hula_hut, R.drawable.trulucks_seafood};
    /*
     * Attraction Photo Image Sources
     *
     * File Name: kerbey_lane.png
     * Original Name: kerbey-700x560.jpg
     * Artist/Owner: Kerbey Lane Cafe
     * File URL: https://img-aws.ehowcdn.com/700x/cdn.onlyinyourstate.com/wp-content/uploads/2018/02/kerbey-700x560.jpg
     * Date Retrieved: Wednesday, November 18th, 2020
     *
     * File Name: snooze_an_am.png
     * Original Name: IMG_7938.0.0.webp
     * Artist/Owner: Nadia Chaudhury/EATX
     * File URL: https://cdn.vox-cdn.com/thumbor/qifAaTwmeo0avUP5lKUmssI2jn8=/73x0:2749x2007/1820x1213/filters:focal(73x0:2749x2007):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/49662569/IMG_7938.0.0.JPG
     * Date Retrieved: Wednesday, November 18th, 2020
     *
     * File Name: south_congress_cafe.png
     * Original Name: Building-Front-South-Congress-Cafe.jpg
     * Artist/Owner: South Congress Cafe
     * File URL: https://i1.wp.com/www.southcongresscafe.com/wp-content/uploads/2018/05/Building-Front-South-Congress-Cafe.jpg
     * Date Retrieved: Wednesday, November 18th, 2020
     *
     * File Name: perrys_steakhouse.png
     * Original Name: PERRS-Austin-Downtown-Exterior.jpg
     * Artist/Owner: Perry's Steakhouse & Grille
     * File URL: https://perryssteakhouse.com/wp-content/uploads/2018/05/PERRS-Austin-Downtown-Exterior.jpg
     * Date Retrieved: Wednesday, November 18th, 2020
     *
     * File Name: hula_hut.png
     * Original Name: g6.jpg
     * Artist/Owner: Ivan Collins
     * File URL: https://www.videocityguide.com/austin/PCWUploads/Hula%20Hut%20on%20Lake%20Austin/g6.jpg
     * Date Retrieved: Wednesday, November 18th, 2020
     *
     * File Name: trulucks_seafood.png
     * Original Name: TLKS_Exteriors_AUSDT_DC20.png
     * Artist/Owner: Truluck's Ocean's Finest Seafood & Crab
     * File URL:https://trulucks.com/wp-content/uploads/2019/10/TLKS_Exteriors_AUSDT_DC20.png
     * Date Retrieved: Wednesday, November 18th, 2020
     */
  }
}