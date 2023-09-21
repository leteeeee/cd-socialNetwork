package com.campusdual.social_network;

import java.time.LocalDate;
import java.util.*;


public abstract class Post {

    // hay 3 tipos de post, de texto, de imagen y de video, por lo que Post será una clase
    // abstracta (no creará ningún objeto) con estas 3 subclases.

    protected Date datePost;
    protected String titlePost;
    protected List<Comments> commentPostList = new ArrayList<>();

    // constructor

    public Post(Date datePost, String titlePost) {
        this.datePost = datePost;
        this.titlePost = titlePost;
    }

    // getters y setters

    public Date getDatePost() {
        return datePost;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }

    public String getTitlePost() {
        return titlePost;
    }

    public void setTitlePost(String titlePost) {
        this.titlePost = titlePost;
    }

    public List<Comments> getCommentPostList() {
        return commentPostList;
    }

    public abstract void setCommentPostList(List<Comments> commentPostList) ;


}
