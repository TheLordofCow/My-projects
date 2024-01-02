//Assignment 2
//select_mood.java
//Jaxson Meisenhelter
package com.example.feeling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class select_mood extends AppCompatActivity {
    ImageView face;
    SeekBar feelingBar;
    TextView feelingValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mood);

        face = findViewById(R.id.face);
        feelingBar = findViewById(R.id.feelingBar);
        feelingValue = findViewById(R.id.feelingValue);

        feelingBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                feelingValue.setText(i+"");

                if(i == 0){
                    face.setImageDrawable(getResources().getDrawable(R.drawable.not_well));
                }
                else if (i == 1) {
                    face.setImageDrawable(getResources().getDrawable(R.drawable.sad));
                }
                else if (i == 2) {
                    face.setImageDrawable(getResources().getDrawable(R.drawable.ok));
                }
                else if (i == 3) {
                    face.setImageDrawable(getResources().getDrawable(R.drawable.good));
                }
                else if (i == 4) {
                    face.setImageDrawable(getResources().getDrawable(R.drawable.very_good));
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { finish(); }
        });

        findViewById(R.id.submitButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(select_mood.this, MainActivity.class);
                i.putExtra("f", feelingBar.getProgress());
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}