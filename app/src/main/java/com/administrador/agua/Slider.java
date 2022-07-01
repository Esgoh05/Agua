package com.administrador.agua;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class Slider extends FragmentStatePagerAdapter {

    public List<Fragment> fragmentList;

    public Slider(FragmentManager fm, List<Fragment> fragmentList){
        super(fm);
        this.fragmentList = fragmentList;
    }

   @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
       }

   @Override
    public int getCount(){
        return fragmentList.size();
       }
}
