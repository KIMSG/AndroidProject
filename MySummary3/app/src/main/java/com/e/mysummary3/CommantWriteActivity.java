package com.e.mysummary3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class CommantWriteActivity extends AppCompatActivity {
    RatingBar ratingBar;
    EditText contentsInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commant_write);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        contentsInput = (EditText) findViewById(R.id.contentsInput);

        Button saveButton = (Button)  findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMain();
            }
        });

        Intent intent = getIntent();
        processIntent(intent);
    }

    private void returnToMain() {
        String contents = contentsInput.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("contents", contents);

        setResult(RESULT_OK);

        finish();
    }

    private void processIntent(Intent intent) {
        if (intent != null){
            float rating = intent.getFloatExtra("rating", 0.0f);
            ratingBar.setRating(rating);
        }
    }
}
