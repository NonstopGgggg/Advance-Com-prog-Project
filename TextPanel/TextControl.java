package TextPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TextControl extends JPanel {
    //private TextInput input = new TextInput();
    private TextOutput output = new TextOutput();
    //private TextButton changeButton = new ChangeButton(input, output);

    public TextControl() {
        setLayout(new BorderLayout());
        setOpaque(true);
        setBackground(Color.BLACK);

        // --- Bottom panel holds input box and button side by side ---
        JPanel bottomPanel = new JPanel(new BorderLayout());

        // --- Assemble text  panels ---
        add(output.getSpeakerBox(), BorderLayout.NORTH);
        add(new JScrollPane(output.getOutputBox()), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public void setSpeaker(String speaker) {
        output.setSpeaker(speaker);
    }

    public void setText(String text) {
        output.setText(text);
    }
}
