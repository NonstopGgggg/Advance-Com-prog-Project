package Storage;

import java.io.File;

public class DataFactory {
    private static DataFactory instance;

    private DataFactory() {}

    public static DataFactory getInstance() {
        if (instance == null) {
            instance = new DataFactory();
        }
        return instance;
    }

    public Data create(String speaker, String text, File image, String voicePath) {
        return new Data(speaker, text, image, voicePath);
    }
}