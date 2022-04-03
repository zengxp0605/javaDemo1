package com.jason.basejava.reflectTest.model;

/**
 *
 */
public class Apple {
    public String testName;
    private int price;
    private String color;

    public Apple(int price, String color) {
        this.price = price;
        this.color = color;
    }

    public Apple() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
