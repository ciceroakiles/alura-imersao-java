package com.sample.app.model;

public class Conteudo {
    
    private String title;
    private String image;
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "[title=" + title + ",\nimage=" + image + "]";
    }
}
