package com.martinez.apptiendaonline.Model;

import android.graphics.Bitmap;

/**
 * Created by HP on 10/16/2016.
 */
public class Category
{
    private String name;
    private String description;
    private Bitmap image;
    private int imageResource;

    public Category( String name, String description, Bitmap image, int imageResource )
    {
        this.name = name;
        this.description = description;
        this.image = image;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
