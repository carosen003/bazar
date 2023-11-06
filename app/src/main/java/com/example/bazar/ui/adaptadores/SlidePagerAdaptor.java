package com.example.bazar.ui.adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class SlidePagerAdaptor extends FragmentStatePagerAdapter {


    private List<Fragment> fragmentList;

    public SlidePagerAdaptor(@NonNull FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;

    }


        @Override
        public Fragment getItem ( int position){
            return fragmentList.get(position);
        }
        @Override
        public int getCount () {
            return fragmentList.size();
        }

}