package GUI;

import javax.swing.JFrame;
import javax.swing.border.Border;
import java.awt.BorderLayout;

public class VentanaPrincipal extends JFrame {

    private PanelOpciones panelEste;
    //private PanelTablero panelTablero;

    public VentanaPrincipal() {
        setTitle("Lights Out");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        panelEste = new PanelOpciones();
        add(panelEste, BorderLayout.EAST);





        setVisible(true);
    }

    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
    }


}
