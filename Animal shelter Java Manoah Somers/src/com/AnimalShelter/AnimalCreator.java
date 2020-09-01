package com.AnimalShelter;

import java.util.Scanner;

public class AnimalCreator {

    private static Scanner scn;
    private static Reservation reservation;

    private static String animalSpecies;
    private static String animalName;
    private static String animalGender;
    public static int numberOfDogs=-1;

    public AnimalCreator(Reservation reservation){
        scn = new Scanner(System.in);
        this.reservation = reservation;
    }

    public void createAnimal(){
        System.out.println("Enter animal species Dog/Cat?");
        animalSpecies = (scn.nextLine());
        System.out.println("Enter animal name:");
        animalName = (scn.nextLine());
        System.out.println("Animal gender:");
        animalGender = (scn.nextLine());
        createNewAnimal();
    }
    private void createNewAnimal(){
        if(animalSpecies.equals("Dog")){
            numberOfDogs++;
            reservation.newDog(animalName, determineGender() );
        }
        else if(animalSpecies.equals("Cat")){
            System.out.println("BadHabits of animal:");
            reservation.newCat(animalName, determineGender(), (scn.nextLine()));
        }
        else{
            System.out.println("Invalid input of animal species.");
        }
    }
    private Gender determineGender(){
        Gender genderOfAnimal = null;
        if(animalGender.equals("male")){
            return genderOfAnimal.male;
        }
        else if(animalGender.equals("female")){
            return genderOfAnimal.female;
        }
        else{
            System.out.println("Invalid input of gender");
            return null;
        }
    }
}
