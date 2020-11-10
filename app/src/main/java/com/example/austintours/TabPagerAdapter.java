package com.example.austintours;

import static com.example.austintours.R.string.tab_1;
import static com.example.austintours.R.string.tab_2;
import static com.example.austintours.R.string.tab_3;
import static com.example.austintours.R.string.tab_4;
import static com.example.austintours.R.string.tab_5;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to one of the tabs.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {

  private final Context CONTEXT;
  private final int[] TAB_TITLES = {tab_1, tab_2, tab_3, tab_4, tab_5};
  private final Fragment[] ATTRACTIONS = new Fragment[]{new MainFragment(), new HistoryFragment(),
      new FoodFragment(), new MusicFragment(), new ParksFragment()};

  public TabPagerAdapter(Context context, FragmentManager fm) {
    super(fm);
    this.CONTEXT = context;
  }

  @NonNull
  @Override
  public Fragment getItem(int position) {
    return ATTRACTIONS[position];
  }

  @Nullable
  @Override
  public CharSequence getPageTitle(int position) {
    return CONTEXT.getResources().getString(TAB_TITLES[position]);
  }

  @Override
  public int getCount() {
    return ATTRACTIONS.length;
  }
}