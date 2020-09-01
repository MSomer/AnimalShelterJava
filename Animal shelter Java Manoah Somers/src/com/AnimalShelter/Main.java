package com.AnimalShelter;

import java.util.Scanner;

public class Main {

    private static Scanner scn;
    private static Animal newAnimal;
    private static Reservation reservation;

    private static String animalSpecies;
    private static String animalName;
    private static String animalGender;

    private static boolean addAnimalMode=true;
    private static boolean reserveAnimalMode = false;

    public static void main(String[] args) {
        scn = new Scanner(System.in);
        reservation = new Reservation();
        //Adding the animals
        while(addAnimalMode){
            createAnimal();
            System.out.println("Add another animal?");
            addAnimalMode = scn.nextBoolean();
            scn.nextLine();
        }
        //Reserving the animals
        printAllAnimals();
        reserveAnimal();
        printAllAnimals();
    }
    private static void createAnimal(){
        System.out.println("Enter animal species Dog/Cat?");
        animalSpecies = (scn.nextLine());
        System.out.println("Enter animal name:");
        animalName = (scn.nextLine());
        System.out.println("Animal gender:");
        animalGender = (scn.nextLine());
        Main.createNewAnimalSpecies();
    }
    private static void reserveAnimal(){
        System.out.println("Type number of the preferred animal to reserve");
        String prefferedAnimalToReserve = scn.nextLine();
        Animal animalToReserve = (Animal) reservation.animals.stream().filter(animal -> prefferedAnimalToReserve.equals(animal.name)).findFirst().orElse(null);
        if(animalToReserve != null){
            System.out.println("Name of reserver");
            String reserverName = scn.nextLine();
            animalToReserve.reserve(reserverName);
        }
        else{
            System.out.println("Animal not found");
        }
    }
    private static void createNewAnimalSpecies(){
        if(animalSpecies.equals("Dog")){
            reservation.newDog(animalName, Main.fixGender() );
        }
        else{
            System.out.println("BadHabits of animal:");
            reservation.newCat(animalName, Main.fixGender(), (scn.nextLine()));
        }
    }
    private static Gender fixGender(){
        Gender genderOfAnimal = null;
        if(animalGender == "male"){
            return genderOfAnimal.male;
        }
        else{
            return genderOfAnimal.female;
        }
    }
    private static void printAllAnimals(){
        reservation.animals.forEach(animal -> {
            System.out.println(animal);
        });
    }
}
