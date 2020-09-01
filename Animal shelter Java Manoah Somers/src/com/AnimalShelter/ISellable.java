package com.AnimalShelter;

public interface ISellable {
    void updatePrice(double price);
    void updateName(String newName);
    double getPrice();
    String getName();

}
