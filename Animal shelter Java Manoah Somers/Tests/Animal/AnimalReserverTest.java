package Animal;

import com.AnimalShelter.Animal.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AnimalReserverTest {
    @Test
    public void reserveAnimalTest1(){
        //Test for Dog
        Reservation reservation = new Reservation();
        reservation.newDog("Testname", Gender.male);
        reservation.reserveAnimal(0,"TestReserver");
        String expectedAnimal = "Testname, male, reserved by TestReserver, price:550.0, last walk: "+ LocalDate.now();
        String actualAnimal = reservation.getAnimals().get(0).toString();
        Assertions.assertEquals(expectedAnimal, actualAnimal);
    }
    @Test
    public void reserveAnimalTest2(){
        //Test for Cat
        Reservation reservation = new Reservation();
        reservation.newCat("Testname", Gender.female, "bites");
        reservation.reserveAnimal(0,"TestReserver");
        String expectedAnimal = "Testname, female, reserved by TestReserver, price:250.0, bad habits: bites";
        String actualAnimal = reservation.getAnimals().get(0).toString();
        Assertions.assertEquals(expectedAnimal, actualAnimal);
    }
}
