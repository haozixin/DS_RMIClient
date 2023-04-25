package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class CanvasPanel extends JPanel{
    private BufferedImage bufferedImage;
    private Graphics2D graphics2D;

    public CanvasPanel() {
        bufferedImage  = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
        graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0, 0, 800, 800);
//        Timer timer = new Timer(1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // 在缓冲区图像上绘制内容
//                graphics2D.setColor(Color.white);
//                graphics2D.fillRect(0, 0, 800, 800);
//
//                // 重绘组件
//                repaint();
//            }
//        });
//        timer.start();
    }

//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawImage(bufferedImage, 0, 0, null);
//    }

    public Graphics2D getGraphics2D() {
        return graphics2D;
    }

//    @Override
//    public void mouseClicked(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//
//    }
}
