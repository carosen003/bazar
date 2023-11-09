package com.example.bazar.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.bazar.R;
import com.example.bazar.ui.adaptadores.SlidePagerAdaptor;
import com.example.bazar.ui.fragments.PageFragment1;
import com.example.bazar.ui.fragments.PageFragment2;
import com.example.bazar.ui.fragments.PageFragment3;

import java.util.ArrayList;
import java.util.List;

public class AcercaDeActivity extends AppCompatActivity {
    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);


        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());


        pager=findViewById(R.id.pager);
        pagerAdapter=new SlidePagerAdaptor(getSupportFragmentManager(),list);

        //pagerAdapter.getClass();
       // pagerAdapter.setAdapter(pagerAdapter);
        pager.setAdapter(pagerAdapter);


    }
}
