//Assignment 1
//Jaxson Meisenhelter
//MainActivity.java
package com.example.tipcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    EditText billTextNumber;
    RadioGroup radioGroup;
    SeekBar seekBar;
    TextView customValue;
    TextView totalValue;
    TextView tipValue;
    Calculator calc;
    double customPercent = 25;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billTextNumber = findViewById(R.id.billTextNumber);
        radioGroup = findViewById(R.id.radioGroup);
        seekBar = findViewById(R.id.seekBar);
        customValue = findViewById(R.id.customValue);
        totalValue = findViewById(R.id.totalValue);
        tipValue = findViewById(R.id.tipValue);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                customPercent = i;
                customValue.setText(i+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        findViewById(R.id.calculateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String enteredBill = billTextNumber.getText().toString();
                try {
                    double bill = Double.valueOf(enteredBill);
                    double tip = 1.1;
                    if(radioGroup.getCheckedRadioButtonId() == R.id.tip15){
                        tip = 1.15;
                    }
                    else if(radioGroup.getCheckedRadioButtonId() == R.id.tip18){
                        tip = 1.18;
                    }
                    else if(radioGroup.getCheckedRadioButtonId() == R.id.tipCustom){
                        //fix
                        Log.d("test1", String.valueOf(customPercent));
                        tip = (customPercent/100) + 1;
                    }

                    calc = new Calculator(bill, tip);
                    double total = calc.total();

                    tipValue.setText(String.valueOf(df.format(total-bill)));
                    totalValue.setText(String.valueOf(df.format(total)));

                } catch(NumberFormatException ex){

                }
            }
        });

        findViewById(R.id.resetButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup.check(R.id.tip10);
                customValue.setText("25%");
                tipValue.setText("0.00");
                totalValue.setText("0.00");
                billTextNumber.setText("");
                seekBar.setProgress(25);
            }
        });
    }
}