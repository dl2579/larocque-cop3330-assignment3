package ex44;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.junit.jupiter.api.Test;

import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void main() throws Exception {
        JsonReader jsonReader = new JsonReader(new FileReader("src/main/java/ex44/exercise44_input.json"));
        Gson gson = new Gson();
        App.productInventory inventory = gson.fromJson(jsonReader, App.productInventory.class);

        assertEquals("Name: Thing\n" +
                "Price: 15.00\n" +
                "Quantity: 5", inventory.inventorySearch("Thing"));

        assertEquals("Name: Widget\n" +
                "Price: 25.00\n" +
                "Quantity: 5", inventory.inventorySearch("Widget"));

        assertEquals("Sorry, that product was not found in our inventory.", inventory.inventorySearch("Galaxy"));

    }
}