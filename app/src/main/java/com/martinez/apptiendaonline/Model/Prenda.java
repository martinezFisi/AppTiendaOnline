package com.martinez.apptiendaonline.Model;


public class Prenda
{
    private String name;
    private int idDrawable;
    private String description;
    private float price;

    public Prenda( String name, int idDrawable, String description, float price )
    {
        this.name = name;
        this.idDrawable = idDrawable;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public void setIdDrawable(int idDrawable) {
        this.idDrawable = idDrawable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
