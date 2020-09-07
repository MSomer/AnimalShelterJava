package com.AnimalShelter.Webshop;

import com.AnimalShelter.ISellable;

public class SellableItem implements ISellable {

    private double price;
    private String name;

    public SellableItem(String name, double price){
        this.name = name;
        this.price = price;
    }

    @Override
    public void updatePrice(double price) {
        this.price = price;
    }

    @Override
    public void updateName(String newName) {
        this.name = newName;
    }

    @Override
    public String toString() {return "Name of item: "+name+", Price of item: "+price;}
}
