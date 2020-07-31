package com.mata.porfolio.portfolio;

import java.io.Serializable;

public class PortfolioItem implements Serializable {
    private int image;
    private String title;
    private String description;

    public PortfolioItem(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }
    public PortfolioItem(int image){
        this.image = image;

    }
    public PortfolioItem(){

    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
