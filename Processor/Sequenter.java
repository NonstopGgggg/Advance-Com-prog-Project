package Processor;
import java.io.File;

import ImagePanel.ImagePanel;
import RouteManager.ChoiceListener;
import RouteManager.UserChoices;
import Storage.Storage;
import TextPanel.TextControl;

public class Sequenter implements ChoiceListener {
    private int currentLine = 0;
    private Storage dialogue;
    private DialogueLoader loader = DialogueLoader.getInstance();
    private TextControl textControl;
    private ImagePanel imagePanel;
    private boolean isStoryEnded;
    private UserChoices userChoices;

    public Sequenter(TextControl textControl, ImagePanel imagePanel) {
        this.textControl = textControl;
        this.imagePanel = imagePanel;
        this.isStoryEnded = false;
        this.userChoices = new UserChoices(imagePanel.getChoicesOverlay());
        this.userChoices.setChoiceListener(this); // register as listener
    }

    @Override
    public void onChoiceSelected(File file) {
        this.setDialogue(loader.load(file));
        this.display();
    }

    public void setDialogue(Storage dialogue) {
        this.dialogue = dialogue;
        this.currentLine = 0;
    }

    public boolean checkEndOfStory(String text) {
        return text.startsWith("\\TRUE") || text.startsWith("\\FALSE");
    }

    public void display() {
        if (isStoryEnded || dialogue == null) return;

        if (currentLine < dialogue.getSize() - 1) {
            updateUI(currentLine);
            currentLine++;
        } else {
            processEndOfDialogue();
        }
    }

    private void processEndOfDialogue() {
        String fullText = dialogue.getScene(currentLine).getText();
        int index = fullText.indexOf("\\", 1);
        if (index == -1) return;

        String command = fullText.substring(0, index);
        String args = fullText.substring(index + 1);

        if (command.equals("\\TRUE")) {
            File file = new File(args).getAbsoluteFile();
            this.setDialogue(loader.load(file));
            this.display();
        }
        else if (command.equals("\\FALSE")) {
            textControl.setSpeaker("");
            textControl.setText("--- END OF STORY ---");
            imagePanel.updateStatus("Story Finished");
            isStoryEnded = true;
        }
        else if (command.equals("\\ROUTE")) {
            File file = new File(args).getAbsoluteFile();
            Storage routeDialogue = loader.load(file);
            userChoices.showChoices(routeDialogue.getChoices(), routeDialogue.getChoiceFiles());
        }
    }

    private void updateUI(int lineIndex) {
        textControl.setSpeaker(dialogue.getScene(lineIndex).getSpeaker());
        textControl.setText(dialogue.getScene(lineIndex).getText());

        if (dialogue.getScene(lineIndex).getImage() != null) {
            imagePanel.setImage(dialogue.getScene(lineIndex).getImage());
        }
    }
}