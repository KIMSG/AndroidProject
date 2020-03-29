package com.e.myprogram2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CommentItemView extends LinearLayout {
    TextView profileId;
    ImageView profileImg;
    TextView profileTime;
    RatingBar profileRatingBar;
    TextView profileComment;
    TextView profileLikeCount;

    public CommentItemView(Context context) {
        super(context);
        init(context);
    }

    public CommentItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment_item_view, this, true);

        profileId = (TextView) findViewById(R.id.profileId);
        profileImg = (ImageView) findViewById(R.id.profileImg);
        profileTime = (TextView) findViewById(R.id.profileTime);
        profileRatingBar = (RatingBar) findViewById(R.id.profileRatingBar);
        profileComment = (TextView) findViewById(R.id.profileComment);
        profileLikeCount = (TextView) findViewById(R.id.profileLikeCount);
    }

    public void setProfileId(String id) {
        profileId.setText(id);
    }

    public void setProfileImg(int img) {
        profileImg.setImageResource(img);
    }

    public void setProfileTime(String time) {
        profileTime.setText(time);
    }

    public void setProfileRatingBar(int star) {
        profileRatingBar.setRating(star);
    }

    public void setProfileComment(String comment) {
        profileComment.setText(comment);
    }

    public void setProfileLikeCount(String count) {
        profileLikeCount.setText(count);
    }
}
