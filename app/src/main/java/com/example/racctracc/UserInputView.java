package com.example.racctracc;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UserInputView extends LinearLayout {

    private TextView nameTextView;

    public UserInputView(Context context) {
        super(context);
        initialize(context);
    }

    public UserInputView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public UserInputView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    private void initialize(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_user_input, this, true);
        nameTextView = view.findViewById(R.id.tvName);

        SharedPreferences sp = context.getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        String name = sp.getString("name", null);
        if (name != null && !name.isEmpty()) {
            nameTextView.setText("Hello, " + name + "!");
        } else {
            nameTextView.setText("Hello!");
        }
    }
}
