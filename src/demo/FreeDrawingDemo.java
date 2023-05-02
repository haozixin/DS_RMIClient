package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FreeDrawingDemo extends JPanel {
    private List<Shape> shapes;
    private Shape currentShape;
    private Point startPoint, endPoint;
    private boolean drawingLine, drawingRect;

    public FreeDrawingDemo() {
        shapes = new ArrayList<Shape>();

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
                endPoint = e.getPoint();

                if (drawingLine) {
                    currentShape = new Line2D.Double(startPoint, endPoint);
                } else if (drawingRect) {
                    currentShape = new Rectangle2D.Double(startPoint.getX(), startPoint.getY(), 0, 0);
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (currentShape != null) {
                    shapes.add(currentShape);
                    currentShape = null;
                }
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                endPoint = e.getPoint();
                if (currentShape instanceof Line2D) {
                    ((Line2D) currentShape).setLine(startPoint, endPoint);
                } else if (currentShape instanceof Rectangle2D) {
                    ((Rectangle2D) currentShape).setFrameFromDiagonal(startPoint, endPoint);
                }
                repaint();
            }
        });
    }

    public void setDrawingLine(boolean drawingLine) {
        this.drawingLine = drawingLine;
        drawingRect = false;
    }

    public void setDrawingRect(boolean drawingRect) {
        this.drawingRect = drawingRect;
        drawingLine = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // 开启反锯齿
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 设置画笔颜色
        g2d.setColor(Color.BLACK);

        // 设置画笔粗细
        Stroke stroke = new BasicStroke(2f);
        g2d.setStroke(stroke);

        // 绘制所有的图形
        for (Shape shape : shapes) {
            g2d.draw(shape);
        }

        // 绘制当前正在绘制的图形
        if (currentShape != null) {
            g2d.draw(currentShape);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Free Drawing Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        FreeDrawingDemo drawingDemo = new FreeDrawingDemo();
        frame.add(drawingDemo);

        // 创建两个按钮，用于切换绘制模式
        javax.swing.JButton lineButton = new javax.swing.JButton("Draw Line");
        lineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawingDemo.setDrawingLine(true);

            }}  );
        frame.add(lineButton, java.awt.BorderLayout.NORTH);

        javax.swing.JButton rectButton = new javax.swing.JButton("Draw Rectangle");
        rectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawingDemo.setDrawingRect(true);
            }
        });
        frame.add(rectButton, java.awt.BorderLayout.SOUTH);

        frame.setVisible(true);
    }}