package ex41;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Damian LaRocque
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {

    public static class nameSorter {

        //This function takes in a file and reads strings from the file and stores them in array list. It returns an array list
        public static ArrayList<String> readInput(File file) throws Exception{
            Scanner sc = new Scanner(file);
            ArrayList<String> nameArr = new ArrayList<String>();

            //loops in through all strings in the file and adds them to teh arraylist
            while (sc.hasNextLine()) {
                nameArr.add(sc.nextLine());
            }
            return nameArr;
        }

        //This function takes in an String array list, sorts it and then prints each element to the output terminal
        public static void sortAndPrint(ArrayList<String> arrL){

            Collections.sort(arrL); //sort the arrayList of Strings

            System.out.printf("Total of %d names\n-----------------\n", arrL.size());
            for(String name : arrL){ //print each element in the array list
                System.out.println(name);
            }
        }

    }


    public static void main(String args[]) throws Exception
    {
        File file = new File("src/main/java/ex41/exercise41_input.txt");

        nameSorter ns = new nameSorter();
        ArrayList<String> nameArr = ns.readInput(file);
        ns.sortAndPrint(nameArr);

    }
}
