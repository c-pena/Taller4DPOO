package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        lblTamanio = new JLabel("Tamano:     ");
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
        ActionListener actionCambiarTamanio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> combo = (JComboBox<String>) e.getSource();
                String selectedOption = combo.getSelectedItem().toString();
                if (selectedOption.equals("3x3")) {
                    VentanaPrincipal.setTamano(3);
                } else if (selectedOption.equals("5x5")) {
                    VentanaPrincipal.setTamano(5);
                } else if (selectedOption.equals("7x7")) {
                    VentanaPrincipal.setTamano(7);
                }
                System.out.println("Selected option: " + selectedOption);
            }
        };
        comboTamanio.addActionListener(actionCambiarTamanio);

        add(new JLabel(""));

        lblDificultad = new JLabel("Dificultad:     ");
        lblDificultad.setFont(boldFont);
        lblDificultad.setForeground(Color.WHITE);
        add(lblDificultad);
        lblDificultad.setHorizontalAlignment(JLabel.RIGHT);

        grupoDificultad = new ButtonGroup();
        btnFacil = new JRadioButton("Facil");
        btnFacil.setBackground(colorLayout);
        btnFacil.setOpaque(true);
        btnFacil.setBorderPainted(false);
        btnFacil.setForeground(Color.WHITE);
        btnNormal = new JRadioButton("Normal");
        btnNormal.setBackground(colorLayout);
        btnNormal.setOpaque(true);
        btnNormal.setBorderPainted(false);
        btnNormal.setForeground(Color.WHITE);
        btnDificil = new JRadioButton("Dificil");
        btnDificil.setBackground(colorLayout);
        btnDificil.setOpaque(true);
        btnDificil.setBorderPainted(false);
        btnDificil.setForeground(Color.WHITE);
        grupoDificultad.add(btnFacil);
        grupoDificultad.add(btnNormal);
        grupoDificultad.add(btnDificil);
        add(btnFacil);
        btnFacil.setHorizontalAlignment(JLabel.RIGHT);
        add(btnNormal);
        btnNormal.setHorizontalAlignment(JLabel.CENTER);
        add(btnDificil);
        btnFacil.doClick();

        ActionListener actionCambiarDificultadFacil = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaPrincipal.setDificultad(1);
                System.out.println("Dificulty changed to: Facil");
            }
        };
        btnFacil.addActionListener(actionCambiarDificultadFacil);

        ActionListener actionCambiarDificultadNormal = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaPrincipal.setDificultad(2);
                System.out.println("Dificulty changed to: Normal");
            }
        };
        btnNormal.addActionListener(actionCambiarDificultadNormal);

        ActionListener actionCambiarDificultadDificil = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaPrincipal.setDificultad(3);
                System.out.println("Dificulty changed to: Dificil");
            }
        };
        btnDificil.addActionListener(actionCambiarDificultadDificil);

        add(new JLabel(""));
        add(new JLabel(""));
    }


}
