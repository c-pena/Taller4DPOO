package GUI;

import javax.swing.JFrame;
import javax.swing.border.Border;
import java.awt.BorderLayout;

public class VentanaPrincipal extends JFrame {

    private PanelOpciones panelEste;
    private PanelModo panelNorte;
    private PanelEstado panelSur;
    //private PanelTablero panelTablero;

    public VentanaPrincipal() {
        setTitle("Lights Out");
        setSize(960, 720);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        panelEste = new PanelOpciones();
        add(panelEste, BorderLayout.EAST);

        panelNorte = new PanelModo();
        add(panelNorte, BorderLayout.NORTH);

        panelSur = new PanelEstado();
        add(panelSur, BorderLayout.SOUTH);



        setVisible(true);
    }

    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
    }


}
