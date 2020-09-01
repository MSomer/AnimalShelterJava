package com.AnimalShelter;

import java.time.LocalDate;

public abstract class Animal {
    public String name;
    public Gender gender;
    public Reservor reservedBy;

    public Animal(String _name, Gender _gender){
        this.name = _name;
        this.gender = _gender;
    }

    public boolean reserve(String reservedBy){
        if(this.reservedBy == null){
            this.reservedBy = new Reservor(reservedBy, LocalDate.now());
            return true;
        }
        return false;
    }

    public String toString(){
        String reserved = "not reserved";
        if (this.reservedBy != null)
        {
            reserved = "reserved by "+reservedBy.name+"";
        }
        return name+", "+gender+", "+reserved+"";
    }
}
