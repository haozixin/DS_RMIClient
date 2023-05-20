package Views;

import remoteInterfaces.IRemoteServiceSkeleton;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * Author:  Zixin Hao
 * Student ID: 1309180
 */
public class CanvasPanel extends JPanel{
    private boolean isDrawing = false;
    private String textDraw = "";
    private Color color = Color.black;
    public String mode = "";
    public final String DRAWLINE = "straight Line";
    public final String FREEDRAW = "freeDraw";
    public final String DRAWRECT = "rectangle";
    public final String DRAWOVAL = "Oval";
    public final String DRAWCIRCLE = "Circle";
    public final String DRAWTEXT = "Text";
    private Point start = new Point(0,0);
    private final Point end = new Point(0,0);
    private BufferedImage bufferedImage;
    private Graphics2D graphics2D;
    private final IRemoteServiceSkeleton service;
    private String name;
    JFileChooser fileChooser;
    FileFilter pngFilter;
    FileFilter jpegFilter;

    public CanvasPanel(IRemoteServiceSkeleton service, String name) {
        this.service = service;
        this.name = name;
        this.setBackground(new Color(255, 255, 255));
        bufferedImage  = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
        graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0, 0, 800, 800);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        setFileChooser();
        this.addMouseMotionListener(new myMotionAdapter());
        this.addMouseListener(new myMouseAdapter());
    }

    private void setFileChooser() {
        fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false); // 禁用“所有文件”过滤器
        pngFilter = new FileNameExtensionFilter("PNG Images", "png");
        fileChooser.addChoosableFileFilter(pngFilter);
        jpegFilter = new FileNameExtensionFilter("JPEG Images", "jpg", "jpeg");
        fileChooser.addChoosableFileFilter(jpegFilter);
    }

    /**
     * The paintComponent() method is a method used to paint graphics in Swing components.
     * It is called automatically when the component needs to be painted, such as when the component is first displayed,
     * when its size, position, background color, and other properties change, or when the repaint() method is called.
     * Whenever a component needs to be repainted, Swing automatically calls the paintComponent() method to complete the painting operation.
     *
     * @param g the <code>Graphics</code> object to protect
     */
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
        graphicDraw(graphics2D);
        this.getGraphics().drawImage(bufferedImage, 0, 0, null);
    }

    private void graphicDraw(Graphics g) {
        switch (mode) {
            case FREEDRAW -> g.drawLine(start.x, start.y, end.x, end.y);
            case DRAWLINE -> g.drawLine(start.x, start.y, end.x, end.y);
            case DRAWRECT ->
                    g.drawRect(startPoint().x, startPoint().y, Math.abs(start.x - end.x), Math.abs(start.y - end.y));
            case DRAWOVAL ->
                    g.drawOval(startPoint().x, startPoint().y, Math.abs(start.x - end.x), Math.abs(start.y - end.y));
            case DRAWCIRCLE -> {
                int radius = (int) Math.sqrt(Math.pow(start.x - end.x, 2) + Math.pow(start.y - end.y, 2));
                g.drawOval(startPoint().x, startPoint().y, radius, radius);
            }
            case DRAWTEXT -> {
                textDraw = JOptionPane.showInputDialog(null, "Please input text");
                if (textDraw != null) {
                    g.drawString(textDraw, start.x, start.y);
                }
            }
        }
    }

    /**
     * A method to draw the image currently in the buffer onto the panel, it will be called by the system
     * when the panel needs to be redrawn, e.g. when it is made visible or moved.
     * repaint() will also cause this method to be called.
     * This can be used to do the pre-draw lines, because every shapes and lines made here will be deleted once other actions happen.
     * @param g  the <code>Graphics</code> context in which to paint
     */
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(color);
        g.drawImage(bufferedImage, 0, 0, null);
        if (isDrawing) {
            graphicDraw(g);
        }
    }

    /**
     * A method to draw the image currently in the buffer onto the panel, it will be called by the remote server
     * @param mode
     * @param start
     * @param end
     * @param color
     * @param textDraw
     */
    public void synDraw(String mode, Point start, Point end, Color color, String textDraw) {
        graphics2D.setColor(color);
        graphics2D.setStroke(new BasicStroke(2));
        switch (mode) {
            case FREEDRAW -> graphics2D.drawLine(start.x, start.y, end.x, end.y);
            case DRAWLINE -> graphics2D.drawLine(start.x, start.y, end.x, end.y);
            case DRAWRECT ->
                    graphics2D.drawRect(remoteStartPoint(start, end).x, remoteStartPoint(start, end).y, Math.abs(start.x - end.x), Math.abs(start.y - end.y));
            case DRAWOVAL ->
                    graphics2D.drawOval(remoteStartPoint(start, end).x, remoteStartPoint(start, end).y, Math.abs(start.x - end.x), Math.abs(start.y - end.y));
            case DRAWCIRCLE -> {
                int radius = (int) Math.sqrt(Math.pow(start.x - end.x, 2) + Math.pow(start.y - end.y, 2));
                graphics2D.drawOval(remoteStartPoint(start, end).x, remoteStartPoint(start, end).y, radius, radius);
            }
            case DRAWTEXT -> {
                if (textDraw != null) {
                    graphics2D.drawString(textDraw, start.x, start.y);
                }
            }
        }
        this.getGraphics().drawImage(bufferedImage, 0, 0, null);

    }

    private Point remoteStartPoint(Point remoteStart, Point remoteEnd){
        Point startPoint = new Point();
        startPoint.x = Math.min(remoteStart.x, remoteEnd.x);
        startPoint.y = Math.min(remoteStart.y, remoteEnd.y);
        return startPoint;
    }

    public void newCanvas() {
        // clear the buffered image
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
        repaint();
    }

    public boolean save(String filePath) {
        // Check if the file exists, if not, notify the user and call saveAs
        File fileToSave = new File(filePath);
        if (!fileToSave.exists()) {
            String path = saveAs();
            return path != null;
        }
        String extension =getFileExtension(fileToSave);
        if (extension == null) {
            extension = "png";
            fileToSave = new File(filePath + ".png");
        }
        // check if the file exists, if yes, ask the user if they want to overwrite
        if (fileToSave.exists()) {
            int overwrite = JOptionPane.showConfirmDialog(this, "File already exists, overwrite?", "Overwrite", JOptionPane.YES_NO_OPTION);
            if (overwrite == JOptionPane.NO_OPTION) {
                return false;
            }
        }
        try {
            ImageIO.write(bufferedImage, extension, fileToSave);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return null;
        }
        return name.substring(lastIndexOf + 1);
    }

    public String saveAs() {
        int userSelection = fileChooser.showSaveDialog(this);
        // if the user click the save button
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String extension = "";
            // 获取用户选择的文件过滤器
            FileFilter selectedFilter = fileChooser.getFileFilter();
            if (selectedFilter == pngFilter) {
                extension = "png";
            } else if (selectedFilter == jpegFilter) {
                extension = "jpg";
            }
            if (extension.trim().equals("") || extension==null) {
                extension = "png";
            }
            if (!fileToSave.getAbsolutePath().endsWith(extension)) {
                fileToSave = new File(fileToSave + "." + extension);
            }

            // check if the file exists, if yes, ask the user if they want to overwrite
            if (fileToSave.exists()) {
                int overwrite = JOptionPane.showConfirmDialog(this, "File already exists, overwrite?", "Overwrite", JOptionPane.YES_NO_OPTION);
                if (overwrite == JOptionPane.NO_OPTION) {
                    return null;
                }
            }

            System.out.println("Save as file into: " + fileToSave.getAbsolutePath());
            try {
                ImageIO.write(bufferedImage, extension, fileToSave);
                return fileToSave.getAbsolutePath();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;

    }

    public String openImage() {
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile();
            try {
                bufferedImage = ImageIO.read(fileToOpen);
                graphics2D = bufferedImage.createGraphics();
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                repaint();
                return fileToOpen.getAbsolutePath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }


    private class myMotionAdapter implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {
            end.setLocation(e.getX(), e.getY());
            if (mode.equals(FREEDRAW)) {
                draw();
                try {
                    service.synDraw(name, mode, start, end, color, textDraw);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                start.setLocation(end);
            }
            if (mode.equals(DRAWLINE) || mode.equals(DRAWOVAL) || mode.equals(DRAWRECT)||mode.equals(DRAWCIRCLE)||mode.equals(DRAWTEXT) ){
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
            start.setLocation(e.getX(), e.getY());
            end.setLocation(e.getX(), e.getY());
            if (mode.equals(DRAWLINE) || mode.equals(DRAWOVAL) || mode.equals(DRAWRECT) || mode.equals(DRAWCIRCLE)){
                isDrawing = true;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            end.setLocation(e.getX(), e.getY());
            if (mode.equals(DRAWLINE)|| mode.equals(DRAWOVAL) || mode.equals(DRAWRECT)|| mode.equals(DRAWCIRCLE)||mode.equals(DRAWTEXT)){
                draw();
                try {
                    service.synDraw(name, mode, start, end, color, textDraw);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
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
