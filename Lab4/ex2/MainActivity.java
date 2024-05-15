package com.example.exercise1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends Activity implements View.OnClickListener {
    Button btnRead, btnWrite;
    EditText editData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnRead = (Button) findViewById(R.id.btnreaddata);
        btnWrite = (Button) findViewById(R.id.btnwritedata);
        editData = (EditText) findViewById(R.id.editdata);

        btnRead.setOnClickListener(this);
        btnWrite.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnreaddata) {
            readData();
        } else if (v.getId() == R.id.btnwritedata) {
            writeData();
        }
    }

    public void readData() {
        try {
            FileInputStream in = openFileInput("myfile.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String data;
            StringBuilder builder = new StringBuilder();
            while ((data = reader.readLine()) != null) {
                builder.append(data).append("\n");
            }
            in.close();
            editData.setText(builder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeData() {
        try {
            FileOutputStream out = openFileOutput("myfile.txt", MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(out);
            writer.write(editData.getText().toString());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
