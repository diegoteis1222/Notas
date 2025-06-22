package views;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {

        setTitle("App de Notas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea areaTexto = new JTextArea();
        add(new JScrollPane(areaTexto));

        setVisible(true);
    }
}
