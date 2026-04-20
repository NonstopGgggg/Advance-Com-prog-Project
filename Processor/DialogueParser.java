package Processor;

import java.io.File;
import Storage.Data;
import Storage.DataFactory;

public class DialogueParser {

    private DataFactory dataFactory = DataFactory.getInstance();

    public Data parseLine(String line) {
        int speakerIndex = Math.max(line.indexOf(":"), -1) + 1;
        int imageIndex = line.indexOf("\\image:");
        String speaker = line.substring(0, Math.max(speakerIndex - 1, 0)).trim();
        String text = null;
        File imageFile = null;
        String voicePath = null;

        if (imageIndex != -1) {
            text = line.substring(speakerIndex, imageIndex).trim();
            String imagePath = line.substring(imageIndex + 7).trim();
            imageFile = new File(imagePath);

            if (!imageFile.exists()) {
                System.out.println("Image not found at: " + imageFile.getAbsolutePath());
            }
        } else {
            text = line.substring(speakerIndex).trim();
        }

        return dataFactory.create(speaker, text, imageFile, voicePath);
    }
}
