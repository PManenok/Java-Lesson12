package by.itacademy.lesson12.operable.serialization;

import by.itacademy.lesson12.domain.Registry;
import by.itacademy.lesson12.operable.BaseRegistryOperation;

import java.io.File;

public abstract class WritePatients extends BaseRegistryOperation {
    private File file;
    private String source;

    public WritePatients(Registry registry, String source) {
        super(registry);
        this.source = source;
        this.file = new File(this.source);
    }

    public WritePatients(Registry registry, File file) {
        super(registry);
        this.source = file.getName();
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public String getSource() {
        return source;
    }
}
