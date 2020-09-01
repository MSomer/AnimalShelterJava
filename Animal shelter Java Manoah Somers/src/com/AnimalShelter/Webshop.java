package com.AnimalShelter;

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
    private void retrieveItems(){
        if(itemsInWebshop.stream().count() == 0){System.out.println("No products found.");webshopEmpty=true;return;}
        webshopEmpty = false;
        itemsInWebshop.forEach(item ->
                System.out.println(itemsInWebshop.indexOf(item)+ " " + item.getName() + " " + item.getPrice() + "\r\n")
        );
    }
    //TODO Make sure input is correct
    private void buyItem(){
        System.out.println("Entered buy item mode.");
        System.out.println("Type number of item to buy.");
        //TODO If needed here actual buying of item.
        SellableItem itemToBuy = itemsInWebshop.get(scn.nextInt());
        scn.nextLine();
        System.out.println("Are you sure you want to buy "+itemToBuy.getName()+" for "+itemToBuy.getPrice());
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
        double price = scn.nextDouble();
        scn.nextLine();
        itemsInWebshop.add(new SellableItem(name, price));
    }
    private void editItem(){
        System.out.println("Entered edit item mode.");
        System.out.println("Type number of item to edit:");
        SellableItem itemToEdit = itemsInWebshop.get(scn.nextInt());
        scn.nextLine();
        System.out.println("New name of item:");
        itemToEdit.updateName(scn.nextLine());
        System.out.println("New price of item:");
        itemToEdit.updatePrice(scn.nextDouble());
        scn.nextLine();
    }
}
