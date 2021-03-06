package by.itacademy.lesson12.operable.serialization.json;

import by.itacademy.lesson12.ExceptionHandler;
import by.itacademy.lesson12.domain.Registry;
import by.itacademy.lesson12.operable.serialization.WritePatients;
import by.itacademy.lesson12.operable.serialization.json.serializers.GsonBooleanSerializer;
import by.itacademy.lesson12.operable.serialization.json.serializers.GsonLocalDateSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.util.logging.Level;

public class WriteLocalGson extends WritePatients {
    public WriteLocalGson(Registry registry, String source) {
        super(registry, source);
    }

    public WriteLocalGson(Registry registry, File file) {
        super(registry, file);
    }

    @Override
    public void operation() {
        Registry registry = getRegistry();
        try (Writer writer = new FileWriter(getFile())) {
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new GsonLocalDateSerializer())
                    .registerTypeAdapter(Boolean.class, new GsonBooleanSerializer()).setPrettyPrinting().create();
            gson.toJson(registry, writer);
        } catch (IOException e) {
            new ExceptionHandler().handle(Level.SEVERE, "Can't get FileWriter from " + getSource(), e);
        }
    }

    @Override
    public String typo() {
        return "Write patients info into local json file";
    }
}
