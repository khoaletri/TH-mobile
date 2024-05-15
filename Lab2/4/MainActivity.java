package com.example.exercise1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText txtName, txtEmail, txtProject;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Initialize views
        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtProject = findViewById(R.id.txtProject);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start ViewContactInfoActivity
                Intent intent = new Intent(MainActivity.this, ViewContactInfoActivity.class);

                // Put the user input into the Intent
                intent.putExtra("nameKey", txtName.getText().toString());
                intent.putExtra("emailKey", txtEmail.getText().toString());
                intent.putExtra("projectKey", txtProject.getText().toString());

                // Start ViewContactInfoActivity
                startActivity(intent);
            }
        });
    }
}
