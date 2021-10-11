package ex45;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void main() throws Exception {

        File readFile = new File("src/main/java/ex45/exercise45_input.txt");
        File writeFile = new File("src/test/java/ex45/junitOutputTest");

        App.wordFinder.replaceWord("utilize", "use", readFile, writeFile);

        File test = new File("src/test/java/ex45/junitOutputTest");
        FileReader fr = new FileReader(test);
        BufferedReader br = new BufferedReader(fr);

        String fileLine;
        String content ="";

        while( (fileLine= br.readLine()) != null){
            if(fileLine != null){
                content += fileLine;
                content += "\n";
            }
        }
        br.close();

        assertEquals( "One should never use the word \"use\" in writing. Use \"use\" instead.\n" +
                "For example, \"She uses an IDE to write her Java programs\" instead of \"She\n" +
                "uses an IDE to write her Java programs\".\n",content);

    }
}