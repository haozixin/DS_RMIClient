package demo;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class FreePaintPanel extends JPanel implements MouseMotionListener {
    private int x1, y1, x2, y2;
    private BufferedImage image;
    private Graphics g;


    public FreePaintPanel() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
        addMouseMotionListener(this);
        image  = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 400, 400);
    }

    public void mouseDragged(MouseEvent e) {

        x2 = e.getX();
        y2 = e.getY();
        Graphics g = getGraphics();
        g.drawLine(x1, y1, x2, y2);
        x1 = x2;
        y1 = y2;
    }

    public void mouseMoved(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FreeDrawPanel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new FreePaintPanel());
        frame.pack();
        frame.setVisible(true);
    }
}


