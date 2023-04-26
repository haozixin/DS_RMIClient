package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class CanvasPanel extends JPanel{
    private boolean isDrawing = false;
    private String textDraw = "";
    private Color color = Color.black;
    public String mode = "";
    public final String DRAWLINE = "drawLine";
    public final String FREEDRAW = "freeDraw";
    public final String DRAWREC = "drawRec";
    public final String DRAWCIRCLE = "drawCircle";
    public final String DRAWTRI = "drawTri";
    public final String DRAWTEXT = "drawText";
    public final String NOTHING = "";
    private Point start = new Point(0,0);
    private final Point end = new Point(0,0);
    private final BufferedImage bufferedImage;
    private final Graphics2D graphics2D;

    public CanvasPanel() {
        this.setBackground(new Color(255, 255, 255));
        bufferedImage  = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
        graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0, 0, 800, 800);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        this.addMouseMotionListener(new myMotionAdapter());
        this.addMouseListener(new myMouseAdapter());
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bufferedImage, 0, 0, null);
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point startPoint(){
        Point startPoint = new Point();
        startPoint.x = Math.min(start.x, end.x);
        startPoint.y = Math.min(start.y, end.y);
        return startPoint;
    }

    private void draw(){

        graphics2D.setColor(color);
        graphics2D.setStroke(new BasicStroke(2));
        switch (mode) {
            case FREEDRAW -> graphics2D.drawLine(start.x, start.y, end.x, end.y);
            case DRAWLINE -> graphics2D.drawLine(start.x, start.y, end.x, end.y);
            case DRAWREC ->
                    graphics2D.drawRect(startPoint().x, startPoint().y, Math.abs(start.x - end.x), Math.abs(start.y - end.y));
            case DRAWCIRCLE ->
                    graphics2D.drawOval(startPoint().x, startPoint().y, Math.abs(start.x - end.x), Math.abs(start.y - end.y));
            case DRAWTRI -> {
                int[] xPoints = {start.x, end.x, Math.min(start.x, end.x) - Math.abs(start.x - end.x)};
                int[] yPoints = {start.y, end.y, end.y};
                graphics2D.drawPolygon(xPoints, yPoints, 3);
            }
            case DRAWTEXT -> {
                textDraw = JOptionPane.showInputDialog(null, "Please input text");
                if (textDraw != null) {
                    graphics2D.drawString(textDraw, start.x, start.y);
                }
            }
        }
        this.getGraphics().drawImage(bufferedImage, 0, 0, null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(color);
        g.drawImage(bufferedImage, 0, 0, null);
        if (isDrawing) {
            g.drawLine(start.x, start.y, end.x, end.y);
        }
    }



    private class myMotionAdapter implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {
            if (mode.equals(FREEDRAW)) {
                end.setLocation(e.getX(), e.getY());
                draw();
                start = end;
            }
            if (mode.equals(DRAWLINE)) {
                end.setLocation(e.getX(), e.getY());
                repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            start.x = e.getX();
            start.y = e.getY();
        }
    }

    private class myMouseAdapter implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (mode.equals(DRAWLINE)){
                start.setLocation(e.getX(), e.getY());
                isDrawing = true;
            }


        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (mode.equals(DRAWLINE)){
                end.setLocation(e.getX(), e.getY());
                draw();
                isDrawing = false;
            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
