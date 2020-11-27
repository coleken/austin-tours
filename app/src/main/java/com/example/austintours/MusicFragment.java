package com.example.austintours;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.austintours.databinding.FragmentMusicBinding;
import java.util.ArrayList;

public class MusicFragment extends Fragment {

  FragmentMusicBinding binding;

  public MusicFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    binding = FragmentMusicBinding.inflate(inflater, container, false);
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
   * @param binding An instance of MusicFragmentBinding.
   */
  private void displayAttractionList(FragmentMusicBinding binding) {
    String[] searchList = getResources().getStringArray(R.array.musicArray);
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
    return new int[]{R.drawable.austin_city_limits, R.drawable.hole_in_the_wall,
        R.drawable.skylark_lounge, R.drawable.austin_convention_center, R.drawable.zach_theater};
    /*
     * Attraction Photo Image Sources
     *
     * File Name: austin_city_limits.png
     * Original Name: exterior-smaller.jpg
     * Artist/Owner: SMITH-CLEMENTI
     * File URL: https://acl-live.com/wp-content/uploads/2018/10/exterior-smaller.jpg
     * Date Retrieved: Thursday, November 19th, 2020
     *
     * File Name: hole_in_the_wall.png
     * Original Name: o.jpg
     * Artist/Owner: Barret L.
     * File URL: https://s3-media0.fl.yelpcdn.com/bphoto/qvAcVqYGUp2Fw62MJdebPw/o.jpg
     * Date Retrieved: Thursday, November 19th, 2020
     *
     * File Name: skylark_lounge.png
     * Original Name: o.jpg
     * Artist/Owner: Jennifer Y.
     * File URL: https://s3-media0.fl.yelpcdn.com/bphoto/HBH60wlItRmXwsqG1Zum8g/o.jpg
     * Date Retrieved: Thursday, November 19th, 2020
     *
     * File Name: austin_convention_center.png
     * Original Name: _MG_5185_Atrium_Day.jpg
     * Artist/Owner: Austin Convention Center
     * File URL: https://images.ctfassets.net/xv1q576gx3e5/2w86FZfs2cygASc8yWi4wY/e11371f0c8d9413a6cd9d0f4391576cb/_MG_5185_Atrium_Day.jpg?w=1800
     * Date Retrieved: Thursday, November 19th, 2020
     *
     * File Name: zach_theater.png
     * Original Name: ZACH-Topfer-1170_Exterior.jpg
     * Artist/Owner: zactheater.org
     * File URL: https://zachtheatre.org/wp-content/uploads/2019/10/ZACH-Topfer-1170_Exterior.jpg
     * Date Retrieved: Monday, November 23rd, 2020
     */
  }
}