package com.example.digitalhelpdesk;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class AdapterMA3 extends FragmentPagerAdapter {
    private int noOfTabs;
    public AdapterMA3(FragmentManager fm, int noOfTabs) {
        super(fm);
        this.noOfTabs = noOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return Fragment_Steps.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Step "+(position+1);
    }
}