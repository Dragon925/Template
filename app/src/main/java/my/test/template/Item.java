package my.test.template;

import android.graphics.drawable.Drawable;

public class Item {

    private String name;
    private String description;
    private double cost;
    private String about;
    private Drawable image;
    private int count;

    public Item(String name, String description, double cost, String about) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.about = about;
        count = 0;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}