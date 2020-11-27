package com.example.austintours;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.example.austintours.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
    View view = binding.getRoot();
    setContentView(view);
    TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(this);
    ViewPager2 viewPager = binding.viewPager;
    viewPager.setAdapter(tabPagerAdapter);
    TabLayout tabs = binding.tabs;
    new TabLayoutMediator(tabs, viewPager,
        (tab, position) -> tab.setText(tabPagerAdapter.getPageTitle(position, this))).attach();
  }
}