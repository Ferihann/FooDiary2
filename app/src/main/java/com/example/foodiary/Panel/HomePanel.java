package com.example.foodiary.Panel;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.foodiary.Controller.MainManager;
import com.example.foodiary.R;
import com.google.android.material.navigation.NavigationView;

public class HomePanel extends MainManager  {
    private TextView soupButton;
    private TextView mainFoodButton;
    private TextView legumesButton;
    private TextView dessertButton;
    private Button searchButton;
    NavigationView navigationView;
    private EditText searchEdit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_top);
        soupButton = (TextView) findViewById(R.id.daily_soup);
        mainFoodButton = (TextView) findViewById(R.id.main_food);
        legumesButton = (TextView) findViewById(R.id.legumes);
        dessertButton = (TextView) findViewById(R.id.dessert);
        searchButton = (Button) findViewById(R.id.search);
        searchEdit = (EditText) findViewById(R.id.searchBar);

//        if (MainManager.getInstance().getCurrentUserID() == 0) {
//            MainManager.getInstance().stockFirstUser();
//        }

        //bu kısımda db den random çekilen tariflerin adı alınarak gerekli yerlere konulacak

        soupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openProfilePanel());
            }
        });

        mainFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openRecipeCaregoryPanel());
            }
        });

        legumesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openIngredientPanel());
            }
        });

        dessertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openRecipePanel());
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bu kısımda db den tarif aranır ardından tarif bulunduysa recipe sayfasına geçilir
                changeActivity(MainManager.getInstance().openRecipePanel());
                //tarif bulunamadıysa ekrana error basılır
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);

    }

    //menü için kullanılacak sonradan
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.nav_profile:
                changeActivity(MainManager.getInstance().openProfilePanel());
                break;
            case R.id.nav_menu:
                break;
            case R.id.nav_stock:
                changeActivity(MainManager.getInstance().openIngredientPanel());
                break;
            case R.id.nav_recipe:
                changeActivity(MainManager.getInstance().openRecipeCaregoryPanel());
                break;
        }
        return true;
    }

    public void changeActivity(Class className) {
        startActivity(new Intent(this, className));
    }

}
