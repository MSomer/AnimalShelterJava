package Animal;

import com.AnimalShelter.Animal.AnimalCreator;
import com.AnimalShelter.Animal.Gender;
import com.AnimalShelter.Animal.Reservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AnimalCreatorTest {
    @Test
    public void createNewAnimalTest1(){
        //Test for dog
        Reservation reservation = new Reservation();
        reservation.newDog("Testname", Gender.male);
        String expectedAnimal = "Testname, male, not reserved, price:550.0, last walk: "+ LocalDate.now();
        String actualAnimal = reservation.getAnimals().get(0).toString();
        Assertions.assertEquals(expectedAnimal, actualAnimal);
    }
    @Test
    public void createNewAnimalTest2(){
        //Test for cat
        Reservation reservation = new Reservation();
        reservation.newCat("Testname", Gender.female, "bites");
        String expectedAnimal = "Testname, female, not reserved, price:250.0, bad habits: bites";
        String actualAnimal = reservation.getAnimals().get(0).toString();
        Assertions.assertEquals(expectedAnimal, actualAnimal);
    }
}