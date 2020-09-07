package com.AnimalShelter.Animal;

import com.AnimalShelter.ISellable;

import java.time.LocalDate;

public abstract class Animal implements ISellable {
    private String name;
    private Gender gender;
    private Reservor reservedBy;
    private double price;

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
            reserved = "reserved by "+reservedBy.getName()+"";
        }
        return name+", "+gender+", "+reserved+", price:"+price;
    }
    public double getPrice(){return price; }
    public void setPrice(double price){this.price = price;}
}
