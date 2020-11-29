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
import com.example.austintours.databinding.FragmentMusicBinding;
import java.util.ArrayList;

/**
 * A fragment for music attractions.
 */
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
    ArrayList<Attraction> attractions = new ArrayList<>();
    String[][] musicArray = getMusicArray();
    TypedArray photos = getAttractionPhotos();
    int counter = 0;
    for (String[] str : musicArray) {
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
  private String[][] getMusicArray() {
    return new String[][]{getResources().getStringArray(R.array.austin_city_limits),
        getResources().getStringArray(R.array.hole_in_wall),
        getResources().getStringArray(R.array.skylark_lounge),
        getResources().getStringArray(R.array.south_by_southwest),
        getResources().getStringArray(R.array.zach_theater)};
  }

  /**
   * Returns a typed array of images for the custom attraction objects.
   *
   * @return A typed array of images.
   */
  private TypedArray getAttractionPhotos() {
    return getResources().obtainTypedArray(R.array.music_photos);
  }
}