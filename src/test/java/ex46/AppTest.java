package ex46;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void main() throws Exception {
        File readFile = new File("src/main/java/ex46/exercise46_input.txt");
        App.wordFreqFinder.findFrequency(readFile);
        String histogram = App.wordFreqFinder.constructHistogram();
        assertEquals("badger: *******\n" +
                "mushroom: **\n" +
                "snake: *\n", histogram);

        readFile = new File("src/test/java/ex46/ex46_Junit_Input.txt");
        App.wordFreqFinder.findFrequency(readFile);
        histogram = App.wordFreqFinder.constructHistogram();

        //Checking that most used words are at top and least used at bottom
        assertEquals("badger: *******\n" +
                "apple: ***\n" +
                "mushroom: **\n" +
                "banana: *\n" +
                "snake: *\n", histogram);
    }
}