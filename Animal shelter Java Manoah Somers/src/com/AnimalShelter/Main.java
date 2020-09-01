package com.AnimalShelter;

import java.util.Scanner;

public class Main {

    private static Scanner scn;
    private static Reservation reservation;
    private static AnimalCreator animalCreator;
    private static Webshop webshop;

    public static void main(String[] args) {
        scn = new Scanner(System.in);
        reservation = new Reservation();
        animalCreator = new AnimalCreator(reservation);
        webshop = new Webshop();

        while(true){
            System.out.println("Choose mode: \n Add animal \n reserve animal \n Webshop");
            switch (scn.nextLine().toLowerCase()) {
                //Adding the animals
                case "add animal":
                    while (true) {
                        animalCreator.createAnimal();
                        System.out.println("Add another animal?");
                        //TODO Change boolean input to yes/no input.
                        if (!scn.nextBoolean()) {
                            scn.nextLine();
                            break;
                        }
                        scn.nextLine();
                    }
                    break;
                //Reserving the animals
                case "reserve animal":
                    while (true) {
                        if(reservation.animals.stream().count()<=0) {System.out.println("No animals added."); break;}
                        printAllAnimals();
                        reserveAnimal();
                        System.out.println("Reserve another animal?");
                        //TODO Change boolean input to yes/no input.
                        if (!scn.nextBoolean()) {
                            scn.nextLine();
                            break;
                        }
                        scn.nextLine();
                    }
                    break;
                case "webshop":
                    while(true){
                        webshop.menu();
                        break;
                    }
                    break;
                //Default case
                default:
                    System.out.println("Command not found.");
                    break;
            }
        }
    }

    private static void reserveAnimal(){
        System.out.println("Type number of the preferred animal to reserve");
        int prefferedAnimalToReserve = scn.nextInt();
        scn.nextLine();
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

    private static void printAllAnimals(){
        reservation.animals.forEach(animal -> {
            System.out.println(reservation.animals.indexOf(animal)+1+" "+animal);
        });
    }
}
