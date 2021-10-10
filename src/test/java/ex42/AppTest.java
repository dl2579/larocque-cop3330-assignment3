package ex42;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void main() throws Exception {
        File file = new File("src/main/java/ex42/exercise42_input.txt");
        App.recordProcessor rp = new App.recordProcessor(file);

        assertEquals("Ling", rp.empArrL.get(0).lastName);
        assertEquals("Mai", rp.empArrL.get(0).firstName);
        assertEquals(55900, rp.empArrL.get(0).salary);
        assertEquals("Zarnecki", rp.empArrL.get(6).lastName);

        assertEquals("Last      First     Salary\n" +
                "--------------------------\n" +
                "Ling      Mai       55900\n" +
                "Johnson   Jim       56500\n" +
                "Jones     Aaron     46000\n" +
                "Jones     Chris     34500\n" +
                "Swift     Geoffrey  14200\n" +
                "Xiong     Fong      65000\n" +
                "Zarnecki  Sabrina   51500\n", rp.getRecordTable());
    }
}