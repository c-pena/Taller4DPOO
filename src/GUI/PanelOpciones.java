package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import modelo.RegistroTop10;
import modelo.Top10;

public class PanelOpciones extends JPanel {

    private JButton btnNuevo;
    private JButton btnReiniciar;
    private JButton btnTop10;
    private JButton btnCambiarJugador;
    private Top10 top10;

    public PanelOpciones() {

        this.top10 = VentanaPrincipal.getTop10();

        setLayout(new GridLayout(15, 1));
        setPreferredSize(new Dimension(230, 720));
        Color colorBtn = new Color(46, 153, 229);

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
                dialog.setSize(380, 220);
                dialog.setLocationRelativeTo(getTopLevelAncestor());
                dialog.setLayout(new BorderLayout());
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

                JPanel panelTitulo = new JPanel();
                panelTitulo.setLayout(new GridLayout(1, 3));
                panelTitulo.setMaximumSize(new Dimension(200, 30));

                JLabel lblTitulo = new JLabel("#");
                Font boldFont = new Font(lblTitulo.getFont().getName(), Font.BOLD, lblTitulo.getFont().getSize() + 2);
                lblTitulo.setFont(boldFont);
                lblTitulo.setBackground(colorBtn);
                lblTitulo.setOpaque(true);
                lblTitulo.setForeground(Color.WHITE);
                lblTitulo.setHorizontalAlignment(JLabel.CENTER);
                panelTitulo.add(lblTitulo);

                JLabel lblTituloNombre = new JLabel("NOMBRE");
                lblTituloNombre.setFont(boldFont);
                lblTituloNombre.setBackground(colorBtn);
                lblTituloNombre.setOpaque(true);
                lblTituloNombre.setForeground(Color.WHITE);
                lblTituloNombre.setHorizontalAlignment(JLabel.CENTER);
                panelTitulo.add(lblTituloNombre);

                JLabel lblTituloPuntaje = new JLabel("PUNTAJE");
                lblTituloPuntaje.setFont(boldFont);
                lblTituloPuntaje.setBackground(colorBtn);
                lblTituloPuntaje.setOpaque(true);
                lblTituloPuntaje.setForeground(Color.WHITE);
                lblTituloPuntaje.setHorizontalAlignment(JLabel.CENTER);
                panelTitulo.add(lblTituloPuntaje);
                dialog.add(panelTitulo, BorderLayout.NORTH);

                DefaultListModel<String> listModel = new DefaultListModel<>();

                Integer counter = 1;
                for (RegistroTop10 registro : topList) {
                    String labelString = registro.toString();
                    String completa = counter.toString() + " " + labelString.split(" ")[0] + " " + labelString.split(" ")[2];
                    listModel.addElement(completa);
                    counter++;
                }

                JList<String> list = new JList<>(listModel);
                list.setCellRenderer(new DefaultListCellRenderer() {
                    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                        String comp = value.toString();
                        String pos = comp.split(" ")[0];
                        String name = "  " + comp.split(" ")[1] + " ";
                        String score = "   " + comp.split(" ")[2];

                        JPanel panel = new JPanel();
                        panel.setLayout(new GridLayout(1, 3));
                        
                        JLabel lblPos = new JLabel(pos);
                        lblPos.setFont(boldFont);
                        lblPos.setHorizontalAlignment(JLabel.CENTER);
                        JLabel lblName = new JLabel(name);
                        lblName.setFont(boldFont);
                        lblName.setHorizontalAlignment(JLabel.CENTER);
                        JLabel lblScore = new JLabel(score);
                        lblScore.setFont(boldFont);
                        lblScore.setHorizontalAlignment(JLabel.CENTER);
                        if (Integer.valueOf(pos) < 4) {
                            lblPos.setForeground(Color.GREEN);
                            lblName.setForeground(Color.GREEN);
                            lblScore.setForeground(Color.GREEN);
                        } else if (Integer.valueOf(pos) < 6) {
                            lblPos.setForeground(Color.BLUE);
                            lblName.setForeground(Color.BLUE);
                            lblScore.setForeground(Color.BLUE);
                        }
                        panel.add(lblPos);
                        panel.add(lblName);
                        panel.add(lblScore);
                        return panel;
                    }
                });

                JScrollPane scrollPane = new JScrollPane(list);

                dialog.add(scrollPane);

                dialog.setVisible(true);
            }
        };
        btnTop10.addActionListener(actionTop10);

        btnCambiarJugador = new JButton("CAMBIAR JUGADOR");
        btnCambiarJugador.setBackground(colorBtn);
        btnCambiarJugador.setOpaque(true);
        btnCambiarJugador.setBorderPainted(false);
        btnCambiarJugador.setForeground(Color.WHITE);
        ActionListener actionCambiarJugador = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog((JFrame) getTopLevelAncestor(), "Ingrese un nuevo nombre", true);
                dialog.setSize(380, 120);
                dialog.setLocationRelativeTo(getTopLevelAncestor());
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setSize(300, 100);

                // Crear un JTextField con una longitud máxima de 8 caracteres
                JTextField textField = new JTextField(8);

                // Crear un botón "OK" para cerrar el diálogo
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nombreNuevo = textField.getText();
                        if (nombreNuevo.length() > 2 && nombreNuevo.length() < 7) {
                            VentanaPrincipal.setNombreJugador(nombreNuevo);
                            dialog.dispose();
                        } else {
                            textField.setText("");
                            JDialog dialogError = new JDialog(dialog,
                                    "ERROR: Revisa que el nombre tenga entre 3 y 6 caracteres", true);
                            dialogError.setLocationRelativeTo(dialog);
                            dialogError.setSize(380, 30);
                            dialogError.setVisible(true);
                        }
                    }
                });

                JPanel panel = new JPanel();
                panel.add(textField);
                panel.add(okButton);

                dialog.add(panel);
                dialog.setVisible(true);
            }
        };
        btnCambiarJugador.addActionListener(actionCambiarJugador);

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
