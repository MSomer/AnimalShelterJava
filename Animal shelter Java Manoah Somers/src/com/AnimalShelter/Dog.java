package com.AnimalShelter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//Dog is Exacly the same as in VS
public class Dog extends Animal {
    public LocalDate lastWalk;

    public Dog(String name, Gender gender){
        super(name, gender);
        this.lastWalk = LocalDate.now();
    }

    public boolean needsWalk(){
        return (LocalDate.now().until(this.lastWalk, ChronoUnit.DAYS)) > 0;
    }

    @Override
    public String toString(){
        return super.toString()+", last walk: "+lastWalk+"";
    }
}
