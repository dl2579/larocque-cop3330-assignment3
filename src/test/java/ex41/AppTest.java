package ex41;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void readInput() {
        File file = new File("src/main/java/ex41/exercise41_input.txt");
        ArrayList<String> testArr = new ArrayList<>();
        App.nameSorter ns = new App.nameSorter();

        try {
            testArr = ns.readInput(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals("Ling, Mai", testArr.get(0));
        assertEquals("Jones, Aaron", testArr.get(4));
        assertEquals("Xiong, Fong", testArr.get(6));
    }

    @Test
    void sortAndPrint() {
        App.nameSorter ns = new App.nameSorter();
        ArrayList<String> testArr1 = new ArrayList<>();
        testArr1.add("Ling, Mai");
        testArr1.add("Johnson, Jim");
        testArr1.add("Zarnecki, Sabrina");
        testArr1.add("Jones, Chris");
        testArr1.add("Jones, Aaron");
        testArr1.add("Swift, Geoffrey");
        testArr1.add("Xiong, Fong");

        ns.sortAndPrint(testArr1);
        assertEquals("Johnson, Jim", testArr1.get(0));
        assertEquals("Ling, Mai", testArr1.get(3));
        assertEquals("Zarnecki, Sabrina", testArr1.get(6));

        ArrayList<String> testArr2 = new ArrayList<>();
        testArr2.add("C");
        testArr2.add("B");
        testArr2.add("D");
        testArr2.add("A");

        ns.sortAndPrint(testArr2);
        assertEquals("A", testArr2.get(0));
        assertEquals("B", testArr2.get(1));
        assertEquals("C", testArr2.get(2));
        assertEquals("D", testArr2.get(3));

    }
}