package Data;

import Item.*;

import java.io.FileWriter;
import java.time.LocalDate;
import java.util.List;

import com.google.gson.*;

public class DataJSON {
    public static String JsonPath = "./Data/Items.json";

    public static void updateFile() {
        // Create Gson with custom LocalDate serializer/deserializer
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
                    @Override
                    public JsonElement serialize(LocalDate src, java.lang.reflect.Type typeOfSrc,
                            JsonSerializationContext context) {
                        return new JsonPrimitive(src.toString()); // "yyyy-MM-dd"
                    }
                })
                .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                    @Override
                    public LocalDate deserialize(JsonElement json, java.lang.reflect.Type typeOfT,
                            JsonDeserializationContext context) {
                        return LocalDate.parse(json.getAsString());
                    }
                })
                .setPrettyPrinting() // makes JSON readable
                .create();

        // Get all items
        List<Item> items = ItemController.getItemList();

        // Write the entire list to JSON at once
        try (FileWriter writer = new FileWriter(JsonPath)) {
            gson.toJson(items, writer);
            System.out.println("Items saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
