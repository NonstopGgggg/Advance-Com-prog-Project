package Processor;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import ImagePanel.ImagePanel;
import Storage.Storage;

import java.io.File;

public class DialogueReader {
    private ImagePanel imagePanel;
    private Sequenter sequenter;
    private JFrame frame;

    public DialogueReader(ImagePanel imagePanel, Sequenter sequenter, JFrame frame) {
        this.imagePanel = imagePanel;
        this.sequenter = sequenter;
        this.frame = frame;
        setupListeners();
    }

    private void setupListeners() {
        setupLoadDialogueListener();
        setupMouseClickListener();
    }

    private DialogueLoader loader = DialogueLoader.getInstance();

private void setupLoadDialogueListener() {
    imagePanel.getLoadDialogueButton().addActionListener(e -> {
        JFileChooser fileChooser = new JFileChooser("");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            
            Storage data = loader.load(selectedFile); //just want to load the file and get Storage, not set it to sequenter yet.
            
            //set the dialogue to sequenter only if the file is loaded successfully, otherwise keep the old dialogue and show an error message.
            if (data != null) {
                sequenter.setDialogue(data); 
                imagePanel.updateStatus("Selected: " + selectedFile.getName());
            } else {
                JOptionPane.showMessageDialog(frame, "Error loading dialogue file.", "File Load Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    });
}

    private void setupMouseClickListener() {
        imagePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                sequenter.display();
            }
        });
    }
}
