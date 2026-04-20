package ImagePanel;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class ImageOutput extends JPanel {
    private BufferedImage image = null;

    public ImageOutput() {
        setBackground(Color.DARK_GRAY);
        setOpaque(true);
    }

    public void setImage(File file) { //still important to show image
        try {
            image = ImageIO.read(file);
            repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to load image: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}