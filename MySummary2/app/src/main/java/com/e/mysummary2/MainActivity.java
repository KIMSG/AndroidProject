package com.e.mysummary2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView likeCountView;
    Button likeButton;
    int likeCount;
    boolean likeState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeButton = (Button)findViewById(R.id.likeButton);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (likeState){
                    decrLikeCount();
                }else {
                    increLikeCount();
                }
                likeState = !likeState;
            }
        });
        likeCountView = (TextView)findViewById(R.id.likeCountView);

    }

    public void increLikeCount(){
        likeCount +=1;
        likeCountView.setText(String.valueOf(likeCount));
        likeButton.setBackgroundResource(R.drawable.ic_thumb_up_selected);
    }
    public void  decrLikeCount(){
        likeCount -=1;
        likeCountView.setText(String.valueOf(likeCount));
        likeButton.setBackgroundResource(R.drawable.thumbs_up_selector);
    }
}
