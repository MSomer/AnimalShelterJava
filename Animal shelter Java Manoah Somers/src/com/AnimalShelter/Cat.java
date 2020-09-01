package com.AnimalShelter;

//Cat is the same as in VS
public class Cat extends Animal {
    public String badHabits;

    public Cat(String name, Gender gender, String _badHabits){
        super(name, gender);
        this.badHabits = _badHabits;
    }
    @Override
    public String toString()
    {
        return super.toString()+", bad habits: "+badHabits+"";
    }
}
