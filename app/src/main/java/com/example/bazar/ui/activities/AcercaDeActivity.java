package com.example.bazar.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.bazar.R;
import com.example.bazar.ui.adaptadores.SlidePagerAdaptor;
import com.example.bazar.ui.datos.Producto;
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ir_menuprincipal, menu);
        return true;
    }

    public void desplegarMensajeHome() {
        Toast toast = Toast.makeText(this, "Ir al menu principal", Toast.LENGTH_SHORT);
        toast.show();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ir_menuprincipal:
                Intent intentMenuPrincipal = new Intent(this, MenuPrincipalActivity.class);
                startActivity(intentMenuPrincipal);
                desplegarMensajeHome();
        }
        return true;
    }








}
