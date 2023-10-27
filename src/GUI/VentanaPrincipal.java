package GUI;

import javax.swing.JFrame;
import javax.swing.border.Border;

import modelo.Top10;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class VentanaPrincipal extends JFrame {

    private PanelOpciones panelEste;
    private PanelModo panelNorte;
    private PanelEstado panelSur;
    private Top10 top10;
    //private PanelTablero panelTablero;

    public VentanaPrincipal() {
        setTitle("Lights Out");
        setSize(960, 720);
        setLocationRelativeTo(null);
        setResizable(false);
        top10 = new Top10();
        String workingDir = System.getProperty("user.dir");
        String filePath = workingDir + File.separator + "data" + File.separator + "top10.csv";
        File top10CSV = new File(filePath);
        top10.cargarRecords(top10CSV);
        System.out.println("Records cargados");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    top10.salvarRecords(top10CSV);
                    System.out.println(top10.darRegistros());
                    System.out.println("Records salvados");
                } catch (FileNotFoundException | UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
                }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        panelEste = new PanelOpciones(top10);
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
