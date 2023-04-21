package com.example.genuinetask.model;

public class ImageModel {
    private int imageResource;
    private String categoryName;
    private String description;

    public ImageModel(int imageResource, String categoryName, String description) {
        this.imageResource = imageResource;
        this.categoryName = categoryName;
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }
}

