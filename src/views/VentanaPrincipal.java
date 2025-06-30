package views;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private JTextArea areaTexto;
    private JTextArea lineas;

    public VentanaPrincipal() {
        setTitle("App de Notas");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        areaTexto = new JTextArea();
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 14));

        // Área para números de línea
        lineas = new JTextArea("1");
        lineas.setBackground(Color.LIGHT_GRAY);
        lineas.setEditable(false);
        lineas.setFont(new Font("Monospaced", Font.PLAIN, 14));

        // Sincroniza scroll
        JScrollPane scroll = new JScrollPane(areaTexto);
        scroll.setRowHeaderView(lineas);

        // Listener para actualizar líneas
        areaTexto.getDocument().addDocumentListener(new DocumentListener() {
            public String getLineas() {
                int lineCount = areaTexto.getLineCount();
                StringBuilder text = new StringBuilder();
                for (int i = 1; i <= lineCount; i++) {
                    text.append(i).append("\n");
                }
                return text.toString();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                lineas.setText(getLineas());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                lineas.setText(getLineas());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                lineas.setText(getLineas());
            }
        });

        add(scroll);
        setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}
