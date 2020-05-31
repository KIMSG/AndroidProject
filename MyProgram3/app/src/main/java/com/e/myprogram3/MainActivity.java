package com.e.myprogram3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

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

    RatingBar ratingBar;
    TextView outputView;
    ListView listView;

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

        listView = (ListView) findViewById(R.id.listView);
        adapter = new CommentAdapter();
        adapter.addItem(new CommentItem("id007***", R.drawable.user1, "110분전",5 ,"잘봤습니다.","30"));
        adapter.addItem(new CommentItem("mountain***", R.drawable.user1, "130분전",2 ,"이런영화는 오랜만입니다.","510"));
        adapter.addItem(new CommentItem("goHOME***", R.drawable.user1, "30분전",3 ,"좋은 영화였습니다..","504"));
        adapter.addItem(new CommentItem("woojoo***", R.drawable.user1, "16분전",5 ,"추천합니다.","60"));
        adapter.addItem(new CommentItem("lown***", R.drawable.user1, "120분전",4 ,"좋은 소개 입니다..","30"));
        listView.setAdapter(adapter);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        Button commentBtn = (Button)findViewById(R.id.commentBtn);
        commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCommentWriteActivity();
            }
        });

        Button commentAllBtn = (Button)findViewById(R.id.commentAllBtn);
        commentAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCommentListActivity(listView);
            }
        });

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
    class CommentAdapter extends BaseAdapter {
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

    private void showCommentWriteActivity() {
        Intent intent = new Intent(getApplicationContext(), CommentWriteActivity.class);
        startActivityForResult(intent, 101);
    }

    private void showCommentListActivity(ListView listView) {
        Intent intent = new Intent(getApplicationContext(), CommentListActivity.class);

        processIntent(intent);
        startActivityForResult(intent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == 101){
            if (intent != null) {
                String contents = intent.getStringExtra("contents");
                float rating = intent.getFloatExtra("rating", 0.0f);

                int toRating = (int)rating;
                adapter.addItem(new CommentItem("add***", R.drawable.user1, "방금",toRating ,contents,"0"));
                listView = (ListView) findViewById(R.id.listView);
                listView.setAdapter(adapter);

            }
        }
    }

    private void processIntent(Intent intent) {
        if (intent != null){
            float rating = intent.getFloatExtra("rating", 0.0f);
        }
    }

}
