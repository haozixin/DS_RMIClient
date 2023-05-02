package demo;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JTextAreaDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTextArea Demo");
        JTextArea textArea = new JTextArea();
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Text inserted: " + textArea.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("Text removed: " + textArea.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // This method is not used for plain text documents
            }
        });
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
