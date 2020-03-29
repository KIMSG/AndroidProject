package com.e.myprogram2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView likeCountView;
    Button likeButton;
    int likeCount;
    boolean likeState = false;

    TextView unlikeCountView;
    Button unlikeButton;
    int unlikeCount;
    boolean unlikeState = false;

    CommentAdapter adapter;

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
                    if (unlikeState == true){
                        unlikeState = !unlikeState;
                        undecrLikeCount();
                    }
                }
                likeState = !likeState;
            }
        });
        likeCountView = (TextView)findViewById(R.id.likeCountView);

        unlikeButton = (Button)findViewById(R.id.unlikeButton);
        unlikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (unlikeState){
                    undecrLikeCount();
                }else {
                    unincreLikeCount();
                    if (likeState == true){
                        likeState = !likeState;
                        decrLikeCount();
                    }
                }
                unlikeState = !unlikeState;
            }
        });
        unlikeCountView = (TextView)findViewById(R.id.unlikeCountView);

        ListView listView = (ListView) findViewById(R.id.listView);
        adapter = new CommentAdapter();
        adapter.addItem(new CommentItem("id007***", R.drawable.user1, "110분전",5 ,"잘봤습니다.","30"));
        adapter.addItem(new CommentItem("mountain***", R.drawable.user1, "130분전",2 ,"이런영화는 오랜만입니다.","510"));
        adapter.addItem(new CommentItem("goHOME***", R.drawable.user1, "30분전",3 ,"좋은 영화였습니다..","504"));
        adapter.addItem(new CommentItem("woojoo***", R.drawable.user1, "16분전",5 ,"추천합니다.","60"));
        adapter.addItem(new CommentItem("lown***", R.drawable.user1, "120분전",4 ,"좋은 소개 입니다..","30"));
        listView.setAdapter(adapter);
    }

    public void increLikeCount() {
        likeCount += 1;
        likeCountView.setText(String.valueOf(likeCount));
        likeButton.setBackgroundResource(R.drawable.ic_thumb_up_selected);
    }

    public void decrLikeCount() {
        likeCount -= 1;
        likeCountView.setText(String.valueOf(likeCount));
        likeButton.setBackgroundResource(R.drawable.thumbs_up_selector);
    }


    public void unincreLikeCount() {
        unlikeCount += 1;
        unlikeCountView.setText(String.valueOf(unlikeCount));
        unlikeButton.setBackgroundResource(R.drawable.ic_thumb_down_selected);
    }

    public void undecrLikeCount() {
        unlikeCount -= 1;
        unlikeCountView.setText(String.valueOf(unlikeCount));
        unlikeButton.setBackgroundResource(R.drawable.thumbs_down_selector);
    }
    class CommentAdapter extends BaseAdapter{
        ArrayList<CommentItem> items = new ArrayList<CommentItem>();
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(CommentItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CommentItemView view = null;
            if (convertView == null){
                view = new CommentItemView(getApplicationContext());
            }else {
                view = (CommentItemView) convertView;
            }
            CommentItem item = items.get(position);
            view.setProfileId(item.getProfileId());
            view.setProfileImg(item.getProfileImg());
            view.setProfileTime(item.getProfileTime());
            view.setProfileRatingBar(item.getProfileRatingBar());
            view.setProfileComment(item.getProfileComment());
            view.setProfileLikeCount(item.getProfileLikeCount());
            return view;
        }

    }
}
