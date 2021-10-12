package ex44;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Damian LaRocque
 */
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class App {

    public static class product{
        String name;
        double price;
        int quantity;
    }

    public static class productInventory{
        product[] products;

        public String inventorySearch(String prodName){
            for(product i: this.products){
                if (prodName.equals(i.name)){
                    return String.format("Name: %s\nPrice: %.2f\nQuantity: %d", i.name, i.price, i.quantity);
                }
            }
            return String.format("Sorry, that product was not found in our inventory.");
        }
    }

    public static void main(String args[]) throws FileNotFoundException {

       Scanner sc = new Scanner(System.in);

       JsonReader jsonReader = new JsonReader(new FileReader("src/main/java/ex44/exercise44_input.json"));
       Gson gson = new Gson();
       productInventory inventory = gson.fromJson(jsonReader, productInventory.class);

       while(true){
           System.out.print("What is the product name? ");
           String prodName = sc.nextLine();

           String searchResult = inventory.inventorySearch(prodName);
           System.out.println(searchResult);
           if(!searchResult.equals("Sorry, that product was not found in our inventory.")){
               break;
           }
       }

    }
}
   