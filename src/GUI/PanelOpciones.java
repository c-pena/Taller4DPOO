package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.RegistroTop10;
import modelo.Top10;

public class PanelOpciones extends JPanel {

    private JButton btnNuevo;
    private JButton btnReiniciar;
    private JButton btnTop10;
    private JButton btnCambiarJugador;
    private Top10 top10;

    public PanelOpciones(Top10 top10) {
        this.top10 = top10;

        setLayout(new GridLayout(15,1));
        setPreferredSize(new Dimension(230, 720));
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
        ActionListener actionTop10 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Collection<RegistroTop10> topList = top10.darRegistros();
               JDialog dialog = new JDialog((JFrame) getTopLevelAncestor(), "Top 10", true);
                dialog.setSize(200, 100);
                dialog.setLocationRelativeTo(getTopLevelAncestor());
                dialog.add(new JLabel("This is a dialog"));
                dialog.setVisible(true);
            }
        };
        btnTop10.addActionListener(actionTop10);


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
