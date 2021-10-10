package ex46;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class App {



    public static void main(String args[]) throws Exception{

        File readFile = new File("src/main/java/ex46/exercise46_input.txt");
        FileReader fr = new FileReader(readFile);
        BufferedReader br = new BufferedReader(fr);

        String edit;
        String fileLine;

        TreeMap<String, Integer> tmap = new TreeMap<String, Integer>();

        while( (fileLine= br.readLine()) != null){

            String words[] = fileLine.split(" ");
            for(String word: words){
                //System.out.println(word);
                if(tmap.containsKey(word)){
                    //int newVal = tmap.get(word) + 1;
                    tmap.put(word, tmap.get(word) + 1);
                }
                else{
                    tmap.put(word, 1);
                }
            }
        }
        br.close();

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
            System.out.printf("%s: %s\n", maxEntry.getKey(), star);
            tmap.remove(maxEntry.getKey());
        }


    }
}
