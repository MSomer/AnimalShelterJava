package com.AnimalShelter.Animal;

public class Cat extends Animal {
    private String badHabits;

    public Cat(String name, Gender gender, String _badHabits){
        super(name, gender);
        this.badHabits = _badHabits;
        setPrice(calculatePrice());
    }
    @Override
    public String toString()
    {
        return super.toString()+", bad habits: "+badHabits;
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
        double priceOfCatAfterBadHabitPenalty = 350 - (badHabits.length() * 20);
        if(priceOfCatAfterBadHabitPenalty < 35) return 35;
        return priceOfCatAfterBadHabitPenalty;
    }
}
