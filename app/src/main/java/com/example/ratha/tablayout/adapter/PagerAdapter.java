package com.example.ratha.tablayout.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by ratha on 11/16/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList;
    String[] tabTitle={"Popular","Recent","Favorite"};
    public PagerAdapter(FragmentManager fm ,List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList=fragmentList;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        Log.e("adapter fragment ->" ,fragmentList.size()+"");
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}
