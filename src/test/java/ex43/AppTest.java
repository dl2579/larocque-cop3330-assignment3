package ex43;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

class AppTest {

    @Test
    void main() {

        File webFolder = new File("src/test/java/ex43/websiteTest");
        App.websiteGenerator wg = new App.websiteGenerator(webFolder);
        wg.generateWebsite("JUnit", "testAuthor", true, true);

        File file1 = new File("src/test/java/ex43/websiteTest/JUnit/index.html");
        File file2 = new File("src/test/java/ex43/websiteTest/JUnit/css");
        File file3 = new File("src/test/java/ex43/websiteTest/JUnit/js");

        assertTrue(file1.exists());
        assertTrue(file2.exists());
        assertTrue(file3.exists());
    }
}