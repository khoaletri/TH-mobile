package com.example.exercise1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText tvresult;

    Button bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btplus, btsub, btmult, btdivi, btresult, btreset;

    Integer lastvalue = 0, currentvalue;

    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvresult = findViewById(R.id.text);
        bt0 = findViewById(R.id.button0);
        bt1 = findViewById(R.id.button1);
        bt2 = findViewById(R.id.button2);
        bt3 = findViewById(R.id.button3);
        bt4 = findViewById(R.id.button4);
        bt5 = findViewById(R.id.button5);
        bt6 = findViewById(R.id.button6);
        bt7 = findViewById(R.id.button7);
        bt8 = findViewById(R.id.button8);
        bt9 = findViewById(R.id.button9);
        btplus = findViewById(R.id.btplus);
        btsub = findViewById(R.id.btsub);
        btmult = findViewById(R.id.btmult);
        btdivi = findViewById(R.id.btdivi);
        btresult = findViewById(R.id.btresult);
        btreset = findViewById(R.id.btreset);

        View.OnClickListener buttonListener = new View.OnClickListener() {
            public void onClick(View v) {
                Button bt = (Button) v;
                int id = bt.getId();
                if (id == R.id.button0) {
                    setvalue(tvresult, "0");
                } else if (id == R.id.button1) {
                    setvalue(tvresult, "1");
                } else if (id == R.id.button2) {
                    setvalue(tvresult, "2");
                } else if (id == R.id.button3) {
                    setvalue(tvresult, "3");
                } else if (id == R.id.button4) {
                    setvalue(tvresult, "4");
                } else if (id == R.id.button5) {
                    setvalue(tvresult, "5");
                } else if (id == R.id.button6) {
                    setvalue(tvresult, "6");
                } else if (id == R.id.button7) {
                    setvalue(tvresult, "7");
                } else if (id == R.id.button8) {
                    setvalue(tvresult, "8");
                } else if (id == R.id.button9) {
                    setvalue(tvresult, "9");
                } else if (id == R.id.btplus) {
                    operation = "plus";
                    lastvalue = Integer.parseInt(tvresult.getText().toString());
                    resetvalue();
                } else if (id == R.id.btsub) {
                    operation = "sub";
                    lastvalue = Integer.parseInt(tvresult.getText().toString());
                    resetvalue();
                } else if (id == R.id.btmult) {
                    operation = "mult";
                    lastvalue = Integer.parseInt(tvresult.getText().toString());
                    resetvalue();
                } else if (id == R.id.btdivi) {
                    operation = "divi";
                    lastvalue = Integer.parseInt(tvresult.getText().toString());
                    resetvalue();
                } else if (id == R.id.btresult) {
                    currentvalue = Integer.parseInt(tvresult.getText().toString());
                    process(lastvalue, currentvalue);
                } else if (id == R.id.btreset) {
                    resetvalue();
                }
            }
        };

        bt0.setOnClickListener(buttonListener);
        bt1.setOnClickListener(buttonListener);
        bt2.setOnClickListener(buttonListener);
        bt3.setOnClickListener(buttonListener);
        bt4.setOnClickListener(buttonListener);
        bt5.setOnClickListener(buttonListener);
        bt6.setOnClickListener(buttonListener);
        bt7.setOnClickListener(buttonListener);
        bt8.setOnClickListener(buttonListener);
        bt9.setOnClickListener(buttonListener);
        btplus.setOnClickListener(buttonListener);
        btsub.setOnClickListener(buttonListener);
        btmult.setOnClickListener(buttonListener);
        btdivi.setOnClickListener(buttonListener);
        btresult.setOnClickListener(buttonListener);
        btreset.setOnClickListener(buttonListener);
    }

    public void setvalue(EditText a, String b) {
        String last = a.getText().toString();
        if (!last.equals("")) {
            last += b;
            b = last;
        }
        a.setText(b);
    }

    public void resetvalue() {
        tvresult.setText("0");
    }

    public void process(Integer a, Integer b) {
        Integer presult = 0;
        if (operation.equals("plus")) {
            presult = a + b;
        } else if (operation.equals("sub")) {
            presult = a - b;
        } else if (operation.equals("mult")) {
            presult = a * b;
        } else if (operation.equals("divi")) {
            if (b != 0) {
                presult = a / b;
            } else {
                // Handle division by zero
                // For now, let's just display an error message
                tvresult.setText("Error: Division by zero");
                return;
            }
        }
        tvresult.setText(String.valueOf(presult));
    }
}
