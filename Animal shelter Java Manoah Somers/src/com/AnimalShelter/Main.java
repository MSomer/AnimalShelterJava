package com.AnimalShelter;

import com.AnimalShelter.Animal.AnimalCreator;
import com.AnimalShelter.Animal.AnimalReserver;
import com.AnimalShelter.Animal.Reservation;
import com.AnimalShelter.Webshop.Webshop;

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
                    animalCreator.createAnimalSpecifications();
                    break;
                //Reserving the animals
                case "reserve animal":
                    if(reservation.getAnimals().stream().count()<=0) {System.out.println("No animals added."); break;}
                    printAllAnimals();
                    animalReserver.chooseAnimalToReserve();
                    break;
                case "webshop":
                    webshop.menu();
                    break;
                //Default case
                default:
                    System.out.println("Command not found.");
                    break;
            }
        }
    }

    private static void printAllAnimals(){
        reservation.getAnimals().forEach(animal -> {
            System.out.println(reservation.getAnimals().indexOf(animal)+1+" "+animal);
        });
    }
}
