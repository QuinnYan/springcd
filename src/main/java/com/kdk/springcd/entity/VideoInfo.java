package com.kdk.springcd.entity;

public class VideoInfo {

    private String VideoID;
    private String VideoURL;
    private Integer VideoLike;
    private String VideoCollection;
    private String UserID;

    public String getVideoID() {
        return VideoID;
    }

    public void setVideoID(String videoID) {
        VideoID = videoID;
    }

    public String getVideoURL() {
        return VideoURL;
    }

    public void setVideoURL(String videoURL) {
        VideoURL = videoURL;
    }

    public Integer getVideoLike() {
        return VideoLike;
    }

    public void setVideoLike(Integer videoLike) {
        VideoLike = videoLike;
    }

    public String getVideoCollection() {
        return VideoCollection;
    }

    public void setVideoCollection(String videoCollection) {
        VideoCollection = videoCollection;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }
}
