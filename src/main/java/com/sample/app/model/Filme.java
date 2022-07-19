package com.sample.app.model;

public class Filme {
    
    private String title;
    private String image;
    private String imDbRating;
    
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
    public String getImDbRating() {
        return imDbRating;
    }
    public void setImDbRating(String imDbRating) {
        this.imDbRating = imDbRating;
    }

    @Override
    public String toString() {
        return "-> Titulo: " + title
            + "\n-> Link da imagem: " + image
            + "\n-> Avaliacao: " + imDbRating;
    }
}
