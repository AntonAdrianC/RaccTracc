package com.example.racctracc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    CheckBox rememberMeCheckBox;
    EditText name, email, password;
    String nameStr, emailStr, passwordStr;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        if (sp.getBoolean("rememberMe", false)) {
            // Remember me is selected, navigate to Navigation activity
            navigateToNavigationActivity();
            finish(); // Add this line to finish MainActivity
            return; // Skip the remaining code in onCreate()
        }

        setContentView(R.layout.activity_main);
        rememberMeCheckBox = findViewById(R.id.remember_me_checkbox);

        name = findViewById(R.id.etName);
        email = findViewById(R.id.etMail);
        password = findViewById(R.id.etPassword);

        boolean rememberMe = sp.getBoolean("rememberMe", false); // Retrieve the "Remember me" preference
        rememberMeCheckBox.setChecked(rememberMe);

        if (rememberMe) {
            // Retrieve the stored values and populate the input fields
            nameStr = sp.getString("name", "");
            emailStr = sp.getString("email", "");
            passwordStr = sp.getString("password", "");

            name.setText(nameStr);
            email.setText(emailStr);
            password.setText(passwordStr);
        }

        rememberMeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && name.getText().toString().isEmpty()) {
                    // Disable "Remember me" if name field is empty
                    rememberMeCheckBox.setChecked(false);
                    Toast.makeText(MainActivity.this, "Please enter a name before selecting 'Remember me'.", Toast.LENGTH_SHORT).show();
                } else {
                    // Save the "Remember me" preference when the checkbox state changes
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("rememberMe", isChecked);
                    editor.apply();

                    if (!isChecked) {
                        // Clear the stored values only when the checkbox is unchecked
                        editor.remove("name");
                        editor.remove("email");
                        editor.remove("password");
                        editor.apply();
                    }
                }
            }
        });

        Button btn = findViewById(R.id.log_in_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameStr = name.getText().toString();
                emailStr = email.getText().toString();
                passwordStr = password.getText().toString();

                SharedPreferences.Editor editor = sp.edit();

                editor.putString("name", nameStr);
                editor.putString("email", emailStr);
                editor.putString("password", passwordStr);
                editor.apply();

                navigateToNavigationActivity();

                Toast.makeText(getApplicationContext(), "Logged in successfully", Toast.LENGTH_SHORT).show();
            }
        });

        ToggleButton showPasswordToggle = findViewById(R.id.show_password_toggle);
        showPasswordToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Show password
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    // Hide password
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }

    private void navigateToNavigationActivity() {
        Intent intent = new Intent(getApplicationContext(), Navigation.class);
        startActivity(intent);
        finishAffinity(); // Close all activities and open MainActivity
    }
}
