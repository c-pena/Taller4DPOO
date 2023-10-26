package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelOpciones extends JPanel {

    private JButton btnNuevo;
    private JButton btnReiniciar;
    private JButton btnTop10;
    private JButton btnCambiarJugador;


    public PanelOpciones() {
        setLayout(new GridLayout(15,1));
        setPreferredSize(new Dimension(200, 720));
        Color colorBtn = new Color(46,153,229);

        btnNuevo = new JButton("NUEVO");
        btnNuevo.setBackground(colorBtn);
        btnNuevo.setOpaque(true);
        btnNuevo.setBorderPainted(false);
        btnNuevo.setForeground(Color.WHITE);

        btnReiniciar = new JButton("REINICIAR");
        btnReiniciar.setBackground(colorBtn);
        btnReiniciar.setOpaque(true);
        btnReiniciar.setBorderPainted(false);
        btnReiniciar.setForeground(Color.WHITE);

        btnTop10 = new JButton("TOP-10");
        btnTop10.setBackground(colorBtn);
        btnTop10.setOpaque(true);
        btnTop10.setBorderPainted(false);
        btnTop10.setForeground(Color.WHITE);

        btnCambiarJugador = new JButton("CAMBIAR JUGADOR");
        btnCambiarJugador.setBackground(colorBtn);
        btnCambiarJugador.setOpaque(true);
        btnCambiarJugador.setBorderPainted(false);
        btnCambiarJugador.setForeground(Color.WHITE);

        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(btnNuevo);
        add(new JLabel(""));
        add(btnReiniciar);
        add(new JLabel(""));
        add(btnTop10);
        add(new JLabel(""));
        add(btnCambiarJugador);
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
    }    
}
