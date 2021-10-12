package ex45;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Damian LaRocque
 */
import java.io.*;
import java.util.Scanner;

public class App {

    public static class wordFinder{
        public static void replaceWord(String word1, String word2, File readFile, File writeFile) throws Exception{
            FileReader fr = new FileReader(readFile);
            BufferedReader br = new BufferedReader(fr);

            writeFile.createNewFile();
            FileWriter fw = new FileWriter(writeFile);
            BufferedWriter bw = new BufferedWriter(fw);

            String edit;
            String fileLine;

            while( (fileLine= br.readLine()) != null){
                if(fileLine != null){
                    edit = fileLine.replaceAll("utilize", "use");
                    bw.write(edit);
                    bw.write("\n");
                }
            }
            bw.flush();
            br.close();
        }
    }

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("What is the name of the output file? ");
        String outputFileName = sc.nextLine();
        outputFileName += ".txt";

        File readFile = new File("src/main/java/ex45/exercise45_input.txt");
        File writeFile = new File("src/main/java/ex45/" + outputFileName);

        wordFinder.replaceWord("utilize", "use", readFile, writeFile);
    }
}
/*
One should never utilize the word "utilize" in writing. Use "use" instead.
For example, "She uses an IDE to write her Java programs" instead of "She
utilizes an IDE to write her Java programs".
 */