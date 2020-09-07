package com.AnimalShelter.Animal;

import java.util.ArrayList;

public class Reservation {
    private ArrayList<Animal>  animals;
    public Reservation(){
        animals = new ArrayList<Animal>();
    }

    public void newCat(String name, Gender gender, String badHabits){
        this.animals.add(new Cat(name, gender, badHabits));
    }

    public void newDog(String name, Gender gender){
        this.animals.add(new Dog(name, gender));
    }
    public ArrayList getAnimals(){
        return animals;
    }
    public void reserveAnimal(int indexOfAnimal, String reserverName){
        animals.get(indexOfAnimal).reserve(reserverName);
    }
}
