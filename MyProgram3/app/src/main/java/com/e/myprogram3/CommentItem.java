package com.e.myprogram3;

public class CommentItem {
    String profileId;
    int profileImg;
    String profileTime;
    int profileRatingBar;
    String profileComment;
    String profileLikeCount;

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public int getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(int profileImg) {
        this.profileImg = profileImg;
    }

    public String getProfileTime() {
        return profileTime;
    }

    public void setProfileTime(String profileTime) {
        this.profileTime = profileTime;
    }

    public int getProfileRatingBar() {
        return profileRatingBar;
    }

    public void setProfileRatingBar(int profileRatingBar) {
        this.profileRatingBar = profileRatingBar;
    }

    public String getProfileComment() {
        return profileComment;
    }

    public void setProfileComment(String profileComment) {
        this.profileComment = profileComment;
    }

    public String getProfileLikeCount() {
        return profileLikeCount;
    }

    public void setProfileLikeCount(String profileLikeCount) {
        this.profileLikeCount = profileLikeCount;
    }

    public CommentItem(String profileId , int profileImg , String profileTime, int profileRatingBar, String profileComment, String profileLikeCount){
        this.profileId = profileId;
        this.profileImg = profileImg;
        this.profileTime = profileTime;
        this.profileRatingBar = profileRatingBar;
        this.profileComment = profileComment;
        this.profileLikeCount = profileLikeCount;
    }

    @Override
    public String toString() {
        return "CommentItem{" +
                "profileId='" + profileId + '\''  +
                ", profileImg=" + profileImg +
                ", profileTime='" + profileTime + '\'' +
                ", profileRatingBar=" + profileRatingBar +
                ", profileComment='" + profileComment + '\'' +
                ", profileLikeCount='" + profileLikeCount + '\'' +
                '}';
    }
}
