package com.campusdual.social_network;

import java.util.*;

public class Comments{

    private String textComment;

    private Date dateComment;

    private User userComment;

    // constructor

    public Comments(String textComment, Date dateComment, User userComment) {
        this.textComment = textComment;
        this.dateComment = dateComment;
        this.userComment = userComment;
    }

    // getters y setters

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public Date getDateComment() {
        return dateComment;
    }

    public void setDateComment(Date dateComment) {
        this.dateComment = dateComment;
    }

    public User getUserComment() {
        return userComment;
    }

    public void setUserComment(User userComment) {
        this.userComment = userComment;
    }

    @Override
    public String toString (){

        return "Comentario: " + this.getTextComment() + "\n" + "De: " + this.getUserComment().getName() +
                "\n" + getDateComment() + "\n";
    }
}
