package com.AnimalShelter;

import java.util.ArrayList;

//Class is the same as VS
public class Reservation {
    public ArrayList<Animal>  animals;
    public Reservation(){
        animals = new ArrayList<Animal>();
    }

    public void newCat(String name, Gender gender, String badHabits){
    this.animals.add(new Cat(name, gender, badHabits));
    }

    public void newDog(String name, Gender gender){
        this.animals.add(new Dog(name, gender));
    }
}
