package TextPanel;
import javax.swing.*;
import java.awt.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class TextOutput {
    private JTextPane displayText;
    private JTextPane displaySpeaker;

    // create textBox
    public TextOutput() {
        //create textbox using JTextPane
        displayText = new JTextPane();
        displaySpeaker = new JTextPane();
        StyledDocument docText = displayText.getStyledDocument();
        StyledDocument docSpeaker = displaySpeaker.getStyledDocument();

        // Define alignment attribute
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);

        // setting for speaker
        docSpeaker.setParagraphAttributes(0, docSpeaker.getLength(), center, false);
        displaySpeaker.setEditable(false);
        displaySpeaker.setOpaque(true);
        displaySpeaker.setBackground(Color.BLACK);
        displaySpeaker.setForeground(Color.WHITE);
        displaySpeaker.setFont(new Font("Arial", Font.PLAIN, 20));
        
        // setting for textbox
        docText.setParagraphAttributes(0, docText.getLength(), center, false);
        displayText.setEditable(false);
        displayText.setOpaque(true);
        displayText.setBackground(Color.BLACK);
        displayText.setForeground(Color.WHITE);
        displayText.setFont(new Font("Arial", Font.PLAIN, 20));
    }

    // display speaker name
    public void setSpeaker(String speaker) {
        displaySpeaker.setText(speaker);
    }

    public JTextPane getSpeakerBox() {
        return displaySpeaker;
    }

    // display Text
    public void setText(String text) {
        displayText.setText(text);
    }

    public JTextPane getOutputBox() {
        return displayText;
    }
}