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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.text.DecimalFormat;

public class Calculator extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.calculator);
        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        int snickersValue = sp.getInt("snickersValue", 0);
        int bountyValue = sp.getInt("bountyValue", 0);
        int marsValue = sp.getInt("marsValue", 0);
        int twixValue = sp.getInt("twixValue", 0);
        int lionValue = sp.getInt("lionValue", 0);
        int kinder_buenoValue = sp.getInt("kinder_buenoValue", 0);
        int dbBoosterValue = sp.getInt("dbBoosterValue", 0);
        int real_burgerValue = sp.getInt("real_burgerValue", 0);
        int zingerValue = sp.getInt("zingerValue", 0);
        int twisterSpicyValue = sp.getInt("twisterSpicyValue", 0);
        int mc_chickenValue = sp.getInt("mc_chickenValue", 0);
        int mc_puisorValue = sp.getInt("mc_puisorValue", 0);
        int big_macValue = sp.getInt("big_macValue", 0);
        int big_tastyValue = sp.getInt("big_tastyValue", 0);
        int quarter_pounderValue = sp.getInt("quarter_pounderValue", 0);
        int hamburgerValue = sp.getInt("hamburgerValue", 0);
        int cheeseburgerValue = sp.getInt("cheeseburgerValue", 0);
        int db_cheeseburgerValue = sp.getInt("db_cheeseburgerValue", 0);
        int dipping_stripsValue = sp.getInt("dipping_stripsValue", 0);
        int mcfries_largeValue = sp.getInt("mcfries_largeValue", 0);
        int mcfries_smallValue = sp.getInt("mcfries_smallValue", 0);
        int pepsiValue = sp.getInt("pepsiValue", 0);
        int pepsi_twistValue = sp.getInt("pepsi_twistValue", 0);
        int cokeValue = sp.getInt("cokeValue", 0);
        int fantaValue = sp.getInt("fantaValue", 0);
        int mountain_dewValue = sp.getInt("mountain_dewValue", 0);
        int spriteValue = sp.getInt("spriteValue", 0);
        int pringlesValue = sp.getInt("pringlesValue", 0);
        int laysValue = sp.getInt("laysValue", 0);
        int laysBBQValue = sp.getInt("laysBBQValue", 0);
        int laysPaprikaValue = sp.getInt("laysPaprikaValue", 0);
        int laysCheeseValue = sp.getInt("laysCheeseValue", 0);
        int laysPiriValue = sp.getInt("laysPiriValue", 0);
        int hariboValue = sp.getInt("hariboValue", 0);
        int haribo_colaValue = sp.getInt("haribo_colaValue", 0);
        int tucValue = sp.getInt("tucValue", 0);
        int tuc_sourValue = sp.getInt("tuc_sourValue", 0);
        int tuc_paprikaValue = sp.getInt("tuc_paprikaValue", 0);
        int mcflurryValue = sp.getInt("mcflurryValue", 0);
        int mc_ice_creamValue = sp.getInt("mc_ice_creamValue", 0);
        int mc_shakeValue = sp.getInt("mc_shakeValue", 0);
        int total = 0;
        double total_fat = 0 ;
        int total_calories= 0;
        double total_sugar= 0;
        double total_protein= 0;
        double total_salt= 0;


        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        TextView totalTextView = findViewById(R.id.totalTextView);
        TextView total_caloriesTextView = findViewById(R.id.total_kcalTextView);
        TextView total_fatTextView = findViewById(R.id.total_fatTextView);
        TextView total_sugarTextView = findViewById(R.id.total_sugarTextView);
        TextView total_proteinTextView = findViewById(R.id.total_proteinTextView);
        TextView total_saltTextView = findViewById(R.id.total_saltTextView);
        total = snickersValue + bountyValue + marsValue + twixValue + lionValue + kinder_buenoValue +dbBoosterValue+ real_burgerValue + zingerValue + twisterSpicyValue;
        total = total + mc_chickenValue + mc_puisorValue + big_macValue + big_tastyValue + quarter_pounderValue + hamburgerValue + cheeseburgerValue + db_cheeseburgerValue + dipping_stripsValue + mcfries_largeValue + mcfries_smallValue;
        total = total + pepsiValue + pepsi_twistValue + cokeValue + fantaValue + mountain_dewValue + spriteValue;
        total = total + pringlesValue + laysValue + laysBBQValue + laysPaprikaValue + laysCheeseValue + laysPiriValue;
        total = total + hariboValue + haribo_colaValue;
        total = total + tucValue + tuc_sourValue + tuc_paprikaValue;
        total = total + mcflurryValue + mc_ice_creamValue + mc_shakeValue;

        total_calories = snickersValue*244+bountyValue*136+marsValue*230+twixValue*123+lionValue*203+kinder_buenoValue*122+dbBoosterValue*465;
        total_calories = total_calories + real_burgerValue*491 + zingerValue*403 + twisterSpicyValue*368 + mc_chickenValue*426 + mc_puisorValue*272 + big_macValue*503 + big_tastyValue*828 + quarter_pounderValue*506+hamburgerValue*254 + cheeseburgerValue*304 + db_cheeseburgerValue*448 + dipping_stripsValue*442 + mcfries_largeValue*434 + mcfries_smallValue*231; //Made by Anton A.
        total_calories = total_calories + pepsiValue*140 + pepsi_twistValue*220 + cokeValue*210 + fantaValue*240 + mountain_dewValue*245 + spriteValue*45;
        total_calories = total_calories + pringlesValue*868 + laysValue*755 + laysBBQValue*742 + laysPaprikaValue*735 + laysCheeseValue*728 + laysPiriValue*687;
        total_calories = total_calories + hariboValue*514 + haribo_colaValue*515 + tucValue*485 + tuc_sourValue*495 + tuc_paprikaValue*495;
        total_calories = total_calories + mcflurryValue*442 + mc_ice_creamValue*101 + mc_shakeValue*326;

        total_fat=mcflurryValue*12 + mc_ice_creamValue*2.3 + mc_shakeValue*6.1 + dipping_stripsValue*26 + mcfries_largeValue*21 + mcfries_smallValue*12;
        total_fat= total_fat + quarter_pounderValue*26 + big_macValue*25 + cheeseburgerValue*13 + db_cheeseburgerValue*24 + big_tastyValue*50 + hamburgerValue*8.8;
        total_fat= total_fat + mc_chickenValue*17 + mc_puisorValue*10 + laysValue*52.15 + laysBBQValue*47.6 + laysCheeseValue*46.2;
        total_fat= total_fat + laysPaprikaValue*46.2 + laysPiriValue*33 + pringlesValue*51.1 ;
        total_fat= total_fat + tucValue*23 + tuc_paprikaValue*23 + tuc_sourValue*23 + hariboValue*0.8 + haribo_colaValue*0.1;
        total_fat= total_fat + pepsiValue*0 + pepsi_twistValue*0 + cokeValue*0 + fantaValue*0 + mountain_dewValue*0 + spriteValue*0;
        total_fat= total_fat + snickersValue*11.7 + lionValue*9.3 + bountyValue*7.3 + marsValue*8.7 + twixValue*6 + kinder_buenoValue*8;
        total_fat= total_fat + dbBoosterValue*22.13 + zingerValue*18.54 + real_burgerValue*25.41 + twisterSpicyValue*16.87;

        total_salt=mcflurryValue*52 + mc_ice_creamValue*0.1 + mc_shakeValue*0.3 + dipping_stripsValue*2.7 + mcfries_largeValue + mcfries_smallValue*0.6;
        total_salt=total_salt + quarter_pounderValue*2.5 + big_macValue*2.2 + cheeseburgerValue*1.7 + db_cheeseburgerValue*2.5 + big_tastyValue*3.7 + hamburgerValue*1.3;
        total_salt= total_salt + mc_chickenValue*1.9 + mc_puisorValue*1.6 + laysValue*2.1 + laysBBQValue*8.4 + laysCheeseValue*8.4;
        total_salt= total_salt + laysPaprikaValue*5.6 + laysPiriValue*1.3 + pringlesValue*1.8 ;
        total_salt= total_salt + tucValue*2.2 + tuc_paprikaValue*2.1 + tuc_sourValue*1.8 + hariboValue*0.1 + haribo_colaValue*0.15;
        total_salt= total_salt + pepsiValue*0.45 + pepsi_twistValue*0.15 + cokeValue*0 + fantaValue*0 + mountain_dewValue*0.05 + spriteValue*0.05;
        total_salt= total_salt + snickersValue*0.3 + lionValue*0.2 + bountyValue*0.07 + marsValue*0.2 + twixValue*0.1 + kinder_buenoValue*0.06;
        total_salt= total_salt + dbBoosterValue*3.09 + zingerValue*1.06 + real_burgerValue*2.14 + twisterSpicyValue*1.85;

        total_sugar=mcflurryValue*0.54  + mc_ice_creamValue*13 + mc_shakeValue*53 + dipping_stripsValue*2 + mcfries_largeValue*0.5 + mcfries_smallValue*0.3;
        total_sugar=total_sugar + quarter_pounderValue*9.3 + big_macValue*8.5 + cheeseburgerValue*7.3 + db_cheeseburgerValue*7.9 + big_tastyValue*10 + hamburgerValue*6.6;
        total_sugar= total_sugar + mc_chickenValue*6.3 + mc_puisorValue*5 + laysValue*0.9 + laysBBQValue*3.6 + laysCheeseValue*4.2;
        total_sugar= total_sugar + laysPaprikaValue*4.2 + laysPiriValue*3.8 + pringlesValue*2 ;
        total_sugar= total_sugar + tucValue*7.1 + tuc_paprikaValue*10 + tuc_sourValue*5.7 + hariboValue*69 + haribo_colaValue*67.5;
        total_sugar= total_sugar + pepsiValue*53 + pepsi_twistValue*55 + cokeValue*53 + fantaValue*52.5 + mountain_dewValue*65 + spriteValue*10;
        total_sugar= total_sugar + snickersValue*26 + lionValue*27 + bountyValue*16.5 + marsValue*35.7 + twixValue*16.2 + kinder_buenoValue*10.6;
        total_sugar= total_sugar + dbBoosterValue*1.85 + zingerValue*1.53 + real_burgerValue*9.77 + twisterSpicyValue*5.99;

        total_protein=mcflurryValue*6.3 + mc_ice_creamValue*2.4 + mc_shakeValue*8.1 + dipping_stripsValue*4.2 + mcfries_largeValue*5.1 + mcfries_smallValue*2.7;
        total_protein= total_protein + quarter_pounderValue*31 + big_macValue*27 + cheeseburgerValue*16 + db_cheeseburgerValue*27 + big_tastyValue*44 + hamburgerValue*13;
        total_protein= total_protein + mc_chickenValue*21 + mc_puisorValue*10 + laysValue*9.5 + laysBBQValue*9.8 + laysCheeseValue*8.4;
        total_protein= total_protein + laysPaprikaValue*8.4 + laysPiriValue*6.6 + pringlesValue*9.7 ;
        total_protein= total_protein + tucValue*8 + tuc_paprikaValue*8 + tuc_sourValue*7.8 + hariboValue*10.4 + haribo_colaValue*9.45;
        total_protein= total_protein + pepsiValue*0 + pepsi_twistValue*0 + cokeValue*0 + fantaValue*0 + mountain_dewValue*0 + spriteValue*0;
        total_protein= total_protein + snickersValue*4.4 + lionValue*2.3 + bountyValue + marsValue*2 + twixValue*1.1 + kinder_buenoValue*1.8;
        total_protein= total_protein + dbBoosterValue*21.27 + zingerValue*23.52 + real_burgerValue*22.51 + twisterSpicyValue*16.43;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedTotalFat = decimalFormat.format(total_fat);
        String formattedTotalSugar = decimalFormat.format(total_sugar);
        String formattedTotalCalories = decimalFormat.format(total_calories);
        String formattedTotalProtein = decimalFormat.format(total_protein);
        String formattedTotalSalt = decimalFormat.format(total_salt);
        totalTextView.setText("Total Junk Food: " + total);
        total_caloriesTextView.setText("Total Calories: " + formattedTotalCalories+"kcal");
        total_fatTextView.setText("Total Fat: " + formattedTotalFat + "g");
        total_sugarTextView.setText("Total Sugar: " + formattedTotalSugar+"g");
        total_proteinTextView.setText("Total Protein: " + formattedTotalProtein+"g");
        total_saltTextView.setText("Total Salt: " + formattedTotalSalt+"g");

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.optNotes) {
                    Toast.makeText(Calculator.this, "This app is still in development. Hope you like it!", Toast.LENGTH_LONG).show();
                } else if (id == R.id.log_out) {
                    clearRememberMe();
                    navigateToMainActivity();
                    showToast();
                } else if (id == R.id.home) {
                    navigateToNavigationActivity();
                } else if (id == R.id.calculator){
                    Toast.makeText(Calculator.this, "You're already in the Calculator", Toast.LENGTH_SHORT).show();
                } else if(id == R.id.settings){
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
