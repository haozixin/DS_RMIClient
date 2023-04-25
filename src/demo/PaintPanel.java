package demo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintPanel extends JPanel implements MouseListener {
    private int x1, y1, x2, y2;

    public PaintPanel() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
        addMouseListener(this);
    }

    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        Graphics g = getGraphics();
        g.drawLine(x1, y1, x2, y2);
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("demo.PaintPanel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new PaintPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
