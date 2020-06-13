package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragment fragment1 = new MainFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.container, fragment1).commit();
            }
        });
        Button button2 = (Button)findViewById(R.id.button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragment fragment1 = new MainFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.container, fragment1).commit();
            }
        });
    }
}