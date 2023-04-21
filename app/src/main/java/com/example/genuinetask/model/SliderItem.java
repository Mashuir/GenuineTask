package com.example.genuinetask.model;

import android.net.Uri;

public class SliderItem {

    private Uri image;

    public SliderItem() {
    }

    public SliderItem(Uri image) {
        this.image = image;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }
}
