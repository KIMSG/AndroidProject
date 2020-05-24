package com.e.myprogram3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

public class CommentWriteActivity extends AppCompatActivity {
    RatingBar sendRatingBar;
    EditText contentsInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commant_write);

        sendRatingBar = (RatingBar) findViewById(R.id.sendRatingBar);
        contentsInput = (EditText) findViewById(R.id.contentsInput);

        Button saveButton = (Button)  findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMain();
            }
        });

        Button resetButton = (Button)  findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        processIntent(intent);
    }

    private void returnToMain() {
        String contents = contentsInput.getText().toString();
        Float rating = sendRatingBar.getRating();

        Intent intent = new Intent();
        intent.putExtra("contents", contents);
        intent.putExtra("rating", rating);

        setResult(Activity.RESULT_OK, intent);

        finish();
    }

    private void processIntent(Intent intent) {
        if (intent != null){
            float rating = intent.getFloatExtra("rating", 0.0f);
            sendRatingBar.setRating(rating);
        }
    }
}
