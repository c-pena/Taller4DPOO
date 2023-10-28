package GUI;

import javax.swing.JFrame;

import modelo.Top10;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class VentanaPrincipal extends JFrame {

    private static PanelOpciones panelEste;
    private static PanelModo panelNorte;
    private static PanelEstado panelSur;

    private static Top10 top10;

    //private PanelTablero panelTablero;

    private static Integer tamano = 3;
    private static Integer dificultad = 0;
    // Los niveles de dificultad y sus respectivas jugadas son: facil-tamanio, medio-2*tamanio, dificil-3*tamanio
    private static String nombreJugador = "Guest";


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

    public static void setTamano(Integer tamanoNuevo) {
        tamano = tamanoNuevo;
    }

    public static Integer getTamano() {
        return tamano;
    }

    public static void setDificultad(Integer dificultadNueva) {
        dificultad = dificultadNueva;
    }

    public static Integer getDificultad() {
        return dificultad;
    }

    public static void setNombreJugador(String nombreNuevo) {
        nombreJugador = nombreNuevo;
        PanelEstado.setNombreJugador(nombreNuevo);
        repaintVentanaPrincipal();
    }

    public static String getNombreJugador() {
        return nombreJugador;
    }

    public static Top10 getTop10() {
        return top10;
    }

    public static void repaintVentanaPrincipal() {
        panelNorte.repaint();
        panelEste.repaint();
        panelSur.repaint();
    }
}
