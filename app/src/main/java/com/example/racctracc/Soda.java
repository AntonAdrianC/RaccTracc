package com.example.racctracc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.shawnlin.numberpicker.NumberPicker;

public class Soda extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    SharedPreferences sp;

    NumberPicker pepsiPicker;
    NumberPicker pepsi_twistPicker;
    NumberPicker cokePicker;
    NumberPicker fantaPicker;
    NumberPicker mountain_dewPicker;
    NumberPicker spritePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.soda);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        pepsiPicker = findViewById(R.id.pepsi);
        pepsi_twistPicker = findViewById(R.id.pepsi_twist);
        cokePicker = findViewById(R.id.coke);
        fantaPicker = findViewById(R.id.fanta);
        mountain_dewPicker = findViewById(R.id.mountain_dew);
        spritePicker = findViewById(R.id.sprite);

        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        pepsiPicker.setValue(sp.getInt("pepsiValue", 0));
        pepsi_twistPicker.setValue(sp.getInt("pepsi_twistValue", 0));
        cokePicker.setValue(sp.getInt("cokeValue", 0));
        fantaPicker.setValue(sp.getInt("fantaValue", 0));
        mountain_dewPicker.setValue(sp.getInt("mountain_dewValue", 0));
        spritePicker.setValue(sp.getInt("spriteValue", 0));


        pepsiPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveSodaOptions();
            }
        });

        pepsi_twistPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveSodaOptions();
            }
        });

        cokePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveSodaOptions();
            }
        });
        fantaPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveSodaOptions();
            }
        });

        mountain_dewPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveSodaOptions();
            }
        });

        spritePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveSodaOptions();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.optNotes) {
                    Toast.makeText(Soda.this, "This app is still in development. Hope you like it!", Toast.LENGTH_LONG).show();
                } else if (id == R.id.log_out) {
                    clearRememberMe();
                    navigateToMainActivity();
                    showToast();
                } else if (id == R.id.home) {
                    navigateToNavigationActivity();
                } else if (id == R.id.calculator){
                    navigateToCalculatorActivity();
                    finish();
                } else if (id == R.id.settings){
                    deleteAllValuesFromSharedPreferences();
                }
                drawerLayout.closeDrawer(navigationView);

                return true;
            }
        });
    }

    private void clearRememberMe() {
        SharedPreferences.Editor editor = sp.edit();
        editor.clear(); // Clear all key-value pairs
        editor.apply();
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    private void showToast() {
        Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show();
    }

    private void navigateToNavigationActivity() {
        Intent intent = new Intent(getApplicationContext(), Navigation.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    private void navigateToCalculatorActivity() {
        Intent intent = new Intent(getApplicationContext(), Calculator.class);
        startActivity(intent);
    }

    private void saveSodaOptions() {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("pepsiValue", pepsiPicker.getValue());
        editor.putInt("pepsi_twistValue", pepsi_twistPicker.getValue());
        editor.putInt("cokeValue", cokePicker.getValue());
        editor.putInt("fantaValue", fantaPicker.getValue());
        editor.putInt("mountain_dewValue", mountain_dewPicker.getValue());
        editor.putInt("spriteValue", spritePicker.getValue());
        editor.apply();
    }
    private void deleteAllValuesFromSharedPreferences() {
        SharedPreferences.Editor editor = sp.edit();

        editor.remove("snickersValue");
        editor.remove("bountyValue");
        editor.remove("marsValue");
        editor.remove("twixValue");
        editor.remove("lionValue");
        editor.remove("kinder_buenoValue");
        editor.remove("dbBoosterValue");
        editor.remove("real_burgerValue");
        editor.remove("zingerValue");
        editor.remove("twisterSpicyValue");
        editor.remove("mc_chickenValue");
        editor.remove("mc_puisorValue");
        editor.remove("big_macValue");
        editor.remove("big_tastyValue");
        editor.remove("quarter_pounderValue");
        editor.remove("hamburgerValue");
        editor.remove("cheeseburgerValue");
        editor.remove("db_cheeseburgerValue");
        editor.remove("dipping_stripsValue");
        editor.remove("mcfries_largeValue");
        editor.remove("mcfries_smallValue");
        editor.remove("pepsiValue");
        editor.remove("pepsi_twistValue");
        editor.remove("cokeValue");
        editor.remove("fantaValue");
        editor.remove("mountain_dewValue");
        editor.remove("spriteValue");
        editor.remove("pringlesValue");
        editor.remove("laysValue");
        editor.remove("laysBBQValue");
        editor.remove("laysPaprikaValue");
        editor.remove("laysCheeseValue");
        editor.remove("laysPiriValue");
        //Made by Anton A.
        editor.remove("hariboValue");
        editor.remove("haribo_colaValue");
        editor.remove("tucValue");
        editor.remove("tuc_sourValue");
        editor.remove("tuc_paprikaValue");
        editor.remove("mcflurryValue");
        editor.remove("mc_ice_creamValue");
        editor.remove("mc_shakeValue");

        editor.apply();
    }
    
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawer(navigationView);
        } else {
            super.onBackPressed();
            finish();
        }
    }
}
