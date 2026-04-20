package ImagePanel;
import javax.swing.*;

import java.awt.*;
import java.io.File;

public class ImagePanel extends JPanel {
    private ImageOutput output;
    private JLabel statusLabel;
    private JButton loadDialogueButton;
    private JPanel choicesOverlay;

    // Create 
    public ImagePanel() {
        setLayout(new BorderLayout());

        statusLabel = new JLabel("No Dialogue selected");
        statusLabel.setForeground(Color.WHITE);
        output = new ImageOutput();
        loadDialogueButton = new JButton("Load Dialogue");

        // --- Button panel ---
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.GRAY);
        buttonPanel.add(loadDialogueButton);
        buttonPanel.add(statusLabel);

        // --- Layered pane to overlay choices on image ---
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(new OverlayLayout(layeredPane));

        // location in the middle of the panel
        output.setAlignmentX(0.5f);
        output.setAlignmentY(0.5f);

        // add image to the panel
        layeredPane.add(output, JLayeredPane.DEFAULT_LAYER);

        choicesOverlay = new JPanel(new GridBagLayout()); // centers the choices
        choicesOverlay.setOpaque(false);
        choicesOverlay.setAlignmentX(0.5f);
        choicesOverlay.setAlignmentY(0.5f);

        // add choices to the panel
        layeredPane.add(choicesOverlay, JLayeredPane.PALETTE_LAYER);

        add(layeredPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.NORTH);
    }

    public JPanel getChoicesOverlay() {
        return choicesOverlay;
    }

    public void setImage(File file) { //related to ImageOutput
        output.setImage(file);
    }

    public JButton getLoadDialogueButton() { // for others to access the button
        return loadDialogueButton;
    }

    public void updateStatus(String text) {
        statusLabel.setText(text);
    }
}