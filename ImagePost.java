package com.campusdual.social_network;

import java.time.LocalDate;
import java.util.*;

public class ImagePost extends Post {
    protected String imageDimensionsPost;

    // constructor
    public ImagePost(Date datePost, String titlePost, String imageDimensionsPost) {
        super(datePost, titlePost);
        this.imageDimensionsPost = imageDimensionsPost;
    }

    // getters y setters propios
    public String getImageDimensionsPost() {
        return imageDimensionsPost;
    }

    public void setImageDimensionsPost(String imageDimensionsPost) {
        this.imageDimensionsPost = imageDimensionsPost;
    }

    // getters y setters heredados
    @Override
    public void setCommentPostList(List<Comments> commentPostList) {
        this.commentPostList = commentPostList;
    }

    @Override
    // "\n" eso es para salto de línea
    public String toString() {
        return "Título: " + this.getTitlePost()+"\n"+ "Tamaño: " + this.getImageDimensionsPost()+
                "px" +
                "\n "+this.getDatePost() + "\n " + this.getCommentPostList();
    }


}
