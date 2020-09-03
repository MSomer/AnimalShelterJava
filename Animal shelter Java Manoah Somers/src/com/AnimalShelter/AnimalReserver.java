package com.AnimalShelter;

import java.util.Scanner;

public class AnimalReserver {

    private Scanner scn;
    private static Reservation reservation;

    public AnimalReserver(Reservation reservation){
        scn = new Scanner(System.in);
        this.reservation = reservation;
    }

    public void reserveAnimal(){
        System.out.println("Type number of the preferred animal to reserve");
        int prefferedAnimalToReserve;
        try{
            prefferedAnimalToReserve = Integer.parseInt(scn.nextLine());
        }
        catch (NumberFormatException ex){
            System.out.println("Enter a number.");
            return;
        }
        //Animal animalToReserve = (Animal) reservation.animals.stream().filter(animal -> prefferedAnimalToReserve.equals(animal.name)).findFirst().orElse(null);
        if(prefferedAnimalToReserve-1 > reservation.animals.stream().count()-1||prefferedAnimalToReserve-1<0){System.out.println("Enter a valid number");return;}
        Animal animalToReserve = reservation.animals.get(prefferedAnimalToReserve-1);
        if(animalToReserve != null){
            System.out.println("Name of booker");
            String reserverName = scn.nextLine();
            animalToReserve.reserve(reserverName);
        }
        else{
            System.out.println("Animal not found");
        }
    }
}
