package view;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class VistaVentana {
    private JFrame frame;
    private JTextArea textArea;
    private JButton btnConvertir;
    private JLabel backgroundLabel;
    private JScrollPane scrollPane;

    public VistaVentana() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Convertidor de Texto a Voz");
        frame.setSize(1069, 596);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1069, 596);
        frame.setContentPane(layeredPane);

        ImageIcon gifIcon = new ImageIcon(getClass().getResource("/img/mai.png"));
        backgroundLabel = new JLabel(gifIcon);
        backgroundLabel.setBounds(0, 0, 1069, 596);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);
        panel.setBounds(0, 0, 1069, 596);
        layeredPane.add(panel, JLayeredPane.PALETTE_LAYER);

        int textAreaWidth = 460;
        int textAreaHeight = 100;
        int buttonWidth = 150;
        int buttonHeight = 40;

        int centerX = (1069 - textAreaWidth) / 2;
        int centerY = (596 - (textAreaHeight + buttonHeight + 20)) / 2;

        textArea = new JTextArea("Introduce cualquier cosa", 5, 20);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setForeground(Color.GRAY);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setBorder(BorderFactory.createCompoundBorder(
                textArea.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(centerX, centerY, textAreaWidth, textAreaHeight);
        panel.add(scrollPane);

        textArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textArea.getText().equals("Introduce cualquier cosa")) {
                    textArea.setText("");
                    textArea.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textArea.getText().trim().isEmpty()) {
                    textArea.setText("Introduce cualquier cosa");
                    textArea.setForeground(Color.GRAY);
                }
            }
        });

        btnConvertir = new JButton("Convertir a voz");
        btnConvertir.setFont(new Font("Arial", Font.BOLD, 16));
        btnConvertir.setBackground(new Color(51, 153, 255));
        btnConvertir.setForeground(Color.WHITE);
        btnConvertir.setBounds(centerX + (textAreaWidth - buttonWidth) / 2, centerY + textAreaHeight + 20, buttonWidth, buttonHeight);
        btnConvertir.setFocusPainted(false);
        btnConvertir.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        panel.add(btnConvertir);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JButton getBtnConvertir() {
        return btnConvertir;
    }
}