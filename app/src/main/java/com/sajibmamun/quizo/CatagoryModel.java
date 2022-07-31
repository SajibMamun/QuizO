package com.sajibmamun.quizo;

public class CatagoryModel {
    private String ImageURL,Title;

    public CatagoryModel(String imageURL, String title) {
        ImageURL = imageURL;
        Title = title;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
