package Webshop;

import com.AnimalShelter.Webshop.SellableItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WebshopTest {

    @Test
    public void addItemTest(){
        //Testing of making a new item
        SellableItem item = new SellableItem("TestProduct", 99);
        String expectedItem = "Name of item: TestProduct, Price of item: 99.0";
        String actualItem = item.toString();
        Assertions.assertEquals(expectedItem, actualItem);
    }
    @Test
    public void editItemTest(){
        //Making a new item to be later edited
        SellableItem itemToEdit = new SellableItem("TestProduct", 99);
        itemToEdit.updateName("TestProductUpdated");
        itemToEdit.updatePrice(100);
        String expectedItem = "Name of item: TestProductUpdated, Price of item: 100.0";
        String actualItem = itemToEdit.toString();
        Assertions.assertEquals(expectedItem, actualItem);
    }
}
