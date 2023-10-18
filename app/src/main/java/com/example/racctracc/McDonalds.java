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

public class McDonalds extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    SharedPreferences sp;

    NumberPicker mc_chickenPicker;
    NumberPicker mc_puisorPicker;
    NumberPicker big_macPicker;
    NumberPicker big_tastyPicker;
    NumberPicker quarter_pounderPicker;
    NumberPicker hamburgerPicker;
    NumberPicker cheeseburgerPicker;
    NumberPicker db_cheeseburgerPicker;
    NumberPicker dipping_stripsPicker;
    NumberPicker mcfries_largePicker;
    NumberPicker mcfries_smallPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.mcdonalds);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        mc_chickenPicker = findViewById(R.id.mc_chicken);
        mc_puisorPicker = findViewById(R.id.mc_puisor);
        big_macPicker = findViewById(R.id.big_mac);
        big_tastyPicker = findViewById(R.id.big_tasty);
        quarter_pounderPicker = findViewById(R.id.quarter_pounder);
        hamburgerPicker = findViewById(R.id.hamburger);
        cheeseburgerPicker = findViewById(R.id.cheeseburger);
        db_cheeseburgerPicker = findViewById(R.id.db_cheeseburger);
        dipping_stripsPicker = findViewById(R.id.dipping_strips);
        mcfries_largePicker = findViewById(R.id.mcfries_large);
        mcfries_smallPicker = findViewById(R.id.mcfries_small);

        mc_chickenPicker.setValue(sp.getInt("mc_chickenValue", 0));
        mc_puisorPicker.setValue(sp.getInt("mc_puisorValue", 0));
        big_macPicker.setValue(sp.getInt("big_macValue", 0));
        big_tastyPicker.setValue(sp.getInt("big_tastyValue", 0));
        quarter_pounderPicker.setValue(sp.getInt("quarter_pounderValue", 0));
        hamburgerPicker.setValue(sp.getInt("hamburgerValue", 0));
        cheeseburgerPicker.setValue(sp.getInt("cheeseburgerValue", 0));
        db_cheeseburgerPicker.setValue(sp.getInt("db_cheeseburgerValue", 0));
        dipping_stripsPicker.setValue(sp.getInt("dipping_stripsValue", 0));
        mcfries_largePicker.setValue(sp.getInt("mcfries_largeValue", 0));
        mcfries_smallPicker.setValue(sp.getInt("mcfries_smallValue", 0));
        //Made by Anton A.


        mc_chickenPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveMcOptions();
            }
        });

        mc_puisorPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveMcOptions();
            }
        });

        big_macPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveMcOptions();
            }
        });
        big_tastyPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveMcOptions();
            }
        });

        quarter_pounderPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveMcOptions();
            }
        });

        hamburgerPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveMcOptions();
            }
        });
        cheeseburgerPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveMcOptions();
            }
        });
        db_cheeseburgerPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveMcOptions();
            }
        });
        dipping_stripsPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveMcOptions();
            }
        });
        mcfries_largePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveMcOptions();
            }
        });
        mcfries_smallPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveMcOptions();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.optNotes) {
                    Toast.makeText(McDonalds.this, "This app is still in development. Hope you like it!", Toast.LENGTH_LONG).show();
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

    private void saveMcOptions() {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("mc_chickenValue", mc_chickenPicker.getValue());
        editor.putInt("mc_puisorValue", mc_puisorPicker.getValue());
        editor.putInt("big_macValue", big_macPicker.getValue());
        editor.putInt("big_tastyValue", big_tastyPicker.getValue());
        editor.putInt("quarter_pounderValue", quarter_pounderPicker.getValue());
        editor.putInt("hamburgerValue", hamburgerPicker.getValue());
        editor.putInt("cheeseburgerValue", cheeseburgerPicker.getValue());
        editor.putInt("db_cheeseburgerValue", db_cheeseburgerPicker.getValue());
        editor.putInt("dipping_stripsValue", dipping_stripsPicker.getValue());
        editor.putInt("mcfries_largeValue", mcfries_largePicker.getValue());
        editor.putInt("mcfries_smallValue", mcfries_smallPicker.getValue());
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
        editor.remove("hariboValue");
        editor.remove("haribo_colaValue");
        //Made by Anton A.
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
