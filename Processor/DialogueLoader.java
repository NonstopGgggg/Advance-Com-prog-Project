package Processor;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import Storage.Storage;
import Storage.StorageFactory;

public class DialogueLoader {
    private static DialogueLoader instance;
    private DialogueParser parser;
    private StorageFactory storageFactory = StorageFactory.getInstance();

    private DialogueLoader() {}

    public static DialogueLoader getInstance() {
        if (instance == null) {
            instance = new DialogueLoader();
        }
        return instance;
    }

    public Storage load(File file) {
        parser = new DialogueParser();
        try {
            Storage newDialogue = storageFactory.create();
            List<String> lines = Files.readAllLines(file.toPath());
            for (String line : lines) {
                newDialogue.addScene(parser.parseLine(line));
            }
            return newDialogue;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}