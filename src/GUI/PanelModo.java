package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
        GridLayout layout = new GridLayout(1,9);
        setLayout(layout);

        setPreferredSize(new Dimension(760, 50));
        Color colorLayout = new Color(46,153,229);
        setBackground(colorLayout);

        add(new JLabel(""));
        add(new JLabel(""));

        lblTamanio = new JLabel("Tamano:       ");
        Font boldFont = new Font(lblTamanio.getFont().getName(), Font.BOLD, lblTamanio.getFont().getSize());
        lblTamanio.setFont(boldFont);
        lblTamanio.setForeground(Color.WHITE);
        add(lblTamanio);
        lblTamanio.setHorizontalAlignment(JLabel.RIGHT);

        comboTamanio = new JComboBox<String>();
        comboTamanio.addItem("3x3");
        comboTamanio.addItem("5x5");
        comboTamanio.addItem("7x7");
        add(comboTamanio);

        add(new JLabel(""));

        lblDificultad = new JLabel("Dificultad:");
        lblDificultad.setFont(boldFont);
        lblDificultad.setForeground(Color.WHITE);
        add(lblDificultad);
        lblDificultad.setHorizontalAlignment(JLabel.RIGHT);

        grupoDificultad = new ButtonGroup();
        btnFacil = new JRadioButton("Facil");
        btnFacil.setForeground(Color.WHITE);
        btnNormal = new JRadioButton("Normal");
        btnNormal.setForeground(Color.WHITE);
        btnDificil = new JRadioButton("Dificil");
        btnDificil.setForeground(Color.WHITE);
        grupoDificultad.add(btnFacil);
        grupoDificultad.add(btnNormal);
        grupoDificultad.add(btnDificil);
        add(btnFacil);
        btnFacil.setHorizontalAlignment(JLabel.RIGHT);
        add(btnNormal);
        btnNormal.setHorizontalAlignment(JLabel.CENTER);
        add(btnDificil);

        add(new JLabel(""));
        add(new JLabel(""));
    }


}
