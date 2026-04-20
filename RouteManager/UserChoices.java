package RouteManager;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class UserChoices {
    private JPanel overlay;
    private ChoiceListener listener;

    public UserChoices(JPanel overlay) {
        this.overlay = overlay;
    }

    public void setChoiceListener(ChoiceListener listener) {
        this.listener = listener;
    }

    public void showChoices(String[] choices, File[] files) {
        overlay.removeAll();

        JPanel choicePanel = new JPanel();
        choicePanel.setLayout(new BoxLayout(choicePanel, BoxLayout.Y_AXIS));
        choicePanel.setOpaque(false);

        for (int i = 0; i < choices.length; i++) {
            String choice = choices[i];
            File file = files[i];

            JButton choiceButton = new JButton(choice);
            choiceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            choiceButton.setMaximumSize(new Dimension(200, 40));
            choiceButton.setBackground(new Color(50, 50, 50));
            choiceButton.setForeground(Color.WHITE);
            choiceButton.setFocusPainted(true);

            choiceButton.addActionListener(e -> {
                hideChoices();
                if (listener != null) listener.onChoiceSelected(file);
            });

            choicePanel.add(choiceButton);
            choicePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        overlay.add(choicePanel);
        overlay.revalidate();
        overlay.repaint();
    }

    public void hideChoices() {
        overlay.removeAll();
        overlay.revalidate();
        overlay.repaint();
    }
}