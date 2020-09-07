package com.AnimalShelter.Animal;

import java.util.Scanner;

public class AnimalReserver {

    private Scanner scn;
    private static Reservation reservation;

    public AnimalReserver(Reservation reservation){
        scn = new Scanner(System.in);
        this.reservation = reservation;
    }

    public void chooseAnimalToReserve(){
        System.out.println("Type number of the preferred animal to reserve");
        try{
            reserveAnimal(Integer.parseInt(scn.nextLine()));
        }
        catch (NumberFormatException ex){
            System.out.println("Enter a number.");
            return;
        }
        //Animal animalToReserve = (Animal) reservation.animals.stream().filter(animal -> prefferedAnimalToReserve.equals(animal.name)).findFirst().orElse(null);
    }
    public void reserveAnimal(int indexOfPrefferdAnimal){
        if(indexOfPrefferdAnimal-1 > reservation.getAnimals().stream().count()-1||indexOfPrefferdAnimal-1<0){System.out.println("Enter a valid number");return;}
        var animalToReserve = reservation.getAnimals().get(indexOfPrefferdAnimal-1);
        if(animalToReserve != null){
            System.out.println("Name of booker");
            String reserverName = scn.nextLine();
            reservation.reserveAnimal(indexOfPrefferdAnimal-1, reserverName);
            //animalToReserve.reserve(reserverName);
        }
        else{
            System.out.println("Animal not found");
        }
    }
}
