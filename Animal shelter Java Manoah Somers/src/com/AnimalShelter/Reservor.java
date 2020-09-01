package com.AnimalShelter;

import java.time.LocalDate;

public class Reservor {
    public String name;
    public LocalDate reservedAt;

    public Reservor(String name, LocalDate date)
    {
        this.name = name;
        this.reservedAt = date;
    }
}
