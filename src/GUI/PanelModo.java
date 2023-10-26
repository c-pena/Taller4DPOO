package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class PanelModo extends JPanel {
    
    private ButtonGroup grupoDificultad;
    private JRadioButton btnFacil;
    private JRadioButton btnNormal;
    private JRadioButton btnDificil;
    private JComboBox<String> comboTamanio;

    private JLabel lblTamanio;
    private JLabel lblDificultad;


    public PanelModo() {
        setLayout(new GridLayout(1,8));
        setPreferredSize(new Dimension(1280, 50));
        Color colorLayout = new Color(46,153,229);
        setBackground(colorLayout);

        add(new JLabel(""));

        lblTamanio = new JLabel("Tamanio:");
        lblTamanio.setForeground(Color.WHITE);
        add(lblTamanio);
        comboTamanio = new JComboBox<String>();
        comboTamanio.addItem("3x3");
        comboTamanio.addItem("5x5");
        comboTamanio.addItem("7x7");
        add(comboTamanio);

        lblDificultad = new JLabel("Dificultad:");
        lblDificultad.setForeground(Color.WHITE);
        add(lblDificultad);

        grupoDificultad = new ButtonGroup();
        btnFacil = new JRadioButton("Fácil");
        btnFacil.setForeground(Color.WHITE);
        btnNormal = new JRadioButton("Normal");
        btnNormal.setForeground(Color.WHITE);
        btnDificil = new JRadioButton("Difícil");
        btnDificil.setForeground(Color.WHITE);
        grupoDificultad.add(btnFacil);
        grupoDificultad.add(btnNormal);
        grupoDificultad.add(btnDificil);
        add(btnFacil);
        add(btnNormal);
        add(btnDificil);

        add(new JLabel(""));

    }


}
