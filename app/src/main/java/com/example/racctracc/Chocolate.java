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

public class Chocolate extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    SharedPreferences sp;
    NumberPicker snickersPicker;
    NumberPicker bountyPicker;
    NumberPicker marsPicker;
    NumberPicker twixPicker;
    NumberPicker lionPicker;
    NumberPicker kinder_buenoPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.chocolate);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        snickersPicker = findViewById(R.id.snickers);
        bountyPicker = findViewById(R.id.bounty);
        marsPicker = findViewById(R.id.mars);
        twixPicker = findViewById(R.id.twix);
        lionPicker = findViewById(R.id.lion);
        kinder_buenoPicker = findViewById(R.id.kinder_bueno);


        // Set saved values to NumberPicker
        snickersPicker.setValue(sp.getInt("snickersValue", 0));
        bountyPicker.setValue(sp.getInt("bountyValue", 0));
        marsPicker.setValue(sp.getInt("marsValue", 0));
        twixPicker.setValue(sp.getInt("twixValue", 0));
        lionPicker.setValue(sp.getInt("lionValue", 0));
        kinder_buenoPicker.setValue(sp.getInt("kinder_buenoValue", 0));

        snickersPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveChocolateOptions();
            }
        });

        bountyPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveChocolateOptions();
            }
        });

        marsPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveChocolateOptions();
            }
        });
        twixPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveChocolateOptions();
            }
        });

        lionPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveChocolateOptions();
            }
        });

        kinder_buenoPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                saveChocolateOptions();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.optNotes) {
                    Toast.makeText(Chocolate.this, "This app is still in development. Hope you like it!", Toast.LENGTH_LONG).show();
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

    private void saveChocolateOptions() {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("snickersValue", snickersPicker.getValue());
        editor.putInt("bountyValue", bountyPicker.getValue());
        editor.putInt("marsValue", marsPicker.getValue());
        editor.putInt("twixValue", twixPicker.getValue());
        editor.putInt("lionValue", lionPicker.getValue());
        editor.putInt("kinder_buenoValue", kinder_buenoPicker.getValue());
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
