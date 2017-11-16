package com.example.ratha.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ratha.tablayout.adapter.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter adapter;
    List list =new ArrayList();
    List<Fragment> fragments =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.tabLayout);

        viewPager=findViewById(R.id.viewPager);

        createFragment();
        adapter= new PagerAdapter(
                getSupportFragmentManager(),fragments
        );

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        getCurrentPager(viewPager);

        //list.add("item1");
        for(int i=0; i<50;i++){
            list.add("item "+i);
        }
    }

    private void getCurrentPager(ViewPager viewPager) {
        PagerAdapter adapter= (PagerAdapter) viewPager.getAdapter();

        if(null!=adapter){
            Fragment fragment=adapter.getItem(tabLayout.getSelectedTabPosition());

            if(fragment instanceof PopularFragment){
                PopularFragment popularFragment= (PopularFragment) fragment;
                popularFragment.setData(list);
            }else if(fragment instanceof RecentFragment){
                RecentFragment recentFragment= (RecentFragment) fragment;

            }else if(fragment instanceof FavoriteFragment){
                FavoriteFragment favoriteFragment= (FavoriteFragment) fragment;

            }
        }
    }

    public void createFragment(){
        PopularFragment f1=PopularFragment.newInstance(0);
        RecentFragment f2= RecentFragment.newInstance(1);
        FavoriteFragment f3=FavoriteFragment.newInstance(2);

        fragments.add(f1);
        fragments.add(f2);
        fragments.add(f3);
    }
}
