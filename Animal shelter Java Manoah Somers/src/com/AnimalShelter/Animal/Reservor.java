package com.AnimalShelter.Animal;

import java.time.LocalDate;

public class Reservor {
    private String name;
    private LocalDate reservedAt;

    public Reservor(String name, LocalDate date)
    {
        this.name = name;
        this.reservedAt = date;
    }
    public String getName(){return name;}
}
