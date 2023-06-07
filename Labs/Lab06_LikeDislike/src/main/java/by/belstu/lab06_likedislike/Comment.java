package com.example.task2.model;

public class Comment {
    private int id;
    private String text;
    private int like;
    private int dislike;

    //region Constructors
    public Comment(int id, String text, int like, int dislike) {
        this.id = id;
        this.text = text;
        this.like = like;
        this.dislike = dislike;
    }
    public Comment(int id, int like, int dislike) {
        this.id = id;
        this.like = like;
        this.dislike = dislike;
    }
    //endregion
    //region Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }
    //endregion
}
