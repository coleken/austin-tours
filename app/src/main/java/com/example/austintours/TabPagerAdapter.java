package com.example.austintours;

import static com.example.austintours.R.string.tab_1;
import static com.example.austintours.R.string.tab_2;
import static com.example.austintours.R.string.tab_3;
import static com.example.austintours.R.string.tab_4;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * A [FragmentStateAdapter] that returns a fragment corresponding to one of the tabs.
 */
public class TabPagerAdapter extends FragmentStateAdapter {

  private final int[] TAB_TITLES = {tab_1, tab_2, tab_3, tab_4};
  private final Fragment[] ATTRACTIONS = new Fragment[]{new HistoryFragment(), new FoodFragment(),
      new MusicFragment(), new ParksFragment()};

  public TabPagerAdapter(FragmentActivity fragmentActivity) {
    super(fragmentActivity);
  }

  @NonNull
  @Override
  public Fragment createFragment(int position) {
    return ATTRACTIONS[position];
  }

  @Override
  public int getItemCount() {
    return ATTRACTIONS.length;
  }

  public CharSequence getPageTitle(int position, @NonNull Context context) {
    return context.getResources().getString(TAB_TITLES[position]);
  }
}