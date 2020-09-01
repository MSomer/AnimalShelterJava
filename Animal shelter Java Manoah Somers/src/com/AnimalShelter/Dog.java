package com.AnimalShelter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//Dog is Exacly the same as in VS
public class Dog extends Animal {
    public LocalDate lastWalk;

    public Dog(String name, Gender gender){
        super(name, gender);
        this.lastWalk = LocalDate.now();
        price = calculatePrice();
    }

    public boolean needsWalk(){
        return (LocalDate.now().until(this.lastWalk, ChronoUnit.DAYS)) > 0;
    }

    @Override
    public String toString(){
        return super.toString()+", last walk: "+lastWalk+"";
    }

    @Override
    public void updatePrice(double price) {
        System.out.println("Not available");
    }

    @Override
    public void updateName(String newName) {
        System.out.println("Not available");
    }
    private double calculatePrice(){
        double priceOfDog = 500 - (AnimalCreator.numberOfDogs * 50);
        if(priceOfDog < 50) return 50;
        return priceOfDog;
    }
}
