package com.campusdual.social_network;

import java.time.LocalDate;
import java.util.*;

public class TextPost extends Post{
    private String contentPost;

    // constructor

    public TextPost(Date datePost, String titlePost, String contentPost) {
        super(datePost, titlePost);
        this.contentPost = contentPost;
    }
    // getters y setters

    public String getContentPost() {
        return contentPost;
    }
    public void setContentPost(String contentPost) {
        this.contentPost = contentPost;
    }

    // getters y setters heredados

    @Override
    public void setCommentPostList(List<Comments> commentPostList) {
        this.commentPostList = commentPostList;
    }
    @Override
    public String toString() {
        return "Título: " +  this.getTitlePost()+"\n"+this.getContentPost()+"\n"+this.getDatePost() + "\n " + this.getCommentPostList();
    }
}
