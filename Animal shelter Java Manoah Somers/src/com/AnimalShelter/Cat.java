package com.AnimalShelter;

//Cat is the same as in VS
public class Cat extends Animal {
    public String badHabits;

    public Cat(String name, Gender gender, String _badHabits){
        super(name, gender);
        this.badHabits = _badHabits;
        price = calculatePrice();
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
