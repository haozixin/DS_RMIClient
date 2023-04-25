package Views;

import Views.CanvasPanel;
import remote.IRemoteBoard;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class FrontEndView extends JFrame {

    private Point remoteStart;
    private Point remoteEnd;
    private String remoteMode;
    private IRemoteBoard remoteBoard;
    private String name;
//    private Color color;
    private Color remoteColor;
    DefaultListModel chatModel;
    private boolean isManager=true;
    private String fileName;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CanvasPanel boardPanel = new CanvasPanel();

    private JScrollPane chatBoxPanel;
    private JLabel chatLabel;
    private JList<String> chatList;
    private JPanel chatPanel;
    private JButton clearButton;
    private JMenuItem colorChooser;
    private JMenu colorMenu;
    private JMenu currentColor;
    private JMenu currentTool;
    private JRadioButtonMenuItem cursorButton;
    private JMenu cursorMenu;
    private JRadioButtonMenuItem drawCir;
    private JLabel drawLabel;
    private JRadioButtonMenuItem drawLine;
    private JRadioButtonMenuItem drawRect;
    private JRadioButtonMenuItem drawText;
    private JRadioButtonMenuItem drawTri;
    private JMenuItem fileClose;
    private JMenu fileMenu;
    private JMenuItem fileOpen;
    private JMenuItem fileSave;
    private JMenuItem fileSaveAs;
    private JMenu freeDraw;
    private JRadioButtonMenuItem freeDrawButton;
    private JTextArea inputArea;
    private JScrollPane inputPanel;
    private JPanel listPanel;
    private JMenuBar menuBar;
    private ButtonGroup modeGroup;
    private JMenuItem newBoard;
    private JButton sendButton;
    private JMenu shapeMenu;
    private JMenu textMenu;
    private JList<String> userList;
    private JLabel userListLabel;
    private JScrollPane userListPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form BoardClient
     */
    public FrontEndView(){
        super.setTitle("ZX Share White Board ~_~");
        initComponents();
        this.getContentPane().setBackground(Color.white);
        listPanel.setBackground(Color.white);
        chatPanel.setBackground(Color.white);
        menuBar.setBackground(Color.white);
        menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));
        remoteStart = new Point(0, 0);
        remoteEnd = new Point(0, 0);
        this.name = name;
        userList = new JList<>();
        remoteColor = new Color(0, 0, 0);
        chatModel = new DefaultListModel();
        fileName = null;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modeGroup = new ButtonGroup();
        drawLabel = new JLabel();
        inputPanel = new JScrollPane();
        inputArea = new JTextArea();
        sendButton = new JButton();
        clearButton = new JButton();
        listPanel = new JPanel();
        userListLabel = new JLabel();
        userListPanel = new JScrollPane();
        userList = new JList<>();
        chatPanel = new JPanel();
        chatLabel = new JLabel();
        chatBoxPanel = new JScrollPane();
        chatList = new JList<>();
        menuBar = new JMenuBar();
        fileMenu = new JMenu();
        newBoard = new JMenuItem();
        fileOpen = new JMenuItem();
        fileSave = new JMenuItem();
        fileSaveAs = new JMenuItem();
        fileClose = new JMenuItem();
        shapeMenu = new JMenu();
        drawLine = new JRadioButtonMenuItem();
        drawRect = new JRadioButtonMenuItem();
        drawTri = new JRadioButtonMenuItem();
        drawCir = new JRadioButtonMenuItem();
        colorMenu = new JMenu();
        colorChooser = new JMenuItem();
        textMenu = new JMenu();
        drawText = new JRadioButtonMenuItem();
        freeDraw = new JMenu();
        freeDrawButton = new JRadioButtonMenuItem();
        cursorMenu = new JMenu();
        cursorButton = new JRadioButtonMenuItem();
        currentTool = new JMenu();
        currentColor = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        boardPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                boardPanelKeyTyped(evt);
            }
        });

        drawLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout boardPanelLayout = new GroupLayout(boardPanel);
        boardPanel.setLayout(boardPanelLayout);
        boardPanelLayout.setHorizontalGroup(
                boardPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(boardPanelLayout.createSequentialGroup()
                                .addComponent(drawLabel)
                                .addGap(0, 339, Short.MAX_VALUE))
        );
        boardPanelLayout.setVerticalGroup(
                boardPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(boardPanelLayout.createSequentialGroup()
                                .addComponent(drawLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        inputPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        inputPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        inputArea.setColumns(25);
        inputArea.setLineWrap(true);
        inputArea.setRows(5);
        inputArea.setText("");
        inputPanel.setViewportView(inputArea);

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        userListLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userListLabel.setText("Participants:");
        userListLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        userList.setModel(new AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        userList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userListMouseClicked(evt);
            }
        });
        userListPanel.setViewportView(userList);

        GroupLayout listPanelLayout = new GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
                listPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(userListPanel)
                        .addGroup(listPanelLayout.createSequentialGroup()
                                .addComponent(userListLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        listPanelLayout.setVerticalGroup(
                listPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(listPanelLayout.createSequentialGroup()
                                .addComponent(userListLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userListPanel, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                .addContainerGap())
        );

        chatLabel.setHorizontalAlignment(SwingConstants.CENTER);
        chatLabel.setText("Messages:");
        chatLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        chatList.setModel(new AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        chatBoxPanel.setViewportView(chatList);

        GroupLayout chatPanelLayout = new GroupLayout(chatPanel);
        chatPanel.setLayout(chatPanelLayout);
        chatPanelLayout.setHorizontalGroup(
                chatPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(chatBoxPanel)
                        .addGroup(chatPanelLayout.createSequentialGroup()
                                .addComponent(chatLabel)
                                .addGap(0, 147, Short.MAX_VALUE))
        );
        chatPanelLayout.setVerticalGroup(
                chatPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(chatPanelLayout.createSequentialGroup()
                                .addComponent(chatLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chatBoxPanel, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                .addContainerGap())
        );

        menuBar.setMaximumSize(new Dimension(400, 30));
        menuBar.setMinimumSize(new Dimension(400, 20));
        menuBar.setPreferredSize(new Dimension(500, 27));

        if (!isManager) {
            fileMenu.setVisible(false);
        }

        addFileMenu();

        addShapeMenu();

        addFreeDraw();
        addCursorMenu();
        addTextMenu();
        addColorMenu();

        addCurrentToolAndColor();

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(boardPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(sendButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(clearButton)
                                                .addGap(27, 27, 27))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(inputPanel, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(listPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(chatPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(4, 4, 4))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(boardPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(listPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chatPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(15, 15, 15)
                                .addComponent(inputPanel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(sendButton)
                                        .addComponent(clearButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void addShapeMenu() {
        shapeMenu.setText("Shape");
        shapeMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                shapeMenuMouseClicked(evt);
            }
        });
        drawLine.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        modeGroup.add(drawLine);
        drawLine.setText("Line");
        drawLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                drawLineActionPerformed(evt);
            }
        });
        shapeMenu.add(drawLine);

        drawRect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        modeGroup.add(drawRect);
        drawRect.setText("Rectangle");
        drawRect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                drawRectActionPerformed(evt);
            }
        });
        shapeMenu.add(drawRect);

        drawTri.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        modeGroup.add(drawTri);
        drawTri.setText("Triangle");
        drawTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                drawTriActionPerformed(evt);
            }
        });
        shapeMenu.add(drawTri);

        drawCir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        modeGroup.add(drawCir);
        drawCir.setText("Circle");
        drawCir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                drawCirActionPerformed(evt);
            }
        });
        shapeMenu.add(drawCir);
        menuBar.add(shapeMenu);
    }

    private void addFileMenu() {
        fileMenu.setText("File");

        newBoard.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        newBoard.setText("New Board");
        newBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newBoardActionPerformed(evt);
            }
        });
        fileMenu.add(newBoard);

        fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        fileOpen.setText("Open");
        fileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                fileOpenActionPerformed(evt);
            }
        });
        fileMenu.add(fileOpen);

        fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        fileSave.setText("Save");
        fileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    fileSaveActionPerformed(evt);
                }catch (NullPointerException e){

                }
            }
        });
        fileMenu.add(fileSave);

        fileSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        fileSaveAs.setText("Save As");
        fileSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try{
                    fileSaveAsActionPerformed(evt);
                }catch (NullPointerException e){
                }
            }
        });
        fileMenu.add(fileSaveAs);

        fileClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        fileClose.setText("Close Board");
        fileClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                fileCloseActionPerformed(evt);
            }
        });
        fileMenu.add(fileClose);
        menuBar.add(fileMenu);
    }

    private void addCurrentToolAndColor() {
        currentTool.setBackground(Color.lightGray);
        currentTool.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        currentTool.setEnabled(false);
        currentTool.setText("current tool");
        currentTool.setOpaque(true);
        currentTool.setIcon(cursorMenu.getIcon());
        // let the current tool be the left most icon
        JPanel panel = new JPanel();
        panel.add(Box.createHorizontalGlue());
        panel.add(currentTool);
        panel.setBackground(Color.white);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(panel);
        menuBar.add(currentTool);


        currentColor.setBackground(Color.lightGray);
        currentColor.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        currentColor.setText("current color");
        currentColor.setEnabled(false);
        currentColor.setOpaque(true);
        menuBar.add(currentColor);
        setJMenuBar(menuBar);
    }

    private void addCursorMenu() {
        cursorMenu.setText("Cursor");
        modeGroup.add(cursorButton);
        cursorButton.setText("Mouse");
        cursorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cursorButtonActionPerformed(evt);
            }
        });
        cursorMenu.add(cursorButton);
        menuBar.add(cursorMenu);
    }

    private void addFreeDraw() {
        freeDraw.setText("Drawing");
        modeGroup.add(freeDrawButton);
        freeDrawButton.setText("Free Draw");
        freeDrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                freeDrawButtonActionPerformed(evt);
            }
        });
        freeDraw.add(freeDrawButton);
        menuBar.add(freeDraw);
    }

    private void addTextMenu() {
        textMenu.setText("Text");
        modeGroup.add(drawText);
        drawText.setSelected(false);
        drawText.setSelected(true);
        drawText.setText("drawText");
        drawText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                drawTextActionPerformed(evt);
            }
        });
        textMenu.add(drawText);

        menuBar.add(textMenu);
    }

    private void addColorMenu() {
        colorMenu.setText("Color");
        colorChooser.setText("Choose");
        colorChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                colorChooserActionPerformed(evt);
            }
        });
        colorMenu.add(colorChooser);
        menuBar.add(colorMenu);
    }

    private void boardPanelKeyTyped(KeyEvent evt) {
    }

    private void sendButtonActionPerformed(ActionEvent evt) {

    }

    private void clearButtonActionPerformed(ActionEvent evt) {

    }

    private void userListMouseClicked(MouseEvent evt) {

    }

    private void fileSaveActionPerformed(ActionEvent evt) {

    }

    private void fileCloseActionPerformed(ActionEvent evt) {

    }

    private void fileSaveAsActionPerformed(ActionEvent evt) {

    }

    private void shapeMenuMouseClicked(MouseEvent evt) {

    }

    private void drawTriActionPerformed(ActionEvent evt) {

    }

    private void drawLineActionPerformed(ActionEvent evt) {

    }

    private void drawRectActionPerformed(ActionEvent evt) {
        
    }

    private void drawCirActionPerformed(ActionEvent evt) {
        
    }

    private void colorChooserActionPerformed(ActionEvent evt) {
        
    }

    private void cursorButtonActionPerformed(ActionEvent evt) {
        
    }

    private void drawTextActionPerformed(ActionEvent evt) {
        
    }

    private void freeDrawButtonActionPerformed(ActionEvent evt) {
        boardPanel.setMode(boardPanel.FREEDRAW);
        currentTool.setText(boardPanel.FREEDRAW);
        currentColor.setBackground(boardPanel.getColor());
    }

    private void fileOpenActionPerformed(ActionEvent evt) {
        
    }

    private void newBoardActionPerformed(ActionEvent evt) {
        
    }

    private void boardPanelMouseReleased(MouseEvent evt) {
        
    }

    private void boardPanelMousePressed(MouseEvent evt) {
        
    }

    private void boardPanelMouseClicked(MouseEvent evt) {
        
    }

    private void formWindowClosing(WindowEvent evt) {
        // ask for confirmation
        int result = JOptionPane.showConfirmDialog(this, "Are you sure to close the board?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            // close
            System.exit(0);
        } else {
            // do nothing
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

}