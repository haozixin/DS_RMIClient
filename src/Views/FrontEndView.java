package Views;

import remoteInterfaces.IRemoteServiceSkeleton;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class FrontEndView extends JFrame {
    private String filePathForSave = null;
    private final IRemoteServiceSkeleton remoteService;
    private final String name;
    DefaultListModel<String> chatListModel;
    private final boolean isManager;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private final CanvasPanel canvasPanel;

    private JList<String> chatJList;
    private JPanel chatPanel;
    private JButton clearChatRecordsButton;
    private JMenuItem colorChooser;

    private JMenu currentColor;
    private JMenu currentTool;
    private JMenu cursorMenu;
    private JRadioButtonMenuItem drawOval;
    private JRadioButtonMenuItem drawLine;
    private JRadioButtonMenuItem drawRect;
    private JRadioButtonMenuItem drawText;
    private JRadioButtonMenuItem drawCir;
    private JMenu fileMenu;
    private JMenuItem fileOpen;
    private JMenuItem fileSave;
    private JMenuItem fileSaveAs;
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
    private JList<String> participantsList;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form BoardClient
     */
    public FrontEndView(String name, boolean isManager, IRemoteServiceSkeleton remoteService){
        super.setTitle("ZX Share White Board ~_~ " + name);
        this.name = name;
        this.isManager = isManager;
        if (isManager){
            this.setTitle("ZX Share White Board ~_~ " + name + " (Manager)");
        }
        participantsList = new JList<>();
        chatListModel = new DefaultListModel<>();
        this.remoteService = remoteService;
        canvasPanel = new CanvasPanel(this.remoteService, name);
        initComponents();
        this.getContentPane().setBackground(Color.white);
        listPanel.setBackground(Color.white);
        chatPanel.setBackground(Color.white);
        menuBar.setBackground(Color.white);
        menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));



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
        JLabel drawLabel = new JLabel();
        inputPanel = new JScrollPane();
        inputArea = new JTextArea();
        sendButton = new JButton();
        sendButton.setEnabled(false);
        sendButton.setToolTipText("Click enable when you input text in the text area");
        clearChatRecordsButton = new JButton();
        listPanel = new JPanel();
        JLabel userListLabel = new JLabel();
        JScrollPane participantsListPanel = new JScrollPane();
        participantsList = new JList<>();
        chatPanel = new JPanel();
        JLabel chatLabel = new JLabel();
        JScrollPane chatBoxPanel = new JScrollPane();
        chatJList = new JList<>();
        menuBar = new JMenuBar();
        fileMenu = new JMenu();
        newBoard = new JMenuItem();
        fileOpen = new JMenuItem();
        fileSave = new JMenuItem();
        fileSaveAs = new JMenuItem();
        shapeMenu = new JMenu();
        drawLine = new JRadioButtonMenuItem();
        drawRect = new JRadioButtonMenuItem();
        drawCir = new JRadioButtonMenuItem();
        drawOval = new JRadioButtonMenuItem();
        colorChooser = new JMenuItem();
        textMenu = new JMenu();
        drawText = new JRadioButtonMenuItem();
        freeDrawButton = new JRadioButtonMenuItem();
        cursorMenu = new JMenu();
        currentTool = new JMenu();
        currentColor = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        canvasPanel.addKeyListener(new KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                boardPanelKeyTyped(evt);
            }
        });

        drawLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout boardPanelLayout = new GroupLayout(canvasPanel);
        canvasPanel.setLayout(boardPanelLayout);
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

        addChatModule();

        userListLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userListLabel.setText("Participants:");
        userListLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        participantsList.setModel(new AbstractListModel<>() {
            final String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        participantsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                participantsListMouseClicked(evt);
            }
        });
        participantsListPanel.setViewportView(participantsList);

        GroupLayout listPanelLayout = new GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
                listPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(participantsListPanel)
                        .addGroup(listPanelLayout.createSequentialGroup()
                                .addComponent(userListLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        listPanelLayout.setVerticalGroup(
                listPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(listPanelLayout.createSequentialGroup()
                                .addComponent(userListLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(participantsListPanel, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                .addContainerGap())
        );

        chatLabel.setHorizontalAlignment(SwingConstants.CENTER);
        chatLabel.setText("Messages:");
        chatLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        chatJList.setModel(new AbstractListModel<>() {
            final String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        chatBoxPanel.setViewportView(chatJList);

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
        addTextMenu();
        addColorMenu();

        addCurrentToolAndColor();

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(canvasPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(sendButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(clearChatRecordsButton)
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
                                .addComponent(canvasPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                        .addComponent(clearChatRecordsButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addChatModule() {
        inputPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        inputPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        inputArea.setColumns(25);
        inputArea.setLineWrap(true);
        inputArea.setRows(5);
        inputArea.setText("");
        inputPanel.setViewportView(inputArea);
        inputArea.getDocument().addDocumentListener(getListener());

        sendButton.setText("Send");
        sendButton.addActionListener(evt -> {
            try {
                boolean isSuccess = remoteService.broadcastMessage(name, inputArea.getText());
                if (!isSuccess) {
                    JOptionPane.showMessageDialog(null,
                            "userName or message is empty, maybe, you are not in the board, please join the board first");
                }
                inputArea.setText("");
            } catch (RemoteException e) {
                System.out.println("Some problem with sending message, this is a RemoteException, the server may be down");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        clearChatRecordsButton.setText("Clear");
        clearChatRecordsButton.addActionListener(evt -> {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to clean chat?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION){
                chatListModel = new DefaultListModel<>();
                chatJList.setModel(chatListModel);
            }
        });
    }

    private DocumentListener getListener() {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkButton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkButton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkButton();
            }
            private void checkButton() {
                sendButton.setEnabled(!inputArea.getText().trim().isEmpty());
            }
        };
    }


    private void addShapeMenu() {
        shapeMenu.setText("Shape");
        drawLine.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        modeGroup.add(drawLine);
        drawLine.setText("Line");
        drawLine.addActionListener(this::drawLineActionPerformed);
        shapeMenu.add(drawLine);

        // =========================================================
        drawRect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        modeGroup.add(drawRect);
        drawRect.setText(canvasPanel.DRAWRECT);
        drawRect.addActionListener(this::drawRectActionPerformed);
        shapeMenu.add(drawRect);

        // =========================================================
        drawCir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        modeGroup.add(drawCir);
        drawCir.setText(canvasPanel.DRAWCIRCLE);
        drawCir.addActionListener(this::drawCircleActionPerformed);
        shapeMenu.add(drawCir);

        // =========================================================
        drawOval.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        modeGroup.add(drawOval);
        drawOval.setText(canvasPanel.DRAWOVAL);
        drawOval.addActionListener(this::drawOvalActionPerformed);
        shapeMenu.add(drawOval);

        // =========================================================
        modeGroup.add(freeDrawButton);
        freeDrawButton.setText("Free Draw");
        freeDrawButton.addActionListener(this::freeDrawButtonActionPerformed);
        shapeMenu.add(freeDrawButton);
        menuBar.add(shapeMenu);
    }

    private void addFileMenu() {
        fileMenu.setText("File");

        newBoard.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        newBoard.setText("New Board");
        newBoard.addActionListener(this::createNewBoardActionPerformed);
        fileMenu.add(newBoard);

        fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        fileOpen.setText("Open");
        fileOpen.addActionListener(this::fileOpenActionPerformed);
        fileMenu.add(fileOpen);

        fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        fileSave.setText("Save");
        fileSave.addActionListener(this::fileSaveActionPerformed);
        fileMenu.add(fileSave);

        fileSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        fileSaveAs.setText("Save As");
        fileSaveAs.addActionListener(this::fileSaveAsActionPerformed);
        fileMenu.add(fileSaveAs);

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


    private void addTextMenu() {
        textMenu.setText("Text");
        modeGroup.add(drawText);
        drawText.setText("drawText");
        drawText.addActionListener(this::drawTextActionPerformed);
        textMenu.add(drawText);

        menuBar.add(textMenu);
    }

    private void addColorMenu() {
        colorChooser.setText("Choose Color");
        colorChooser.addActionListener(evt -> {
            canvasPanel.setColor(JColorChooser.showDialog(null, "Choose a color", Color.black));
            currentColor.setBackground(canvasPanel.getColor());
        });
        menuBar.add(colorChooser);
    }

    private void boardPanelKeyTyped(KeyEvent evt) {
    }



    private void participantsListMouseClicked(MouseEvent evt) {
        // if the user double click the name (not himself/herself) and the user is manager, then kick the user out
        if (evt.getClickCount() == 2 && isManager){
            if (participantsList.getSelectedIndex() != 0) {
                String name = participantsList.getSelectedValue();
                if (name != null) {
                    // send a message to the server to kick the user out
                    int option = JOptionPane.showConfirmDialog(null, "Are you sure to kick " + name + " out?", "Kick out", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        try {
                            remoteService.kickOut(name);
                        } catch (RemoteException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

        }


    }

    private void fileSaveActionPerformed(ActionEvent evt) {
        // if the file name is empty, means the user has not saved the file before, then call saveAs
        // if the file name is not empty, then save the file
        if (filePathForSave == null || filePathForSave.trim().equals("")) {
            fileSaveAsActionPerformed(evt);
        } else {
            boolean isSaved = canvasPanel.save(filePathForSave);
            if (isSaved){
                JOptionPane.showMessageDialog(null, "File saved successfully");
            }
        }
    }

    private void fileSaveAsActionPerformed(ActionEvent evt) {
        // each time the user click save as, the file saving path will be reset
        String absolutePath = canvasPanel.saveAs();
        if (absolutePath != null) {
            filePathForSave = absolutePath;
            JOptionPane.showMessageDialog(null, "File saved successfully");
        }
    }


    private void drawCircleActionPerformed(ActionEvent evt) {
        canvasPanel.setMode(canvasPanel.DRAWCIRCLE);
        currentTool.setText(canvasPanel.DRAWCIRCLE);
        currentColor.setBackground(canvasPanel.getColor());
    }

    /**
     * What will happen when the user click the line button in shape menu
     * @param evt
     */
    private void drawLineActionPerformed(ActionEvent evt) {
        canvasPanel.setMode(canvasPanel.DRAWLINE);
        currentTool.setText(canvasPanel.DRAWLINE);
        currentColor.setBackground(canvasPanel.getColor());
    }

    private void drawRectActionPerformed(ActionEvent evt) {
        canvasPanel.setMode(canvasPanel.DRAWRECT);
        currentTool.setText(canvasPanel.DRAWRECT);
        currentColor.setBackground(canvasPanel.getColor());
    }

    private void drawOvalActionPerformed(ActionEvent evt) {
        canvasPanel.setMode(canvasPanel.DRAWOVAL);
        currentTool.setText(canvasPanel.DRAWOVAL);
        currentColor.setBackground(canvasPanel.getColor());
    }



    private void drawTextActionPerformed(ActionEvent evt) {
        canvasPanel.setMode(canvasPanel.DRAWTEXT);
        currentTool.setText(canvasPanel.DRAWTEXT);
        currentColor.setBackground(canvasPanel.getColor());
    }

    private void freeDrawButtonActionPerformed(ActionEvent evt) {
        canvasPanel.setMode(canvasPanel.FREEDRAW);
        currentTool.setText(canvasPanel.FREEDRAW);
        currentColor.setBackground(canvasPanel.getColor());
    }

    private void fileOpenActionPerformed(ActionEvent evt) {
        String path = canvasPanel.openImage();
        if (path != null) {
            filePathForSave = path;
        }
    }

    private void createNewBoardActionPerformed(ActionEvent evt) {
        int result = JOptionPane.showConfirmDialog(this, "Have you save the board?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            canvasPanel.newCanvas();
            filePathForSave = null;
            try {
                remoteService.newCanvas();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        
    }
    public void addMessage(String text){
        chatListModel.addElement(text);
        chatJList.setModel(chatListModel);
    }


    private void formWindowClosing(WindowEvent evt) {
        // ask for confirmation
        if (isManager) {
            int result = JOptionPane.showConfirmDialog(this, "All users will be removed, Are you sure to close the board?", "Confirm", JOptionPane.YES_NO_OPTION);
            // if the user is the manager, ask if he wants to save the board
            if (result == JOptionPane.YES_OPTION) {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }else{
                // do nothing
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        }
        else{
            // if the user is not the manager, ask if he wants to save the board
            int result = JOptionPane.showConfirmDialog(this, "Are you sure to close the board?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }else{
                // do nothing
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        }
    }



    public void updateUserList(ArrayList<String> userList) {
        DefaultListModel<String> userModel = new DefaultListModel<>();
        for(String name:userList){
            userModel.addElement(name);
        }
        this.participantsList.setModel(userModel);
    }

    public void synDraw(String mode, Point start, Point end, Color color, String textDraw) {
        canvasPanel.synDraw(mode, start, end, color, textDraw);
    }

    public void newCanvas() {
        canvasPanel.newCanvas();
    }
}
