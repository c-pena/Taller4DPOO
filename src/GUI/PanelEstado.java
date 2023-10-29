package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelEstado extends JPanel {

    private JLabel lblJugadas;
    private static JLabel lblNumeroDeJugadas;
    private JLabel lblJugador;
    private static JLabel lblNombreJugador;

    public PanelEstado() {

        GridLayout layout = new GridLayout(3,6);
        setLayout(layout);
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));

        setPreferredSize(new Dimension(760, 90));

        lblJugadas = new JLabel("Jugadas: ");
        Font customFont = new Font(lblJugadas.getFont().getName(), Font.BOLD, 18);
        lblJugadas.setFont(customFont);
        lblNumeroDeJugadas = new JLabel("0");
        lblNumeroDeJugadas.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        lblJugador = new JLabel("Jugador: ");
        lblJugador.setFont(customFont);
        lblNombreJugador = new JLabel("Gst");
        lblNombreJugador.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        add(new JLabel(""));
        add(lblJugadas);
        lblJugadas.setHorizontalAlignment(JLabel.RIGHT);
        add(lblNumeroDeJugadas);
        lblNumeroDeJugadas.setHorizontalAlignment(JLabel.CENTER);
        add(lblJugador);
        lblJugador.setHorizontalAlignment(JLabel.RIGHT);
        add(lblNombreJugador);
        lblNombreJugador.setHorizontalAlignment(JLabel.CENTER);
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
    }

    public static void setJugadas(int jugadas) {
        lblNumeroDeJugadas.setText(String.valueOf(jugadas));
    }

    public static void setNombreJugador(String nombreJugador) {
        lblNombreJugador.setText(nombreJugador);
    }
    
}
