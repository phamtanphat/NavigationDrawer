package com.ptp.phamtanphat.navigationdrawer;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigationview);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.itemgallery:
                        fragment = new Fragment_Android();
                        break;
                    case R.id.itemimport:
                        fragment = new Fragment_iOS();
                        break;
                    case R.id.itemsend:
                        fragment = new Fragment_PHP();
                        break;
                    case R.id.itemtools:
                        fragment = new Fragment_Android();
                        break;
                }
                fragmentTransaction.replace(R.id.linearlayout,fragment);
                fragmentTransaction.commit();
                drawerLayout.closeDrawer(Gravity.START);
                return true;
            }
        });
    }
}
