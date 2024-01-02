//Assignment 2
//MainActivity.java
//Jaxson Meisenhelter
package com.example.feeling;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView feelingLabel;
    EditText nameText, ageText;
    ImageView mainFace;
    int feelingId = 1;
    private ActivityResultLauncher<Intent> selectMoodResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK){
                        feelingLabel.setText(result.getData().getIntExtra("f", 2));
                    } else{
                        feelingLabel.setText("");
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.nameText);
        ageText = findViewById(R.id.ageText);
        mainFace = findViewById(R.id.mainFace);
        feelingLabel = findViewById(R.id.feelingLabel);



        findViewById(R.id.tellUsButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), select_mood.class);
                startActivity(i);
            }
        });

        findViewById(R.id.submitButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feelingLabel.setText(Integer.toString(feelingId));
                System.out.println(Integer.toString(feelingId));
            }
        });


    }
}