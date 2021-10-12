package ex46;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Damian LaRocque
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class App {

    public static class wordFreqFinder{

        static TreeMap<String, Integer> tmap = new TreeMap<String, Integer>();

        public static void findFrequency(File inputFile) throws Exception{
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);

            String fileLine;
            while( (fileLine= br.readLine()) != null){

                String words[] = fileLine.split(" ");
                for(String word: words){
                    if(tmap.containsKey(word)){
                        tmap.put(word, tmap.get(word) + 1);
                    }
                    else{
                        tmap.put(word, 1);
                    }
                }
            }
            br.close();
        }

        public static String constructHistogram(){
            String histogram = "";

            while(tmap.firstEntry() != null) {
                Map.Entry maxEntry = tmap.firstEntry();

                for (Map.Entry entry : tmap.entrySet()) {
                    if( (int)entry.getValue() > (int)maxEntry.getValue()) {
                        maxEntry = entry;
                    }
                }
                String star = "";
                for (int i = 0; i < (int) maxEntry.getValue(); i++) {
                    star += "*";
                }
                histogram += String.format("%s: %s\n", maxEntry.getKey(), star);
                tmap.remove(maxEntry.getKey());
            }
            return histogram;
        }
    }

    public static void main(String args[]) throws Exception{
        File readFile = new File("src/main/java/ex46/exercise46_input.txt");

        wordFreqFinder.findFrequency(readFile);
        String histogram = wordFreqFinder.constructHistogram();
        System.out.println(histogram);
    }
}
