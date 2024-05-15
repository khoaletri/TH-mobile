package com.example.exercise1;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup colorButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorButtons = findViewById(R.id.color_buttons);

        colorButtons.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.red_button) {
                    changeBackgroundColor(Color.RED);
                } else if (checkedId == R.id.green_button) {
                    changeBackgroundColor(Color.GREEN);
                } else if (checkedId == R.id.blue_button) {
                    changeBackgroundColor(Color.BLUE);
                } else if (checkedId == R.id.grey_button) {
                    changeBackgroundColor(Color.GRAY);
                }
            }
        });
    }

    private void changeBackgroundColor(int color) {
        findViewById(R.id.content_layout).setBackgroundColor(color);
    }
}
