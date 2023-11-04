import javax.swing.*;
import java.awt.*;

public class CircularProgressBar1 extends JComponent {
    private int progress; // Current progress value (0-100)

    public void setProgress(int progress) {
        this.progress = progress;
        repaint(); // Redraw the component when the progress changes
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        int diameter = Math.min(width, height);

        // Calculate the position and size of the circle
        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;

        // Draw the background circle
        g2d.setColor(new Color(3, 150, 141));
        g2d.fillOval(x, y, diameter, diameter);

        // Draw the progress arc
        g2d.setColor(new Color(255, 255, 255));
        int startAngle = 90; // 90 degrees is the top of the circle
        int arcAngle = (int) (360.0 * (progress / 24.0));
        g2d.fillArc(x, y, diameter, diameter, startAngle, arcAngle);
    }
}
