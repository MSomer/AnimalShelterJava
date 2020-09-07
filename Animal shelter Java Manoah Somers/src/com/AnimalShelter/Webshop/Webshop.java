package com.AnimalShelter.Webshop;

import java.util.ArrayList;
import java.util.Scanner;

public class Webshop {

    private ArrayList<SellableItem> itemsInWebshop;
    private Scanner scn;
    private boolean webshopActive = true;
    private boolean webshopEmpty = false;

    public Webshop(){
        itemsInWebshop = new ArrayList<>();
        scn = new Scanner(System.in);
    }
    
    public void menu(){
        while(webshopActive){
            System.out.println("WEBSHOP: \n Buy item \n Add item \n Edit item \n exit");
            switch (scn.nextLine().toLowerCase()){
                case "buy item":
                    retrieveItems();
                    if(webshopEmpty)break;
                    buyItem();
                    break;
                case "add item":
                    addItem();
                    break;
                case "edit item":
                    retrieveItems();
                    if(webshopEmpty)break;
                    editItem();
                    break;
                case "exit":
                    webshopActive = false;
                    break;
                default:
                    System.out.println("command not found.");
                    break;
            }
        }
    }
    public void retrieveItems(){
        if(itemsInWebshop.stream().count() == 0){System.out.println("No products found.");webshopEmpty=true;return;}
        webshopEmpty = false;
        itemsInWebshop.forEach(item ->
                System.out.println(itemsInWebshop.indexOf(item)+ item.toString() + "\r\n")
        );
    }
    private void buyItem(){
        System.out.println("Entered buy item mode.");
        System.out.println("Type number of item to buy.");
        //TODO If needed here actual buying of item.
        SellableItem itemToBuy;
        try{
            itemToBuy = itemsInWebshop.get(scn.nextInt());
        }
        catch (NumberFormatException ex){
            System.out.println("Enter a number.");
            return;
        }
        scn.nextLine();
        System.out.println("Are you sure you want to buy: "+itemToBuy.toString()+"?");
        while(true){
            String userInput = scn.nextLine();
            if(userInput.toLowerCase().equals("yes")){
                System.out.println("You bought the item!");
                break;
            }
            else if(userInput.toLowerCase().equals("no")){
                System.out.println("Cancelled order!");
                break;
            }
            else{
                System.out.println("Please enter 'yes' or 'no' ");
            }
        }
    }
    private void addItem(){
        System.out.println("Entered add item mode.");
        System.out.println("Name of item:");
        String name = scn.nextLine();
        System.out.println("Price of item");
        String priceInput = scn.nextLine();
        if(checkPriceInput(priceInput)){
            itemsInWebshop.add(new SellableItem(name, Double.parseDouble(priceInput)));
        }
    }
    private void editItem(){
        System.out.println("Entered edit item mode.");
        System.out.println("Type number of item to edit:");
        SellableItem itemToEdit = itemsInWebshop.get(scn.nextInt());
        scn.nextLine();
        System.out.println("New name of item:");
        String updatedName = scn.nextLine();
        System.out.println("New price of item:");
        String updatedPrice = scn.nextLine();
        if(checkPriceInput(updatedPrice)){
            itemToEdit.updateName(updatedName);
            itemToEdit.updatePrice(Double.parseDouble(updatedPrice));
        }
    }
    private boolean checkPriceInput(String priceInput){
        try{
            Double.parseDouble(priceInput);
            return true;
        }
        catch (NumberFormatException ex){
            System.out.println("Invalid price entered.");
        }
        return false;
    }
}
