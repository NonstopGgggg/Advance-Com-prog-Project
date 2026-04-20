import javax.swing.*;

import ImagePanel.ImagePanel;
import Processor.DialogueReader;
import Processor.Sequenter;
import TextPanel.TextControl;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        // --- Window ---
        JFrame frame = new JFrame("Visual Novel Engine");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // --- Image control ---
        ImagePanel imagePanel = new ImagePanel();

        // --- Text control ---
        TextControl textControl = new TextControl();
        textControl.setPreferredSize(new Dimension(800, 80));

        // --- Text Dialogue ---
        Sequenter sequenter = new Sequenter(textControl, imagePanel);
        
        // --- Image Controller (handles event listeners) ---
        new DialogueReader(imagePanel, sequenter, frame);


        // --- South container ---
        JPanel southContainer = new JPanel();
        southContainer.setLayout(new BoxLayout(southContainer, BoxLayout.Y_AXIS));
        southContainer.add(textControl);

        // --- Assemble window ---
        frame.add(imagePanel, BorderLayout.CENTER);
        frame.add(southContainer, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}