package com.example.exercise1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewContactInfoActivity extends Activity {

    private TextView txtNameValue, txtEmailValue, txtProjectValue;
    private Button btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactinfo);

        // Initialize views
        txtNameValue = findViewById(R.id.txtNameValue);
        txtEmailValue = findViewById(R.id.txtEmailValue);
        txtProjectValue = findViewById(R.id.txtProjectValue);
        btnFinish = findViewById(R.id.btnFinish);

        // Retrieve and display the contact information from the Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("nameKey");
            String email = extras.getString("emailKey");
            String project = extras.getString("projectKey");

            txtNameValue.setText(name);
            txtEmailValue.setText(email);
            txtProjectValue.setText(project);
        }

        // Set a click listener for the finish button to close the activity
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close the activity
                finish();
            }
        });
    }
}