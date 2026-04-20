package Storage;
import java.io.File;
import java.util.ArrayList;

public class Storage {
    private ArrayList<Data> scenes;
    public Storage() {
        scenes = new ArrayList<>();
    }
    public void addScene(Data scene) {
        scenes.add(scene);
    }
    public Data getScene(int index) {
        return scenes.get(index);
    }
    public int getSize() {
        return scenes.size();
    }

    public String[] getChoices() {
        String[] choices = new String[getSize()];

        // Extract choices from route text
        for (int i = 0; i < getSize(); i++) {
            String text = getScene(i).getText();
            int index = text.indexOf("\\");

            // Get  next dialogue for each choice
            if (index != -1) {
                choices[i] = text.substring(0, index);
            }
        }

        return choices;
    }

    public File[] getChoiceFiles() {
        File[] files = new File[getSize()];
        for (int i = 0; i < getSize(); i++) {
            String text = getScene(i).getText();
            int index = text.indexOf("\\");
            if (index != -1) {
                files[i] = new File(text.substring(index + 1).trim()).getAbsoluteFile();
            }
        }

        return files;
    }
}