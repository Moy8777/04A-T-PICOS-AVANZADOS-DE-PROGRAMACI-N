/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import view.VistaVentana;
import textoavoz.TextoaVoz;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Pedro García
 */
public class mainpp {
 public static void main(String[] args) {
        // Iniciar la ventana de la aplicación
        VistaVentana vista = new VistaVentana();
        vista.getFrame().setVisible(true);

        // Acción del botón "Convertir a voz"
        vista.getBtnConvertir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = vista.getTextArea().getText(); // Usar getTextArea() para obtener texto
                TextoaVoz.convertir(texto); // Llamar al método convertir con el texto
            }
        });
    }
}
