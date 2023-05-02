package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class LineDrawingExample extends JFrame implements MouseListener, MouseMotionListener {
    private int x1, y1, x2, y2;
    private boolean drawing = false;
    private final BufferedImage bufferedImage;
    private Graphics2D graphics2D;

    public LineDrawingExample() {
        setTitle("Java Line Drawing Example");
        bufferedImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        graphics2D = bufferedImage.createGraphics();
        graphics2D.fillRect(0, 0, 800, 800);
        graphics2D.setStroke(new BasicStroke(2));
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paint(Graphics g) {
        super.paint(graphics2D);
        graphics2D.drawImage(bufferedImage, 0, 0, null);
        if (drawing) {
            graphics2D.drawLine(x1, y1, x2, y2);
        }
    }

    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        drawing = true;
    }

    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        repaint();
    }

    public void mouseReleased(MouseEvent e) {
        drawing = false;
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}

    public static void main(String[] args) {
        LineDrawingExample example = new LineDrawingExample();
        example.setVisible(true);
    }
}
