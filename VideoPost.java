package com.campusdual.social_network;

import java.time.LocalDate;
import java.util.*;

public class VideoPost extends Post {
    private int videoQualityPost;
    private int videoDurationPost;

    // constructor

    public VideoPost(Date datePost, String titlePost, int videoQualityPost, int videoDurationPost) {
        super(datePost, titlePost);
        this.videoQualityPost = videoQualityPost;
        this.videoDurationPost = videoDurationPost;
    }

    // getters y setters

    public int getVideoQualityPost() {
        return videoQualityPost;
    }

    public void setVideoQualityPost(int videoQualityPost) {
        this.videoQualityPost = videoQualityPost;
    }

    public int getVideoDurationPost() {
        return videoDurationPost;
    }

    public void setVideoDurationPost(int videoDurationPost) {
        this.videoDurationPost = videoDurationPost;
    }

    // getters y setters heredados

    @Override
    public void setCommentPostList(List<Comments> commentPostList) {
        this.commentPostList = commentPostList;
    }

    @Override
    public String toString() {
        return "Título: " + this.getTitlePost()+"\n"+ "Duración: " + this.getVideoDurationPost()+
                " min " + "\n"+ "Calidad: "+ this.getVideoQualityPost() + "p" +
                "\n" + this.getDatePost() + "\n " + this.getCommentPostList();
    }
}
