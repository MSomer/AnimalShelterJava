package com.AnimalShelter;

import java.util.Scanner;

public class Main {

    private static Scanner scn;
    private static Reservation reservation;
    private static AnimalCreator animalCreator;
    private static AnimalReserver animalReserver;
    private static Webshop webshop;

    public static void main(String[] args) {
        scn = new Scanner(System.in);
        reservation = new Reservation();
        animalCreator = new AnimalCreator(reservation);
        animalReserver = new AnimalReserver(reservation);
        webshop = new Webshop();

        while(true){
            System.out.println("Choose mode: \n Add animal \n reserve animal \n Webshop");
            switch (scn.nextLine().toLowerCase()) {
                //Adding the animals
                case "add animal":
                    while (true) {
                        animalCreator.createAnimalSpecifications();
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
                        animalReserver.reserveAnimal();
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

    private static void printAllAnimals(){
        reservation.animals.forEach(animal -> {
            System.out.println(reservation.animals.indexOf(animal)+1+" "+animal);
        });
    }
}
