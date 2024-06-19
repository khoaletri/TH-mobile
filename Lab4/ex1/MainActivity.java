package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editData = findViewById(R.id.editData);
        Button btnReadData = findViewById(R.id.btnReadData);

        btnReadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream in = getResources().openRawResource(R.raw.myfileA);
                InputStreamReader inReader = new InputStreamReader(in);
                BufferedReader bufReader = new BufferedReader(inReader);
                StringBuilder builder = new StringBuilder();
                String data;

                try {
                    while ((data = bufReader.readLine()) != null) {
                        builder.append(data);
                        builder.append("\n");
                    }
                    in.close();
                } catch (IOException ex) {
                    Log.e("ERROR", ex.getMessage());
                }

                editData.setText(builder.toString());
            }
        });
    }
}



