package ex44;

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
    }

    public static void main(String args[]) throws FileNotFoundException {

       Scanner sc = new Scanner(System.in);

        JsonReader jsonReader = new JsonReader(new FileReader("src/main/java/ex44/exercise44_input.json"));
        Gson gson = new Gson();
        productInventory inventory = gson.fromJson(jsonReader, productInventory.class);

       while(true){
           System.out.print("What is the product name? ");
           String prodName = sc.nextLine();

           Boolean productFound = false;
           for(product i: inventory.products){
               if (prodName.equals(i.name)){
                   productFound = true;
                   System.out.printf("Name: %s\nPrice: %.2f\nQuantity: %d\n", i.name, i.price, i.quantity);
                   break;
               }
           }
           if(!productFound){
               System.out.println("Sorry, that product was not found in our inventory.");
           } else{
               break;
           }

       }

    }
}
   