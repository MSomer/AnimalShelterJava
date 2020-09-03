package com.AnimalShelter;

import java.util.Scanner;

public class AnimalCreator {

    private static Scanner scn;
    private static Reservation reservation;

    public static int numberOfDogs=-1;

    public AnimalCreator(Reservation reservation){
        scn = new Scanner(System.in);
        this.reservation = reservation;
    }

    public void createAnimalSpecifications(){
        System.out.println("Enter animal species Dog/Cat?");
        String animalSpecies = (scn.nextLine());
        System.out.println("Enter animal name:");
        String animalName = (scn.nextLine());
        System.out.println("Animal gender:");
        createNewAnimal(animalSpecies, animalName, determineGender((scn.nextLine())));
    }
    private void createNewAnimal(String animalSpecies, String animalName, Gender animalGender){
        if(animalSpecies.equals("Dog") && animalGender != null){
            numberOfDogs++;
            reservation.newDog(animalName, animalGender);
        }
        else if(animalSpecies.equals("Cat") && animalGender != null){
            System.out.println("BadHabits of animal:");
            reservation.newCat(animalName, animalGender, (scn.nextLine()));
        }
        else{
            System.out.println("Invalid input of animal species.");
        }
    }
    private Gender determineGender(String animalGender){
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
