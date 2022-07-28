package com.administrador.agua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.administrador.agua.fragments.PageFragment1;
import com.administrador.agua.fragments.PageFragment2;
import com.administrador.agua.fragments.PageFragment3;
import com.google.android.material.tabs.TabLayout;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import java.util.ArrayList;
import java.util.List;

public class Pager_Priv_Activity extends AppCompatActivity {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    private Button btnSiguiente;
    private Button btnIrAcPI;
    int posicion = 0;
    SpringDotsIndicator springDotsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_pager_priv);
        setContentView(R.layout.pager_prueba);
        getSupportActionBar().hide(); //funcion ocultar barra menu

        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());

        pager = findViewById(R.id.pager);
        btnSiguiente = findViewById(R.id.btn_siguiente);
        btnIrAcPI = findViewById(R.id.btn_ir_personalinfo);
        springDotsIndicator = findViewById(R.id.spring_dots_indicator);
        pagerAdapter = new Slider(getSupportFragmentManager(), list);

        btnSiguiente.setBackgroundResource(R.drawable.custom_button); //shape, contorno de esquinas para boton
        btnSiguiente.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1E88E5")));

        btnIrAcPI.setBackgroundResource(R.drawable.custom_button); //shape, contorno de esquinas para boton
        btnIrAcPI.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1E88E5")));

        btnIrAcPI.setOnClickListener((View v) -> {
            // do something here
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
            finish();
        });

        pager.setAdapter(pagerAdapter);
        springDotsIndicator.setViewPager(pager);

        btnSiguiente.setOnClickListener(new View.OnClickListener (){
            public void onClick(View v) {
                //pager.setCurrentItem(pagerAdapter);
               posicion = pager.getCurrentItem();
               if (posicion < list.size()){
                   posicion++;
                   pager.setCurrentItem(posicion);
               }

               if(posicion == list.size()-1){
                   LoadLastScreen();
               }
            }
        });


    }

    private void LoadLastScreen(){
        btnSiguiente.setVisibility(View.GONE);
        btnIrAcPI.setVisibility(View.VISIBLE);
    }
}