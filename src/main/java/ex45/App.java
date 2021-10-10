package ex45;

import java.io.*;
import java.util.Scanner;

public class App {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("What is the name of the output file? ");
        String fileName = sc.nextLine();
        fileName += ".txt";

        File readFile = new File("src/main/java/ex45/exercise45_input.txt");
        FileReader fr = new FileReader(readFile);
        BufferedReader br = new BufferedReader(fr);

        File writeFile = new File("src/main/java/ex45/" + fileName);
        writeFile.createNewFile();
        FileWriter fw = new FileWriter(writeFile);
        BufferedWriter bw = new BufferedWriter(fw);

        //bw.write("test write to file");
        //bw.flush();
        //bw.close();

        String edit;
        String fileLine;

        while( (fileLine= br.readLine()) != null){
            //System.out.println(fileLine);
            if(fileLine != null){
                edit = fileLine.replaceAll("utilize", "use");
                //System.out.println(edit);
                bw.write(edit);
                bw.write("\n");
                //bw.flush();
            }
        }
        bw.flush();
        br.close();
    }
}
/*
One should never utilize the word "utilize" in writing. Use "use" instead.
For example, "She uses an IDE to write her Java programs" instead of "She
utilizes an IDE to write her Java programs".
 */