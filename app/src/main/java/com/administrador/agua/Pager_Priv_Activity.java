package com.administrador.agua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.administrador.agua.fragments.PageFragment1;
import com.administrador.agua.fragments.PageFragment2;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import java.util.ArrayList;
import java.util.List;

public class Pager_Priv_Activity extends AppCompatActivity {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    SpringDotsIndicator springDotsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_priv);
        getSupportActionBar().hide(); //funcion ocultar barra menu

        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());

        pager = findViewById(R.id.pager);
        springDotsIndicator = findViewById(R.id.spring_dots_indicator);
        pagerAdapter = new Slider(getSupportFragmentManager(), list);

        pager.setAdapter(pagerAdapter);
        springDotsIndicator.setViewPager(pager);
    }
}