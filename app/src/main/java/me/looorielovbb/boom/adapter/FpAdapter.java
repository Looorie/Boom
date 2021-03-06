package me.looorielovbb.boom.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by Lulei on 2017/5/22.
 * time : 14:03
 * date : 2017/5/22
 * mail to lulei4461@gmail.com
 */

public class FpAdapter extends FragmentPagerAdapter {
    @NonNull
    Fragment[] fragments;
    @NonNull
    String[] titles;

    public FpAdapter(FragmentManager fm, @NonNull Fragment[] fragments, @NonNull String[] titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments[i];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position + 1 > titles.length)
            return "";
        return titles[position];
    }
}
